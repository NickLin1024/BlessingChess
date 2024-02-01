package com.example.blessingchess.data.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginData {
    @Getter
    private String code;
    private String encryptedData;
    private String iv;
    private String rawData;
    private String signature;
}
