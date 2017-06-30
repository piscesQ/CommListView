package com.app.koreq.aop.aspectj.learndemo;

import com.app.koreq.aop.AopConst;
import com.app.koreq.commlib.widget.utils.DebugLog;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.SourceLocation;

/**
 * project : CommListView
 * author : YanBin on 6/8/17
 * version : v4.0
 * description : 直接针对JoinPoint的选择 execution call get set staticinitialization handler initialization
 *                                      preinitialization adviceexecution
 */
@Aspect
public class AspectApiDemo {

    //====================================分割线=====================================================
    // withincode test   不要单独使用，若单独使用则JPoint对应的方法里面每执行一行代码，所有advice都执行一遍！！！
    public static final String POINT_WITHINCODE = "withincode(* com.app.koreq.commlistview.activity.AopActivity.apiWithincode1(..))";

    @Pointcut(POINT_WITHINCODE)
    public void pointcutApiWithincode1() {
    }

    @Before("pointcutApiWithincode1()")
    public void beforeApiWithincode1(JoinPoint joinPoint) {
        DebugLog.log(AopConst.LOG_TAG, "koreyoshi before apiWithincode1");
    }

    // After 与 Around 不能同时使用， 否则该 Pointcut 上的所有aop事件都会失效
//    @After("pointcutApiWithincode1()")
//    public void afterApiWithincode1(JoinPoint joinPoint) {
//        DebugLog.log(AopConst.LOG_TAG, "koreyoshi after apiWithincode1");
//    }

    @Around("pointcutApiWithincode1()")
    public void aroundApiWithincode1(ProceedingJoinPoint joinPoint) throws Throwable {
        DebugLog.log(AopConst.LOG_TAG, "koreyoshi around before apiWithincode1");
        joinPoint.proceed();
        DebugLog.log(AopConst.LOG_TAG, "koreyoshi around after apiWithincode1");
    }

    //====================================分割线=====================================================
    //Constructor test

    public static final String POINT_CONSTRUCTOR = "execution(com.app.koreq.commlistview.bean.AopTestBean.new(..))";

    @Pointcut(POINT_CONSTRUCTOR)
    public void pointcutConstructorTest() {

    }

    @Before("pointcutConstructorTest()")
    public void beforeConstructorTest(JoinPoint joinPoint) {
        DebugLog.log(AopConst.LOG_TAG, "koreyoshi before constructorTest");
    }

    //测试多个Before是否可以并存 - 可以 顺序为代码顺序
    @Before("pointcutConstructorTest()")
    public void before2ConstructorTest(JoinPoint joinPoint) {
        DebugLog.log(AopConst.LOG_TAG, "koreyoshi before2 constructorTest");
    }

    @Around("pointcutConstructorTest()")
    public void aroundConstructorTest(ProceedingJoinPoint joinPoint) throws Throwable {
        DebugLog.log(AopConst.LOG_TAG, "koreyoshi around before constructorTest");
        joinPoint.proceed();
        DebugLog.log(AopConst.LOG_TAG, "koreyoshi around after constructorTest");
    }

    //测试多个around是否可以并存 - 可以 顺序为 around 包含 around2 方法
    @Around("pointcutConstructorTest()")
    public void around2ConstructorTest(ProceedingJoinPoint joinPoint) throws Throwable {
        DebugLog.log(AopConst.LOG_TAG, "koreyoshi around before2 constructorTest");
        joinPoint.proceed();
        DebugLog.log(AopConst.LOG_TAG, "koreyoshi around after2 constructorTest");
    }

    //测试多个after是否可以并存 - 可以 顺序为代码顺序
//    @After("pointcutConstructorTest()")
//    public void afterConstructorTest(JoinPoint joinPoint) {
//        DebugLog.log(AopConst.LOG_TAG, "koreyoshi after constructorTest");
//    }
//
//    @After("pointcutConstructorTest()")
//    public void after2ConstructorTest(JoinPoint joinPoint) {
//        DebugLog.log(AopConst.LOG_TAG, "koreyoshi after2 constructorTest");
//    }


    //====================================分割线=====================================================
    // get set test
    public static final String POINT_GET_FILED = "get(String com.app.koreq.commlistview.bean.AopTestBean.name)";
    public static final String POINT_SET_FILED = "set(String com.app.koreq.commlistview.bean.AopTestBean.name)";

    @Pointcut(POINT_GET_FILED)
    public void pointcutGetFiled() {

    }

    @Pointcut(POINT_SET_FILED)
    public void pointcutSetFiled() {

    }

    @Before("pointcutGetFiled()")
    public void beforeGetFiled(JoinPoint joinPoint) {
        DebugLog.log(AopConst.LOG_TAG, "koreyoshi  before get Test");
    }

    @Before("pointcutSetFiled()")
    public void beforeSetFiled(JoinPoint joinPoint) {
        DebugLog.log(AopConst.LOG_TAG, "koreyoshi  before set Test");
    }

