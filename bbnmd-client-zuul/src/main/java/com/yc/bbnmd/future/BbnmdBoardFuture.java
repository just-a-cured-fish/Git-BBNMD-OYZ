package com.yc.bbnmd.future;

import com.yc.bbnmd.entity.Board;
import com.yc.bbnmd.service.BoardRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class BbnmdBoardFuture {
    @Autowired
    private BoardRestService boardRestService;

    @Async
    public CompletableFuture<String> findById(Integer id) {
        return CompletableFuture.supplyAsync(() -> {
            return boardRestService.findById(id);
        });
    }


    @Async
    public CompletableFuture<String> create(Board board) {
        return CompletableFuture.supplyAsync(() -> {
            return boardRestService.create(board);
        });
    }


    @Async
    public CompletableFuture<String> delete(Integer id) {
        return CompletableFuture.supplyAsync(() -> {
            return boardRestService.delete(id);
        });
    }
}
