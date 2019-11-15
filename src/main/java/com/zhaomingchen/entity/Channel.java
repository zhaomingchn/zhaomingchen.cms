package com.zhaomingchen.entity;

public class Channel {

	
	private Integer id;
	
	private String name;
	
	private String descirption;
	
	private String icon;

	@Override
	public String toString() {
		return "Channel [id=" + id + ", name=" + name + ", descirption=" + descirption + ", icon=" + icon + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescirption() {
		return descirption;
	}

	public void setDescirption(String descirption) {
		this.descirption = descirption;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Channel(Integer id, String name, String descirption, String icon) {
		super();
		this.id = id;
		this.name = name;
		this.descirption = descirption;
		this.icon = icon;
	}

	public Channel() {
		super();
	}
	
	
}
