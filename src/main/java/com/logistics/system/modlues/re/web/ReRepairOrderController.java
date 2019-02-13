package com.logistics.system.modlues.re.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.logistics.system.modlues.re.entity.ReRepairOrder;
import com.logistics.system.modlues.re.entity.ReRepairOrderType;
import com.logistics.system.modlues.re.service.ReRepairOrderService;
import com.logistics.system.modlues.re.service.ReRepairOrderTypeService;
import com.logistics.system.modlues.sys.entity.SysUser;
import com.logistics.system.modlues.sys.service.SysDepartmentService;

@Controller
@RequestMapping("/a/reRepairOrder")
public class ReRepairOrderController {
	
	@Autowired
	ReRepairOrderService reRepairOrderService;
	
	@Autowired
	ReRepairOrderTypeService reRepairOrderTypeService;
	
	@RequestMapping("/save.do")
	public String save(Model model,ReRepairOrder reRepairOrder){
		
		if (reRepairOrder !=null && reRepairOrder.getDelFlag().equals("0")) {
			reRepairOrderService.save(reRepairOrder);
			String msg = "添加成功!";
			model.addAttribute("msg", msg);
		}
		List<ReRepairOrderType> reRepairOrderTypes = reRepairOrderTypeService.findList(new ReRepairOrderType());
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		model.addAttribute("reRepairOrderTypes", reRepairOrderTypes);
		return "moudlues/re/reRepairOrder_add";
		
	}
	


	@RequestMapping("/del.do")
	@ResponseBody
	public String del(Model model,ReRepairOrder reRepairOrder){
		reRepairOrderService.delete(reRepairOrder);
		  return "删除成功";
		
	}
	
	@RequestMapping("/list.do")
	public String list(Model model,ReRepairOrder reRepairOrder){
		List<ReRepairOrder> reRepairOrders = reRepairOrderService.findList(reRepairOrder);
		model.addAttribute("reRepairOrders", reRepairOrders);
		return "moudlues/re/reRepairOrder_list";
	}
	
	@RequestMapping("/update.do")
	public String update(Model model,ReRepairOrder reRepairOrder){
		if (reRepairOrder !=null && reRepairOrder.getDelFlag().equals("0")) {
			reRepairOrderService.update(reRepairOrder);
			String msg = "修改成功!";
			model.addAttribute("msg", msg);
			return "moudlues/nt/reRepairOrder_update";
		}
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		return "moudlues/re/reRepairOrder_update";
		
	}
	@RequestMapping("/show.do")
	public String show(Model model,ReRepairOrder reRepairOrder){
	   ReRepairOrder reRepairOrder2 = reRepairOrderService.get(reRepairOrder);
	   model.addAttribute("reRepairOrder", reRepairOrder2);
		return "moudlues/re/reRepairOrder_show";
		
	}

}
