package com.dgq.spring.context.pojo;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = -6032135122746054939L;
	private Long id;

	private String name;

	private Integer age;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
