package com.home.wupupupu.controller;

import com.home.wupupupu.pojo.Result;
import com.home.wupupupu.util.OssUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@RestController

public class FileUploadController {
    @PostMapping("upload")
    public Result<String> userPic(MultipartFile file) throws Exception {
        String OriginalFilename= file.getOriginalFilename();
        String fileName= UUID.randomUUID()+OriginalFilename.substring(OriginalFilename.lastIndexOf("."));
        InputStream in=file.getInputStream();
        file.transferTo(new File("C:\\Users\\27160\\Desktop\\localPic\\"+fileName));
        return Result.success(OssUtil.upload(fileName,in));
    }
}
