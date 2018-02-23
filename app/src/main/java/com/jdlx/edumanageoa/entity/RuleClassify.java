package com.jdlx.edumanageoa.entity;

import java.util.List;

/**
 * @description  规则分类
 * @author  fupengpeng
 * @date  2018/1/27 0027 11:26
 */
public class RuleClassify {
    // 规则分类ID
    private String ruleClassifyId;
    // 分类名
    private String ruleClassifyname;
    // 规则列表
    private List<Rule> ruleList;

    public String getRuleClassifyId() {
        return ruleClassifyId;
    }

    public void setRuleClassifyId(String ruleClassifyId) {
        this.ruleClassifyId = ruleClassifyId;
    }

    public String getRuleClassifyname() {
        return ruleClassifyname;
    }

    public void setRuleClassifyname(String ruleClassifyname) {
        this.ruleClassifyname = ruleClassifyname;
    }

    public List<Rule> getRuleList() {
        return ruleList;
    }

    public void setRuleList(List<Rule> ruleList) {
        this.ruleList = ruleList;
    }
}
