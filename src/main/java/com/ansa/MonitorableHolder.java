package com.ansa;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by asalkov on 1/11/17.
 */
public class MonitorableHolder {
    private Map<String, Object>  namedMonitorables = new HashMap<>();

    public void add(String name, Object object){
        System.out.println("Add monitorable:"+name);
        namedMonitorables.put(name, object);
    }
}
