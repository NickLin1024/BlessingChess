package com.example.blessingchess;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.blessingchess.mapper")
public class BlessingChessApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlessingChessApplication.class, args);
	}

}
