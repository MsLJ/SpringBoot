package com.ms.rbk2.mp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class MyPhotoController {

    @Autowired
    MyPhotoDAO mpDAO;

    @PostMapping(value = "/photo.upload", produces = "application/json;charset=utf-8")
    public @ResponseBody MyPhoto photoUpload(@RequestParam("file2") MultipartFile mf,
                                              MyPhoto mp,
                                             HttpServletResponse res) {
        // 포스트 방식이기에 다 열면안돼는
        // 여는건 다 서버에 쓰는거
        res.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");
        // 리액트 크로스도메인할때필요한거
        res.addHeader("Access-Control-Allow-Credentials", "true");
        return mpDAO.upload(mf, mp);
    }

    @GetMapping(value = "/photo.get", produces = "application/json;charset=utf-8")
    public @ResponseBody MyPhotos photoGet(HttpServletResponse res) {
        res.addHeader("Access-Control-Allow-Origin", "*");
        return mpDAO.get();
    }

    @GetMapping(value = "/photo/{name}")
    public @ResponseBody Resource getPhoto(@PathVariable("name") String name) {
        return mpDAO.getPhoto(name);
    }
}
