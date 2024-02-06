package com.example.BlessingChess.service;

import com.example.BlessingChess.mapper.BlessingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlessingService {
    //注入BlessingMapper
    @Autowired
    BlessingMapper blessingMapper;
}
