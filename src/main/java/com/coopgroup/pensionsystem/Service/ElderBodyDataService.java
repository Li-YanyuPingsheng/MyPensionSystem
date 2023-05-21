package com.coopgroup.pensionsystem.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.coopgroup.pensionsystem.Pojo.ElderBodyData;

import java.util.ArrayList;

public interface ElderBodyDataService extends IService<ElderBodyData> {
    public Boolean addElderBodyData(ElderBodyData elderBodyData);
    public Boolean updateElderBodyData(ElderBodyData elderBodyData);
    public Boolean deleteElderBodyData(Long UUID);
    public ArrayList<ElderBodyData> getElderBodyList(Long Elder_UUID);
}
