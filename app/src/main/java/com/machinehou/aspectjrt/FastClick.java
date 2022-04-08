package com.machinehou.aspectjrt;

import android.util.Log;

/**
 * 快速点击工具栏
 */
public class FastClick {
    // 两次点击按钮之间的点击间隔时间毫秒
    private static long lastClickTime;
    private volatile static FastClick mInstance;

    public FastClick() {
    }

    public static FastClick getmInstance() {
        if (mInstance == null) {
            synchronized (FastClick.class) {
                if (mInstance == null) {
                    Log.e("aaaaa", "getmInstance: "+lastClickTime );
                    mInstance = new FastClick();
                }
            }
        }
        return mInstance;
    }


    /**
     * @param MIN_CLICK_DELAY_TIME 设置的点击时间间隔
     * @return true过, false发生了快速点击拦截
     */
    public static boolean isFastClick(long MIN_CLICK_DELAY_TIME) {
        boolean flag = false;
        long curClickTime = System.currentTimeMillis();
        Log.e("aaaaa", "curClickTime: " + curClickTime);
        if ((curClickTime - lastClickTime) >= MIN_CLICK_DELAY_TIME) {
            // 超过点击间隔后再将lastClickTime重置为当前点击时间
            lastClickTime = curClickTime;
            flag = true;
            Log.e("aaaaa", "lastClickTime: " + lastClickTime);
        }
//        lastClickTime = curClickTime;
        Log.e("aaaaa", "flag: " + flag);
        return flag;
    }
}
