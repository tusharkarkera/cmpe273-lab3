package edu.sjsu.cmpe.cache.client;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by tusharkarkera on 11/12/14.
 */
public class HashFunction {
    MessageDigest instance;

    public HashFunction() {
        try {
            instance = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
        }
    }

    int hash(String key) {
        instance.reset();
        instance.update(key.getBytes());
        byte[] digest = instance.digest();

        int h = 0;
        for (int i = 0; i < 4; i++) {
            h <<= 8;
            h |= ((int) digest[i]) & 0xFF;
        }
        return h;
    }
}