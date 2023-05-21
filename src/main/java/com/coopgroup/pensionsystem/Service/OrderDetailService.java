package com.coopgroup.pensionsystem.Service;

import com.coopgroup.pensionsystem.Pojo.OrderDetail;
import com.github.jeffreyning.mybatisplus.service.IMppService;

import java.util.ArrayList;

public interface OrderDetailService extends IMppService<OrderDetail> {
    public Boolean addOrderDetail(OrderDetail orderDetail);
    public Boolean addOrderDetailList(ArrayList<OrderDetail> orderDetailArrayList);
    public ArrayList<OrderDetail> getOrderDetailList(Long order_UUID);
}
