package com.example.randomshiba.service;

import com.example.randomshiba.dto.ShibaPicture;

import java.util.List;

public interface ShibaPictureService {
    public List<ShibaPicture> getShiba();
    public int insertShiba(List<String> list);
    public ShibaPicture getShibaOne();
}
