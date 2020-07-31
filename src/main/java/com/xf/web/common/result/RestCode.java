package com.xf.web.common.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 响应码枚举，参考HTTP状态码的语义。可以自定义需求。
 */
@Getter
@AllArgsConstructor
public enum RestCode {
    // //成功
    SUCCESS(200, "请求成功"),
    // 失败
    FAIL(400, "请求失败"),
    //  "请求地址无效"
    REQUEST_INVALID(404, "请求地址无效"),
    //  "未授权:用户名和密码是否正确，token是否无效"
    AUTH_INVALID(401, "未授权:用户名和密码是否正确，token是否无效"),
    // "签名无效"
    AUTH_SIGNATURE_NOTFOUND(405, "签名无效"),
    // "请求次数达到上限"
    REQUEST_LIMIT(406, "请求次数达到上限"),
    // "系统配置缺失"
    SYSTEM_CONFIG_LACK(407, "系统配置缺失"),
    // "服务运行时异常"
    SERVICE_UNAVAILABLE(408, "服务运行时异常"),
    // "服务未处理异常"
    SERVICE_NOFIX_EXCEPTION(409, "服务未处理异常"),
    // "访问参数无效"
    PARAM_INVALID(410, "访问参数无效"),
    // "参数验证不通过"
    VALIDATOR_INVALID(411, "参数验证不通过"),
    // 没有sn号或者sn号在数据库中查找不到
    SN_IS_INVALID(412, "没有sn号或者sn号在数据库中查找不到"),
    SERVICE_NOT_AVAILABLE(413, "服务提供者异常"),
    JSON_REQUESTBODY_EXCEPTION(414, "application/context-json参数不正确"),


    /**
     * swis-bedhead-screen  枚举2000开始
     */
    NO_CONFIRM_CALL(2000, "不是床头屏禁止呼叫"),
    HOSPITAL_BED_NO_IS_NULL(2001, "床位为空，不能呼叫");



    private int code;

    private String msg;


    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static void main(String[] args) {
        System.out.println(RestCode.REQUEST_INVALID.getCode());
        System.out.println(RestCode.REQUEST_INVALID.getMsg());
        System.out.println(RestCode.REQUEST_INVALID);
    }
}
