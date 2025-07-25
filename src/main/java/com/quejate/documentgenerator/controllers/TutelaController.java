package com.quejate.documentgenerator.controllers;

import com.quejate.documentgenerator.dtos.TutelaRequestDTO;
import com.quejate.documentgenerator.services.TutelaGeneratorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tutelas")
public class TutelaController {

    private final TutelaGeneratorService tutelaService;

    public TutelaController(TutelaGeneratorService tutelaService) {
        this.tutelaService = tutelaService;
    }

    @PostMapping
    public ResponseEntity<String> generarTutela(@RequestBody TutelaRequestDTO request) {
        String documentoTutela = tutelaService.generarTutela(request);
        return ResponseEntity.ok(documentoTutela);
    }
}
