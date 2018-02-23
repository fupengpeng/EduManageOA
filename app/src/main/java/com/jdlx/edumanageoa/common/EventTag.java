package com.jdlx.edumanageoa.common;

/**                              hankehui
 * Created by hankehui on 2017/12/7.
 * EventBus标签
 *
 * xxxx.xx.xxxx
 * 类  作用 标签
 * 1001:                          客户账单
 * 1002:                          消费账单详情
 * 1003:                          报表
 * 1004:                          客户建档
 * 1005:                          会员界面
 * 1006                           充值界面
 *
 * 01:                            控件修改
 * 02:                            适配器更新ui
 * 03:                            数据修改
 * 04:                            获取数据
 * 05:                            提示
 *
 * 0001:                          标签
 */

public class EventTag {
    /**
     * view控件修改
     */
    public class viewRevamp{
        /**
         * 输入框修改
         */
        public static final int CLIENT_SCREEN_SEEK_CANCEL=1001010001;
    }

    /**
     * 适配器更新ui
     */
    public class adapter{
        /**
         * 客单详情删除项目
         */
        public static final int CLIENT_ADAPTER_VIEW=1002020001;
    }

    /**
     * 数据修改
     */
    public class message{
        /**
         * 报表现金收入百分比显示
         */
        public static final int STATEMENT_MONEY_TEXT_PERCENT=1003030001;
        /**
         * 验证码等待
         */
        public static final int CLIENT_BOOK_BUILDING_VERIFICATION_CODE_TIME=1004030001;
        /**
         * 发送验证码
         */
        public static final int CLIENT_BOOK_BUILDING_SEND_VERIFICATION_CODE=1004030002;
        /**
         * mid获取会员手机号
         */
        public static final int CLIENT_BOOK_BUILDING_SEARCH_MEMENT_PHONE=1001030001;
    }

    /**
     * 获取数据
     */
    public class getMessage{
        /**
         * 客户类型
         */
        public static final int CLIENT_BOOK_BUILDING_GET_TYPE=1004040001;
        /**
         * 客户来源
         */
        public static final int CLIENT_BOOK_BUILDING_GET_SOURCE=1004040002;
        /**
         * 获取会员平台信息
         */
        public static final int CLIENT_BOOK_BUILDING_GET_MESSAGE=1004040003;
        /**
         * 消费账单列表
         */
        public static final int CLIENT_EXPENSE_BILL_GET_MESSAGE=1001040001;
        /**
         * 账单列表搜索无数据
         */
        public static final int CLIENT_EXPENSE_BILL_GET_PARTICULARS=1001020002;
        /**
         * 会员资料类型
         */
        public static final int MEMBER_GET_TYPE=1005040001;
        /**
         * 会员资料来源
         */
        public static final int MEMBER_GET_SOURCE=1005040002;
        /**
         * 售卡人信息
         */
        public static final int RECHARGE_SELL_CARD_PEOPLE_MESSAGE=1006040001;
    }

    /**
     * 提示
     */
    public class hint{
        /**
         * 会员创建会员已存在提示
         *
         */
        public static final int CLIENT_BOOK_BUILDING_MEMBER_EXIST_HINT=1004050001;
    }
}
