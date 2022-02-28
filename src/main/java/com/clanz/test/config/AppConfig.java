package com.clanz.test.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com")
@PropertySource(value = {"classpath:config.properties"}, encoding = "UTF-8")
public class AppConfig {

}
