package com.coopgroup.pensionsystem.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.coopgroup.pensionsystem.Mapper.CartMapper;
import com.coopgroup.pensionsystem.Pojo.Cart;
import com.coopgroup.pensionsystem.Service.CartService;
import com.github.jeffreyning.mybatisplus.service.MppServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class CartServiceImpl extends MppServiceImpl<CartMapper, Cart> implements CartService {
    private Cart isExist(Long Elder_UUID,Long Good_UUID){
        QueryWrapper<Cart> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("Elder_UUID",Elder_UUID).eq("Good_UUID",Good_UUID);
        Cart cart=this.getOne(queryWrapper);
        return cart;
    }
    @Override
    public Boolean cartAddItem(Long Elder_UUID,Long Good_UUID) {
        Boolean valueReturn=false;
        Cart cartUpdate=isExist(Elder_UUID,Good_UUID);
        if(cartUpdate==null)
        {
            Cart cart=new Cart();
            cart.setQuantity(1);
            cart.setGoodUUID(Good_UUID);
            cart.setElderUUID(Elder_UUID);
            valueReturn=this.saveOrUpdate(cart);
        }
        else {
            cartUpdate.setQuantity(cartUpdate.getQuantity()+1);
            valueReturn=this.saveOrUpdate(cartUpdate);
        }
        return valueReturn;
    }

    @Override
    public Boolean cartRemoveItem(Long Elder_UUID,Long Good_UUID) {
        Boolean valueReturn=false;
        Cart cartUpdate=isExist(Elder_UUID,Good_UUID);
        if(cartUpdate.getQuantity()-1!=0){
            cartUpdate.setQuantity(cartUpdate.getQuantity()-1);
            valueReturn=this.saveOrUpdate(cartUpdate);
        }
        else {
            this.deleteByMultiId(cartUpdate);
        }
        return valueReturn;
    }

    @Override
    public Boolean emptyCart(Long Elder_UUID) {
        QueryWrapper<Cart> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("Elder_UUID",Elder_UUID);
        Boolean valueReturn=this.remove(queryWrapper);
        return valueReturn;
    }

    @Override
    public ArrayList<Cart> getCartMap(Long Elder_UUID) {
        QueryWrapper<Cart> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("Elder_UUID",Elder_UUID);
        ArrayList<Cart> cartArrayList= (ArrayList<Cart>) this.list(queryWrapper);
        return cartArrayList;
    }
}
