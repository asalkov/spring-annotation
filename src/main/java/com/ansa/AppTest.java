package com.ansa;

import org.springframework.context.ApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by asalkov on 1/10/17.
 */
public class AppTest {

    @Monitorable(name = "cache")
    private Map<String, String> cache = new HashMap<>();


    public static void main(String[] args) {
        ApplicationContext ctx;
    }
}
