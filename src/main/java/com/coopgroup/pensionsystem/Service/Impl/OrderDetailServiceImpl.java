package com.coopgroup.pensionsystem.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.coopgroup.pensionsystem.Mapper.OrderDetailMapper;
import com.coopgroup.pensionsystem.Pojo.OrderDetail;
import com.coopgroup.pensionsystem.Service.OrderDetailService;
import com.github.jeffreyning.mybatisplus.service.MppServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OrderDetailServiceImpl extends MppServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {
    @Override
    public Boolean addOrderDetail(OrderDetail orderDetail) {
        Boolean valueReturn=this.saveOrUpdate(orderDetail);
        return valueReturn;
    }

    @Override
    public Boolean addOrderDetailList(ArrayList<OrderDetail> orderDetailArrayList) {
        Boolean valueReturn=this.saveOrUpdateBatch(orderDetailArrayList);
        return valueReturn;
    }

    @Override
    public ArrayList<OrderDetail> getOrderDetailList(Long order_UUID) {
        QueryWrapper<OrderDetail> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("order_UUID",order_UUID);
        ArrayList<OrderDetail> orderDetailArrayList= (ArrayList<OrderDetail>) this.list(queryWrapper);
        return orderDetailArrayList;
    }
}
