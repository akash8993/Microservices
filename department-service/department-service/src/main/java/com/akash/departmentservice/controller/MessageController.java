package com.akash.departmentservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/*We have created this class to access the properties in github and return that*/
/*Here we have used RefreshScope annotation to reload this springbean we have created
* means the class only*/
@RestController
@RefreshScope
public class MessageController {
    @Value("${spring.boot.message}")
    private String message;

    @GetMapping("/getProperty")
    public String getData()
    {
        return message;
    }
}
