package com.example.randomshiba.service;

import com.example.randomshiba.dao.ShibaPictureDao;
import com.example.randomshiba.dto.ShibaPicture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShibaPictureServiceImpl implements ShibaPictureService {
    @Autowired
    ShibaPictureDao shibaPictureDao;

    @Override
    public List<ShibaPicture> getShiba() {
        return shibaPictureDao.selectAll();
    }

    @Override
    public int insertShiba(List<String> list) {
       int cnt = 0;
        for (String name : list) {
            ShibaPicture shibaPicture = new ShibaPicture();
            shibaPicture.setName(name);
            int i = shibaPictureDao.insert(shibaPicture);
            cnt += i;
        }

        return cnt;
    }

    @Override
    public ShibaPicture getShibaOne() {
        return shibaPictureDao.selectRandomOne();
    }
}
