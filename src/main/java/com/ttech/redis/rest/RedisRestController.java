package com.ttech.redis.rest;

import com.ttech.redis.rest.request.RedisPutRequest;
import com.ttech.redis.service.RedisCoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/redis")
public class RedisRestController {

    @Autowired
    private RedisCoreService redisCoreService;

    @RequestMapping(value = "/get/{key}" , method = RequestMethod.GET)
    public @ResponseBody Object get(@PathVariable String key) {
        Object result = "";
        if(key != null) {
            result = redisCoreService.getValue(key);
        }
        return result;
    }

    @RequestMapping(value = "/put" , method = RequestMethod.PUT)
    public @ResponseBody String put(@RequestBody RedisPutRequest redisPutRequest) {
        Object result = null;
        if(redisPutRequest != null && redisPutRequest.getKey() != null && redisPutRequest.getValue() != null) {
            redisCoreService.setValue(redisPutRequest.getKey(),redisPutRequest.getValue());
            return "success";
        }
        return "error";
    }


}
