package com.logistics.system.modlues.ctn.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.logistics.system.modlues.ctn.entity.CtnFood;
import com.logistics.system.modlues.ctn.entity.CtnFoodType;
import com.logistics.system.modlues.ctn.entity.CtnMenu;
import com.logistics.system.modlues.ctn.service.CtnFoodService;
import com.logistics.system.modlues.ctn.service.CtnFoodTypeService;
import com.logistics.system.modlues.ctn.service.CtnMenuService;
import com.logistics.system.modlues.sys.entity.SysUser;
import com.logistics.system.modlues.sys.service.SysDepartmentService;

@Controller
@RequestMapping("/a/ctnMenu")
public class CtnMenuController {
	
	@Autowired
	CtnMenuService ctnMenuService;
	
	@RequestMapping("/save.do")
	public String save(Model model,CtnMenu ctnMenu){
		
		if (ctnMenu !=null && ctnMenu.getDelFlag().equals("0")) {
			ctnMenuService.save(ctnMenu);
			String msg = "添加成功!";
			model.addAttribute("msg", msg);
		}
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		return "moudlues/ctn/ctnMenu_add";
		
	}
	


	@RequestMapping("/del.do")
	@ResponseBody
	public String del(Model model,CtnMenu ctnMenu){
		ctnMenuService.delete(ctnMenu);
		  return "删除成功";
		
	}
	
	@RequestMapping("/list.do")
	public String list(Model model,CtnMenu ctnMenu){
		List<CtnMenu> ctnMenus = ctnMenuService.findList(ctnMenu);
		model.addAttribute("ctnMenus", ctnMenus);
		return "moudlues/ctn/ctnMenu_list";
	}
	
	@RequestMapping("/update.do")
	public String update(Model model,CtnMenu ctnMenu){
		if (ctnMenu !=null && ctnMenu.getDelFlag().equals("0")) {
			ctnMenuService.update(ctnMenu);
			String msg = "修改成功!";
			model.addAttribute("msg", msg);
			return "moudlues/ctn/ctnMenu_update";
		}
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		return "moudlues/ctn/ctnMenu_update";
		
	}
	@RequestMapping("/show.do")
	public String show(Model model,CtnMenu ctnMenu){
	   CtnMenu ctnMenu2 = ctnMenuService.get(ctnMenu);
	   model.addAttribute("ctnMenu", ctnMenu2);
		return "moudlues/ctn/ctnMenu_show";
		
	}

}