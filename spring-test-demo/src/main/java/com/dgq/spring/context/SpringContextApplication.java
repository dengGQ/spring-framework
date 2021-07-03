package com.dgq.spring.context;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.dgq.spring.context")
@EnableAspectJAutoProxy
public class SpringContextApplication {
}
