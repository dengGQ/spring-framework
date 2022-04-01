package com.dgq.spring.context.service;

import com.dgq.spring.context.pojo.User;

public interface UserService {


	User getUserNameCache(String name);
	User getUserName(String name);
}
