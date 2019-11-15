package com.zhaomingchen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhaomingchen.dao.ChannelDao;
import com.zhaomingchen.entity.Article;
import com.zhaomingchen.entity.Channel;
import com.zhaomingchen.service.ChannelService;
@Service
public class ChannelServiceimpl implements ChannelService {

	@Autowired
	private ChannelDao dao;
	
	
	@Override
	public List<Channel> getChannel() {
		// TODO Auto-generated method stub
		return dao.getChannel();
	}



	
	
}
