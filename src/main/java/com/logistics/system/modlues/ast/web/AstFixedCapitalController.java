package com.logistics.system.modlues.ast.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.logistics.system.modlues.ast.entity.AstFixedCapital;
import com.logistics.system.modlues.ast.entity.AstWorkingCapital;
import com.logistics.system.modlues.ast.service.AstFixedCapitalService;
import com.logistics.system.modlues.ast.service.AstWorkingCapitalService;
import com.logistics.system.modlues.sys.entity.SysUser;
import com.logistics.system.modlues.sys.service.SysDepartmentService;

@Controller
@RequestMapping("/a/astFixedCapital")
public class AstFixedCapitalController {
	
	@Autowired
	AstFixedCapitalService astFixedCapitalService;
	
	
	@RequestMapping("/save.do")
	public String save(Model model,AstFixedCapital astFixedCapital){
		
		if (astFixedCapital !=null && astFixedCapital.getDelFlag().equals("0")) {
			astFixedCapitalService.save(astFixedCapital);
			String msg = "添加成功!";
			model.addAttribute("msg", msg);
		}
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		return "moudlues/ast/astFixedCapital_add";
		
	}
	


	@RequestMapping("/del.do")
	@ResponseBody
	public String del(Model model,AstFixedCapital astFixedCapital){
		astFixedCapitalService.delete(astFixedCapital);
		  return "删除成功";
		
	}
	
	@RequestMapping("/list.do")
	public String list(Model model,AstFixedCapital astFixedCapital){
		List<AstFixedCapital> astFixedCapitals = astFixedCapitalService.findList(astFixedCapital);
		model.addAttribute("astFixedCapitals", astFixedCapitals);
		return "moudlues/ast/astFixedCapital_list";
	}
	
	@RequestMapping("/update.do")
	public String update(Model model,AstFixedCapital astFixedCapital){
		if (astFixedCapital !=null && astFixedCapital.getDelFlag().equals("0")) {
			astFixedCapitalService.update(astFixedCapital);
			String msg = "修改成功!";
			model.addAttribute("msg", msg);
			return "moudlues/ast/astFixedCapital_update";
		}
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		return "moudlues/ast/astFixedCapital_update";
		
	}
	@RequestMapping("/show.do")
	public String show(Model model,AstFixedCapital astFixedCapital){
	   AstFixedCapital astFixedCapital2 = astFixedCapitalService.get(astFixedCapital);
	   model.addAttribute("astFixedCapital", astFixedCapital2);
		return "moudlues/ast/astFixedCapital_show";
		
	}

}
