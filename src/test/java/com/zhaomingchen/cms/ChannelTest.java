package com.zhaomingchen.cms;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhaomingchen.entity.Channel;
import com.zhaomingchen.service.ChannelService;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:spring-beans.xml")
public class ChannelTest {
	
	@Autowired
	private ChannelService service;
	
	/**
	 * 
	 * @Title: getChannel 
	 * @Description: 测试是否能获取导航条的值
	 * @return: void
	 */
	@Test
	public void getChannel() {
		
		List<Channel> channel = service.getChannel();
		
		for (Channel channel2 : channel) {
			System.out.println(channel2);
		}
		
		
		
	}

}
