package com.coopgroup.pensionsystem.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coopgroup.pensionsystem.Mapper.ChatContentMapper;
import com.coopgroup.pensionsystem.Pojo.ChatContent;
import com.coopgroup.pensionsystem.Service.ChatContentService;
import org.springframework.stereotype.Service;

@Service
public class ChatContentServiceImpl extends ServiceImpl<ChatContentMapper, ChatContent> implements ChatContentService {
}
