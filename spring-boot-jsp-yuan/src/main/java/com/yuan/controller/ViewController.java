package com.yuan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yuaneg on 2016/8/22.
 */
@RestController
public class ViewController {

    @RequestMapping("/test")
    public String test(){
        return "这是什么";
    }

}
