package com.coopgroup.pensionsystem.Controller;

import com.coopgroup.pensionsystem.Pojo.DoctorAnalyseData;
import com.coopgroup.pensionsystem.Pojo.ElderBodyData;
import com.coopgroup.pensionsystem.Service.DoctorAnalyseDataService;
import com.coopgroup.pensionsystem.Service.ElderBodyDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MedicalRestController {
    @Autowired
    private ElderBodyDataService elderBodyDataService;
    @Autowired
    private DoctorAnalyseDataService doctorAnalyseDataService;
    @RequestMapping(value = "/bodyData",method = RequestMethod.POST)
    public void addBodyData(ElderBodyData elderBodyData){
        elderBodyDataService.addElderBodyData(elderBodyData);
    }
    @RequestMapping(value = "/bodyData",method = RequestMethod.PUT)
    public void updateBodyData(ElderBodyData elderBodyData){
        elderBodyDataService.updateElderBodyData(elderBodyData);
    }
    @RequestMapping(value = "/bodyData",method = RequestMethod.DELETE)
    public void deleteBodyData(@RequestParam Long UUID){
        elderBodyDataService.deleteElderBodyData(UUID);
    }
    @RequestMapping(value = "/bodyData/analysis",method = RequestMethod.POST)
    public void addAnalysis(DoctorAnalyseData doctorAnalyseData){
        doctorAnalyseDataService.addDoctorAnalyze(doctorAnalyseData);
    }
    @RequestMapping(value = "/bodyData/analysis",method = RequestMethod.PUT)
    public void updateAnalysis(DoctorAnalyseData doctorAnalyseData){
        doctorAnalyseDataService.updateDoctorAnalyze(doctorAnalyseData);
    }
}
