package com.coopgroup.pensionsystem.Controller;

import com.coopgroup.pensionsystem.Pojo.Activity;
import com.coopgroup.pensionsystem.Pojo.ActivityComment;
import com.coopgroup.pensionsystem.Service.ActivityAttentionService;
import com.coopgroup.pensionsystem.Service.ActivityCommentService;
import com.coopgroup.pensionsystem.Service.ActivityFavouriteService;
import com.coopgroup.pensionsystem.Service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ActivityRestController {
    @Autowired
    private ActivityService activityService;
    @Autowired
    private ActivityCommentService activityCommentService;
    @Autowired
    private ActivityFavouriteService activityFavouriteService;
    @Autowired
    private ActivityAttentionService activityAttentionService;
    @RequestMapping(value = "/activity",method = RequestMethod.POST)
    public void addActivity(Activity activity){
        activity.setStatus("招募中");
        activityService.addActivity(activity);
    }
    @RequestMapping(value = "/activity",method = RequestMethod.PUT)
    public void updateActivity(Activity activity){
        activityService.updateActivity(activity);
    }
    @RequestMapping(value = "/activity",method = RequestMethod.DELETE)
    public void deleteActivity(@RequestParam Long UUID){
        activityService.deleteActivity(UUID);
    }
    @RequestMapping(value = "/activity",method = RequestMethod.PATCH)
    public void alterStatus(@RequestParam Long UUID,@RequestParam String status){
        activityService.activityAlterStatus(UUID, status);
    }
    @RequestMapping(value = "/activities",method = RequestMethod.DELETE)
    public void deleteActivities(@RequestBody ArrayList<Long> UUIDList){
        activityService.deleteActivity(UUIDList);
    }
    @RequestMapping(value="/activity/comment",method = RequestMethod.POST)
    public void addActivityComment(ActivityComment activityComment){
        activityCommentService.addActivityComment(activityComment);
    }
    @RequestMapping(value = "/activity/comment",method = RequestMethod.PUT)
    public void addActivityReplyComment(@RequestParam Long UUID,@RequestParam String Content){
        activityCommentService.addActivityReplyComment(UUID,Content);
    }
    @RequestMapping(value="activity/comment",method = RequestMethod.DELETE)
    public void deleteActivityComment(@RequestParam Long UUID){
        activityCommentService.deleteActivityComment(UUID);
    }
    @RequestMapping(value = "/activity/favourite",method = RequestMethod.PUT)
    public void alterActivityFavouriteStatus(@RequestParam Long activity_UUID,@RequestParam Long Elder_UUID){
        activityFavouriteService.alterStatus(activity_UUID, Elder_UUID);
    }
    @RequestMapping(value = "/activity/attention",method = RequestMethod.POST)
    public void addActivityAttention(@RequestParam Long activity_UUID,@RequestParam Long Elder_UUID){
        activityAttentionService.activityAttentionAdd(activity_UUID, Elder_UUID);
    }
    @RequestMapping(value = "/activity/attention",method = RequestMethod.DELETE)
    public void deleteActivityAttention(@RequestParam Long activity_UUID,@RequestParam Long Elder_UUID){
        activityAttentionService.activityAttentionDelete(activity_UUID, Elder_UUID);
    }
}
