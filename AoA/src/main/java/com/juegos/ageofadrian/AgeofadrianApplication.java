package com.juegos.ageofadrian;

import com.juegos.ageofadrian.backsrv.BeanIO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AgeofadrianApplication {

	public static void main(String[] args) {
		BeanIO beanio = new BeanIO();
		//beanio.lecturaCSV("LegionesPrimeraVersion");
		SpringApplication.run(AgeofadrianApplication.class, args);

	}
}
