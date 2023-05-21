package com.coopgroup.pensionsystem.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.coopgroup.pensionsystem.Pojo.AgentOrder;

import java.util.ArrayList;
import java.util.HashMap;

public interface AgentOrderService extends IService<AgentOrder> {
    public Boolean addAgentOrder(AgentOrder agentOrder);
    public Boolean alterAgentOrder(AgentOrder agentOrder);
    public Boolean deleteAgentOrder(Long UUID);
    public Boolean alterAgentOrderStatus(Long UUID,String status);
    public HashMap<Long,AgentOrder> getAgentOrderMap();
    public HashMap<Long,AgentOrder> getAgentOrderMap(Long Elder_UUID);
    public ArrayList<AgentOrder> getAgentOrderList();
    public ArrayList<AgentOrder> getAgentOrderList(Long Elder_UUID);
}
