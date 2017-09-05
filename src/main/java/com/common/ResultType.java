package com.common;

public enum ResultType {
	
    SUCCESS("200", "成功"),
    SUCCESS_CREATED("201", "已创建"),
    SUCCESS_ACCEPTED("202", "已接受"),
    SUCCESS_NO_CONTENT("204", "无内容"),
    REDIRECT_PERMANTENTLY("301", "永久移动"),
    REDIRECT_PROXY_REQUIRED("305", "使用代理"),
    REDIRECT_TEMMPORARILY("307", "临时重定向"),
    BAD_REQUEST("400", "错误请求"),
    UNAUTHORIZED_REQUEST("401", "未授权"),
    FORBIDDEN_REQUEST("403", "禁止"),
    NOT_FOUND("404", "未找到"),
    METHOD_NOT_ALLOWED("405", "方法禁用"),
    PROXY_UNAUTHORIZED_REQUEST("407", "需要代理授权"),
    REQUEST_TIMEOUT("408", "请求超时"),
    INTERNAL_SERVER_ERROR("500", "服务器内部错误"),
    BAD_GATEWAY("502", "错误网关"),
    SERVICE_UNAVAILABLE("503", "服务不可用"),
    GATEWAY_TIMEOUT("504", "网关超时"),
    HTTP_VERSION_NOT_SUPPORTED("505", "HTTP 版本不受支持"),
	
	
	;
	/**
	 * 编码
	 */
	private String code;
	
	/**
	 * 描述
	 */
	private String description;
	
	private ResultType(String code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}
