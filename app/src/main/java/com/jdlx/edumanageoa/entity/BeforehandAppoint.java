package com.jdlx.edumanageoa.entity;

import java.util.List;

/**
 * @author fupengpeng
 * @description 预约
 * @data 2018/1/15 0015 8:38
 */

public class BeforehandAppoint {
    // 预约id
    private String id;
    // 所属门店
    private String shopid;
    // 预约人ID
    private String mid;
    // 预约来源，1.线上预约，2.线下预约
    private String source;
    // 预约店员ID
    private String cuid;
    // 预约时间
    private String ctime;
    // 预约状态，1待接受2待服务3已服务4已拒绝5已爽约6已撤销7已入单】
    private int state;
    // 创建人ID，为0则为用户自主创建
    private String euid;
    // 对应的订单ID
    private String oid;
    // 备注
    private String info;
    // 选择的服务项目或商品
    private List<ServiceItem> project;
    // 门店名称
    private String name;
    // 老板ID
    private String bid;
    // 会员手机号
    private String mobile;
    // 会员真实姓名
    private String truename;
    // 会员昵称
    private String nickname;
    // 会员头像
    private String faceurl;
    // 会员性别
    private String gender;
    // 预约店员姓名
    private String cuname;
    // 创建人姓名
    private String euname;

    // 支付状态
    private String paystate;
    // 支付金额
    private String price;

//    "name":"白宫",
//            "bid":"1",
//            "mobile":"13605372265",
//            "truename":"窦娥",
//            "nickname":"豆豆",
//            "faceurl":"http://cdn.juyunmei.com/shop/upfile/u1/2017-11-12/1510489142.png",
//            "gender":"0",
//            "del":"0",
//            "cancelinfo":"",
//            "canceluid":"0",
//            "price":"0.00",
//            "paystate":"0",
//            "key":"",
//            "refund":"0.00",
//            "refundstate":null,
//            "cuname":"老王",
//            "euname":"窦娥"


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShopid() {
        return shopid;
    }

    public void setShopid(String shopid) {
        this.shopid = shopid;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCuid() {
        return cuid;
    }

    public void setCuid(String cuid) {
        this.cuid = cuid;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getEuid() {
        return euid;
    }

    public void setEuid(String euid) {
        this.euid = euid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<ServiceItem> getProject() {
        return project;
    }

    public void setProject(List<ServiceItem> project) {
        this.project = project;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFaceurl() {
        return faceurl;
    }

    public void setFaceurl(String faceurl) {
        this.faceurl = faceurl;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCuname() {
        return cuname;
    }

    public void setCuname(String cuname) {
        this.cuname = cuname;
    }

    public String getEuname() {
        return euname;
    }

    public void setEuname(String euname) {
        this.euname = euname;
    }

    public String getPaystate() {
        return paystate;
    }

    public void setPaystate(String paystate) {
        this.paystate = paystate;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
