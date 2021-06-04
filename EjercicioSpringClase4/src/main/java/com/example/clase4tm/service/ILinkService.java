package com.example.clase4tm.service;

import com.example.clase4tm.dto.CreateLinkRequestDTO;
import com.example.clase4tm.dto.CreateLinkResponseDTO;
import com.example.clase4tm.dto.LinkDTO;
import com.example.clase4tm.model.LinkException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

public interface ILinkService {
    public CreateLinkResponseDTO createLink(CreateLinkRequestDTO requestDTO);
    public String redirect(Integer linkID, String password) throws LinkException;
    public LinkDTO invalidateLink(Integer linkID) throws LinkException;
    public Integer linkMetrics(Integer linkID);
}
