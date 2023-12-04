package com.example.pruebas;

import com.example.pruebas.storage.StorageProperties;
import com.example.pruebas.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class PruebasApplication {

	public static void main(String[] args) {
		String command = "C:\\xampp\\mysql\\bin\\mysqld.exe";
		try{
			Process process = Runtime.getRuntime().exec(command);
		}catch (IOException e){
			e.printStackTrace();
		}
		SpringApplication.run(PruebasApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			//storageService.deleteAll();
			storageService.init();
		};
	}

}
