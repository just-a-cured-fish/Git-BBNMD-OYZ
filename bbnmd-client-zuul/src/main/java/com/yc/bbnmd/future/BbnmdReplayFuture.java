package com.yc.bbnmd.future;

import com.yc.bbnmd.entity.Replay;
import com.yc.bbnmd.entity.Topic;
import com.yc.bbnmd.service.ReplayRestService;
import com.yc.bbnmd.service.TopicRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

// 对外公开的业务层
@Component
public class BbnmdReplayFuture {
    @Autowired
    private ReplayRestService replayRestService;

    @Async
    public CompletableFuture<String> findById(Integer id) {
        return CompletableFuture.supplyAsync(() -> {
            return replayRestService.findById(id);
        });
    }


    @Async
    public CompletableFuture<String> create(Replay replay) {
        return CompletableFuture.supplyAsync(() -> {
            return replayRestService.create(replay);
        });
    }


    @Async
    public CompletableFuture<String> delete(Integer id) {
        return CompletableFuture.supplyAsync(() -> {
            return replayRestService.delete(id);
        });
    }
}
