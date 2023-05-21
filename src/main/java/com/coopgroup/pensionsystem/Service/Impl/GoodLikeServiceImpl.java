package com.coopgroup.pensionsystem.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.coopgroup.pensionsystem.Mapper.GoodLikeMapper;
import com.coopgroup.pensionsystem.Pojo.GoodFavourite;
import com.coopgroup.pensionsystem.Pojo.GoodLike;
import com.coopgroup.pensionsystem.Service.GoodLikeService;
import com.github.jeffreyning.mybatisplus.service.MppServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class GoodLikeServiceImpl extends MppServiceImpl<GoodLikeMapper, GoodLike> implements GoodLikeService {
    private GoodLike isExist(Long Good_UUID, Long Elder_UUID){
        QueryWrapper<GoodLike> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("Good_UUID",Good_UUID).eq("Elder_UUID",Elder_UUID);
        GoodLike goodLike=this.getOne(queryWrapper);
        return goodLike;
    }
    @Override
    public Boolean alterStatus(Long Good_UUID, Long Elder_UUID) {
        Boolean valueReturn=false;
        GoodLike goodLike=isExist(Good_UUID,Elder_UUID);
        if(goodLike==null)
        {
            goodLike=new GoodLike();
            goodLike.setGoodUUID(Good_UUID);
            goodLike.setElderUUID(Elder_UUID);
            valueReturn=this.saveOrUpdateByMultiId(goodLike);
        }
        else {
            valueReturn=this.deleteByMultiId(goodLike);
        }
        return valueReturn;
    }
}
