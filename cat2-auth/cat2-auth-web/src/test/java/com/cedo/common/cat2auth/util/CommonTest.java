package com.cedo.common.cat2auth.util;

import org.apache.shiro.crypto.hash.Sha256Hash;

/**
 * @Author chendong
 * @date 19-3-1 下午5:37
 */
public class CommonTest {

    public static void main(String[] args) {
        String pwd = "123456";
        System.out.println(new Sha256Hash(pwd, "100"));
    }
}
