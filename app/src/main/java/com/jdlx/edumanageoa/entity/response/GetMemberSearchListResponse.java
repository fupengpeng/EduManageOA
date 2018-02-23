package com.jdlx.edumanageoa.entity.response;

import com.jdlx.edumanageoa.entity.Member;

import java.util.List;

/**
 * 检索会员信息的响应
 */
public class GetMemberSearchListResponse extends BaseResponse{
    // 会员列表
    private List<Member> data;

    public List<Member> getData() {
        return data;
    }

    public void setData(List<Member> data) {
        this.data = data;
    }
}
