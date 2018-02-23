package com.jdlx.edumanageoa.entity;

import java.util.List;

/**
 * 服务分类
 */
public class ServiceCategory {
    // 服务分类ID
    private String servicecategoryid;
    // 服务分类名
    private String servicecategoryname;
    // 服务项目列表
    private List<ServiceItem> serviceitemlist;

    public String getServicecategoryid() {
        return servicecategoryid;
    }

    public void setServicecategoryid(String servicecategoryid) {
        this.servicecategoryid = servicecategoryid;
    }

    public String getServicecategoryname() {
        return servicecategoryname;
    }

    public void setServicecategoryname(String servicecategoryname) {
        this.servicecategoryname = servicecategoryname;
    }

    public List<ServiceItem> getServiceitemlist() {
        return serviceitemlist;
    }

    public void setServiceitemlist(List<ServiceItem> serviceitemlist) {
        this.serviceitemlist = serviceitemlist;
    }
}
