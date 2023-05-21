package com.coopgroup.pensionsystem.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.coopgroup.pensionsystem.Mapper.ActivityAttentionMapper;
import com.coopgroup.pensionsystem.Pojo.ActivityAttention;
import com.coopgroup.pensionsystem.Service.ActivityAttentionService;
import com.github.jeffreyning.mybatisplus.service.MppServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ActivityAttentionServiceImpl extends MppServiceImpl<ActivityAttentionMapper, ActivityAttention> implements ActivityAttentionService {
    @Override
    public Boolean activityAttentionAdd(Long activity_UUID, Long Elder_UUID) {
        Boolean valueReturn=false;
        ActivityAttention activityAttention=new ActivityAttention();
        activityAttention.setActivityUUID(activity_UUID);
        activityAttention.setElderUUID(Elder_UUID);
        valueReturn=this.saveOrUpdateByMultiId(activityAttention);
        return valueReturn;
    }

    @Override
    public Boolean activityAttentionDelete(Long activity_UUID, Long Elder_UUID) {
        Boolean valueReturn=false;
        ActivityAttention activityAttention=new ActivityAttention();
        activityAttention.setActivityUUID(activity_UUID);
        activityAttention.setElderUUID(Elder_UUID);
        valueReturn=this.deleteByMultiId(activityAttention);
        return valueReturn;
    }
    @Override
    public ArrayList<ActivityAttention> getAttentionList(Long Elder_UUID) {
        ArrayList<ActivityAttention> activityAttentionArrayList=new ArrayList<>();
        QueryWrapper<ActivityAttention> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("Elder_UUID",Elder_UUID);
        activityAttentionArrayList= (ArrayList<ActivityAttention>) this.list(queryWrapper);
        return activityAttentionArrayList;
    }
}
