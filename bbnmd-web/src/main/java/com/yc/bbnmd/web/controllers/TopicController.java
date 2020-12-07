package com.yc.bbnmd.web.controllers;

import com.yc.bbnmd.entity.Topic;
import com.yc.bbnmd.future.BbnmdTopicFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/bbnmd/topic")
public class TopicController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class.getName());

    @Autowired
    private BbnmdTopicFuture bbnmdTopicFuture;

    @RequestMapping(value = "/{id}")
    public CompletableFuture<String> findById(@PathVariable Integer id) {
        return bbnmdTopicFuture.findById(id);
    }


    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public CompletableFuture<String> save(@RequestBody Topic topic) {
        return bbnmdTopicFuture.create(topic);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public CompletableFuture<String> delete(@PathVariable Integer id) {
        return bbnmdTopicFuture.findById(id);
    }

}
