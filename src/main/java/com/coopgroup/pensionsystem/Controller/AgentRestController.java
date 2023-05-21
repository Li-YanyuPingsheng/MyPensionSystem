package com.coopgroup.pensionsystem.Controller;

import com.coopgroup.pensionsystem.Pojo.AgentOrder;
import com.coopgroup.pensionsystem.Service.AgentOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgentRestController {
    @Autowired
    private AgentOrderService agentOrderService;
    @RequestMapping(value = "/agent",method = RequestMethod.POST)
    public void addAgentOrder(AgentOrder agentOrder){
        agentOrder.setStatus("等待处理");
        agentOrderService.addAgentOrder(agentOrder);
    }
    @RequestMapping(value = "/agent",method = RequestMethod.PUT)
    public void alterAgentOrder(AgentOrder agentOrder){
        agentOrderService.alterAgentOrder(agentOrder);
    }
    @RequestMapping(value = "/agent",method = RequestMethod.DELETE)
    public void deleteAgentOrder(@RequestParam Long UUID){
        agentOrderService.deleteAgentOrder(UUID);
    }
    @RequestMapping(value = "/agent",method = RequestMethod.PATCH)
    public void alterStatus(@RequestParam Long UUID,@RequestParam String status){
        agentOrderService.alterAgentOrderStatus(UUID, status);
    }
}
