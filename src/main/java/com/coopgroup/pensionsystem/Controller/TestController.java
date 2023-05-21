package com.coopgroup.pensionsystem.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;

@Controller
public class TestController {
    @RequestMapping(value="/test",method = RequestMethod.GET)
    public String getTest(){
        return "Test";
    }
    @RequestMapping(value = "/test/ajax",method = RequestMethod.PUT)
    public void getStatusTest(HttpServletResponse response){
        response.setStatus(401);
    }
}
