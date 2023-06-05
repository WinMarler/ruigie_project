package com.wjh.test;

/**
 * @description:
 * @author:WINmarler
 * @time2023/6/5 21:11
 */


import org.testng.annotations.Test;
import redis.clients.jedis.Jedis;

/**
 * 使用Jdeis操作Redis
 */
public class JedisTest {
    @Test
    public void testRedis() {
        //1.获取链接
        Jedis jedis = new Jedis("192.168.200.130", 6379);

        //2.执行具体操作
        jedis.auth("123456");
        jedis.set("username", "xiaoming");
        //3/关闭链接
        jedis.close();
    }
}
