package com.anderson.tiendaback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


import com.anderson.tiendaback.config.RsaKeyConfigProperties;


@EnableConfigurationProperties(RsaKeyConfigProperties.class)
@SpringBootApplication
public class TiendabackApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendabackApplication.class, args);
	}

}
