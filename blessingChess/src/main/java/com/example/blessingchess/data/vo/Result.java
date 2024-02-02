package com.example.blessingchess.data.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Integer code;
    private Object data;
    private String message;

    public static Result success(Object data, String message){
        return new Result(200, data, message);
    }

    public static Result ok() {
        return new Result(200, null, "ok");
    }

    public static Result error(Integer code, String message){
        return new Result(code, null, message);
    }

}
