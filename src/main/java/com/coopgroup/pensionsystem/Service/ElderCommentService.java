package com.coopgroup.pensionsystem.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.coopgroup.pensionsystem.Pojo.ActivityComment;
import com.coopgroup.pensionsystem.Pojo.ElderComment;

import java.util.ArrayList;

public interface ElderCommentService extends IService<ElderComment> {
    public Boolean addElderComment(ElderComment ElderComment);
    public Boolean addElderReplyComment(Long UUID,String content);
    public Boolean deleteElderComment(Long UUID);
    public ArrayList<ElderComment> getCommentList();
}
