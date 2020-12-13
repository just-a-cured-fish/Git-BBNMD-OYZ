package com.yc.bbnmd1.restapi.user.controllers;


import com.google.gson.Gson;

import com.yc.bbnmd1.entity.User;
import com.yc.bbnmd1.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/bbnmd/user")
public class BbRestController {
    private static Logger logger = LoggerFactory.getLogger(BbRestController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{id}")
    public CompletableFuture<String> findById(@PathVariable Integer id) {

        //非阻塞式异步编程方法。因为在web ui的微服务对rest api的调用中将使用这种高并发的编程方法，所以为了保证与调用端保持同步，这里也使用这种方法.
        return CompletableFuture.supplyAsync(() -> {
            User user = userService.findById(id);
            //协议
            Map<String, Object> map = new HashMap<>();
            map.put("code", 1);
            map.put("data", user);
            System.out.println("map::::"+map);
            return new Gson().toJson(map);
        });

    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public CompletableFuture<String> findOne(@RequestBody User userbean) {

        //非阻塞式异步编程方法。因为在web ui的微服务对rest api的调用中将使用这种高并发的编程方法，所以为了保证与调用端保持同步，这里也使用这种方法.
        return CompletableFuture.supplyAsync(() -> {



            User user = userService.findOne(userbean);
            //协议
            Map<String, Object> map = new HashMap<>();
            map.put("code", 1);
            map.put("data", user);
            System.out.println("map::::"+map);
            return new Gson().toJson(map);
        });

    }



    @RequestMapping(method = RequestMethod.POST)
    public CompletableFuture<String> save(@RequestBody User user) throws Exception {
        return CompletableFuture.supplyAsync(() -> {
            userService.save(user);
            logger.info("新增->ID=" + user.getUid());
            Map<String, Object> map = new HashMap<>();
            map.put("code", 1);
            map.put("data", user);
            return new Gson().toJson(map);
        });
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public CompletableFuture<String> delete(@PathVariable Integer id) throws Exception {
        return CompletableFuture.supplyAsync(() -> {
            userService.delete(id);
            logger.info("删除->ID=" + id);
            Map<String, Object> map = new HashMap<>();
            map.put("code", 1);
            return new Gson().toJson(map);
        });
    }

}
