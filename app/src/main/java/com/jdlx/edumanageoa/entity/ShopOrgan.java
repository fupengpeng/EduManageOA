package com.jdlx.edumanageoa.entity;

/**
 * 门店属性配置
 */
public class ShopOrgan {
    // ID
    private String id;
    // 配置类型,参见基础配置-属性分类
    private String type;
    // 配置名称
    private String name;
    // 门店ID
    private String shopid;

    // 排序
    private String sort;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShopid() {
        return shopid;
    }

    public void setShopid(String shopid) {
        this.shopid = shopid;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
