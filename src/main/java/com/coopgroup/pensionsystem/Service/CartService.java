package com.coopgroup.pensionsystem.Service;

import com.coopgroup.pensionsystem.Pojo.Cart;
import com.github.jeffreyning.mybatisplus.service.IMppService;

import java.util.ArrayList;
import java.util.HashMap;

public interface CartService extends IMppService<Cart> {
    public Boolean cartAddItem(Long Elder_UUID,Long Good_UUID);
    public Boolean cartRemoveItem(Long Elder_UUID,Long Good_UUID);
    public Boolean emptyCart(Long Elder_UUID);
    public ArrayList<Cart> getCartMap(Long Elder_UUID);
}
