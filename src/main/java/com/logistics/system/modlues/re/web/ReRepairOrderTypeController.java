package com.logistics.system.modlues.re.web;

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

import com.logistics.system.modlues.re.entity.ReRepairOrderType;
import com.logistics.system.modlues.re.service.ReRepairOrderTypeService;
import com.logistics.system.modlues.sys.entity.SysDepartment;
import com.logistics.system.modlues.sys.entity.SysUser;
import com.logistics.system.modlues.sys.service.SysDepartmentService;

@Controller
@RequestMapping("/a/reRepairOrderType")
public class ReRepairOrderTypeController {
	
	@Autowired
	ReRepairOrderTypeService reRepairOrderTypeService;
	
	@RequestMapping("/save.do")
	public String save(Model model,ReRepairOrderType reRepairOrderType){
		
		if (reRepairOrderType !=null && reRepairOrderType.getDelFlag().equals("0")) {
			reRepairOrderTypeService.save(reRepairOrderType);
			String msg = "添加成功!";
			model.addAttribute("msg", msg);
		}
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		return "moudlues/re/reRepairOrderType_add";
		
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
	public Object del(Model model,ReRepairOrderType reRepairOrderType){
		reRepairOrderTypeService.delete(reRepairOrderType);
		HashMap<String,Object> hashMap = new HashMap<>();
		hashMap.put("del", "删除成功");
	    return hashMap;
		
	}
	
	@RequestMapping("/list.do")
	public String list(Model model,ReRepairOrderType reRepairOrderType){
		List<ReRepairOrderType> reRepairOrderTypes = reRepairOrderTypeService.findList(reRepairOrderType);
		model.addAttribute("reRepairOrderTypes", reRepairOrderTypes);
		return "moudlues/re/reRepairOrderType_list";
	}
	
	@RequestMapping("/update.do")
	public String update(Model model,ReRepairOrderType reRepairOrderType){
		if (reRepairOrderType !=null && reRepairOrderType.getDelFlag().equals("0")) {
			reRepairOrderTypeService.update(reRepairOrderType);
			String msg = "修改成功!";
			model.addAttribute("msg", msg);
			return "moudlues/re/reRepairOrderType_update";
		}
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		return "moudlues/re/reRepairOrderType_update";
		
	}
	//信息太少，暂时没有需求
	@RequestMapping("/show.do")
	public String show(Model model,ReRepairOrderType reRepairOrderType){
	
		return null;
		
	}
	//删除多条
	@RequestMapping("/dels.do")
	@ResponseBody
	public Object dels(Model model,@RequestParam(value = "ids[]") String[] ids){
		reRepairOrderTypeService.deletes(ids);
		   HashMap<String, Object> data = new HashMap<>();
		   data.put("data", "删除");
			return data;
			
		}
}
