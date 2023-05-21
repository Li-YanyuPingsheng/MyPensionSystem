package com.coopgroup.pensionsystem.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coopgroup.pensionsystem.Mapper.ElderCommentMapper;
import com.coopgroup.pensionsystem.Pojo.ActivityComment;
import com.coopgroup.pensionsystem.Pojo.Elder;
import com.coopgroup.pensionsystem.Pojo.ElderComment;
import com.coopgroup.pensionsystem.Service.ElderCommentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ElderCommentServiceImpl extends ServiceImpl<ElderCommentMapper, ElderComment> implements ElderCommentService {
    @Override
    public Boolean addElderComment(ElderComment elderComment) {
        Boolean valueReturn=this.saveOrUpdate(elderComment);
        return valueReturn;
    }
    @Override
    public Boolean addElderReplyComment(Long UUID, String content) {
        UpdateWrapper<ElderComment> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("UUID",UUID).set("ReplyContent",content);
        Boolean valueReturn=this.update(updateWrapper);
        return valueReturn;
    }

    @Override
    public Boolean deleteElderComment(Long UUID) {
        Boolean valueReturn=this.removeById(UUID);
        return valueReturn;
    }

    @Override
    public ArrayList<ElderComment> getCommentList() {
        ArrayList<ElderComment> elderCommentArrayList= (ArrayList<ElderComment>) this.list();
        return elderCommentArrayList;
    }
}
