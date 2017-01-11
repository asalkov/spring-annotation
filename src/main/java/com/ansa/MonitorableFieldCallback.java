package com.ansa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

/**
 * Created by asalkov on 1/11/17.
 */
public class MonitorableFieldCallback implements ReflectionUtils.FieldCallback {

    private ConfigurableListableBeanFactory beanFactory;
    private Object bean;

    @Autowired
    MonitorableHolder monitorableHolder;

    public MonitorableFieldCallback(ConfigurableListableBeanFactory beanFactory, Object bean) {
        this.beanFactory = beanFactory;
        this.bean = bean;
    }

    @Override
    public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {

        if (!field.isAnnotationPresent(Monitorable.class)) {
            return;
        }

        MonitorableHolder holder = (MonitorableHolder) beanFactory.getBean("monitorableHolder");

        ReflectionUtils.makeAccessible(field);
        Monitorable[] monitorables = field.getAnnotationsByType(Monitorable.class);

        holder.add(monitorables[0].name(), field.get(bean));
        System.out.println("field:"+field);

        //holder.add();


    }
}
