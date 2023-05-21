package com.coopgroup.pensionsystem.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.coopgroup.pensionsystem.Pojo.DeliveryAddress;

import java.util.HashMap;

public interface DeliveryAddressService extends IService<DeliveryAddress> {
    public Boolean addDeliverAddress(DeliveryAddress deliveryAddress);
    public Boolean updateDeliverAddress(Long UUID,String updateContent);
    public Boolean deleteDeliverAddress(Long UUID);
    public HashMap<Long ,DeliveryAddress> getDeliverAddress(Long Elder_UUID);
}
