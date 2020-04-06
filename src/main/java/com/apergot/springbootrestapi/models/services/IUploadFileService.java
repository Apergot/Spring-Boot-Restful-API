package com.apergot.springbootrestapi.models.services;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;

public interface IUploadFileService {

    public Resource load(String filename) throws MalformedURLException;
    public String save(MultipartFile file) throws IOException;
    public boolean remove(String filename);
    public Path getPath(String filename);
}
