package com.lyj.web.controller;


import com.lyj.dto.FileInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @auther lyj
 * @date 2018/11/20 0020 下午 14:02
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @PostMapping
    public FileInfo upload(MultipartFile file) throws IOException {
        System.out.println(file.getName());
        System.out.println( file.getOriginalFilename());
        System.out.println(file.getSize());
        String folder="D:/lyjsecurity/lyj-security-demo/src/main/java/com/lyj/web";
        File localFile=new File(folder,new Date().getTime()+".txt");
        file.transferTo(localFile);
        return new FileInfo(localFile.getAbsolutePath());

    }
}
