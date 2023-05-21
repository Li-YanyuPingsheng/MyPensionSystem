package com.coopgroup.pensionsystem.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.coopgroup.pensionsystem.Pojo.Activity;

import java.util.ArrayList;
import java.util.HashMap;

public interface ActivityService extends IService<Activity> {
    public Boolean addActivity(Activity activity);
    public Boolean updateActivity(Activity activity);
    public Boolean deleteActivity(Long UUID);
    public Boolean deleteActivity(ArrayList<Long> UUIDList);
    public Boolean activityAlterStatus(Long UUID,String Status);
    public HashMap<Long,Activity> getActivityMap();
    public ArrayList<Activity> getActivityList();
}
