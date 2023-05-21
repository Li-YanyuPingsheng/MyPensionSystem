package com.coopgroup.pensionsystem.Service;

import com.coopgroup.pensionsystem.Pojo.ActivityAttention;
import com.github.jeffreyning.mybatisplus.service.IMppService;

import java.util.ArrayList;

public interface ActivityAttentionService extends IMppService<ActivityAttention> {
    public Boolean activityAttentionAdd(Long activity_UUID,Long Elder_UUID);
    public Boolean activityAttentionDelete(Long activity_UUID,Long Elder_UUID);
    public ArrayList<ActivityAttention> getAttentionList(Long Elder_UUID);
}
