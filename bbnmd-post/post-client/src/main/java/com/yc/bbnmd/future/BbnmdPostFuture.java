package com.yc.bbnmd.future;

import com.yc.bbnmd.entity.Replay;
import com.yc.bbnmd.entity.Topic;
import com.yc.bbnmd.service.PostRestService;
import net.sf.jsqlparser.statement.select.Top;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class BbnmdPostFuture {
    @Autowired
    private PostRestService postRestService;

    @Async
    public CompletableFuture<String> findById(Integer id) {
        return CompletableFuture.supplyAsync(() -> {
            return postRestService.findById(id);
        });
    }


    @Async
    public CompletableFuture<String> createReplay(Replay replay) {
        return CompletableFuture.supplyAsync(() -> {
            return postRestService.createReplay(replay);
        });
    }

    @Async
    public CompletableFuture<String> createTopic(Topic topic) {
        return CompletableFuture.supplyAsync(() -> {
            return postRestService.createTopic(topic);
        });
    }

    @Async
    public CompletableFuture<String> update(Replay replay) {
        return CompletableFuture.supplyAsync(() -> {
            return postRestService.update(replay);
        });
    }

}

