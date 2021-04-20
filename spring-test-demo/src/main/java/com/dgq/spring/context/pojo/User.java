package com.dgq.spring.context.pojo;

import org.springframework.stereotype.Component;

@Component
public class User {

	private String name = "dgq";

	public String getName() {
		return name;
	}
}
