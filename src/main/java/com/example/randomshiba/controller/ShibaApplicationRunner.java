//package com.example.randomshiba.controller;
//
//import com.example.randomshiba.service.ShibaPictureService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
//import org.springframework.stereotype.Component;
//
//import java.io.File;
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class ShibaApplicationRunner implements ApplicationRunner {
//    @Autowired
//    ShibaPictureService shibaPictureService;
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        List<String> list = new ArrayList<>();
//
//
//        Resource resource = new ClassPathResource("static/shibaPic");
//        File file = resource.getFile();
//
//        for(File file2 : file.listFiles()){
//            list.add(file2.getName());
//        }
//
//        shibaPictureService.insertShiba(list);
//    }
//}
