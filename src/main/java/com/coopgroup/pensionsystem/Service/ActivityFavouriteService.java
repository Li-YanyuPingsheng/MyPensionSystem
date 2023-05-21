package com.coopgroup.pensionsystem.Service;

import com.coopgroup.pensionsystem.Pojo.ActivityFavourite;
import com.github.jeffreyning.mybatisplus.service.IMppService;

public interface ActivityFavouriteService extends IMppService<ActivityFavourite> {
    public Boolean alterStatus(Long activity_UUID,Long Elder_UUID);
}
