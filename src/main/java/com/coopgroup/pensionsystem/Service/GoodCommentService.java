package com.coopgroup.pensionsystem.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.coopgroup.pensionsystem.Pojo.ElderComment;
import com.coopgroup.pensionsystem.Pojo.GoodComment;

import java.util.ArrayList;

public interface GoodCommentService extends IService<GoodComment> {
    public Boolean addGoodComment(GoodComment GoodComment);
    public Boolean addGoodReplyComment(Long UUID,String content);
    public Boolean deleteGoodComment(Long UUID);
    public ArrayList<GoodComment> getCommentList(Long Good_UUID);
}
