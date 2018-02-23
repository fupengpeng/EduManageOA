package com.jdlx.edumanageoa.entity;

/**
 * 工作者信息
 */
public class Worker {
    // 工号
    private String jobnumber;
    // 岗位ID
    private String postid;
    // 岗位名称
    private String postname;
    // 职位ID
    private String jobid;
    // 职位名称
    private String jobname;
    // 说明
    private String memo;
    // 工作状态
    private String workstate;
    // 工作状态名称
    private String workstatename;
    // 收款码
    private String paycode;

    public String getJobnumber() {
        return jobnumber;
    }

    public void setJobnumber(String jobnumber) {
        this.jobnumber = jobnumber;
    }

    public String getPostid() {
        return postid;
    }

    public void setPostid(String postid) {
        this.postid = postid;
    }

    public String getPostname() {
        return postname;
    }

    public void setPostname(String postname) {
        this.postname = postname;
    }

    public String getJobid() {
        return jobid;
    }

    public void setJobid(String jobid) {
        this.jobid = jobid;
    }

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getWorkstate() {
        return workstate;
    }

    public void setWorkstate(String workstate) {
        this.workstate = workstate;
    }

    public String getWorkstatename() {
        return workstatename;
    }

    public void setWorkstatename(String workstatename) {
        this.workstatename = workstatename;
    }

    public String getPaycode() {
        return paycode;
    }

    public void setPaycode(String paycode) {
        this.paycode = paycode;
    }
}
