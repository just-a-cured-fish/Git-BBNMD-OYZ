package com.yc.bbnmd.web.controllers;

import com.yc.bbnmd.entity.Board;
import com.yc.bbnmd.entity.Replay;
import com.yc.bbnmd.future.BbnmdBoardFuture;
import com.yc.bbnmd.future.BbnmdReplayFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/bbnmd/board")
public class BoardController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class.getName());

    @Autowired
    private BbnmdBoardFuture bbnmdBoardFuture;

    @RequestMapping(value = "/{id}")
    public CompletableFuture<String> findById(@PathVariable Integer id) {
        return bbnmdBoardFuture.findById(id);
    }


    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public CompletableFuture<String> save(@RequestBody Board board) {
        return bbnmdBoardFuture.create(board);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public CompletableFuture<String> delete(@PathVariable Integer id) {
        return bbnmdBoardFuture.findById(id);
    }
}
