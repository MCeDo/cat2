package com.cedo.common.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class MathUtil {
	
	public static void main(String[] args) {
		System.out.println(MD5encoder("123456"));
		System.out.println(MD5encoder("12"));
	}


	/**
	 * MD5 加密
	 * @param code
	 * @return
	 */
	public static String MD5encoder(String code) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(code.getBytes());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return new BigInteger(1, md.digest()).toString(16); 
	}

	/**
	 * 生成随机数
	 * @return
	 */
	public static String random() {
		return String.valueOf(new Random(1000).nextDouble());
	}
}
