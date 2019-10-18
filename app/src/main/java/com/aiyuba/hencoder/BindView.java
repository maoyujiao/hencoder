package com.aiyuba.hencoder;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by maoyujiao on 2019/10/18.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface BindView {
    int id();
    String name() default "maoyujiao";
    int value();//特殊的注解方法，不需要使用等号赋值


}
