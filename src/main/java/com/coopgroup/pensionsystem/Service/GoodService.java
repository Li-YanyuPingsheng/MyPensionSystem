package com.coopgroup.pensionsystem.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.coopgroup.pensionsystem.Pojo.Good;
import com.coopgroup.pensionsystem.Pojo.User;

import java.util.HashMap;

public interface GoodService extends IService<Good> {
    public Boolean addGood(Good good);
    public Boolean updateGood(Good good);
    public Boolean deleteGood(Long UUID);
    public HashMap<Long,Good> getGoodHashMap();
    public HashMap<Long,Good> getGoodHashMapByMerchant(Long merchant_UUID);
    public HashMap<Long,Good> getGoodHashMapByCategory(Long category_UUID);
}
