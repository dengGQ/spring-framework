package com.dgq.spring.context.domain;

import com.dgq.spring.context.pojo.User;
import com.dgq.spring.context.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class Account {

	@Autowired
	private UserService userService;

	public void printUserName(){

		final User user = userService.getUserName("dgq");
		System.out.println(user.getName());
	}
}
