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
import com.logistics.system.modlues.wh.entity.WhWarehouseType;
import com.logistics.system.modlues.wh.service.WhWarehouseTypeService;

@Controller
@RequestMapping("/a/whWarehouseType")
public class WhWarehouseTypeController {
	
	@Autowired
	WhWarehouseTypeService whWarehouseTypeService;
	
	@RequestMapping("/save.do")
	public String save(Model model,WhWarehouseType whWarehouseType){
		
		if (whWarehouseType !=null && whWarehouseType.getDelFlag().equals("0")) {
			whWarehouseTypeService.save(whWarehouseType);
			String msg = "添加成功!";
			model.addAttribute("msg", msg);
		}
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		return "moudlues/wh/whWarehouseType_add";
		
	}
	
	@RequestMapping("/del.do")
	@ResponseBody
	public Object del(Model model,WhWarehouseType whWarehouseType){
		whWarehouseTypeService.delete(whWarehouseType);
		HashMap<String,Object> hashMap = new HashMap<>();
		hashMap.put("del", "删除成功");
	    return hashMap;
		
	}
	
	@RequestMapping("/list.do")
	public String list(Model model,WhWarehouseType whWarehouseType){
		List<WhWarehouseType> whWarehouseTypes = whWarehouseTypeService.findList(whWarehouseType);
		model.addAttribute("whWarehouseTypes", whWarehouseTypes);
		return "moudlues/wh/whWarehouseType_list";
	}
	
	@RequestMapping("/update.do")
	public String update(Model model,WhWarehouseType whWarehouseType){
		if (whWarehouseType !=null && whWarehouseType.getDelFlag().equals("0")) {
			whWarehouseTypeService.update(whWarehouseType);
			String msg = "修改成功!";
			model.addAttribute("msg", msg);
			return "moudlues/ad/whWarehouseType_update";
		}
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		return "moudlues/wh/whWarehouseType_update";
		
	}
	//信息太少，暂时没有需求
	@RequestMapping("/show.do")
	public String show(Model model,WhWarehouseType whWarehouseType){
	
		return null;
		
	}

}
