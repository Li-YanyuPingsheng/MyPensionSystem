package com.coopgroup.pensionsystem.Controller;


import com.coopgroup.pensionsystem.Pojo.DeliveryAddress;
import com.coopgroup.pensionsystem.Pojo.Elder;
import com.coopgroup.pensionsystem.Pojo.Merchant;
import com.coopgroup.pensionsystem.Pojo.User;
import com.coopgroup.pensionsystem.Service.DeliveryAddressService;
import com.coopgroup.pensionsystem.Service.ElderService;
import com.coopgroup.pensionsystem.Service.MerchantService;
import com.coopgroup.pensionsystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class UserRestController {
    @Autowired
    private UserService userService;
    @Autowired
    private ElderService elderService;
    @Autowired
    private MerchantService merchantService;
    @Autowired
    private DeliveryAddressService deliveryAddressService;

    /**
     * 登录接口需要通过状态响应码来输出响应的信息
     * 其中 404 账号不存在 405 密码错误
     * 200表示登录成功
     * 注册更新信息的未做状态码的修改 只有成功与失败两种状态
     * 对于状态码等尝试使用的应用 在Test.html中可以参考
     * */
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public void Login(User user, HttpServletResponse response, HttpSession session) {
        HashMap<Integer,User> userHashMap=userService.getLoginInfo(user);
        if(userHashMap.containsKey(200))
        {
            response.setStatus(200);
            session.setAttribute("User", userHashMap.get(200));
        }
        if(userHashMap.containsKey(404))
        {
            response.setStatus(404);
        }
        if(userHashMap.containsKey(405))
        {
            response.setStatus(405);
        }
    }
    @RequestMapping(value = "/user/merchant",method = RequestMethod.POST)
    public void MerchantRegister(User user) {
        userService.save(user);
        merchantService.addMerchant(user.getUUID());
    }
    @RequestMapping(value = "/user/doctor",method = RequestMethod.POST)
    public void DoctorRegister(User user) {
        userService.save(user);
    }
    @RequestMapping(value = "/user/merchant",method=RequestMethod.PUT)
    public void MerchantUpdate(Merchant merchant){
        merchantService.updateMerchant(merchant);
    }
    @RequestMapping(value = "/user/username",method = RequestMethod.PUT)
    public void UpdateInfo(@RequestParam String username,@RequestParam String newUsername){
        userService.updateUsername(username,newUsername);
    }
    @RequestMapping(value = "/user/password",method = RequestMethod.PUT)
    public void updatePassword(@RequestParam String username, @RequestParam String password){
        userService.updatePassword(username,password);
    }
    @RequestMapping(value = "/users/elders",method = RequestMethod.POST)
    public void addList(@RequestBody ArrayList<Elder> elderArrayList){
        ArrayList<User> userArrayList=new ArrayList<>();
        elderArrayList.forEach(e->{
            User user=new User();
            user.setUsername(e.getID());
            user.setRole("elder");
            user.setPassword(e.getID().substring(e.getID().length()-6));
            userArrayList.add(user);
        });
        userService.addUserList(userArrayList);
        elderService.addElderList(userArrayList,elderArrayList);
    }
    @RequestMapping(value = "/users/elder",method = RequestMethod.POST)
    public void addElder(Elder elder){
        User user=new User();
        user.setUsername(elder.getID());
        user.setRole("elder");
        user.setPassword(elder.getID().substring(elder.getID().length()-6));
        userService.addUser(user);
        elderService.addElder(user,elder);
    }
    @RequestMapping(value = "/user/elder/deliverAddress",method = RequestMethod.POST)
    public void addDeliverAddress(DeliveryAddress deliveryAddress){
        deliveryAddressService.addDeliverAddress(deliveryAddress);
    }
    @RequestMapping(value = "/user/elder/deliverAddress",method = RequestMethod.PUT)
    public void updateDeliverAddress(@RequestParam Long UUID,@RequestParam String updateContent){
        deliveryAddressService.updateDeliverAddress(UUID, updateContent);
    }
    @RequestMapping(value = "/user/elder/deliverAddress",method = RequestMethod.DELETE)
    public void deleteDeliverAddress(@RequestParam Long UUID){
        deleteDeliverAddress(UUID);
    }


}
