package com.example.blessingchess.controller;

import com.example.blessingchess.data.vo.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User")
public class UserController {

    public Result handleLogin(@RequestBody UserController userController) {
        return Result.ok();
    }

    class UserLoginBody {
        private String code;
        private String encryptedData;
        private String iv;
        private String rawData;
        private String signature;

    }
}
