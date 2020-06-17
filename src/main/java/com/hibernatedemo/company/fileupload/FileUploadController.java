package com.hibernatedemo.company.fileupload;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Random;

@RestController
public class FileUploadController {

    String UPLOAD_DIR = System.getProperty("user.dir") + "/files/";

    @PostMapping(value = "/upload")
    public ContentFile handleFileUpload(@RequestParam(value = "file") MultipartFile file) throws IOException {
//        if (!Files.isDirectory(Paths.get(UPLOAD_DIR))) {
//            Files.createDirectory(Paths.get(UPLOAD_DIR));
//        }
//        String fileExtension = getFileExtension(file);
//        String filename = getRandomString();
//
//        File targetFile = getTargetFile(fileExtension, filename);
//
////        byte[] bytes = file.getBytes();
//        file.transferTo(targetFile);
//        String UploadedDirectory = targetFile.getAbsolutePath();
        return new ContentFile(file);
    }

//    @RequestMapping(value = "/upload/{galleryId}", method = RequestMethod.GET)
//    public ResponseEntity<byte[]> getFile(@PathVariable("galleryId") String galleryId) throws IOException {
//
//    }

    private String getRandomString() {
        return new Random().nextInt(999999) + "_" + System.currentTimeMillis();
    }

    private File getTargetFile(String fileExtn, String fileName) {
        return new File(UPLOAD_DIR + fileName + fileExtn);
    }

    private String getFileExtension(MultipartFile inFile) {
        return inFile.getOriginalFilename().substring(inFile.getOriginalFilename().lastIndexOf('.'));
    }

}
