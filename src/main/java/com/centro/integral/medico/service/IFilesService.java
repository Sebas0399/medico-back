package com.centro.integral.medico.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IFilesService {
    String handleFileUpload(MultipartFile examen, String id, String uuid) throws IOException;
}
