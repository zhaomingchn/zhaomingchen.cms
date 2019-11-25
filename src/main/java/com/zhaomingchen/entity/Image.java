package com.zhaomingchen.entity;

public class Image {
	
	
	private String url;
	
	private String desc;

	@Override
	public String toString() {
		return "Image [url=" + url + ", desc=" + desc + "]";
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Image(String url, String desc) {
		super();
		this.url = url;
		this.desc = desc;
	}

	public Image() {
		super();
	}
	
	
	
	

}
