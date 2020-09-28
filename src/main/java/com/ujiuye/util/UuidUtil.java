package com.ujiuye.util;

import java.util.UUID;

/**
 * @author 朱峰
 * @create 2020-07-10 11:48
 */
public class UuidUtil {
    public static String getUUID(){
        return UUID.randomUUID().toString();
    }
}
