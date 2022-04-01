package com.dgq;

import com.dgq.spring.context.pojo.User;
import com.dgq.spring.context.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@SpringBootApplication
@RestController
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Resource
	private UserService userService;

	@GetMapping("/springCache/test/{userName}")
	public void test(@PathVariable("userName")String userName) {
		User user = userService.getUserName(userName);
		System.out.println(user.getClass().getClassLoader());
	}
}
