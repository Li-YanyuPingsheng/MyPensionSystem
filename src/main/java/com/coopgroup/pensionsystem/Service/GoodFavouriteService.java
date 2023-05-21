package com.coopgroup.pensionsystem.Service;

import com.coopgroup.pensionsystem.Pojo.GoodFavourite;
import com.github.jeffreyning.mybatisplus.service.IMppService;

public interface GoodFavouriteService extends IMppService<GoodFavourite> {
    public Boolean alterStatus(Long Good_UUID,Long Elder_UUID);
}
