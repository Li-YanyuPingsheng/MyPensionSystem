package com.coopgroup.pensionsystem.Controller;

import com.coopgroup.pensionsystem.Pojo.*;
import com.coopgroup.pensionsystem.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class TradeRestController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private GoodCommentService goodCommentService;
    @Autowired
    private GoodService goodService;
    @Autowired
    private GoodFavouriteService goodFavouriteService;
    @Autowired
    private GoodLikeService goodLikeService;
    @Autowired
    private CartService cartService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailService orderDetailService;
    @RequestMapping(value = "/good/category",method = RequestMethod.POST)
    public void addCategory(Category category){
        categoryService.addCategory(category);
    }
    @RequestMapping(value = "/good/category",method = RequestMethod.PUT)
    public void updateCategory(Category category){
        categoryService.updateCategory(category);
    }
    @RequestMapping(value = "/good/category",method = RequestMethod.DELETE)
    public void deleteCategory(@RequestParam Long UUID){
        categoryService.deleteCategory(UUID);
    }
    @RequestMapping(value = "/good/comment",method = RequestMethod.POST)
    public void addGoodComment(GoodComment goodComment){
        goodCommentService.addGoodComment(goodComment);
    }
    @RequestMapping(value = "/good/comment",method = RequestMethod.PUT)
    public void replyGoodComment(@RequestParam Long UUID,@RequestParam String content){
        goodCommentService.addGoodReplyComment(UUID, content);
    }
    @RequestMapping(value = "/good/comment",method = RequestMethod.DELETE)
    public void deleteGoodComment(@RequestParam Long UUID){
        goodCommentService.deleteGoodComment(UUID);
    }
    @RequestMapping(value = "/good",method = RequestMethod.POST)
    public void addGood(Good good){
        goodService.addGood(good);
    }
    @RequestMapping(value = "/good",method = RequestMethod.PUT)
    public void updateGood(Good good){
        goodService.updateGood(good);
    }
    @RequestMapping(value = "/good",method = RequestMethod.DELETE)
    public void deleteGood(@RequestParam Long UUID){
        goodService.deleteGood(UUID);
    }
    @RequestMapping(value = "/good/favourite",method = RequestMethod.POST)
    public void alterGoodFavouriteStatus(@RequestParam Long Good_UUID,@RequestParam Long Elder_UUID){
        goodFavouriteService.alterStatus(Good_UUID, Elder_UUID);
    }
    @RequestMapping(value = "/good/like",method = RequestMethod.POST)
    public void alterGoodLikeStatus(@RequestParam Long Good_UUID,@RequestParam Long Elder_UUID){
        goodLikeService.alterStatus(Good_UUID, Elder_UUID);
    }
    @RequestMapping(value = "/cart",method = RequestMethod.POST)
    public void addCartItem(@RequestParam Long Elder_UUID,@RequestParam Long Good_UUID){
        cartService.cartAddItem(Elder_UUID, Good_UUID);
    }
    @RequestMapping(value = "/cart",method = RequestMethod.PUT)
    public void removeCartItem(@RequestParam Long Elder_UUID,@RequestParam Long Good_UUID){
        cartService.cartRemoveItem(Elder_UUID, Good_UUID);
    }
    @RequestMapping(value = "/cart",method = RequestMethod.DELETE)
    public void emptyCart(@RequestParam Long Elder_UUID){
        cartService.emptyCart(Elder_UUID);
    }
    @RequestMapping(value = "/order",method = RequestMethod.POST)
    public void addOrder(Order order, @RequestBody ArrayList<OrderDetail> orderDetailArrayList){
        order.setStatus("等待发货");
        orderService.addOrder(order);
        orderDetailArrayList.forEach(e->{
            e.setOrderUUID(order.getUUID());
        });
        orderDetailService.addOrderDetailList(orderDetailArrayList);
    }
    @RequestMapping(value = "/order",method = RequestMethod.PUT)
    public void alterOrderStatus(@RequestParam Long UUID,@RequestParam String status){
        orderService.updateOrder(UUID, status);
    }
}
