package com.coopgroup.pensionsystem.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coopgroup.pensionsystem.Mapper.DeliveryAddressMapper;
import com.coopgroup.pensionsystem.Pojo.DeliveryAddress;
import com.coopgroup.pensionsystem.Service.DeliveryAddressService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class DeliveryAddressServiceImpl extends ServiceImpl<DeliveryAddressMapper, DeliveryAddress> implements DeliveryAddressService {
    @Override
    public Boolean addDeliverAddress(DeliveryAddress deliveryAddress) {
        Boolean valueReturn=false;
        valueReturn=this.saveOrUpdate(deliveryAddress);
        return valueReturn;
    }

    @Override
    public Boolean updateDeliverAddress(Long UUID, String updateContent) {
        Boolean valueReturn=false;
        UpdateWrapper<DeliveryAddress> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("UUID",UUID).set("Location",updateContent);
        valueReturn=this.update(updateWrapper);
        return valueReturn;
    }

    @Override
    public Boolean deleteDeliverAddress(Long UUID) {
        Boolean valueReturn=false;
        valueReturn=this.removeById(UUID);
        return valueReturn;
    }

    @Override
    public HashMap<Long, DeliveryAddress> getDeliverAddress(Long Elder_UUID) {
        HashMap<Long,DeliveryAddress> deliveryAddressHashMap=new HashMap<>();
        QueryWrapper<DeliveryAddress> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("Elder_UUID",Elder_UUID);
        ArrayList<DeliveryAddress> deliveryAddressArrayList= (ArrayList<DeliveryAddress>) this.list(queryWrapper);
        deliveryAddressArrayList.forEach(e->{
            deliveryAddressHashMap.put(e.getUUID(),e);
        });
        return deliveryAddressHashMap;
    }
}
