package com.coopgroup.pensionsystem.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coopgroup.pensionsystem.Mapper.AgentOrderMapper;
import com.coopgroup.pensionsystem.Pojo.AgentOrder;
import com.coopgroup.pensionsystem.Service.AgentOrderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class AgentOrderServiceImpl extends ServiceImpl<AgentOrderMapper, AgentOrder> implements AgentOrderService {
    @Override
    public Boolean addAgentOrder(AgentOrder agentOrder) {
        Boolean valueReturn=false;
        valueReturn=this.saveOrUpdate(agentOrder);
        return valueReturn;
    }
    @Override
    public Boolean alterAgentOrder(AgentOrder agentOrder) {
        Boolean valueReturn=false;
        valueReturn=this.saveOrUpdate(agentOrder);
        return valueReturn;
    }

    @Override
    public Boolean alterAgentOrderStatus(Long UUID,String status) {
        UpdateWrapper<AgentOrder> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("UUID",UUID).set("Status",status);
        Boolean valueReturn=this.update(updateWrapper);
        return valueReturn;
    }

    @Override
    public Boolean deleteAgentOrder(Long UUID) {
        Boolean valueReturn=false;
        valueReturn=this.removeById(UUID);
        return valueReturn;
    }

    @Override
    public HashMap<Long, AgentOrder> getAgentOrderMap() {
        HashMap<Long,AgentOrder> agentOrderHashMap=new HashMap<>();
        QueryWrapper<AgentOrder> queryWrapper=new QueryWrapper<>();
        queryWrapper.orderByAsc("update_time");
        ArrayList<AgentOrder> agentOrderArrayList= (ArrayList<AgentOrder>) this.list(queryWrapper);
        agentOrderArrayList.forEach(e->{
            agentOrderHashMap.put(e.getUUID(),e);
        });
        return agentOrderHashMap;
    }

    @Override
    public HashMap<Long, AgentOrder> getAgentOrderMap(Long Elder_UUID) {
        HashMap<Long,AgentOrder> agentOrderHashMap=new HashMap<>();
        QueryWrapper<AgentOrder> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("Elder_UUID",Elder_UUID).orderByAsc("update_time");
        ArrayList<AgentOrder> agentOrderArrayList= (ArrayList<AgentOrder>) this.list(queryWrapper);
        agentOrderArrayList.forEach(e->{
            agentOrderHashMap.put(e.getUUID(),e);
        });
        return agentOrderHashMap;
    }

    @Override
    public ArrayList<AgentOrder> getAgentOrderList() {
        QueryWrapper<AgentOrder> queryWrapper=new QueryWrapper<>();
        queryWrapper.orderByAsc("update_time");
        ArrayList<AgentOrder> agentOrderArrayList= (ArrayList<AgentOrder>) this.list(queryWrapper);
        return agentOrderArrayList;
    }

    @Override
    public ArrayList<AgentOrder> getAgentOrderList(Long Elder_UUID) {
        QueryWrapper<AgentOrder> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("Elder_UUID",Elder_UUID).orderByAsc("update_time");
        ArrayList<AgentOrder> agentOrderArrayList= (ArrayList<AgentOrder>) this.list(queryWrapper);
        return agentOrderArrayList;
    }
}
