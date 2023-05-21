package com.coopgroup.pensionsystem.Pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
@TableName("agent_service")
public class AgentOrder {
    @JsonSerialize(using=ToStringSerializer.class)
    @TableId(value = "UUID",type = IdType.ASSIGN_ID)
    private Long UUID;
    @JsonSerialize(using= ToStringSerializer.class)
    @TableField("Elder_UUID")
    private Long elder_UUID;
    @TableField("Content")
    private String content;
    @TableField("Status")
    private String status;
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalDateTime create_time;
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime update_time;
}
