package com.jr.model;
/**
 * 返回前端数据
 * @author Administrator
 *
 */
public class ReturnInfo {
	
	public ReturnInfo() {}
	public ReturnInfo(Boolean _success,String _errMsg,Object _data) {
		this.success=_success;
		this.errMsg=_errMsg;
		this.data=_data;
	}
	
	private Boolean success;
	private String errMsg;
	private Object data;
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
	
}
