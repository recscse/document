package com.example.document.util;

import java.util.Random;
import java.util.UUID;

public class UniqueIdGenerator {
    public static String generateUniqueId() {
        Random random = new Random();
        int uniqueId = 1000 + random.nextInt(9000); // Generates a number between 1000 and 9999
        return String.valueOf(uniqueId);
//        return UUID.randomUUID().toString();
    }
}
