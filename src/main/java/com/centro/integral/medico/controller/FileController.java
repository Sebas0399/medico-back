package com.centro.integral.medico.controller;

import com.centro.integral.medico.service.IFilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/upload")
@CrossOrigin

public class FileController {
    @Autowired
    IFilesService filesService;

    @PostMapping("/examen")
    private ResponseEntity<String> uploadExamen(@RequestParam("examen") MultipartFile file, @RequestParam String id, @RequestParam String uuid) throws IOException {
        return ResponseEntity.of(Optional.of(filesService.handleFileUpload(file, id, uuid)));
    }
}

