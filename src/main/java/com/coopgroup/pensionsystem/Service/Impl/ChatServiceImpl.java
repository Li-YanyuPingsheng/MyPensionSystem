package com.coopgroup.pensionsystem.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coopgroup.pensionsystem.Mapper.ChatMapper;
import com.coopgroup.pensionsystem.Pojo.Chat;
import com.coopgroup.pensionsystem.Service.ChatService;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl extends ServiceImpl<ChatMapper, Chat> implements ChatService {
}
