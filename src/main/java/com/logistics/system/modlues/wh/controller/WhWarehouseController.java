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
import com.logistics.system.modlues.wh.entity.WhWarehouseType;
import com.logistics.system.modlues.wh.service.WhWarehouseService;
import com.logistics.system.modlues.wh.service.WhWarehouseTypeService;

@Controller
@RequestMapping("/a/whWarehouse")
public class WhWarehouseController {
	
	@Autowired
	WhWarehouseService whWarehouseService;
	
	@Autowired
	WhWarehouseTypeService whWarehouseTypeService;
	
	@RequestMapping("/save.do")
	public String save(Model model,WhWarehouse whWarehouse){
		
		if (whWarehouse !=null && whWarehouse.getDelFlag().equals("0")) {
			whWarehouseService.save(whWarehouse);
			String msg = "添加成功!";
			model.addAttribute("msg", msg);
		}
		List<WhWarehouseType> whWarehouseTypes = whWarehouseTypeService.findList(new WhWarehouseType());
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		model.addAttribute("whWarehouseTypes", whWarehouseTypes);
		return "moudlues/wh/whWarehouse_add";
		
	}
	


	@RequestMapping("/del.do")
	@ResponseBody
	public String del(Model model,WhWarehouse whWarehouse){
		whWarehouseService.delete(whWarehouse);
		  return "删除成功";
		
	}
	
	@RequestMapping("/list.do")
	public String list(Model model,WhWarehouse whWarehouse){
		List<WhWarehouse> whWarehouses = whWarehouseService.findList(whWarehouse);
		model.addAttribute("whWarehouses", whWarehouses);
		return "moudlues/wh/whWarehouse_list";
	}
	
	@RequestMapping("/update.do")
	public String update(Model model,WhWarehouse whWarehouse){
		if (whWarehouse !=null && whWarehouse.getDelFlag().equals("0")) {
			whWarehouseService.update(whWarehouse);
			String msg = "修改成功!";
			model.addAttribute("msg", msg);
			return "moudlues/wh/whWarehouse_update";
		}
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		return "moudlues/wh/whWarehouse_update";
		
	}
	@RequestMapping("/show.do")
	public String show(Model model,WhWarehouse whWarehouse){
	   WhWarehouse whWarehouse2 = whWarehouseService.get(whWarehouse);
	   model.addAttribute("WhWarehouse", whWarehouse2);
		return "moudlues/wh/whWarehouse_show";
		
	}

}
