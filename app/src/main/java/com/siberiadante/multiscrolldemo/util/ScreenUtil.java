package com.siberiadante.multiscrolldemo.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * @Created SiberiaDante
 * @Describe：
 * @CreateTime: 2017/12/18
 * @UpDateTime:
 * @Email: 2654828081@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class ScreenUtil {

    /**
     * 获取屏幕的高度（单位：px）
     *
     * @return 屏幕高
     */
    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    /**
     * @return 获取屏幕的高 单位：px
     */
    public static int getScreenHeightPx(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(dm);
        return dm.heightPixels;

    }
}
