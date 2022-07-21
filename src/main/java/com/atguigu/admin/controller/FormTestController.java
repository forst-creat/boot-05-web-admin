package com.atguigu.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件上传
 * @author liuyang
 * @create 2022-07-06-10:03
 */
@Slf4j
@Controller
public class FormTestController {

    @GetMapping("/form_layouts")
    public String form_layouts() {
        int i = 10 / 0;
        return "form/form_layouts";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImage")MultipartFile headerImage,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {
    log.info("上传的信息：email={},username={},headerImage={},photos={}",
            email,username,headerImage.getSize(),photos.length);

    if (!headerImage.isEmpty()) {
        //保存到文件服务器，oss服务器
        String originalFilename = headerImage.getOriginalFilename();
        headerImage.transferTo(new File("F:\\image\\" + originalFilename));
    }

    if (photos.length > 0) {
        for (MultipartFile photo: photos) {
            if (!photo.isEmpty()) {
                String originalFilename = photo.getOriginalFilename();
                photo.transferTo(new File("F:\\image\\" + originalFilename));
            }
        }
    }
        return "index";
    }

}
