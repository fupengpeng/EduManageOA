package com.jdlx.edumanageoa.entity.response;

/**
 * 获取最新版本信息的响应
 */
public class NewVersionResponse {
    /**
     * id
     */
    private String id;
    /**
     * 版本名
     */
    private String verName;
    /**
     * 版本号
     */
    private String verCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVerName() {
        return verName;
    }

    public void setVerName(String verName) {
        this.verName = verName;
    }

    public String getVerCode() {
        return verCode;
    }

    public void setVerCode(String verCode) {
        this.verCode = verCode;
    }
}
