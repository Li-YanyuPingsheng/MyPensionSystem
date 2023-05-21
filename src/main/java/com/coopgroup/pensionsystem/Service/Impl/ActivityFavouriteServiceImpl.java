package com.coopgroup.pensionsystem.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.coopgroup.pensionsystem.Mapper.ActivityFavouriteMapper;
import com.coopgroup.pensionsystem.Pojo.ActivityFavourite;
import com.coopgroup.pensionsystem.Service.ActivityFavouriteService;
import com.github.jeffreyning.mybatisplus.service.MppServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ActivityFavouriteServiceImpl extends MppServiceImpl <ActivityFavouriteMapper, ActivityFavourite> implements ActivityFavouriteService {
    private ActivityFavourite isExist(Long activity_UUID,Long Elder_UUID){
        QueryWrapper<ActivityFavourite> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("Activity_UUID",activity_UUID).eq("Elder_UUID",Elder_UUID);
        ActivityFavourite activityFavourite=this.getOne(queryWrapper);
        return activityFavourite;
    }
    @Override
    public Boolean alterStatus(Long activity_UUID, Long Elder_UUID) {
        Boolean valueReturn=false;
        ActivityFavourite activityFavourite=isExist(activity_UUID,Elder_UUID);
        if(activityFavourite==null)
        {
            activityFavourite=new ActivityFavourite();
            activityFavourite.setActivityUUID(activity_UUID);
            activityFavourite.setElderUUID(Elder_UUID);
            valueReturn=this.saveOrUpdateByMultiId(activityFavourite);
        }
        else {
            valueReturn=this.deleteByMultiId(activityFavourite);
        }
        return valueReturn;
    }
}
