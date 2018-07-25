package lesson.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class JedisConfig {



    @Bean(name = "jedisPool")
    @Autowired
    public JedisPool jedisPool(@Qualifier("jedisPoolConfig") JedisPoolConfig jedisPoolConfig,
                               @Value("${spring.jedis.pool.host}") String host,
                               @Value("${spring.jedis.pool.port}") int port,
                               @Value("${spring.jedis.pool.timeout}") int timeout,
                               @Value("${spring.jedis.pool.password}") String password) {

        return new JedisPool(jedisPoolConfig, host, port, timeout, password);
    }




    @Bean(name = "jedisPoolConfig")
    public JedisPoolConfig jedisPoolConfig(@Value("${spring.jedis.pool.config.maxTotal}") int maxTotal,
                               @Value("${spring.jedis.pool.config.maxIdle}") int maxIdle,
                               @Value("${spring.jedis.pool.config.maxWaitMills}") int maxWaitMills){

        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMills);

        return jedisPoolConfig;
    }



}
