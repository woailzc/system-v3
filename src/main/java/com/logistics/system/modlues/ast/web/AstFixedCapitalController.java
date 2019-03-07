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

import com.logistics.system.modlues.ast.entity.AstFixedCapital;
import com.logistics.system.modlues.ast.entity.AstWorkingCapital;
import com.logistics.system.modlues.ast.service.AstFixedCapitalService;
import com.logistics.system.modlues.ast.service.AstWorkingCapitalService;
import com.logistics.system.modlues.sys.entity.SysUser;
import com.logistics.system.modlues.sys.service.SysDepartmentService;
import com.logistics.system.modlues.wh.entity.WhWarehouse;
import com.logistics.system.modlues.wh.service.WhWarehouseService;

@Controller
@RequestMapping("/a/astFixedCapital")
public class AstFixedCapitalController {
	
	@Autowired
	AstFixedCapitalService astFixedCapitalService;
	@Autowired
	WhWarehouseService whWarehouseService;
	
	
	@RequestMapping("/save.do")
	public String save(Model model,AstFixedCapital astFixedCapital){
		
		if (astFixedCapital.getName() != null && !astFixedCapital.getName().equals("") && astFixedCapital.getDelFlag().equals("0")) {
			astFixedCapitalService.save(astFixedCapital);
			String msg = "添加成功!";
			model.addAttribute("msg", msg);
		}
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		return "moudlues/ast/astFixedCapital_add";
		
	}
	


	@RequestMapping("/del.do")
	@ResponseBody
	public Object del(Model model,AstFixedCapital astFixedCapital){
		astFixedCapitalService.delete(astFixedCapital);
		HashMap<String,Object> hashMap = new HashMap<>();
		hashMap.put("del", "删除成功");
	    return hashMap;
		
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
		}
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		model.addAttribute("astFixedCapital", astFixedCapitalService.get(astFixedCapital));
		return "moudlues/ast/astFixedCapital_update";
		
	}
	@RequestMapping("/show.do")
	public String show(Model model,AstFixedCapital astFixedCapital){
	   AstFixedCapital astFixedCapital2 = astFixedCapitalService.get(astFixedCapital);
	   model.addAttribute("astFixedCapital", astFixedCapital2);
		return "moudlues/ast/astFixedCapital_show";
		
	}
	//删除多条
	@RequestMapping("/dels.do")
	@ResponseBody
	public Object dels(Model model,@RequestParam(value = "ids[]") String[] ids){
		astFixedCapitalService.deletes(ids);
		   HashMap<String, Object> data = new HashMap<>();
		   data.put("data", "删除");
			return data;
			
		}
	//申请入仓
	@RequestMapping("/applyInWarehouse.do")
	public String applyInWarehouse(Model model,AstFixedCapital astFixedCapital){
		if(astFixedCapital.getDelFlag().equals("0") && astFixedCapital != null){
			astFixedCapitalService.applyInWarehouse(astFixedCapital);
			String msg = "申请成功!";
			model.addAttribute("msg", msg);
		}
	   WhWarehouse whWarehouse = new WhWarehouse();
	   whWarehouse.setStatus("启用中");
	   List<WhWarehouse> whWarehouses = whWarehouseService.findList(whWarehouse);//查找所有启用中的仓库
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());//当前用户
		model.addAttribute("whWarehouses", whWarehouses);
	    AstFixedCapital astFixedCapital2 = astFixedCapitalService.get(astFixedCapital);
	    model.addAttribute("astFixedCapital", astFixedCapital2);
		return "moudlues/ast/astFixedCapital_applyInWarehouse";
		
	}
	
}
