package com.coopgroup.pensionsystem.Service.Impl;

import com.coopgroup.pensionsystem.Mapper.FriendMapper;
import com.coopgroup.pensionsystem.Pojo.Friend;
import com.coopgroup.pensionsystem.Service.FriendService;
import com.github.jeffreyning.mybatisplus.service.MppServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class FriendServiceImpl extends MppServiceImpl<FriendMapper, Friend> implements FriendService {
}
