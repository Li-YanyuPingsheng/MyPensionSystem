package com.coopgroup.pensionsystem.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coopgroup.pensionsystem.Mapper.ElderMapper;
import com.coopgroup.pensionsystem.Pojo.Elder;
import com.coopgroup.pensionsystem.Pojo.User;
import com.coopgroup.pensionsystem.Service.ElderService;
import com.coopgroup.pensionsystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class ElderServiceImpl extends ServiceImpl<ElderMapper, Elder> implements ElderService {
    @Override
    public void addElder(User user, Elder elder) {
        elder.setAccount_UUID(user.getUUID());
        this.saveOrUpdate(elder);
    }

    @Override
    public void addElderList(ArrayList<User> userArrayList,ArrayList<Elder> elderArrayList) {
        for(int i=0;i< elderArrayList.size();i++){
            elderArrayList.get(i).setAccount_UUID(userArrayList.get(i).getUUID());
        }
        this.saveOrUpdateBatch(elderArrayList);
    }
}
