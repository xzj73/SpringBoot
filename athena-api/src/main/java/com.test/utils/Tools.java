package com.test.utils;

import java.util.UUID;

public class Tools {

    public static String getUUID() {
        return UUID.randomUUID().toString().trim().replaceAll("-", "");
    }
}
