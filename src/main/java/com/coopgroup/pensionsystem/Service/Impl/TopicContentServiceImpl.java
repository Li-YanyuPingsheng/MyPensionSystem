package com.coopgroup.pensionsystem.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coopgroup.pensionsystem.Mapper.TopicContentMapper;
import com.coopgroup.pensionsystem.Pojo.TopicContent;
import com.coopgroup.pensionsystem.Service.TopicContentService;
import org.springframework.stereotype.Service;

@Service
public class TopicContentServiceImpl extends ServiceImpl<TopicContentMapper, TopicContent> implements TopicContentService {
}