    //====================================分割线=====================================================
    // static block test
    public static final String POINT_STATIC_BLOCK = "staticinitialization(com.app.koreq.commlistview.bean.AopTestBean)";

    @Pointcut(POINT_STATIC_BLOCK)
    public void pointcutStaticBlock() {

    }

    @Before("pointcutStaticBlock()")
    public void beforeStaticBlock(JoinPoint joinPoint) {
        DebugLog.log(AopConst.LOG_TAG, "koreyoshi before static Test");
    }

    //====================================分割线=====================================================
    // AfterThrowing test
    public static final String POINT_AFTER_THROWING_TEST = "execution(* com.app.koreq.commlistview.activity.AopActivity.afterThrowingTest(..))";

    @Pointcut(POINT_AFTER_THROWING_TEST)
    public void pointcutAfterThrowing() {

    }

    @Before("pointcutAfterThrowing()")
    public void beforeAfterThrowing(JoinPoint joinPoint) {
        DebugLog.log(AopConst.LOG_TAG, "koreyoshi before AfterThrowing Test");
    }

    // 与after冲突  影响所有事件织入

    /**
     * 核心逻辑抛出异常走此方法，但不能阻止程序崩溃
     *
     * @param joinPoint
     * @param exception 异常对象
     */
    @AfterThrowing(value = "pointcutAfterThrowing()", throwing = "exception")
    public void afterThrowException(JoinPoint joinPoint, Exception exception) {
        DebugLog.log(AopConst.LOG_TAG, "koreyoshi AfterThrowing Test - " + exception.getMessage());
    }

//    @After("pointcutAfterThrowing()")
//    public void afterAdvice(JoinPoint joinPoint, int retVal) {
//        DebugLog.log(AopConst.LOG_TAG, "koreyoshi after Test - " + String.valueOf(retVal));
//    }

    //====================================分割线=====================================================
    //AfterReturning test afterReturningTest

    public static final String POINT_AFTER_TURNING_TEST = "execution(* com.app.koreq.commlistview.activity.AopActivity.afterReturningTest(..))";

    @Pointcut(POINT_AFTER_TURNING_TEST)
    public void pointcutReturn() {

    }

    // 与after冲突  影响所有事件织入

    /**
     * 核心业务逻辑调用正常退出后，不管是否有返回值，正常退出后，均执行此Advice
     *
     * @param joinPoint
     * @param retVal    返回值，需要和join point方法对应的返回值类型一致，否则不会有值
     */
    @AfterReturning(value = "pointcutReturn()", returning = "retVal")
    public void afterReturningAdvice(JoinPoint joinPoint, int retVal) {
        DebugLog.log(AopConst.LOG_TAG, "koreyoshi afterReturning Test - " + String.valueOf(retVal));
    }

//    @After("pointcutReturn()")
//    public void afterAdvice(JoinPoint joinPoint, int retVal) {
//        DebugLog.log(AopConst.LOG_TAG, "koreyoshi after Test - " + String.valueOf(retVal));
//    }

    //====================================分割线=====================================================
    // Exception test  !!!! 只能处理try...catch()的括号中的异常！！！！！
//    public static final String POINT_EXCEPTION = "handler(java.lang.NullPointerException)";   //写法正确
//    public static final String POINT_EXCEPTION = "handler(java.lang.ArithmeticException)";   //写法正确
    public static final String POINT_EXCEPTION = "handler(java.lang.Exception+)";   //写法正确，"+"表示Exception的所有子类！！！

    @Pointcut(POINT_EXCEPTION)
    public void pointcutException() {

    }

    @Before("pointcutException()")
    public void beforeException(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        for(int i = 0; i < args.length; i++){
            DebugLog.log(AopConst.LOG_TAG, "Exception Name  = " + args[i].getClass());  //class java.lang.NullPointerException
        }
        DebugLog.log(AopConst.LOG_TAG, "!!koreyoshi Exception  = " + joinPoint.getThis());
    }

    //====================================分割线=====================================================
//    initialization(com.app.koreq.commlistview.bean.AopTestBean.new(..))
    public static final String POINT_INITIAL = "initialization(com.app.koreq.commlistview.bean.AopTestBean.new(..))";

    @Pointcut(POINT_INITIAL)
    public void pointcutInitial() {

    }

    @Before("pointcutInitial()")
    public void beforeInitial(JoinPoint joinPoint) {
        DebugLog.log(AopConst.LOG_TAG, "koreyoshi before init Test");
    }

    @After("pointcutInitial()")
    public void afterInitial(JoinPoint joinPoint) {
        DebugLog.log(AopConst.LOG_TAG, "koreyoshi after init Test");
    }

