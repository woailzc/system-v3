package com.logistics.system.modlues.ctn.web;

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

import com.logistics.system.modlues.ctn.entity.CtnFoodType;
import com.logistics.system.modlues.ctn.service.CtnFoodTypeService;
import com.logistics.system.modlues.sys.entity.SysDepartment;
import com.logistics.system.modlues.sys.entity.SysUser;
import com.logistics.system.modlues.sys.service.SysDepartmentService;

@Controller
@RequestMapping("/a/ctnFoodType")
public class CtnFoodTypeController {
	
	@Autowired
	CtnFoodTypeService ctnFoodTypeService;
	
	@RequestMapping("/save.do")
	public String save(Model model,CtnFoodType ctnFoodType){
		
		if (ctnFoodType !=null && ctnFoodType.getDelFlag().equals("0")) {
			ctnFoodTypeService.save(ctnFoodType);
			String msg = "添加成功!";
			model.addAttribute("msg", msg);
		}
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		return "moudlues/ctn/ctnFoodType_add";
		
	}
	
//	@RequestMapping("/del.do")
//	@ResponseBody
//	public Object del(Model model,SysDepartment sysODepartment){
//		sysDepartmentService.delete(sysODepartment);
//		  Map<String, String> responseDataMap = new HashMap<>();
//		  responseDataMap.put("responseData","success");
//		  return responseDataMap;
//		
//	}
	@RequestMapping("/del.do")
	@ResponseBody
	public Object del(Model model,CtnFoodType ctnFoodType){
		ctnFoodTypeService.delete(ctnFoodType);
		HashMap<String,Object> hashMap = new HashMap<>();
		hashMap.put("del", "删除成功");
	    return hashMap;
		
	}
	
	@RequestMapping("/list.do")
	public String list(Model model,CtnFoodType ctnFoodType){
		List<CtnFoodType> ctnFoodTypes = ctnFoodTypeService.findList(ctnFoodType);
		model.addAttribute("ctnFoodTypes", ctnFoodTypes);
		return "moudlues/ctn/ctnFoodType_list";
	}
	
	@RequestMapping("/update.do")
	public String update(Model model,CtnFoodType ctnFoodType){
		if (ctnFoodType !=null && ctnFoodType.getDelFlag().equals("0")) {
			ctnFoodTypeService.update(ctnFoodType);
			String msg = "修改成功!";
			model.addAttribute("msg", msg);
			return "moudlues/ctn/ctnFoodType_update";
		}
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		return "moudlues/ctn/ctnFoodType_update";
		
	}
	//信息太少，暂时没有需求
	@RequestMapping("/show.do")
	public String show(Model model,CtnFoodType ctnFoodType){
	
		return null;
		
	}
	//删除多条
	@RequestMapping("/dels.do")
	@ResponseBody
	public Object dels(Model model,@RequestParam(value = "ids[]") String[] ids){
		ctnFoodTypeService.deletes(ids);
		   HashMap<String, Object> data = new HashMap<>();
		   data.put("data", "删除");
			return data;
			
		}
}
