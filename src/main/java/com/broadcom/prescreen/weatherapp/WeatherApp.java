package com.broadcom.prescreen.weatherapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

@SpringBootApplication
public class WeatherApp {

	public static void main(String[] args) {

		double x;
		double y;
		Scanner sc = new Scanner(System.in);

		System.out.println("This is Broadcom Pre screening application");
		ApplicationContext applicationContext = SpringApplication.run(WeatherApp.class,args);
		WeatherRestClient weatherAppClient = applicationContext.getBean(WeatherRestClient.class);

		System.out.println("Enter Latitude: ");
		while (!sc.hasNextDouble())
		{
			System.out.println("Invalid input\n please type number:");
			sc.next();
		}
		x=sc.nextDouble();

		System.out.println("Enter Longitude: ");
		while (!sc.hasNextDouble())
		{
			System.out.println("Invalid input\n please type number:");
			sc.next();
		}
		y=sc.nextDouble();

	System.out.println(weatherAppClient.callGetWeatherForecastByCoordinatesAPI(x, y));


	}

}
