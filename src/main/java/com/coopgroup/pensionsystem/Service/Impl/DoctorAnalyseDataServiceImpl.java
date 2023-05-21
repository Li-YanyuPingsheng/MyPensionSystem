package com.coopgroup.pensionsystem.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coopgroup.pensionsystem.Mapper.DoctorAnalyseDataMapper;
import com.coopgroup.pensionsystem.Pojo.DoctorAnalyseData;
import com.coopgroup.pensionsystem.Service.DoctorAnalyseDataService;
import org.springframework.stereotype.Service;

@Service
public class DoctorAnalyseDataServiceImpl extends ServiceImpl<DoctorAnalyseDataMapper, DoctorAnalyseData> implements DoctorAnalyseDataService {
    @Override
    public Boolean addDoctorAnalyze(DoctorAnalyseData doctorAnalyseData) {
        Boolean valueReturn=false;
        valueReturn=this.saveOrUpdate(doctorAnalyseData);
        return valueReturn;
    }

    @Override
    public Boolean updateDoctorAnalyze(DoctorAnalyseData doctorAnalyseData) {
        Boolean valueReturn=false;
        valueReturn=this.saveOrUpdate(doctorAnalyseData);
        return valueReturn;
    }

    @Override
    public DoctorAnalyseData getByBodyData(Long bodyDataUUID) {
        QueryWrapper<DoctorAnalyseData> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("Elder_Data_UUID",bodyDataUUID);
        DoctorAnalyseData doctorAnalyseData=this.getOne(queryWrapper);
        return doctorAnalyseData;
    }
}
