package com.coopgroup.pensionsystem.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.coopgroup.pensionsystem.Pojo.Merchant;

public interface MerchantService extends IService<Merchant> {
    public Boolean addMerchant(Long accountID);
    public Boolean updateMerchant(Merchant merchant);
}
