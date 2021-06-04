package com.example.clase4tm.controller;

import com.example.clase4tm.dto.CreateLinkRequestDTO;
import com.example.clase4tm.dto.CreateLinkResponseDTO;
import com.example.clase4tm.dto.ErrorResponseDTO;
import com.example.clase4tm.dto.LinkDTO;
import com.example.clase4tm.model.LinkException;
import com.example.clase4tm.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class LinkController {

    @Autowired
    ILinkService service;

    @PostMapping("/create")
    public ResponseEntity<CreateLinkResponseDTO> createLink(@RequestBody CreateLinkRequestDTO requestDTO) {
        return new ResponseEntity<CreateLinkResponseDTO>(service.createLink(requestDTO), HttpStatus.OK);
    }

    @GetMapping("/link/{linkID}")
    public RedirectView redirectToLink(@PathVariable Integer linkID, @RequestParam String password) throws LinkException {
        return new RedirectView( service.redirect(linkID, password));
    }

    @GetMapping("/metrics/{linkID}")
    public ResponseEntity<Integer> linkMetrics(@PathVariable Integer linkID) {
        return new ResponseEntity<Integer>(service.linkMetrics(linkID), HttpStatus.OK);
    }
    @PostMapping("/invalidate/{linkID}")
    public ResponseEntity<LinkDTO> invalidateLink(@PathVariable Integer linkID) throws LinkException {
        return new ResponseEntity<LinkDTO>(service.invalidateLink(linkID), HttpStatus.OK);
    }
}