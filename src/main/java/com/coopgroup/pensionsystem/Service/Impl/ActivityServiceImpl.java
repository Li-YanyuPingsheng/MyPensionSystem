package com.coopgroup.pensionsystem.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coopgroup.pensionsystem.Mapper.ActivityMapper;
import com.coopgroup.pensionsystem.Pojo.Activity;
import com.coopgroup.pensionsystem.Pojo.ActivityAttention;
import com.coopgroup.pensionsystem.Service.ActivityService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity> implements ActivityService {
    @Override
    public Boolean addActivity(Activity activity) {
        Boolean valueReturn=false;
        valueReturn=this.saveOrUpdate(activity);
        return valueReturn;
    }

    @Override
    public Boolean updateActivity(Activity activity) {
        Boolean valueReturn=false;
        valueReturn=this.saveOrUpdate(activity);
        return valueReturn;
    }

    @Override
    public Boolean deleteActivity(Long UUID) {
        Boolean valueReturn=false;
        valueReturn=this.removeById(UUID);
        return valueReturn;
    }

    @Override
    public Boolean deleteActivity(ArrayList<Long> UUIDList) {
        Boolean valueReturn=false;
        valueReturn=this.removeBatchByIds(UUIDList);
        return valueReturn;
    }

    @Override
    public Boolean activityAlterStatus(Long UUID, String Status) {
        Boolean valueReturn=false;
        UpdateWrapper<Activity> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("Activity_UUID",UUID).set("status",Status);
        valueReturn=this.update(updateWrapper);
        return valueReturn;
    }

    @Override
    public HashMap<Long, Activity> getActivityMap() {
        HashMap<Long,Activity> activityHashMap=new HashMap<>();
        QueryWrapper<Activity> queryWrapper=new QueryWrapper<>();
        queryWrapper.orderByAsc("Status");
        ArrayList<Activity> activityArrayList= (ArrayList<Activity>) this.list(queryWrapper);
        activityArrayList.forEach(e->{
            activityHashMap.put(e.getUUID(),e);
        });
        return activityHashMap;
    }

    @Override
    public ArrayList<Activity> getActivityList() {
        QueryWrapper<Activity> queryWrapper=new QueryWrapper<>();
        queryWrapper.orderByAsc("Status");
        ArrayList<Activity> activityArrayList= (ArrayList<Activity>) this.list(queryWrapper);
        return activityArrayList;
    }
}
