package com.cedo.common.util;

import com.cedo.common.exception.RestException;
import org.springframework.http.HttpStatus;

import java.security.MessageDigest;
import java.util.UUID;

/**
 * token生成器
 * @Author chendong
 * @date 19-3-1 下午1:12
 */
public class TokenGenerator {

    private static final char[] hexCode = "0123456789abcdef".toCharArray();

    public static String generateToken() {
        return generateValue(UUID.randomUUID().toString());
    }

    public static String generateValue(String param) {
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(param.getBytes());
            byte[] messageDigest = algorithm.digest();
            return toHexString(messageDigest);
        } catch (Exception e) {
            throw new RestException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "生成Token失败");
        }
    }

    public static String toHexString(byte[] data) {
        if(data == null) {
            return null;
        }
        StringBuilder r = new StringBuilder(data.length*2);
        for ( byte b : data) {
            r.append(hexCode[(b >> 4) & 0xF]);
            r.append(hexCode[(b & 0xF)]);
        }
        return r.toString();
    }
}
