package com.resttemplate.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

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

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(TestController.class);

    @PostMapping("post")
    public void testPost() {
        String value = restTemplate.postForObject(url, new Object().toString(), String.class);
        System.out.println(value);
    }

    @PostMapping("testGetForEntity")
    public void testGetForEntity() {
        //请求方式1
        String value = restTemplate.getForObject(url+"findPet?petId={1}",String.class,3434343);

        //请求方式2
        Map<String, Object> values = new HashMap<>();
        values.put("petId", 45667787);
        value = restTemplate.getForObject(url+"findPet?petId={petId}",String.class,values);
        log.info("value={}",value);
    }

    @PostMapping("testGetForObject")
    public void testGetForObject() {
        //请求方式1
        String value = restTemplate.getForObject(url+"findPet?petId={1}",String.class,3434343);

        //请求方式2
        Map<String, Object> values = new HashMap<>();
        values.put("petId", 45667787);
        value = restTemplate.getForObject(url+"findPet?petId={petId}",String.class,values);
        log.info("value={}",value);
    }
}
