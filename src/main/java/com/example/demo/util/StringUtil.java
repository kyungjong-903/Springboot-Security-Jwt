package com.example.demo.util;

import java.security.InvalidParameterException;

public class StringUtil {

    public static boolean hasValue(String target) {
        return !isNullOrEmpty(target);
    }

    /** 값이 비어있는지 확인 */
    public static boolean isNullOrEmpty(String target) {
        if (target == null || target.trim().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}

