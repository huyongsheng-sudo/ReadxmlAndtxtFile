package com.example.demo;

/**
 * @Description: 自定义响应数据结构
 * 				200：表示成功
 * 				500：表示错误，错误信息在msg字段中
 * 				501：bean验证错误，不管多少个错误都以map形式返回
 * 				502：拦截器拦截到用户tsuccessen出错
 * 				555：异常抛出信息
 */
public class JSONResult {

    // 响应业务状态
    private Integer code;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;
    
    private String success;	// 不使用

    public static JSONResult build(Integer code, String msg, Object data) {
        return new JSONResult(code, msg, data);
    }

    public static JSONResult success(Object data) {
        return new JSONResult(data);
    }

    public static JSONResult success() {
        return new JSONResult(null);
    }
    
    public static JSONResult errorMsg(String msg) {
        return new JSONResult(500, msg, null);
    }
    
    public static JSONResult errorMap(Object data) {
        return new JSONResult(501, "error", data);
    }
    
    public static JSONResult errorTsuccessenMsg(String msg) {
        return new JSONResult(502, msg, null);
    }
    
    public static JSONResult errorException(String msg) {
        return new JSONResult(555, msg, null);
    }

    public JSONResult() {

    }

    public JSONResult(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public JSONResult(Object data) {
        this.code = 200;
        this.msg = "success";
        this.data = data;
    }

    public Boolean issuccess() {
        return this.code == 200;
    }

    public Integer getcode() {
        return code;
    }

    public void setcode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

	public String getsuccess() {
		return success;
	}

	public void setsuccess(String success) {
		this.success = success;
	}

}
