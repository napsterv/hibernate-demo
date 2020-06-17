package com.hibernatedemo.company.fileupload;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class FileUploadAlternateController {

    private final ContentFileRepository contentFileRepository;

    public FileUploadAlternateController(ContentFileRepository contentFileRepository) {
        this.contentFileRepository = contentFileRepository;
    }

    @PostMapping(value = "upload_file")
    public ContentFile addFile(@RequestParam(value = "file") MultipartFile file) throws IOException {
        ContentFile contentFile = new ContentFile(file);
        return contentFileRepository.save(contentFile);
    }

    @GetMapping(value = "upload_file")
    public List<ContentFile> getFiles() {
        return contentFileRepository.findAll();
    }
}