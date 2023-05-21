package com.coopgroup.pensionsystem.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.coopgroup.pensionsystem.Mapper.GoodFavouriteMapper;
import com.coopgroup.pensionsystem.Pojo.ActivityFavourite;
import com.coopgroup.pensionsystem.Pojo.GoodFavourite;
import com.coopgroup.pensionsystem.Service.GoodFavouriteService;
import com.github.jeffreyning.mybatisplus.service.MppServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class GoodFavouriteServiceImpl extends MppServiceImpl<GoodFavouriteMapper, GoodFavourite> implements GoodFavouriteService {
    private GoodFavourite isExist(Long Good_UUID, Long Elder_UUID){
        QueryWrapper<GoodFavourite> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("Good_UUID",Good_UUID).eq("Elder_UUID",Elder_UUID);
        GoodFavourite goodFavourite=this.getOne(queryWrapper);
        return goodFavourite;
    }
    @Override
    public Boolean alterStatus(Long Good_UUID, Long Elder_UUID) {
        Boolean valueReturn=false;
        GoodFavourite goodFavourite=isExist(Good_UUID,Elder_UUID);
        if(goodFavourite==null)
        {
            goodFavourite=new GoodFavourite();
            goodFavourite.setGoodUUID(Good_UUID);
            goodFavourite.setElderUUID(Elder_UUID);
            valueReturn=this.saveOrUpdateByMultiId(goodFavourite);
        }
        else {
            valueReturn=this.deleteByMultiId(goodFavourite);
        }
        return valueReturn;
    }
}
