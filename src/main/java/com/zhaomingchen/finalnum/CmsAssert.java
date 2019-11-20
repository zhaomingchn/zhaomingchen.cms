package com.zhaomingchen.finalnum;


public class CmsAssert {

	public  static void AssertTrue(boolean express,String msg) {
		if(!express) {
			throw new CmsException(msg);
			
		}
		
	}
	
	
	
}
