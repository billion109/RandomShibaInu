package com.example.randomshiba.controller;

import com.example.randomshiba.dto.ShibaPicture;
import com.example.randomshiba.service.ShibaPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ShibaPictrueController {
    @Autowired
    ShibaPictureService shibaPictureService;

    @GetMapping("/")
    public String index() {
        return "redirect:/newPicture";
    }

    @GetMapping("/newPicture")
    public String newPicture(@CookieValue(value = "count", defaultValue = "1", required = true) String value,
                             ModelMap modelMap, HttpServletResponse response) {

        try {
            int i = Integer.parseInt(value);
            value = Integer.toString(++i);
        }catch(Exception ex){
            value = "1";
        }
        Cookie cookie = new Cookie("count", value);
        cookie.setMaxAge(60 * 60 * 24 * 365); // 1년 동안 유지.
        cookie.setPath("/"); // / 경로 이하에 모두 쿠키 적용.
        response.addCookie(cookie);


        ShibaPicture shibaPicture = shibaPictureService.getShibaOne();
        String imgName = shibaPicture.getName();
        modelMap.addAttribute("imgName", imgName);
        modelMap.addAttribute("count", value);

        return "main";
    }

}
