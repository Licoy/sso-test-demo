package cn.licoy.test;

import java.util.UUID;

/**
 * @author 刘杰
 * @version 1.0 /
 */
public class Test {
    @org.junit.Test
    public void test(){
        for (int i = 0; i < 100; i++) {
            System.out.println(UUID.randomUUID().toString());
        }
    }
}
