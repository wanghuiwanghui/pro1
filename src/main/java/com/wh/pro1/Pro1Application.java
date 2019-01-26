package com.wh.pro1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wh
 */
@SpringBootApplication
@MapperScan("com.wh.pro1.dao")
public class Pro1Application {

	public static void main(String[] args) {
		SpringApplication.run(Pro1Application.class, args);
	}

}

