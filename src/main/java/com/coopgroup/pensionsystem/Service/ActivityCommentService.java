package com.coopgroup.pensionsystem.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.coopgroup.pensionsystem.Pojo.ActivityComment;

import java.util.ArrayList;

public interface ActivityCommentService extends IService<ActivityComment> {
    public Boolean addActivityComment(ActivityComment activityComment);
    public Boolean addActivityReplyComment(Long UUID,String content);
    public Boolean deleteActivityComment(Long UUID);
    public ArrayList<ActivityComment> getCommentList(Long activity_UUID);
}
