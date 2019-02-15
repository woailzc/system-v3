package com.logistics.system.modlues.redisTest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = false)
public class RedisListenerService implements MessageListener {
	
	@Autowired
	public RedisTemplate<String, Object> redisTemplate;

	@Override
	public void onMessage(Message message, byte[] pattern) {
		// TODO Auto-generated method stub
		System.out.println("channel:" + new String(message.getChannel())
				+ ",message:" + new String(message.getBody()));
		
	}

}
