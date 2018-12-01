package com.example.clientdemo;

import java.io.IOException;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.User;
import com.example.UserService;

@SpringBootApplication(scanBasePackages = "com.example")
public class ClientDemoApplication {

	@Reference(version = "1.0.0")
	private UserService userService;

	public static void main(String[] args) throws IOException, InterruptedException {
		ConfigurableApplicationContext context = SpringApplication.run(ClientDemoApplication.class, args);

		ClientDemoApplication application = context.getBean(ClientDemoApplication.class);

//		 application.loop();
	}

	public void loop() throws InterruptedException {
		while (true) {
			List<User> users = userService.listUsers();
			Thread.sleep(10);
		}
	}

}
