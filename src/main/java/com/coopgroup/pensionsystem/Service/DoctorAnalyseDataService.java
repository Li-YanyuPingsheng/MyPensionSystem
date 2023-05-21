package com.coopgroup.pensionsystem.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.coopgroup.pensionsystem.Pojo.DoctorAnalyseData;

public interface DoctorAnalyseDataService extends IService<DoctorAnalyseData> {
    public Boolean addDoctorAnalyze(DoctorAnalyseData doctorAnalyseData);
    public Boolean updateDoctorAnalyze(DoctorAnalyseData doctorAnalyseData);
    public DoctorAnalyseData getByBodyData(Long UUID);
}
