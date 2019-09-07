package com.hundsun.jvm;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * TODO
 *
 * @author wuyun
 * @date 2019/8/24 12:47
 */
public class DirectMemoryOOM {

    public static final int _1MB = 1024*1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe)unsafeField.get(null);
        while (true){
            unsafe.allocateMemory(_1MB);
        }
    }
}
