package com.coopgroup.pensionsystem.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coopgroup.pensionsystem.Mapper.UserMapper;
import com.coopgroup.pensionsystem.Pojo.User;
import com.coopgroup.pensionsystem.Service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    private User isExist(String username){
        User user=null;
        QueryWrapper<User> userQueryWrapper=new QueryWrapper<>();
        userQueryWrapper.eq("Username",username);
        user=getOne(userQueryWrapper);
        return user;
    }

    @Override
    public HashMap<Integer, User> getLoginInfo(User user) {
        HashMap<Integer,User> valueReturn=new HashMap<>();
        QueryWrapper<User> userQueryWrapper=new QueryWrapper<>();
//        userQueryWrapper.eq("Username",user.getUsername()).eq("Role",user.getRole());
        userQueryWrapper.eq("Username",user.getUsername());
        User value= getOne(userQueryWrapper);
        if(value==null)
        {
            valueReturn.put(404,null);
        }
        if(value!=null)
        {
            if(user.getPassword().equals(value.getPassword()))
            {
                valueReturn.put(200,value);
            }
            else
            {
                valueReturn.put(405,user);
            }
        }
        return valueReturn;
    }
    @Override
    public String addUser(User user) {
        String valueReturn="";
        if(isExist(user.getUsername())==null) {
            this.saveOrUpdate(user);
            valueReturn="注册成功";
        }
        else
            valueReturn="注册失败,账号已存在";
        return valueReturn;
    }
    @Override
    public Boolean updateUsername(String username, String newUsername) {
        Boolean valueReturn=false;
        User user=isExist(username);
        if(isExist(newUsername)==null)
        {
            user.setUsername(newUsername);
            valueReturn=this.saveOrUpdate(user);
        }
        return valueReturn;
    }
    @Override
    public Boolean updatePassword(String username, String password) {
        Boolean valueReturn = false;
        User user=isExist(username);
        user.setPassword(password);
        valueReturn=this.saveOrUpdate(user);
        return valueReturn;
    }
    /**
     * 多用户注册未做检验
     * */
    @Override
    public void addUserList(ArrayList<User> userArrayList) {
        this.saveBatch(userArrayList);
    }
    @Override
    public User getUserByName(String name) {
        QueryWrapper<User> userQueryWrapper=new QueryWrapper<>();
        userQueryWrapper.eq("Name",name);
        User user=this.getOne(userQueryWrapper);
        return user;
    }

    @Override
    public Boolean updateUser(User user) {
//        LambdaUpdateWrapper<User> userLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
//        userLambdaUpdateWrapper.eq(User::getUUID, user.getUUID())
//                .set(User::getUsername, user.getUsername())
//                .set(User::getPhone, user.getPhone())
//                .set(User::getName, user.getName());
        return this.saveOrUpdate(user);
    }

}
