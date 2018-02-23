package com.jdlx.edumanageoa.entity;

import java.util.List;

/**
 * @author fupengpeng
 * @description 预约时间价格设置
 * @data 2018/2/5 0005 9:19
 */

public class AppointConfig {

    // ??
    private String advance;

    //
    private List<TimeItemSet> time;

    public String getAdvance() {
        return advance;
    }

    public void setAdvance(String advance) {
        this.advance = advance;
    }

    public List<TimeItemSet> getTime() {
        return time;
    }

    public void setTime(List<TimeItemSet> time) {
        this.time = time;
    }
}
