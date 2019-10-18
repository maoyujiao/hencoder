package com.aiyuba.hencoder;

import android.app.Activity;

import java.lang.reflect.Field;

/**
 * Created by maoyujiao on 2019/10/18.
 */

public class Binding {
    public static void bind(Activity activity){
        //遍历field,反射注解，耗性能，使用AnnotationProccessing
        //依赖注入
        for(Field field : activity.getClass().getDeclaredFields()){
            BindView bindView = field.getAnnotation(BindView.class);
            if(bindView !=null){
                try {
                    field.setAccessible(true);
                    field.set(activity,activity.findViewById(bindView.value()));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
