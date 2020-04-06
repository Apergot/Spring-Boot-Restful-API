package com.apergot.springbootrestapi.models.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class UploadFileServiceImp implements IUploadFileService {

    private final Logger log = LoggerFactory.getLogger(UploadFileServiceImp.class);
    private final static String DIRECTORY_UPLOAD = "uploads";

    @Override
    public Resource load(String filename) throws MalformedURLException{
        Path filePath = getPath(filename);
        log.info(filePath.toString());
        Resource resource = new UrlResource(filePath.toUri());
        if (!resource.exists() && !resource.isReadable()) {
            filePath = Paths.get("src/main/resources/static/images").resolve("no-user.png").toAbsolutePath();
            resource = new UrlResource(filePath.toUri());
            log.error("Error image could not be loaded" + filename);
        }
        return resource;
    }

    @Override
    public String save(MultipartFile file) throws IOException {
        String filename = UUID.randomUUID().toString()+ "_" +file.getOriginalFilename().replace(" ", "");
        Path filePath = getPath(filename);
        log.info(filePath.toString());
        Files.copy(file.getInputStream(), filePath);
        return filename;
    }

    @Override
    public boolean remove(String filename) {
        if (filename != null && filename.length() > 0) {
            Path lastImagePath = getPath(filename);
            File fileLastImage = lastImagePath.toFile();
            if (fileLastImage.exists() && fileLastImage.canRead()) {
                fileLastImage.delete();
            }
        }
        return false;
    }

    @Override
    public Path getPath(String filename) {
        return Paths.get(DIRECTORY_UPLOAD).resolve(filename).toAbsolutePath();
    }
}
