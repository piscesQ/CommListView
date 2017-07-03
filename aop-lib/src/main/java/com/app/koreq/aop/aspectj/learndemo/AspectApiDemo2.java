package com.app.koreq.aop.aspectj.learndemo;

import com.app.koreq.aop.AopConst;
import com.app.koreq.commlib.utils.DebugLog;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * project : CommListView
 * author : YanBin on 6/8/17
 * version : v4.0
 * description : 间接针对JoinPoint的选择 within withincode cflow cflowbelow this target args
 */
@Aspect
public class AspectApiDemo2 {
    /**
     * target 和 this 的区别
     * target：调用joinPoint的类
     * this：joinPoint调用时，在哪个类中
     */

    public static final String POINT_API_DEMO2 = "call(* com.app.koreq.commlistview.activity.AopActivity.apiDemo2(..))";

    @Pointcut(POINT_API_DEMO2)
    public void pointcutApiDemo2() {
    }

    @Before("pointcutApiDemo2()")
    public void beforeCallMethod(JoinPoint joinPoint) {
        DebugLog.log(AopConst.LOG_TAG, "koreyoshi around before CallMethod");
        DebugLog.log(AopConst.LOG_TAG, "koreyoshi around before CallMethod；this = " + joinPoint.getThis());
        DebugLog.log(AopConst.LOG_TAG, "koreyoshi around before CallMethod; target = " + joinPoint.getTarget());
    }

    //====================================分割线=====================================================
    // within test 某个类中
    public static final String POINT_WITHIN = "within(com.app.koreq.commlistview.activity.AopActivity)";

    @Pointcut(POINT_WITHIN)
    public void pointcutApiWithin1() {
    }

    @Pointcut("pointcutApiWithin1() && pointcutApiDemo2()")
    public void pointcutWithinCall() {

    }

    @Before("pointcutWithinCall()")
    public void beforeApiWithin1(JoinPoint joinPoint) {
        DebugLog.log(AopConst.LOG_TAG, "koreyoshi before within && call");
    }
//
//    @Around("pointcutWithinCall()")
//    public void aroundApiWithin1(ProceedingJoinPoint joinPoint) throws Throwable {     //调用正常
//        DebugLog.log(AopConst.LOG_TAG, "koreyoshi around before within test");
//        joinPoint.proceed();
//        DebugLog.log(AopConst.LOG_TAG, "koreyoshi around after within test");
//    }

    //====================================分割线=====================================================
    // withincode test
    public static final String POINT_WITHINCODE = "withincode(* com.app.koreq.commlistview.activity.AopActivity.apiWithincode2(..))";

    @Pointcut(POINT_WITHINCODE)
    public void pointcutWithincode() {

    }

    @Pointcut("pointcutWithincode() && pointcutApiDemo2()")
    public void pointcutWithincodeCall() {
    }

    /**
     * 与其他before方法一起的执行顺序只与代码顺序有关系
     *
     * @param joinPoint
     */
    @Before("pointcutWithincodeCall()")
    public void beforeWithincode(JoinPoint joinPoint) {
        DebugLog.log(AopConst.LOG_TAG, "koreyoshi  before Withincode && Call");
    }

    //====================================分割线=====================================================
    // cflow test  条件是一个pointcut
    public static final String POINT_CFLOW = "cflow(call(* com.app.koreq.commlistview.activity.AopActivity.cflowDemo(..)))";

    @Pointcut(POINT_CFLOW + " && " + POINT_API_DEMO2)
    public void pointcutCflowCall() {
    }

    @Before("pointcutCflowCall()")
    public void beforeCflowCall(JoinPoint joinPoint) {
        DebugLog.log(AopConst.LOG_TAG, "koreyoshi  before cflow && Call");
    }

    //====================================分割线=====================================================
    // cflowbelow test  条件是一个pointcut
    public static final String POINT_CFLOWBELOW = "cflowbelow(call(* com.app.koreq.commlistview.activity.AopActivity.cflowbelowDemo(..)))";

    @Pointcut(POINT_CFLOWBELOW + " && " + POINT_API_DEMO2)
    public void pointcutCflowbelowCall() {
    }

    @Before("pointcutCflowbelowCall()")
    public void beforeCflowbelowCall(JoinPoint joinPoint) {
        DebugLog.log(AopConst.LOG_TAG, "koreyoshi  before cflowbelow && Call");
    }

    //====================================分割线=====================================================
    // this test
    public static final String POINT_THIS = "this(com.app.koreq.commlistview.activity.AopActivity)";

    @Pointcut(POINT_THIS)
    public void pointcutThis() {

    }

//    @Pointcut("pointcutThis() && pointcutApiDemo2()")
//    public void pointcutThisCall() {
//
//    }

    /**
     *  @Pointcut(POINT_THIS + " && " + POINT_API_DEMO2) 和 @Pointcut("pointcutThis() && pointcutApiDemo2()")
     *  效果一样！！！
     */
    @Pointcut(POINT_THIS + " && " + POINT_API_DEMO2)
    public void pointcutThisCall() {

    }

    @Before("pointcutThisCall()")
    public void beforeThisCall(JoinPoint joinPoint) {
        DebugLog.log(AopConst.LOG_TAG, "koreyoshi  before this && Call; this = " + joinPoint.getThis());
    }

    //====================================分割线=====================================================
    // target test
    public static final String POINT_TARGET = "target(com.app.koreq.commlistview.activity.AopActivity)";

    @Pointcut(POINT_TARGET)
    public void pointcutTarget() {
    }

    @Pointcut("pointcutTarget() && pointcutApiDemo2()")
    public void pointcutTargetCall() {

    }

    @Before("pointcutTargetCall()")
    public void beforeTargetCall(JoinPoint joinPoint) {
        DebugLog.log(AopConst.LOG_TAG, "koreyoshi  before target && Call; target = " + joinPoint.getTarget());
    }

    //====================================分割线=====================================================
    // args testa
    public static final String POINT_ARGS = "args(int)";

    @Pointcut(POINT_ARGS)
    public void pointcutArgs() {
    }

    @Pointcut("pointcutArgs() && pointcutApiDemo2()")
    public void pointcutArgsCall() {
    }

    @Before("pointcutArgsCall()")
    public void beforeArgsCall(JoinPoint joinPoint) {
        DebugLog.log(AopConst.LOG_TAG, "koreyoshi  before args && Call");
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            DebugLog.log(AopConst.LOG_TAG, "koreyoshi args[" + i + "] = " + args[i]);
        }
    }
}
