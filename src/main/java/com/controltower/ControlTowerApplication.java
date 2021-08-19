package com.controltower;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ControlTowerApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ControlTowerApplication.class, args);
	}
	
	@Override
    public void run(String... args) {
		Scanner scanner= new Scanner(System.in);
        System.out.println("hello world!");
        System.out.println("tell me your name: ");
        String name=scanner.next();
        System.out.println("well, have a nice day " + name);
        scanner.close();
    }

}
