package com.example.BlessingChess;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

//@ServletComponentScan	//支持filter
@SpringBootApplication
@MapperScan("com.example.BlessingChess.mapper")
public class BlessingChessApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlessingChessApplication.class, args);
	}

}
