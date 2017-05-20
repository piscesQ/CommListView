package com.app.koreq.aop.aspectj.configdemo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * project : CommListView
 * author : YanBin on 5/19/17
 * version : v4.0
 * description : 测试AspectJ的多种写法和Api
 */
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD})
public @interface DebugTrace {
}
