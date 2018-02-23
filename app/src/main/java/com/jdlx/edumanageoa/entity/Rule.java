package com.jdlx.edumanageoa.entity;

/**
 * @description  规则
 * @author  fupengpeng
 * @date  2018/1/27 0027 11:26
 */
public class Rule {
    // 规则ID
    private String ruleId;
    // 规则标题
    private String ruleName;
    // 规则内容
    private String ruleContent;

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRuleContent() {
        return ruleContent;
    }

    public void setRuleContent(String ruleContent) {
        this.ruleContent = ruleContent;
    }
}
