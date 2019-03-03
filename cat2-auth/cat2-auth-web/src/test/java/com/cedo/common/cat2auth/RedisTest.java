package com.cedo.common.cat2auth;

import com.cedo.cat2auth.Cat2AuthApplication;
import com.cedo.redis.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author chendong
 * @date 19-3-1 下午9:46
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Cat2AuthApplication.class)
@ComponentScan(basePackages = "com.cedo")
public class RedisTest {

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void test() {
        redisUtil.set("hello", "word");
        String v = (String) redisUtil.get("hello");
        System.out.println(v);
    }

    static int c1=12;
    static {
        c1 += 8;
    }
    public static void main(String[] args) {
        System.out.println(c1);
        switch (1) {
            case 1:

        }
    }
    static {
        c1 /=4;
    }

}
