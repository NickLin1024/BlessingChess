package com.example.BlessingChess.controller;

import com.example.BlessingChess.service.BlessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blessing")
public class BlessingController {
    @Autowired
    BlessingService blessingService;
}
