package com.resttemplate.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author huanyao
 * @version 1.0
 * @ClassName TestController.java
 * @Description TODO(用一句话描述该文件做什么)
 * @date 2021/7/7 4:15 下午
 */
@RestController
@RequestMapping("/test/")
public class TestController {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${url}")
    private String url;

    @PostMapping("post")
    public void testPost() {
        String value = restTemplate.postForObject(url, new Object().toString(), String.class);
        System.out.println(value);
    }
}
