package com.coopgroup.pensionsystem.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coopgroup.pensionsystem.Mapper.ElderBodyDataMapper;
import com.coopgroup.pensionsystem.Pojo.ElderBodyData;
import com.coopgroup.pensionsystem.Service.ElderBodyDataService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ElderBodyDataServiceImpl extends ServiceImpl<ElderBodyDataMapper, ElderBodyData> implements ElderBodyDataService {
    @Override
    public Boolean addElderBodyData(ElderBodyData elderBodyData) {
        Boolean valueReturn=this.saveOrUpdate(elderBodyData);
        return valueReturn;
    }

    @Override
    public Boolean updateElderBodyData(ElderBodyData elderBodyData) {
        Boolean valueReturn=this.saveOrUpdate(elderBodyData);
        return valueReturn;
    }

    @Override
    public Boolean deleteElderBodyData(Long UUID) {
        Boolean valueReturn=this.removeById(UUID);
        return valueReturn;
    }

    @Override
    public ArrayList<ElderBodyData> getElderBodyList(Long Elder_UUID) {
        QueryWrapper<ElderBodyData> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("Elder_UUID",Elder_UUID).orderByAsc("update_time");
        ArrayList<ElderBodyData> elderBodyDataArrayList= (ArrayList<ElderBodyData>) this.list(queryWrapper);
        return elderBodyDataArrayList;
    }
}
