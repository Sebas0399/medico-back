package com.centro.integral.medico.service;

import com.centro.integral.medico.repository.HistoriaClinicaRepository;
import com.centro.integral.medico.repository.entity.HistoriaClinica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;

@Service
public class FilesService implements IFilesService {
    @Autowired
    HistoriaClinicaRepository historiaClinicaRepository;

    @Override
    public String handleFileUpload(MultipartFile examen, String id, String uuid) throws IOException {
        Optional<HistoriaClinica> historiaClinica = this.historiaClinicaRepository.findById(Integer.valueOf(id));
        System.out.println(uuid);
        String fileName = UUID.randomUUID().toString();
        byte[] bytes = examen.getBytes();
        String fileOriginalName = examen.getOriginalFilename();
        long fileSize = examen.getSize();
        long maxFileSize = 20 * 1024 * 1024;
        if (fileSize > maxFileSize) {
            return "Examen supera el limite 20MB";
        }
        if (!fileOriginalName.endsWith(".pdf")) {
            return "Solo PDF";
        }
        String fileExtension = fileOriginalName.substring(fileOriginalName.lastIndexOf("."));
        String newFileName = fileName + fileExtension;
        File folder = new File("/examenes");
        if (!folder.exists()) {
            folder.mkdirs();
        }
        Path path = Paths.get("examenes/" + newFileName);
        Files.write(path, bytes);
        for (var algo : historiaClinica.get().getExamenes()) {
            if (algo.get("id").contains(uuid)) {
                algo.replace("ruta", path.toString());
            }
            System.out.println(algo.get("id"));
        }
        this.historiaClinicaRepository.save(historiaClinica.get());
        return "File upload succesfull";


    }
}
