package com.hibernatedemo.company.fileupload;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Entity
@Table(name = "files")
public class ContentFile {

    @Transient
    private final String UPLOAD_DIR = System.getProperty("user.dir") + "/files/";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Transient
    private MultipartFile file;

    private String url;

    public ContentFile(MultipartFile file) throws IOException {
        this.file = file;
        if (!Files.isDirectory(Paths.get(UPLOAD_DIR))) {
            Files.createDirectory(Paths.get(UPLOAD_DIR));
        }
        file.transferTo(new File(UPLOAD_DIR + file.getOriginalFilename()));
        url = "/files/" + file.getOriginalFilename();
        this.setUrl(url);
    }

    public ContentFile() {
    }

    public ContentFile(Integer id, MultipartFile file, String url) {
        this.id = id;
        this.file = file;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getUrl() {
        return ServletUriComponentsBuilder.fromCurrentContextPath().path(this.url).toUriString();
    }

    public void setUrl(String url) throws IOException {
        this.url = url;
    }

    private File getTargetFile(String fileName) {
        return new File(UPLOAD_DIR + fileName);
    }
}
