package com.coopgroup.pensionsystem.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coopgroup.pensionsystem.Mapper.GoodMapper;
import com.coopgroup.pensionsystem.Pojo.Good;
import com.coopgroup.pensionsystem.Pojo.User;
import com.coopgroup.pensionsystem.Service.GoodService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class GoodServiceImpl extends ServiceImpl<GoodMapper, Good> implements GoodService {
    @Override
    public Boolean addGood(Good good) {
        Boolean valueReturn=this.saveOrUpdate(good);
        return valueReturn;
    }

    @Override
    public Boolean updateGood(Good good) {
        Boolean valueReturn=this.saveOrUpdate(good);
        return valueReturn;
    }

    @Override
    public Boolean deleteGood(Long UUID) {
        Boolean valueReturn=this.removeById(UUID);
        return valueReturn;
    }

    @Override
    public HashMap<Long, Good> getGoodHashMap() {
        HashMap<Long,Good> goodHashMap=new HashMap<>();
        ArrayList<Good> goodArrayList= (ArrayList<Good>) this.list();
        goodArrayList.forEach(e->{
            goodHashMap.put(e.getGood_UUID(),e);
        });
        return goodHashMap;
    }

    @Override
    public HashMap<Long, Good> getGoodHashMapByMerchant(Long merchant_UUID) {
        HashMap<Long,Good> goodHashMap=new HashMap<>();
        QueryWrapper<Good> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("Merchant_UUID",merchant_UUID).orderByAsc("Name");
        ArrayList<Good> goodArrayList= (ArrayList<Good>) this.list(queryWrapper);
        goodArrayList.forEach(e->{
            goodHashMap.put(e.getGood_UUID(),e);
        });
        return goodHashMap;
    }

    @Override
    public HashMap<Long, Good> getGoodHashMapByCategory(Long category_UUID) {
        HashMap<Long,Good> goodHashMap=new HashMap<>();
        QueryWrapper<Good> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("category_UUID",category_UUID).orderByAsc("Name");
        ArrayList<Good> goodArrayList= (ArrayList<Good>) this.list(queryWrapper);
        goodArrayList.forEach(e->{
            goodHashMap.put(e.getGood_UUID(),e);
        });
        return goodHashMap;
    }
}
