package com.fabiodc.cursocm;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.fabiodc.cursocm.domain")
@EnableJpaRepositories(basePackages = "com.fabiodc.cursocm.repositories")
public class CursocmApplication implements CommandLineRunner{
   
    
    
	public static void main(String[] args) {
        SpringApplication.run(CursocmApplication.class, args);
    }
    
    @Override
    public void run(String...args) throws Exception{
    	
    	
    }
    
}
