package de.haegerconsulting.internShop.hcproductservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HcProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HcProductServiceApplication.class, args);
	}

}
