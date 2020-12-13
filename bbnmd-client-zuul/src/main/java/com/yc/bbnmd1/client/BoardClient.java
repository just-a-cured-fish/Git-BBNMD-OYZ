package com.yc.bbnmd1.client;

import com.yc.bbnmd1.config.FeignClientConfig;
import com.yc.bbnmd1.entity.Board;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "BASE-MICROSERVICE-ZUUL-GATEWAY",
        configuration = FeignClientConfig.class
)  // 配置要按自定义的类FeignClientConfig
public interface BoardClient {

    //访问的路径value要修改成zuul指定的服务路由路径
    @RequestMapping(method = RequestMethod.GET, value = "/yc-api/bbnmd-proxy/bbnmd/board/{id}")
    String findById(@RequestParam("id") Integer id);


    @RequestMapping(method = RequestMethod.POST, value = "/yc-api/bbnmd-proxy/bbnmd/board",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String create(@RequestBody Board board);

    @RequestMapping(method = RequestMethod.DELETE, value = "/yc-api/bbnmd-proxy/bbnmd/board/{id}")
    String delete(@RequestParam("id") Integer id);
}
