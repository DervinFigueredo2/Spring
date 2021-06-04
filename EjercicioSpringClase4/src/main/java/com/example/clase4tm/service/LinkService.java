package com.example.clase4tm.service;

import com.example.clase4tm.dto.CreateLinkRequestDTO;
import com.example.clase4tm.dto.CreateLinkResponseDTO;
import com.example.clase4tm.dto.LinkDTO;
import com.example.clase4tm.model.LinkException;
import com.example.clase4tm.repository.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@Primary
public class LinkService implements ILinkService {

    @Autowired
    private ILinkRepository repository;

    @Override
    public CreateLinkResponseDTO createLink(CreateLinkRequestDTO requestDTO) {
        return new CreateLinkResponseDTO(repository.addLink(new LinkDTO(requestDTO.getUrl(),
                requestDTO.getPassword(),
                true)));
    }

    @Override
    public String redirect(Integer linkID, String password) throws LinkException {
        try {
            LinkDTO link = repository.getLink(linkID);
            validate(link, password);
            repository.incrementMetric(linkID);
            return link.getUrl();
        } catch (NullPointerException exception) {
            throw new LinkException("No se pudo encontrar la url asociada al link: " + linkID, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public LinkDTO invalidateLink(Integer linkID) throws LinkException {
        try {
            return repository.invalidateLink(linkID);
        } catch (NoSuchElementException e) {
            throw new LinkException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public Integer linkMetrics(Integer linkID) {
        return repository.getMetric(linkID);
    }

    private void validate(LinkDTO link, String password) throws LinkException {
        if (!link.getValido()) {
            throw new LinkException("El link ingresado es inválido.", HttpStatus.NOT_FOUND);
        }
        if (!link.getPassword().equals(password)) {
            throw new LinkException("La contraseña para el link ingresado es incorrecta.",  HttpStatus.BAD_REQUEST);
        }
    }
}
