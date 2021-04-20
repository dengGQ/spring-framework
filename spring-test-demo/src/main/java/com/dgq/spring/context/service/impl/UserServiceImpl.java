package com.dgq.spring.context.service.impl;

import com.dgq.spring.context.pojo.User;
import com.dgq.spring.context.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private User user;

	@Override
	public String getUserName(String number) {
		return user.getName()+"_"+number;
	}
}
