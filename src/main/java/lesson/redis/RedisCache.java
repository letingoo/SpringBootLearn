package lesson.redis;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;

@Component("redisCache")
public class RedisCache {

    @Resource(name = "jedisPool")
    private JedisPool jedisPool;


    public String getDataFromRedis(String key) {
        Jedis jedis = jedisPool.getResource();
        return jedis.get(key);
    }


    public void setDataToRedis(String key, Object obj) {
        Jedis jedis = jedisPool.getResource();
        jedis.set(key, JSON.toJSONString(obj));
    }
}
