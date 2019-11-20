package com.zhaomingchen.finalnum;

import org.apache.commons.codec.digest.DigestUtils;

public class Md5 {
	
  public static	String password(String password,String salt) {
	  
	  return DigestUtils.md5Hex(password + "::::" +  salt);
	}

}
