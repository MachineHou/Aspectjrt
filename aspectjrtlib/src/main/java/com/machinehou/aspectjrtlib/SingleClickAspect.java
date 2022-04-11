package com.machinehou.aspectjrtlib;


import android.util.Log;
import android.view.View;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SingleClickAspect {
    /**
     * 最近一次点击的时间
     */
    private long mLastTime;
    /**
     * 最近一次点击的控件ID
     */
    private int mLastId;

    /**
     * 方法切入点（改变成自己的包名）
     */
    @Pointcut("execution(@com.machinehou.aspectjrtlib.SingleClick * *(..))")
    public void method() {}

    /**
     * 在连接点进行方法替换
     */
    @Around("method() && @annotation(singleClick)")
    public void aroundJoinPoint(ProceedingJoinPoint joinPoint, SingleClick singleClick) throws Throwable {
        View view = null;
        for (Object arg : joinPoint.getArgs()) {
            if (arg instanceof View) {
                view = (View) arg;
            }
        }
        if (view != null) {
            if (!FastClick.getmInstance().isFastClick(singleClick.value())){
                Log.e("aaaaa", "发生快速点击");
//                ToastUtils.showLong("请不要重复点击");
                return;
            }
//            long currentTime = Calendar.getInstance().getTimeInMillis();
//            if (currentTime - mLastTime < singleClick.value() && view.getId()
//                    == mLastId) {
//                Log.i("SingleClick", "发生快速点击");
//                return;
//            }
//            mLastTime = currentTime;
//            mLastId = view.getId();
            //执行原方法
            joinPoint.proceed();
        }
    }
}
