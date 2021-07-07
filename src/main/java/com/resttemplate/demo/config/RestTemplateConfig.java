package com.resttemplate.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author huanyao
 * @version 1.0
 * @ClassName RestTemplateConfig.java
 * @Description restTemplate配置类
 * @date 2021/7/7 4:13 下午
 */
@Configuration
public class RestTemplateConfig {
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
