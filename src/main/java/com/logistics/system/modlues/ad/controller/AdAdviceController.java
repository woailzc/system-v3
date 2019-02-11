package com.logistics.system.modlues.ad.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.logistics.system.modlues.ad.entity.AdAdvice;
import com.logistics.system.modlues.ad.entity.AdAdviceType;
import com.logistics.system.modlues.ad.service.AdAdviceService;
import com.logistics.system.modlues.ad.service.AdAdviceTypeService;
import com.logistics.system.modlues.sys.entity.SysUser;

@Controller
@RequestMapping("/a/adAdvice")
public class AdAdviceController {
	
	@Autowired
	AdAdviceService adAdviceService;
	
	@Autowired
	AdAdviceTypeService adAdviceTypeService;
	
	@RequestMapping("/save.do")
	public String save(Model model,AdAdvice adAdvice){
		
		if (adAdvice !=null && adAdvice.getDelFlag().equals("0")) {
			adAdviceService.save(adAdvice);
			String msg = "添加成功!";
			model.addAttribute("msg", msg);
		}
		List<AdAdviceType> adAdviceTypes = adAdviceTypeService.findList(new AdAdviceType());
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		model.addAttribute("adAdviceTypes", adAdviceTypes);
		return "moudlues/ad/adAdvice_add";
		
	}
	


	@RequestMapping("/del.do")
	@ResponseBody
	public String del(Model model,AdAdvice adAdvice){
		adAdviceService.delete(adAdvice);
		  return "删除成功";
		
	}
	
	@RequestMapping("/list.do")
	public String list(Model model,AdAdvice adAdvice){
		List<AdAdvice> adAdvices = adAdviceService.findList(adAdvice);
		model.addAttribute("adAdvices", adAdvices);
		return "moudlues/ad/adAdvice_list";
	}
	
	@RequestMapping("/update.do")
	public String update(Model model,AdAdvice adAdvice){
		if (adAdvice !=null && adAdvice.getDelFlag().equals("0")) {
			adAdviceService.update(adAdvice);
			String msg = "修改成功!";
			model.addAttribute("msg", msg);
			return "moudlues/ad/adAdvice_update";
		}
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		return "moudlues/ad/adAdvice_update";
		
	}
	@RequestMapping("/show.do")
	public String show(Model model,AdAdvice adAdvice){
	   AdAdvice adAdvice2 = adAdviceService.get(adAdvice);
	   model.addAttribute("adAdvice", adAdvice2);
		return "moudlues/ad/adAdvice_show";
		
	}

}
