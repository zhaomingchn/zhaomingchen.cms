package com.zhaomingchen.entity;

public class Category {
	
	
	private Integer id;
	
	private String name;
	
	private Integer channel_id;

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", channel_id=" + channel_id + "]";
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

	public Integer getChannel_id() {
		return channel_id;
	}

	public void setChannel_id(Integer channel_id) {
		this.channel_id = channel_id;
	}

	public Category(Integer id, String name, Integer channel_id) {
		super();
		this.id = id;
		this.name = name;
		this.channel_id = channel_id;
	}

	public Category() {
		super();
	}
	
	
	

}
