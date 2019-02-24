package com.logistics.system.modlues.ast.web;

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

import com.logistics.system.modlues.ast.entity.AstSpecialCapital;
import com.logistics.system.modlues.ast.entity.AstWorkingCapital;
import com.logistics.system.modlues.ast.service.AstSpecialCapitalService;
import com.logistics.system.modlues.ast.service.AstWorkingCapitalService;
import com.logistics.system.modlues.sys.entity.SysUser;
import com.logistics.system.modlues.sys.service.SysDepartmentService;

@Controller
@RequestMapping("/a/astSpecialCapital")
public class AstSpecialController {
	
	@Autowired
	AstSpecialCapitalService astSpecialCapitalService;
	
	
	@RequestMapping("/save.do")
	public String save(Model model,AstSpecialCapital astSpecialCapital){
		
		if (astSpecialCapital !=null && astSpecialCapital.getDelFlag().equals("0")) {
			astSpecialCapitalService.save(astSpecialCapital);
			String msg = "添加成功!";
			model.addAttribute("msg", msg);
		}
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		return "moudlues/ast/astSpecialCapital_add";
		
	}
	


	@RequestMapping("/del.do")
	@ResponseBody
	public Object del(Model model,AstSpecialCapital astSpecialCapital){
		astSpecialCapitalService.delete(astSpecialCapital);
		HashMap<String,Object> hashMap = new HashMap<>();
		hashMap.put("del", "删除成功");
	    return hashMap;
		
	}
	
	@RequestMapping("/list.do")
	public String list(Model model,AstSpecialCapital astSpecialCapital){
		List<AstSpecialCapital> astSpecialCapitals = astSpecialCapitalService.findList(astSpecialCapital);
		model.addAttribute("astSpecialCapitals", astSpecialCapitals);
		return "moudlues/ast/astSpecialCapital_list";
	}
	
	@RequestMapping("/update.do")
	public String update(Model model,AstSpecialCapital astSpecialCapital){
		if (astSpecialCapital !=null && astSpecialCapital.getDelFlag().equals("0")) {
			astSpecialCapitalService.update(astSpecialCapital);
			String msg = "修改成功!";
			model.addAttribute("msg", msg);
			return "moudlues/ast/astSpecialCapital_update";
		}
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		return "moudlues/ast/astSpecialCapital_update";
		
	}
	@RequestMapping("/show.do")
	public String show(Model model,AstSpecialCapital astSpecialCapital){
	   AstSpecialCapital astSpecialCapital2 = astSpecialCapitalService.get(astSpecialCapital);
	   model.addAttribute("astSpecialCapital", astSpecialCapital2);
		return "moudlues/ast/astSpecialCapital_show";
		
	}
	//删除多条
	@RequestMapping("/dels.do")
	@ResponseBody
	public Object dels(Model model,@RequestParam(value = "ids[]") String[] ids){
		astSpecialCapitalService.deletes(ids);
		   HashMap<String, Object> data = new HashMap<>();
		   data.put("data", "删除");
			return data;
			
		}
}
