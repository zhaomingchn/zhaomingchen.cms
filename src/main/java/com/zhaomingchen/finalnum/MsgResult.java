package com.zhaomingchen.finalnum;

import java.io.Serializable;

public class MsgResult implements Serializable{

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 7744959646398084177L;
	
	
	private Integer num;
	
	private String error;
	
	private Object date;

	@Override
	public String toString() {
		return "MsgResult [num=" + num + ", error=" + error + ", date=" + date + "]";
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Object getDate() {
		return date;
	}

	public void setDate(Object date) {
		this.date = date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public MsgResult(Integer num, String error, Object date) {
		super();
		this.num = num;
		this.error = error;
		this.date = date;
	}

	public MsgResult() {
		super();
	}
	
	
	
	

	
	
	
	 
	
}
