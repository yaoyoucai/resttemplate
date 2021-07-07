package com.resttemplate.demo.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

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
    public RestTemplate getRestTemplate(RestTemplateBuilder builder) {
        //获取到所有的请求消息转换器
        List<HttpMessageConverter<?>> messageConverters = builder.build().getMessageConverters();
        for (HttpMessageConverter<?> messageConverter : messageConverters) {
            //判断是否是json转换器
            if (messageConverter instanceof StringHttpMessageConverter) {
                List<MediaType> supportedMediaTypes = messageConverter.getSupportedMediaTypes();
                //上面拿到的集合是Arrays.asList(),不能直接修改，所以需要重新创建集合
                List<MediaType> mediaTypes = new ArrayList<>(supportedMediaTypes);
                //加入对text/html的支持
                mediaTypes.add(MediaType.TEXT_HTML);
                ((StringHttpMessageConverter) messageConverter).setSupportedMediaTypes(mediaTypes);
            }
        }
        return builder.build();
    }
}
