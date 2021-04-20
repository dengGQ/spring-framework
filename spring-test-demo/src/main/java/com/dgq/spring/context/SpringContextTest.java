package com.dgq.spring.context;

import com.dgq.spring.context.pojo.User;
import com.dgq.spring.context.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringContextTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringContextApplication.class);

		UserService userService = applicationContext.getBean(UserService.class);

		System.out.println(userService.getUserName("邓国泉"));
	}
}
