package com.yc.bbnmd1.restapi.post.controllers;

import com.google.gson.Gson;
import com.yc.bbnmd1.entity.Replay;
import com.yc.bbnmd1.entity.Topic;
import com.yc.bbnmd1.entity.User;
import com.yc.bbnmd1.service.PostService;
import com.yc.bbnmd1.service.ReplayService;
import com.yc.bbnmd1.service.TopicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;


@RestController
@RequestMapping("/bbnmd/post")
public class BbRestController {
    private static Logger logger = LoggerFactory.getLogger(BbRestController.class);

    @Autowired
    private PostService postService;

    @Autowired
    private ReplayService replayService;

    @Autowired
    private TopicService topicService;

    @RequestMapping(value = "/replay/{id}")
    public CompletableFuture<String> findById(@PathVariable Integer id) {

        //非阻塞式异步编程方法。因为在web ui的微服务对rest api的调用中将使用这种高并发的编程方法，所以为了保证与调用端保持同步，这里也使用这种方法.
        return CompletableFuture.supplyAsync(() -> {
            Replay replay = replayService.findOne(id);
            //协议
            Map<String, Object> map = new HashMap<>();
            map.put("code", 1);
            map.put("data", replay);
            System.out.println("map::::"+map);
            return new Gson().toJson(map);
        });

    }



    @RequestMapping(value = "/topic",method = RequestMethod.POST)
    public CompletableFuture<String> saveTopic(@RequestBody Topic topic, HttpSession session) throws Exception {
        return CompletableFuture.supplyAsync(() -> {
            User user= (User) session.getAttribute("user");
            topic.setUid(user.getUid());
            topicService.save(topic);
            logger.info("新增->ID=" + topic.getTid());
            Map<String, Object> map = new HashMap<>();
            map.put("code", 1);
            map.put("data", topic);
            return new Gson().toJson(map);
        });
    }

    @RequestMapping(value = "/replay",method = RequestMethod.PUT)
    public CompletableFuture<String> update(@RequestBody Replay replay) throws Exception {
        return CompletableFuture.supplyAsync(() -> {
            int num=postService.update(replay);
            Map<String, Object> map = new HashMap<>();
            map.put("code", 1);
            map.put("data", num);
            return new Gson().toJson(map);
        });
    }
    @RequestMapping(value = "/replay",method = RequestMethod.POST)
    public CompletableFuture<String> saveReplay(@RequestBody Replay replay, HttpSession session) throws Exception {
        return CompletableFuture.supplyAsync(() -> {
            User user= (User) session.getAttribute("user");
            replay.setUid(user.getUid());
            replayService.save(replay);
            logger.info("新增->ID=" + replay.getRid());
            Map<String, Object> map = new HashMap<>();
            map.put("code", 1);
            map.put("data", replay);
            return new Gson().toJson(map);
        });
    }

}
