package com.dgq;

import com.dgq.SpringContextApplication;
import com.dgq.spring.context.pojo.User;
import com.dgq.spring.context.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

public class SpringContextTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringContextApplication.class);

		@SuppressWarnings (value="unchecked")
		final RedisTemplate<String, Object> redisTemplate = applicationContext.getBean(RedisTemplate.class);

		final UserService userService = applicationContext.getBean(UserService.class);

		User user = userService.getUserName("dgq");

		System.out.println(user);
	}
}
