package com.coopgroup.pensionsystem.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coopgroup.pensionsystem.Mapper.OrderMapper;
import com.coopgroup.pensionsystem.Pojo.Order;
import com.coopgroup.pensionsystem.Service.OrderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
    @Override
    public Boolean addOrder(Order order) {
        Boolean valueReturn=this.saveOrUpdate(order);
        return valueReturn;
    }

    @Override
    public Boolean updateOrder(Long UUID, String status) {
        UpdateWrapper<Order> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("UUID",UUID).set("Status",status);
        Boolean valueReturn=this.update(updateWrapper);
        return valueReturn;
    }

    @Override
    public ArrayList<Order> getOrderList(Long Elder_UUID) {
        QueryWrapper<Order> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("Elder_UUID",Elder_UUID);
        ArrayList<Order> orderArrayList= (ArrayList<Order>) this.list(queryWrapper);
        return orderArrayList;
    }
}
