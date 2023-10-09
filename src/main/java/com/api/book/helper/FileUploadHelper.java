package com.api.book.helper;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileUploadHelper {
   // public final String URL_DIR="E:\\Spring\\bootrestbook\\src\\main\\resources\\static\\Image";
    public final String URL_DIR=new ClassPathResource("static/Image/").getFile().getAbsolutePath();

    public FileUploadHelper()throws IOException
    {

    }
    public boolean uploadFile(MultipartFile multipartFile)
    {
        boolean b= false;
        try{
           // InputStream is = multipartFile.getInputStream();
           // byte data[] = new byte[is.available()];
           // is.read(data);

           // FileOutputStream fos = new FileOutputStream(URL_DIR+ File.separator + multipartFile.getOriginalFilename());
           // fos.write(data);

          //  fos.close();
            Files.copy(multipartFile.getInputStream(), Paths.get(URL_DIR+File.separator+multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            b = true;

        }catch (Exception e)
        {
            e.printStackTrace();
        }


        return b;
    }
}
