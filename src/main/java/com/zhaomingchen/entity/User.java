package com.zhaomingchen.entity;

import java.io.Serializable;
import java.util.Date;

import com.zhaomingchen.finalnum.FinalNum;

public class User implements Serializable  {
	
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 7891291251024146593L;
	private Integer id            ;
	//
	private String username       ;
	private String password       ;
	//昵称没有用上
	private String nickname       ;
	//生日
	private Date birthday       ;
	// 性别
	private int gender         ;
	//是否被解禁
	private int  locked         ;
	//注册时间
	private Date createTime    ;
	private Date updateTime    ;
	//没有用上
	private String url            ;
	// 没有用上
	private int score          ;
	private int role=FinalNum.ROLE;

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", nickname=" + nickname
				+ ", birthday=" + birthday + ", gender=" + gender + ", locked=" + locked + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + ", url=" + url + ", score=" + score + ", role=" + role + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getLocked() {
		return locked;
	}

	public void setLocked(int locked) {
		this.locked = locked;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public User() {
		super();
	}

	public User(Integer id, String username, String password, String nickname, Date birthday, int gender, int locked,
			Date createTime, Date updateTime, String url, int score, int role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.birthday = birthday;
		this.gender = gender;
		this.locked = locked;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.url = url;
		this.score = score;
		this.role = role;
	}

	
	
	

	
	
	

}
