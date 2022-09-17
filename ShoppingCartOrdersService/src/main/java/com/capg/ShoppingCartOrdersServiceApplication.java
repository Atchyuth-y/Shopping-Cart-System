package com.capg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages ="com.capg.controller" )
@ComponentScan(basePackages ="com.capg.service" )
@ComponentScan(basePackages ="com.capg.entity" )
@ComponentScan(basePackages ="com.capg.dto" )
@ComponentScan(basePackages ="com.capg.repository" )
public class ShoppingCartOrdersServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartOrdersServiceApplication.class, args);
	}

}
