package com.coopgroup.pensionsystem.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.coopgroup.pensionsystem.Pojo.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface UserService extends IService<User> {
    public HashMap<Integer, User> getLoginInfo(User user);
    public String addUser(User user);
    public Boolean updateUsername(String username,String newUsername);
    public Boolean updatePassword(String username,String password);
    public void addUserList(ArrayList<User> userArrayList);
    public User getUserByName(String name);

    Boolean updateUser(User user);
}
