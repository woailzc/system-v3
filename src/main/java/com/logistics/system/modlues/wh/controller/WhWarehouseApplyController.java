package com.logistics.system.modlues.wh.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.logistics.system.modlues.sys.entity.SysUser;
import com.logistics.system.modlues.wh.entity.WhWarehouse;
import com.logistics.system.modlues.wh.entity.WhWarehouseApply;
import com.logistics.system.modlues.wh.service.WhWarehouseApplyService;
import com.logistics.system.modlues.wh.service.WhWarehouseService;

@Controller
@RequestMapping("/a/whWarehouseApply")
public class WhWarehouseApplyController {
	
	@Autowired
	WhWarehouseApplyService whWarehouseApplyService;
	@Autowired
	WhWarehouseService whWarehouseService;
	
	@RequestMapping("/save.do")
	public String save(Model model,WhWarehouseApply whWarehouseApply){
		
		if (whWarehouseApply !=null && whWarehouseApply.getDelFlag().equals("0")) {
			whWarehouseApplyService.save(whWarehouseApply);
			String msg = "申请成功，等待审核!";
			model.addAttribute("msg", msg);
			return "moudlues/wh/whWarehouseApply_add";
		}
		WhWarehouse whWarehouse = new WhWarehouse();
		whWarehouse.setStatus("空闲");
		List<WhWarehouse> whWarehouses = whWarehouseService.findList(whWarehouse);
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		model.addAttribute("whWarehouses", whWarehouses);
		return "moudlues/wh/whWarehouseApply_add";
		
	}
	


	@RequestMapping("/del.do")
	@ResponseBody
	public Object del(Model model,WhWarehouseApply warehouseApply){
		whWarehouseApplyService.delete(warehouseApply);
		 HashMap<String, Object> data = new HashMap<>();
		   data.put("del","删除成功" );
			return data;
		
	}
	
	@RequestMapping("/list.do")
	public String list(Model model,WhWarehouseApply whWarehouseApply){
		List<WhWarehouseApply> whWarehouseApplys = whWarehouseApplyService.findList(whWarehouseApply);
		model.addAttribute("whWarehouseApplys", whWarehouseApplys);
		return "moudlues/wh/whWarehouseApply_list";
	}
	
	@RequestMapping("/update.do")
	public String update(Model model,WhWarehouseApply whWarehouseApply){
		if (whWarehouseApply !=null && whWarehouseApply.getDelFlag().equals("0")) {
			whWarehouseApplyService.update(whWarehouseApply);
			String msg = "修改成功!";
			model.addAttribute("msg", msg);
			return "moudlues/wh/whWarehouseApply_update";
		}
		model.addAttribute("whWarehouseApply",whWarehouseApplyService.get(whWarehouseApply.getId()));
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		return "moudlues/wh/whWarehouseApply_update";
		
	}
	@RequestMapping("/show.do")
	public String show(Model model,WhWarehouseApply whWarehouseApply){
	   WhWarehouseApply whWarehouseApply2 = whWarehouseApplyService.get(whWarehouseApply);
	   model.addAttribute("whWarehouseApply", whWarehouseApply2);
		return "moudlues/wh/whWarehouseApply_show";
		
	}

}
