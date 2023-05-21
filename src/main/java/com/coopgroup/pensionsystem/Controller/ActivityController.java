package com.coopgroup.pensionsystem.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author LiMingYu
 * @Create 2023-05-18 15:52
 * @Description 处理新闻相关controller
 */
@Controller
@RequestMapping("/news")
public class ActivityController {
    /**
     * 跳转到新闻管理页面
     * @return
     */
    @GetMapping("/newsList")
    public String toNewsList()
    {

        return "admin/newslist";
    }

    /**
     * 跳转新闻添加页面
     * @return
     */
    @GetMapping("newsadd")
    public String toNewsAdd()
    {
        return "admin/newsadd";
    }

    /**
     * 删除所选新闻
     * @param request
     */
    @DeleteMapping("newsDelAll")
    public void newsDelAll(HttpServletRequest request)
    {
        String vals = request.getParameter("vals");
        String[] val = vals.split(",");

    }
}
