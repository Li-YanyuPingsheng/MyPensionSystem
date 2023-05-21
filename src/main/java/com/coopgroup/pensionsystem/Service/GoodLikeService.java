package com.coopgroup.pensionsystem.Service;


import com.coopgroup.pensionsystem.Pojo.GoodLike;
import com.github.jeffreyning.mybatisplus.service.IMppService;

public interface GoodLikeService extends IMppService<GoodLike> {
    public Boolean alterStatus(Long Good_UUID,Long Elder_UUID);
}
