package com.wdk.permissions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableDiscoveryClient
@EnableTransactionManagement
@MapperScan("com.wdk.permissions.dao")
public class PermissionsServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PermissionsServerApplication.class, args);
	}
}
