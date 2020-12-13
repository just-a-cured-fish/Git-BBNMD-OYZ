package com.yc.bbnmd1.future;

import com.yc.bbnmd1.entity.Topic;
import com.yc.bbnmd1.service.TopicRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

// 对外公开的业务层
@Component
public class BbnmdTopicFuture {
    @Autowired
    private TopicRestService topicRestService;

    @Async
    public CompletableFuture<String> findById(Integer id) {
        return CompletableFuture.supplyAsync(() -> {
            return topicRestService.findById(id);
        });
    }


    @Async
    public CompletableFuture<String> create(Topic topic) {
        return CompletableFuture.supplyAsync(() -> {
            return topicRestService.create(topic);
        });
    }


    @Async
    public CompletableFuture<String> delete(Integer id) {
        return CompletableFuture.supplyAsync(() -> {
            return topicRestService.delete(id);
        });
    }
}
