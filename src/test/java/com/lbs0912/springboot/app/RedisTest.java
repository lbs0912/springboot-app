package com.lbs0912.springboot.app;

import com.lbs0912.springboot.app.entity.UserInfo;

import cn.hutool.json.JSONUtil;
import redis.clients.jedis.Jedis;

public class RedisTest {
    private static final String REDIS_KEY = "user";

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost",6379); //默认端口号

        UserInfo userInfo = new UserInfo("lbs0912",1992);

        jedis.set(REDIS_KEY, JSONUtil.toJsonStr(userInfo)); //set redis

        //get from redis
        UserInfo getUserInfo = JSONUtil.toBean(jedis.get(REDIS_KEY),UserInfo.class);

        System.out.println("从Redis中读取到的Bean-UserInfo:" + JSONUtil.toJsonStr(getUserInfo));

    }

}

