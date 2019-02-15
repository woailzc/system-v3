package com.logistics.system.modlues.redisTest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = false)
public class RedisSendService{
	@Autowired
	public RedisTemplate<String, Object> redisTemplate;
	
	public void sendMessage(String channel, String message) {
		System.out.println("开始发布消息。。。");
		redisTemplate.convertAndSend(channel, message);
		System.out.println("发布成功！");
		}
}
