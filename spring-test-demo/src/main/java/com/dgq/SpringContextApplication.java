package com.dgq;

import org.springframework.boot.devtools.restart.classloader.RestartClassLoader;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.support.NoOpCacheManager;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/*@Configuration
@ComponentScan("com.dgq.spring")
@EnableAspectJAutoProxy
@EnableCaching*/
public class SpringContextApplication {
}
