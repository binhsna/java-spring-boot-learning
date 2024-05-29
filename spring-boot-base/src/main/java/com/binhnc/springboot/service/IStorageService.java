package com.binhnc.springboot.service;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface IStorageService {
    public String storeFile(MultipartFile file);

    // Load all file inside a folder
    public Stream<Path> loadAll();

    public byte[] readFileContent(String fileName);

    public void deleteAllFiles();
}
