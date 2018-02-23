package com.jdlx.edumanageoa.util;


import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jdlx.edumanageoa.R;

import java.util.Date;

/**
 * @description  聚云美公共工具类
 * @author  hnkehui
 * @date  2018/2/10 11:43
 */

public class JYMUtils {
    /**
     * 获取多长时间
     * @param date     加入时间
     * @return     返回String类型天数
     */
    public static String howLongDates(long date){
        long ss = new Date().getTime()/1000;
        long time=ss-date;
        String times= String.valueOf((time/60/60/24));
        return times;
    }
    /**
     * 获取多长时间
     * @param date     加入时间
     * @return     返回String类型天数
     */
    public static void howLongDates(long date, TextView view){
        view.setText(howLongDates(date)+"天");
    }


    /**
     * 显示性别
     * @param sex            性别
     * @param imageView      性别控件
     */
    public static void setSexImg(String sex, ImageView imageView){
        if (sex != null&&!sex.equals("")){//判断是否为空或者为""
        if (sex.equals("0")){//判断性别是否为女
            imageView.setImageResource(R.drawable.order_woman);//修改性别标记为女
        }else if (sex.equals("1")){//判断性别是否为男
            imageView.setImageResource(R.drawable.order_man);//修改性别标记为男
        }
        }
    }
    public static void setPhone(String phone, TextView view, LinearLayout layout) {
        if (phone != null && !phone.equals("")) {//判断是否为空或者为""
            view.setText(phone);//电话
            layout.setVisibility(View.VISIBLE);//显示拨打电话
        }
    }
}
