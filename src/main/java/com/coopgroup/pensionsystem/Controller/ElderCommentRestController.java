package com.coopgroup.pensionsystem.Controller;

import com.coopgroup.pensionsystem.Pojo.ElderComment;
import com.coopgroup.pensionsystem.Service.ElderCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ElderCommentRestController {
    @Autowired
    private ElderCommentService elderCommentService;
    @RequestMapping(value = "/comment",method = RequestMethod.POST)
    public void addComment(ElderComment elderComment){
        elderCommentService.addElderComment(elderComment);
    }
    @RequestMapping(value ="/comment",method = RequestMethod.PUT)
    public void addReply(@RequestParam Long UUID, @RequestParam String content){
        elderCommentService.addElderReplyComment(UUID, content);
    }
}
