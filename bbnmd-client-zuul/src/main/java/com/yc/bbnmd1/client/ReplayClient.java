package com.yc.bbnmd1.client;

import com.yc.bbnmd1.config.FeignClientConfig;
import com.yc.bbnmd1.entity.Replay;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

// feign客户端要访问的是  zuul服务 BASE-MICROSERVICE-ZUUL-GATEWAY
@FeignClient(name = "BASE-MICROSERVICE-ZUUL-GATEWAY",
        configuration = FeignClientConfig.class
)  // 配置要按自定义的类FeignClientConfig
public interface ReplayClient {

    //访问的路径value要修改成zuul指定的服务路由路径
    @RequestMapping(method = RequestMethod.GET, value = "/yc-api/bbnmd-proxy/bbnmd/replay/{id}")
    String findById(@RequestParam("id") Integer id);


    @RequestMapping(method = RequestMethod.POST, value = "/yc-api/bbnmd-proxy/bbnmd/replay",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String create(@RequestBody Replay replay);

    @RequestMapping(method = RequestMethod.DELETE, value = "/yc-api/bbnmd-proxy/bbnmd/replay/{id}")
    String delete(@RequestParam("id") Integer id);

}




