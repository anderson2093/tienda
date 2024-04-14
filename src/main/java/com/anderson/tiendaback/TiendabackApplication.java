package com.anderson.tiendaback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.anderson.tiendaback.config.RsaKeyConfigProperties;





@Configuration
@EnableConfigurationProperties(RsaKeyConfigProperties.class)
@SpringBootApplication
public class TiendabackApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendabackApplication.class, args);
	}


}
