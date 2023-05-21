package com.coopgroup.pensionsystem.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.coopgroup.pensionsystem.Pojo.Order;

import java.util.ArrayList;

public interface OrderService extends IService<Order> {
    public Boolean addOrder(Order order);
    public Boolean updateOrder(Long UUID,String status);
    public ArrayList<Order> getOrderList(Long Elder_UUID);
}
