package com.app.koreq.aop.aspectj.configdemo;

/**
 * project : CommListView
 * author : YanBin on 5/17/17
 * version : v
 * description :
 */

import com.app.koreq.aop.AopConst;
import com.app.koreq.commlib.widget.utils.DebugLog;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * Aspect representing the cross cutting-concern: Method and Constructor Tracing.
 * 配置AspectJ的环境，测试环境是否正常
 */
@Aspect
public class TraceAspect {

    /*
    解释："execution(@com.app.koreq.aop.aspectj.configdemo.DebugTrace * *(..))"
    @[注解类的完成包名]；第一个"*" 表示返回值为任意值；第二个"*" 表示方法名为任意值； (..)表示参数列表为任意数量任意类型

    execution 与 call 的区别：execution是方法执行前后插入代码，在方法内；call是方法被调用前后插入代码，在方法外；

    注意：
    1、Around和After是不能同时作用在同一个方法上的，会产生重复切入的问题，不会崩溃，但会导致该Pointcut上所有的aop事件都失效！！！
    2、多个before、after可以并存，顺序为代码顺序，多个around也能并存 顺序为包含 前面的包含后面的

    */
    private static final String POINTCUT_METHOD =
            "execution(@com.app.koreq.aop.aspectj.configdemo.DebugTrace * *(..))";


    /*
    Constructorsignature和Method Signature类似，只不过构造函数没有返回值，而且函数名必须叫new。
    解释：public *..TestDerived.new(..)：
       public：选择public访问权限  （可选）
       *..代表任意包名
       TestDerived.new：代表TestDerived的构造函数
       (..)：代表参数个数和类型都是任意

     */
    private static final String POINTCUT_CONSTRUCTOR =
            "execution(@com.app.koreq.aop.aspectj.configdemo.DebugTrace *.new(..))";

    @Pointcut(POINTCUT_METHOD)
    public void methodAnnotatedWithDebugTrace() {
    }

    @Pointcut(POINTCUT_CONSTRUCTOR)
    public void constructorAnnotatedDebugTrace() {
    }

    @Around("methodAnnotatedWithDebugTrace() || constructorAnnotatedDebugTrace()")
    public Object weaveJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        DebugLog.log(AopConst.LOG_TAG, "Koreyoshi - begin");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();

        DebugLog.log(AopConst.LOG_TAG, "Koreyoshi - start");
        final StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object result = joinPoint.proceed();
        stopWatch.stop();

        DebugLog.log(AopConst.LOG_TAG +" - "+ className, buildLogMessage(methodName, stopWatch.getTotalTimeMillis()));

        return result;
    }

    /**
     * Create a log message.
     *
     * @param methodName     A string with the method name.
     * @param methodDuration Duration of the method in milliseconds.
     * @return A string representing message.
     */
    private static String buildLogMessage(String methodName, long methodDuration) {
        StringBuilder message = new StringBuilder();
        message.append(AopConst.LOG_TAG);
        message.append(" --> ");
        message.append(methodName);
        message.append(" --> ");
        message.append("[");
        message.append(methodDuration);
        message.append("ms");
        message.append("]");

        return message.toString();
    }
}