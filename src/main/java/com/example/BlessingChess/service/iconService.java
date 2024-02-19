package com.example.BlessingChess.service;

import com.example.BlessingChess.utils.ImageStorageUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class iconService {

    public void uploadIcon(MultipartFile file, Integer userId){
        ImageStorageUtils imageStorageUtils = new ImageStorageUtils("/icon");
    }
}
