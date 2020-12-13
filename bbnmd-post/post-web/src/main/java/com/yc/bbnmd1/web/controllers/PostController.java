package com.yc.bbnmd1.web.controllers;

import com.yc.bbnmd1.entity.Replay;
import com.yc.bbnmd1.entity.Topic;
import com.yc.bbnmd1.future.BbnmdPostFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/bbnmd/post")
public class PostController {
    private static Logger logger = LoggerFactory.getLogger(PostController.class.getName());

    @Autowired
    private BbnmdPostFuture bbnmdPostFuture;

    @RequestMapping(value = "/{id}")
    public CompletableFuture<String> findById(@PathVariable Integer id) {
        return bbnmdPostFuture.findById(id);
    }


    @RequestMapping(value = "/saveRepaly",method = RequestMethod.POST)
    public CompletableFuture<String> saveReplay(@RequestBody Replay replay) {
        return bbnmdPostFuture.createReplay(replay);
    }

    @RequestMapping(value = "/saveTopic",method = RequestMethod.POST)
    public CompletableFuture<String> saveTopic(@RequestBody Topic topic) {
        return bbnmdPostFuture.createTopic(topic);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public CompletableFuture<String> update(@RequestBody Replay replay) {
        return bbnmdPostFuture.update(replay);
    }
}
