package com.yc.bbnmd1.web.controllers;

import com.yc.bbnmd1.entity.Replay;
import com.yc.bbnmd1.future.BbnmdReplayFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/bbnmd/replay")
public class ReplayController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class.getName());

    @Autowired
    private BbnmdReplayFuture bbnmdReplayFuture;

    @RequestMapping(value = "/{id}")
    public CompletableFuture<String> findById(@PathVariable Integer id) {
        return bbnmdReplayFuture.findById(id);
    }


    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public CompletableFuture<String> save(@RequestBody Replay replay) {
        return bbnmdReplayFuture.create(replay);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public CompletableFuture<String> delete(@PathVariable Integer id) {
        return bbnmdReplayFuture.findById(id);
    }

}