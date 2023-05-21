package com.coopgroup.pensionsystem.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coopgroup.pensionsystem.Mapper.MerchantMapper;
import com.coopgroup.pensionsystem.Pojo.Merchant;
import com.coopgroup.pensionsystem.Service.MerchantService;
import org.springframework.stereotype.Service;

@Service
public class MerchantServiceImpl extends ServiceImpl<MerchantMapper, Merchant> implements MerchantService {
    @Override
    public Boolean addMerchant(Long accountID) {
        Merchant merchant=new Merchant();
        merchant.setUUID(accountID);
        merchant.setMerchantName("便民小店");
        Boolean valueReturn=this.saveOrUpdate(merchant);
        return valueReturn;
    }

    @Override
    public Boolean updateMerchant(Merchant merchant) {
        Boolean valueReturn=this.saveOrUpdate(merchant);
        return valueReturn;
    }
}
