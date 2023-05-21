package com.coopgroup.pensionsystem.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.coopgroup.pensionsystem.Pojo.Elder;
import com.coopgroup.pensionsystem.Pojo.User;

import java.util.ArrayList;
import java.util.HashMap;

public interface ElderService extends IService<Elder> {
    public void addElderList(ArrayList<User> userArrayList,ArrayList<Elder> elderArrayList);
    public void addElder(User user,Elder elder);
}
