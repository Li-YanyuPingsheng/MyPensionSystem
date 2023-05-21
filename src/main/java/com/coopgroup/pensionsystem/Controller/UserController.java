package com.coopgroup.pensionsystem.Controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.coopgroup.pensionsystem.Pojo.User;
import com.coopgroup.pensionsystem.Service.UserService;
import org.apache.tomcat.util.descriptor.web.MessageDestinationRef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author LiMingYu
 * @Create 2023-05-16 22:56
 * @Description 功能描述
 */
@Transactional
@Controller
@RequestMapping("/admin")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = {"/", ""})
    public String login() {
        return "admin/login";
    }

    @GetMapping("/index")
    public String index() {
        return "admin/index";
    }

    //后台退出
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("User");
        return "admin/login";
    }

    @GetMapping("/grInfo")
    public String personInfo() {
        return "admin/grinfo";
    }

    //个人信息更新
    @PostMapping("/updateGrinfo")
    public String updateInfo(HttpServletRequest request) {
        User user1 = (User) request.getSession().getAttribute("User");
        String phone = request.getParameter("phone");
        String name = request.getParameter("name");

        User user = new User();
        user.setUsername(user1.getUsername());
        user.setName(name);
        user.setPhone(phone);
        user.setRole(user1.getRole());
        user.setUUID(user1.getUUID());
        user.setPassword(user1.getPassword());

        Boolean aBoolean = userService.updateUser(user);
        if (aBoolean) {
            request.getSession().setAttribute("User", user);
        }
        return "redirect:/admin/grInfo";
    }

    /**
     * 跳转更改密码
     *
     * @return
     */
    @GetMapping("/getUpdatePassword")
    public String getUpdatePassword() {
        return "admin/updatepwd";
    }


    /**
     * 跳转添加用户页面
     *
     * @return
     */
    @GetMapping("/useradd")
    public String toAddUser() {
        return "admin/useradd";
    }

    /**
     * 用户信息展示
     *
     * @return
     */
    @GetMapping("/userList")
    public String userList(Model model) {
        List<User> list = userService.list();
        model.addAttribute("list", list);
        return "admin/userlist";
    }

    @PostMapping("/searchUser")
    public String userListSearch(@RequestParam(value = "key", defaultValue = "") String key,
                                 Model model) {
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (!key.equals("")) {
            userLambdaQueryWrapper.like(User::getUsername, key).or().eq(User::getName, key);
        }
        List<User> list = userService.list(userLambdaQueryWrapper);
        model.addAttribute("list", list);
        return "admin/userlist";
    }


    @GetMapping("/edituser")
    public String editUser(@RequestParam("id") Long UUID, Model model) {
        User byId = userService.getById(UUID);
        model.addAttribute("user", byId);
        return "admin/useredit";
    }

    @PostMapping("/userEdit")
    public String userEdit(User user) {
        userService.updateUser(user);
        return "redirect:/admin/userList";
    }

    @PostMapping("/userAdd")
    public String useradd(User user) {
        user.setRole("admin");
        userService.save(user);
        return "redirect:/admin/userList";
    }

    @GetMapping("/elderadd")
    public String toElderAdd() {
        return "admin/elderadd";
    }

    @PostMapping("/elderadd")
    public String elderAdd(User user, HttpServletRequest request){
        String location = request.getParameter("location");

        return "redirect:/admin/userList";
    }


}
