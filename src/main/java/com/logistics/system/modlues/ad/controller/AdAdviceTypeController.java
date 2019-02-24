package com.logistics.system.modlues.ad.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.logistics.system.modlues.ad.entity.AdAdviceType;
import com.logistics.system.modlues.ad.service.AdAdviceTypeService;
import com.logistics.system.modlues.sys.entity.SysDepartment;
import com.logistics.system.modlues.sys.entity.SysUser;
import com.logistics.system.modlues.sys.service.SysDepartmentService;

@Controller
@RequestMapping("/a/adAdviceType")
public class AdAdviceTypeController {
	
	@Autowired
	AdAdviceTypeService adAdviceTypeService;
	
	@RequestMapping("/save.do")
	public String save(Model model,AdAdviceType adAdviceType){
		
		if (adAdviceType !=null && adAdviceType.getDelFlag().equals("0")) {
			adAdviceTypeService.save(adAdviceType);
			String msg = "添加成功!";
			model.addAttribute("msg", msg);
		}
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		return "moudlues/ad/adAdviceType_add";
		
	}
	
	@RequestMapping("/del.do")
	@ResponseBody
	public Object del(Model model,AdAdviceType adAdviceType){
		adAdviceTypeService.delete(adAdviceType);
		HashMap<String,Object> hashMap = new HashMap<>();
		hashMap.put("del", "删除成功");
	    return hashMap;
		
	}
	
	@RequestMapping("/list.do")
	public String list(Model model,AdAdviceType adAdviceType){
		List<AdAdviceType> adAdviceTypes = adAdviceTypeService.findList(adAdviceType);
		model.addAttribute("adAdviceTypes", adAdviceTypes);
		return "moudlues/ad/adAdviceType_list";
	}
	
	@RequestMapping("/update.do")
	public String update(Model model,AdAdviceType adAdviceType){
		if (adAdviceType !=null && adAdviceType.getDelFlag().equals("0")) {
			adAdviceTypeService.update(adAdviceType);
			String msg = "修改成功!";
			model.addAttribute("msg", msg);
			return "moudlues/ad/adAdviceType_update";
		}
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		return "moudlues/ad/adAdviceType_update";
		
	}
	//信息太少，暂时没有需求
	@RequestMapping("/show.do")
	public String show(Model model,AdAdviceType adAdviceType){
	
		return null;
		
	}
	//删除多条
	@RequestMapping("/dels.do")
	@ResponseBody
	public Object dels(Model model,@RequestParam(value = "ids[]") String[] ids){
		adAdviceTypeService.deletes(ids);
		   HashMap<String, Object> data = new HashMap<>();
		   data.put("data", "删除");
			return data;
			
		}
}
