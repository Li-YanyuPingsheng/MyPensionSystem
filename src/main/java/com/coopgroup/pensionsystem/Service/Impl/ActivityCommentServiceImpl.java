package com.coopgroup.pensionsystem.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coopgroup.pensionsystem.Mapper.ActivityCommentMapper;
import com.coopgroup.pensionsystem.Pojo.ActivityComment;
import com.coopgroup.pensionsystem.Service.ActivityCommentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ActivityCommentServiceImpl extends ServiceImpl<ActivityCommentMapper, ActivityComment>implements ActivityCommentService{
    @Override
    public Boolean addActivityComment(ActivityComment activityComment) {
        Boolean valueReturn=false;
        valueReturn=this.saveOrUpdate(activityComment);
        return valueReturn;
    }
    @Override
    public Boolean addActivityReplyComment(Long UUID, String content) {
        Boolean valueReturn=false;
        UpdateWrapper<ActivityComment> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("UUID",UUID).set("ReplyContent",content);
        valueReturn=this.update(updateWrapper);
        return valueReturn;
    }
    @Override
    public Boolean deleteActivityComment(Long UUID) {
        Boolean valueReturn=false;
        valueReturn=this.removeById(UUID);
        return valueReturn;
    }
    @Override
    public ArrayList<ActivityComment> getCommentList(Long activity_UUID) {
        QueryWrapper<ActivityComment> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("activity_UUID",activity_UUID).orderByAsc("update_time");
        ArrayList<ActivityComment> activityCommentArrayList= (ArrayList<ActivityComment>) this.list(queryWrapper);
        return activityCommentArrayList;
    }
}
