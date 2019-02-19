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

import com.logistics.system.modlues.ast.entity.AstWorkingCapital;
import com.logistics.system.modlues.ast.service.AstWorkingCapitalService;
import com.logistics.system.modlues.sys.entity.SysUser;
import com.logistics.system.modlues.sys.service.SysDepartmentService;

@Controller
@RequestMapping("/a/astWorkingCapital")
public class AstWorkingCapitalController {
	
	@Autowired
	AstWorkingCapitalService astWorkingCapitalService;
	
	
	@RequestMapping("/save.do")
	public String save(Model model,AstWorkingCapital astWorkingCapital){
		
		if (astWorkingCapital !=null && astWorkingCapital.getDelFlag().equals("0")) {
			astWorkingCapitalService.save(astWorkingCapital);
			String msg = "添加成功!";
			model.addAttribute("msg", msg);
		}
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		return "moudlues/ast/astWorkingCapital_add";
		
	}
	


	@RequestMapping("/del.do")
	@ResponseBody
	public Object del(Model model,AstWorkingCapital astWorkingCapital){
		astWorkingCapitalService.delete(astWorkingCapital);
		HashMap<String,Object> hashMap = new HashMap<>();
		hashMap.put("删除成功", hashMap);
	    return hashMap;
		
	}
	
	@RequestMapping("/list.do")
	public String list(Model model,AstWorkingCapital astWorkingCapital){
		List<AstWorkingCapital> astWorkingCapitals = astWorkingCapitalService.findList(astWorkingCapital);
		model.addAttribute("astWorkingCapitals", astWorkingCapitals);
		return "moudlues/ast/astWorkingCapital_list";
	}
	
	@RequestMapping("/update.do")
	public String update(Model model,AstWorkingCapital astWorkingCapital){
		if (astWorkingCapital !=null && astWorkingCapital.getDelFlag().equals("0")) {
			astWorkingCapitalService.update(astWorkingCapital);
			String msg = "修改成功!";
			model.addAttribute("msg", msg);
			return "moudlues/ast/astWorkingCapital_update";
		}
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		return "moudlues/ast/astWorkingCapital_update";
		
	}
	@RequestMapping("/show.do")
	public String show(Model model,AstWorkingCapital astWorkingCapital){
	   AstWorkingCapital astWorkingCapital2 = astWorkingCapitalService.get(astWorkingCapital);
	   model.addAttribute("astWorkingCapital", astWorkingCapital2);
		return "moudlues/ast/astWorkingCapital_show";
		
	}

}
