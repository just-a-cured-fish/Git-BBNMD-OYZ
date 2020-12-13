package com.yc.bbnmd1.web.controllers;

import com.yc.bbnmd1.future.BbnmdViewFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/bbnmd/view")
public class ViewController {
    private static Logger logger = LoggerFactory.getLogger(ViewController.class.getName());

    @RequestMapping(value = "/")
    public String getIndex() {
        System.out.println("测试");
        System.out.println("测试");
        System.out.println("测试");
        System.out.println("测试");
        System.out.println("测试");
        System.out.println("测试");


        return "index";
    }

//    String findIndex();
    @Autowired
    private BbnmdViewFuture bbnmdViewFuture;

    @RequestMapping(value = "/check",method = RequestMethod.GET)
    public CompletableFuture<String> check() {
        return bbnmdViewFuture.check();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public CompletableFuture<String> findById(@PathVariable Integer id) {
        return bbnmdViewFuture.findById(id);
    }




    @RequestMapping(value = "/findPage", method = RequestMethod.GET)
    public CompletableFuture<String> findAll(Integer page, Integer pageSize,Integer bid) {
        return bbnmdViewFuture.findPage(page, pageSize,bid);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public CompletableFuture<String> update(@PathVariable Integer id) {
        return bbnmdViewFuture.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public CompletableFuture<String> findIndex() {
        return bbnmdViewFuture.findIndex();
    }
}
