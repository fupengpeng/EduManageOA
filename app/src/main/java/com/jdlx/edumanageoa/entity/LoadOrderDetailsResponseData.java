package com.jdlx.edumanageoa.entity;

import java.util.List;

/**
 * @author fupengpeng
 * @description 加载订单详情接单人及服务项等的数据
 * @data 2017/12/28 0028 16:35
 */

public class LoadOrderDetailsResponseData {

    // 条目隶属人ID
    private String acuid;
    // 条目隶属人名称
    private String acuname;
    // 条目隶属人图像
    private String acface;
    // 条目隶属人岗位
    private String acpost;
    // 服务项是否显示
    private boolean enable = true;
    // 服务项
    private List<SelectOrderItem> slist;

    public String getAcuid() {
        return acuid;
    }

    public void setAcuid(String acuid) {
        this.acuid = acuid;
    }

    public String getAcuname() {
        return acuname;
    }

    public void setAcuname(String acuname) {
        this.acuname = acuname;
    }

    public String getAcface() {
        return acface;
    }

    public void setAcface(String acface) {
        this.acface = acface;
    }

    public String getAcpost() {
        return acpost;
    }

    public void setAcpost(String acpost) {
        this.acpost = acpost;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public List<SelectOrderItem> getSlist() {
        return slist;
    }

    public void setSlist(List<SelectOrderItem> slist) {
        this.slist = slist;
    }

    @Override
    public String toString() {
        return "LoadOrderDetailsResponseData{" +
                "acuid='" + acuid + '\'' +
                ", acuname='" + acuname + '\'' +
                ", acface='" + acface + '\'' +
                ", acpost='" + acpost + '\'' +
                ", enable=" + enable +
                ", slist=" + slist +
                '}';
    }
}
