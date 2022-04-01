package com.dgq.spring.context.service.impl;

import com.dgq.spring.context.pojo.User;
import com.dgq.spring.context.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig
public class UserServiceImpl implements UserService {

	/**
	 * @CachePut将结果缓存起来,且该方法不管缓存是否存在每次都会执行
	 * @param name
	 * @return
	 */
	@Override
	@CachePut(value = "cache_test", key = "#name")
	public User getUserNameCache(String name) {
		return getUserName(name);
	}

	/**
	 * @Cacheable 将结果缓存起来，当参数相同时从缓存中取
	 * @param name
	 * @return
	 */
	@Override
	@Cacheable(value = "cache_test", key = "#name")
	public User getUserName(String name) {
		System.out.println("----------------getUserName:"+name);

		User user = new User();

		user.setName(name);

		return user;
	}
}
