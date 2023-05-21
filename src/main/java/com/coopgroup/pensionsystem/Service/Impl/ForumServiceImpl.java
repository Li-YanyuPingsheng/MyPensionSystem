package com.coopgroup.pensionsystem.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coopgroup.pensionsystem.Mapper.ForumMapper;
import com.coopgroup.pensionsystem.Pojo.Forum;
import com.coopgroup.pensionsystem.Service.ForumService;
import org.springframework.stereotype.Service;

@Service
public class ForumServiceImpl extends ServiceImpl<ForumMapper, Forum> implements ForumService {
}
