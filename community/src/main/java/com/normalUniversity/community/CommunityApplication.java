package com.normalUniversity.community;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 扫描配置类所在的包下以及子包下的bean（比如controller里的）
@MapperScan({"com.normalUniversity.community.dao"})
public class CommunityApplication {

	public static void main(String[] args) {
		// 在底层主动为我们创建Spring Container
		SpringApplication.run(CommunityApplication.class, args);
	}

}
