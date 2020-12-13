package com.yc.bbnmd1.restapi.view.controllers;


import com.google.gson.Gson;

import com.yc.bbnmd1.domain.PageDomain;
import com.yc.bbnmd1.domain.ViewDomain;
import com.yc.bbnmd1.entity.Board;
import com.yc.bbnmd1.entity.Topic;
import com.yc.bbnmd1.entity.User;
import com.yc.bbnmd1.service.ViewService;
import com.yc.bbnmd1.util.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/bbnmd/view")
public class BbRestController {
    private static Logger logger = LoggerFactory.getLogger(BbRestController.class);

    @Autowired
    private ViewService viewService;

    @RequestMapping(value = "/check")
    public CompletableFuture<String> doCheck(HttpSession session) {
        //非阻塞式异步编程方法。因为在web ui的微服务对rest api的调用中将使用这种高并发的编程方法，所以为了保证与调用端保持同步，这里也使用这种方法.
        return CompletableFuture.supplyAsync(() -> {
            User user=(User) session.getAttribute("user");
            //协议
            Map<String, Object> map = new HashMap<>();
            map.put("code", 1);
            map.put("data", user);
            System.out.println("map::::"+map);
            return new Gson().toJson(map);
        });
    }

    @RequestMapping(method = RequestMethod.GET)
    public CompletableFuture<String> findIndex(HttpSession session) {
        //非阻塞式异步编程方法。因为在web ui的微服务对rest api的调用中将使用这种高并发的编程方法，所以为了保证与调用端保持同步，这里也使用这种方法.
        return CompletableFuture.supplyAsync(() -> {
            List<Board> parent=new ArrayList<Board>();
            List<Board> child=new ArrayList<Board>();
            List<Board> allBoards=viewService.getBoardAndTopic();
            Map<String, Object> map=new HashMap<String, Object>();
            for(int i=0;i<allBoards.size();i++) {
                Board board=allBoards.get(i);
                if(board.getParentid()==0) {
                    parent.add(board);//顶级板块信息存在parent
                }else {
                    child.add(board);
                }
            }
            map.put("parent",parent);
            map.put("child", child);
            map.put("code", 1);
            System.out.println("map::::"+map);
            return new Gson().toJson(map);
        });
    }





    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public CompletableFuture<String> findById(@PathVariable Integer id) {

        //非阻塞式异步编程方法。因为在web ui的微服务对rest api的调用中将使用这种高并发的编程方法，所以为了保证与调用端保持同步，这里也使用这种方法.
        return CompletableFuture.supplyAsync(() -> {
            Topic topic = viewService.getTopic(id);
            //协议
            Map<String, Object> map = new HashMap<>();
            map.put("code", 1);
            map.put("data", topic);
            System.out.println("map::::"+map);
            return new Gson().toJson(map);
        });

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public CompletableFuture<String> delete(@PathVariable Integer id) throws Exception {
        return CompletableFuture.supplyAsync(() -> {
            viewService.deleteReplay(id);
            logger.info("删除->ID=" + id);
            Map<String, Object> map = new HashMap<>();
            map.put("code", 1);
            return new Gson().toJson(map);
        });
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public CompletableFuture<String> findAll(Integer page, Integer pageSize,Integer bid) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                ViewDomain viewDomain = new ViewDomain();
                viewDomain.setBoardid(bid);

                if (CommonUtils.isNotNull(page)) {
                    viewDomain.setPage(page);
                }
                if (CommonUtils.isNotNull(pageSize)) {
                    viewDomain.setPageSize(pageSize);
                }

                PageDomain<ViewDomain> pageDomain = viewService.getTopicByPage(viewDomain);

                Map<String, Object> map = new HashMap<>();
                map.put("code", 1);
                map.put("data", pageDomain);


                return new Gson().toJson(map);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        });
    }

}
