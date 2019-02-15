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
import com.logistics.system.modlues.ctn.service.CtnFoodService;
import com.logistics.system.modlues.ctn.service.CtnFoodTypeService;
import com.logistics.system.modlues.sys.entity.SysUser;
import com.logistics.system.modlues.sys.service.SysDepartmentService;

@Controller
@RequestMapping("/a/ctnFood")
public class CtnFoodController {
	
	@Autowired
	CtnFoodService ctnFoodService;
	
	@Autowired
	CtnFoodTypeService ctnFoodTypeService;
	
	@RequestMapping("/save.do")
	public String save(Model model,CtnFood ctnFood){
		
		if (ctnFood !=null && ctnFood.getDelFlag().equals("0")) {
			ctnFoodService.save(ctnFood);
			String msg = "添加成功!";
			model.addAttribute("msg", msg);
		}
		List<CtnFoodType> ctnFoodTypes = ctnFoodTypeService.findList(new CtnFoodType());
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		model.addAttribute("ctnFoodTypes", ctnFoodTypes);
		return "moudlues/ctn/ctnFood_add";
		
	}
	


	@RequestMapping("/del.do")
	@ResponseBody
	public String del(Model model,CtnFood ctnFood){
		ctnFoodService.delete(ctnFood);
		  return "删除成功";
		
	}
	
	@RequestMapping("/list.do")
	public String list(Model model,CtnFood ctnFood){
		List<CtnFood> ctnFoods = ctnFoodService.findList(ctnFood);
		model.addAttribute("ctnFoods", ctnFoods);
		return "moudlues/ctn/ctnFood_list";
	}
	
	@RequestMapping("/update.do")
	public String update(Model model,CtnFood ctnFood){
		if (ctnFood !=null && ctnFood.getDelFlag().equals("0")) {
			ctnFoodService.update(ctnFood);
			String msg = "修改成功!";
			model.addAttribute("msg", msg);
			return "moudlues/ctn/ctnFood_update";
		}
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		return "moudlues/ctn/ctnFood_update";
		
	}
	@RequestMapping("/show.do")
	public String show(Model model,CtnFood ctnFood){
	   CtnFood ctnFood2 = ctnFoodService.get(ctnFood);
	   model.addAttribute("ctnFood", ctnFood2);
		return "moudlues/ctn/ctnFood_show";
		
	}

}