    //====================================分割线=====================================================
//    preinitialization(com.app.koreq.commlistview.bean.AopTestBean.new(..))
    public static final String POINT_PRE_INITIAL = "preinitialization(com.app.koreq.commlistview.bean.AopTestBean.new(..))";

    @Pointcut(POINT_PRE_INITIAL)
    public void pointcutPreInitial() {

    }

    @Before("pointcutPreInitial()")
    public void beforePreInitial(JoinPoint joinPoint) {
        DebugLog.log(AopConst.LOG_TAG, "koreyoshi before pre init Test");
    }

    @After("pointcutPreInitial()")
    public void afterPreInitial(JoinPoint joinPoint) {
        DebugLog.log(AopConst.LOG_TAG, "koreyoshi after pre init Test");
    }

    //====================================分割线=====================================================
//    adviceexecution()
    public static final String POINT_ADVICE = "adviceexecution()";

    @Pointcut(POINT_ADVICE)
    public void pointcutAdvice() {

    }

    @Before("pointcutPreInitial()")
    public void beforeAdvice(JoinPoint joinPoint) {
        DebugLog.log(AopConst.LOG_TAG, "koreyoshi advice Test");
    }

    //====================================分割线=====================================================
    // JoinPoint 属性、方法测试

    public static final String POINT_JOIN_POINT_METHOD = "execution(* com.app.koreq.commlistview.activity.AopActivity.joinPointMethod(..))";

    @Pointcut(POINT_JOIN_POINT_METHOD)
    public void pointcutJoinPointMethod() {

    }

    @Before("pointcutJoinPointMethod()")
    public void beforeJoinPointMethod(JoinPoint joinPoint) {
        DebugLog.log(AopConst.LOG_TAG, "koreyoshi joinPoint start");
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            DebugLog.log(AopConst.LOG_TAG, "args[" + i + "] = " + args[i] + ", type = " + args[i].getClass());
        }

        String kind = joinPoint.getKind();
        DebugLog.log(AopConst.LOG_TAG, "kind = " + kind);

        Signature signature = joinPoint.getSignature();
        DebugLog.log(AopConst.LOG_TAG, "signature : name = " + signature.getName());

        SourceLocation sourceLocation = joinPoint.getSourceLocation();
        DebugLog.log(AopConst.LOG_TAG, "sourceLocation : type = " + sourceLocation.getWithinType()
                + ", fileName = " + sourceLocation.getFileName()
                + ", line = " + sourceLocation.getLine()
                + ", column = " + sourceLocation.getColumn());

        JoinPoint.StaticPart staticPart = joinPoint.getStaticPart();
        DebugLog.log(AopConst.LOG_TAG, "staticPart : kind = " + staticPart.getKind() + ", id = " + staticPart.getId());

        Object target = joinPoint.getTarget();
        DebugLog.log(AopConst.LOG_TAG, "target = " + target.toString());

        Object aThis = joinPoint.getThis();
        DebugLog.log(AopConst.LOG_TAG, "aThis = " + aThis.toString());

        DebugLog.log(AopConst.LOG_TAG, "koreyoshi joinPoint end");

        //输出样例
//        kind = method-execution
//        args[0] = Kore, type = class java.lang.String
//        args[1] = 999, type = class java.lang.Integer
//        args[2] = 666.0, type = class java.lang.Float
//        signature : name = joinPointMethod    //方法名
//        sourceLocation : type = class com.app.koreq.commlistview.activity.AopActivity,
//                              fileName = AopActivity.java, line = 162, column = -1   //line joinPoint方法源码的行号
//        staticPart : kind = method-execution, id = 4
//        target = com.app.koreq.commlistview.activity.AopActivity@6954868
//        aThis = com.app.koreq.commlistview.activity.AopActivity@6954868
//        koreyoshi joinPoint end

    }

    //====================================分割线=====================================================
    // Around test 修改参数列表
    public static final String POINT_AROUND_TEST = "execution(* com.app.koreq.commlistview.activity.AopActivity.aroundTest(..))";

    @Pointcut(POINT_AROUND_TEST)
    public void pointcutAroundTest() {
    }

    @Around("pointcutAroundTest()")
    public void aroundAroundTest(ProceedingJoinPoint joinPoint) throws Throwable {
        DebugLog.log(AopConst.LOG_TAG, "koreyoshi around start");
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {     //修改参数列表
            if (args[i] instanceof String) {
                String temp = (String) args[i];
                temp += "--";
                args[i] = temp;
            } else if (args[i] instanceof Float) {
                float temp = (Float) args[i];
                temp += 10f;
                args[i] = temp;
            } else if (args[i] instanceof Integer) {
                int temp = (Integer) args[i];
                temp += 10;
                args[i] = temp;
            }
        }
        joinPoint.proceed(args);
//        joinPoint.proceed();
        DebugLog.log(AopConst.LOG_TAG, "koreyoshi around end");
    }
}
