package com.logistics.system.modlues.cl.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.logistics.system.modlues.cl.entity.ClClean;
import com.logistics.system.modlues.cl.service.ClCleanService;
import com.logistics.system.modlues.sys.entity.SysUser;
import com.logistics.system.modlues.sys.service.SysDepartmentService;

@Controller
@RequestMapping("/a/clClean")
public class ClCleanController {
	
	@Autowired
	ClCleanService clCleanService;

	@RequestMapping("/save.do")
	public String save(Model model,ClClean clClean){
		
		if (clClean !=null && clClean.getDelFlag().equals("0")) {
			clCleanService.save(clClean);
			String msg = "添加成功!";
			model.addAttribute("msg", msg);
		}
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		return "moudlues/cl/clClean_add";
		
	}
	


	@RequestMapping("/del.do")
	@ResponseBody
	public String del(Model model,ClClean clClean){
		clCleanService.delete(clClean);
		  return "删除成功";
		
	}
	
	@RequestMapping("/list.do")
	public String list(Model model,ClClean clClean){
		List<ClClean> clCleans = clCleanService.findList(clClean);
		model.addAttribute("clCleans", clCleans);
		return "moudlues/cl/clClean_list";
	}
	
	@RequestMapping("/update.do")
	public String update(Model model,ClClean clClean){
		if (clClean !=null && clClean.getDelFlag().equals("0")) {
			clCleanService.update(clClean);
			String msg = "修改成功!";
			model.addAttribute("msg", msg);
			return "moudlues/cl/clClean_update";
		}
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		return "moudlues/cl/clClean_update";
		
	}
	@RequestMapping("/show.do")
	public String show(Model model,ClClean clClean){
	   ClClean clClean2 = clCleanService.get(clClean);
	   model.addAttribute("clClean", clClean2);
		return "moudlues/cl/clClean_show";
		
	}

}
