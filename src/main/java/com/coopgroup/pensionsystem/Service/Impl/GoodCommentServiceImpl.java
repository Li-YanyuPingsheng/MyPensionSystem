package com.coopgroup.pensionsystem.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coopgroup.pensionsystem.Mapper.GoodCommentMapper;
import com.coopgroup.pensionsystem.Pojo.ElderComment;
import com.coopgroup.pensionsystem.Pojo.GoodComment;
import com.coopgroup.pensionsystem.Service.GoodCommentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GoodCommentServiceImpl extends ServiceImpl<GoodCommentMapper, GoodComment> implements GoodCommentService {
    @Override
    public Boolean addGoodComment(GoodComment GoodComment) {
        Boolean valueReturn=this.saveOrUpdate(GoodComment);
        return valueReturn;
    }

    @Override
    public Boolean addGoodReplyComment(Long UUID, String content) {
        UpdateWrapper<GoodComment> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("UUID",UUID).set("ReplyContent",content);
        Boolean valueReturn=this.update(updateWrapper);
        return valueReturn;
    }

    @Override
    public Boolean deleteGoodComment(Long UUID) {
        Boolean valueReturn=this.removeById(UUID);
        return valueReturn;
    }

    @Override
    public ArrayList<GoodComment> getCommentList(Long Good_UUID) {
        QueryWrapper<GoodComment> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("Good_UUID",Good_UUID).orderByAsc("update_time");
        ArrayList<GoodComment> goodCommentArrayList= (ArrayList<GoodComment>) this.list(queryWrapper);
        return goodCommentArrayList;
    }
}
