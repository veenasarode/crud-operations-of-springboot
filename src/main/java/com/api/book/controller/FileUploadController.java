package com.api.book.controller;

import com.api.book.helper.FileUploadHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class FileUploadController {
    @Autowired
    private FileUploadHelper fileUploadHelper;
    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file)
    {
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());
        try {
            if(file.isEmpty())
            {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File is Empty");
            }


            boolean f = fileUploadHelper.uploadFile(file);
            if (f)
            {
                //return ResponseEntity.ok("File uploaded sucessfully");
                return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.ok("working");
    }
}
