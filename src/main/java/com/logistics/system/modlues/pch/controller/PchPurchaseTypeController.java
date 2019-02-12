package com.logistics.system.modlues.pch.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.logistics.system.modlues.ad.entity.AdAdviceType;
import com.logistics.system.modlues.ad.service.AdAdviceTypeService;
import com.logistics.system.modlues.pch.entity.PchPurchaseType;
import com.logistics.system.modlues.pch.service.PchPurchaseTypeService;
import com.logistics.system.modlues.sys.entity.SysDepartment;
import com.logistics.system.modlues.sys.entity.SysUser;
import com.logistics.system.modlues.sys.service.SysDepartmentService;

@Controller
@RequestMapping("/a/pchPurchaseType")
public class PchPurchaseTypeController {
	
	@Autowired
	PchPurchaseTypeService pchPurchaseTypeService;
	
	@RequestMapping("/save.do")
	public String save(Model model,PchPurchaseType pchPurchaseType){
		
		if (pchPurchaseType !=null && pchPurchaseType.getDelFlag().equals("0")) {
			pchPurchaseTypeService.save(pchPurchaseType);
			String msg = "添加成功!";
			model.addAttribute("msg", msg);
		}
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		return "moudlues/pch/pchPurchaseType_add";
		
	}
	
	@RequestMapping("/del.do")
	@ResponseBody
	public String del(Model model,PchPurchaseType pchPurchaseType){
		pchPurchaseTypeService.delete(pchPurchaseType);
		  return "删除成功";
		
	}
	
	@RequestMapping("/list.do")
	public String list(Model model,PchPurchaseType pchPurchaseType){
		List<PchPurchaseType> pchPurchaseTypes = pchPurchaseTypeService.findList(pchPurchaseType);
		model.addAttribute("pchPurchaseTypes", pchPurchaseTypes);
		return "moudlues/pch/pchPurchaseType_list";
	}
	
	@RequestMapping("/update.do")
	public String update(Model model,PchPurchaseType pchPurchaseType){
		if (pchPurchaseType !=null && pchPurchaseType.getDelFlag().equals("0")) {
			pchPurchaseTypeService.update(pchPurchaseType);
			String msg = "修改成功!";
			model.addAttribute("msg", msg);
			return "moudlues/pch/pchPurchaseType_update";
		}
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		return "moudlues/pch/pchPurchaseType_update";
		
	}
	//信息太少，暂时没有需求
	@RequestMapping("/show.do")
	public String show(Model model,PchPurchaseType pchPurchaseType){
	
		return null;
		
	}

}
