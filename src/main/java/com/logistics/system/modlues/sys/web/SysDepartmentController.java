package com.logistics.system.modlues.sys.web;

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

import com.logistics.system.modlues.sys.entity.SysDepartment;
import com.logistics.system.modlues.sys.entity.SysUser;
import com.logistics.system.modlues.sys.service.SysDepartmentService;

@Controller
@RequestMapping("/a/sysDepartment")
public class SysDepartmentController {
	
	@Autowired
	SysDepartmentService sysDepartmentService;
	
	@RequestMapping("/save.do")
	public String save(Model model,SysDepartment sysDepartment){
		
		if (sysDepartment !=null && sysDepartment.getDelFlag().equals("0")) {
			sysDepartmentService.save(sysDepartment);
			String msg = "添加成功!";
			model.addAttribute("msg", msg);
		}
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		return "moudlues/sys/sysDepartment_add";
		
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
	public Object del(Model model,SysDepartment sysDepartment){
		sysDepartmentService.delete(sysDepartment);
		HashMap<String,Object> hashMap = new HashMap<>();
		hashMap.put("del", "删除成功");
	    return hashMap;
		
	}
	
	@RequestMapping("/list.do")
	public String list(Model model,SysDepartment sysDepartment){
		List<SysDepartment> sysDepartments = sysDepartmentService.findList(sysDepartment);
		model.addAttribute("sysDepartments", sysDepartments);
		return "moudlues/sys/sysDepartment_list";
	}
	
	@RequestMapping("/update.do")
	public String update(Model model,SysDepartment sysDepartment){
		if (sysDepartment !=null && sysDepartment.getDelFlag().equals("0")) {
			sysDepartmentService.update(sysDepartment);
			String msg = "修改成功!";
			model.addAttribute("msg", msg);
			return "moudlues/sys/sysDepartment_update";
		}
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		return "moudlues/sys/sysDepartment_update";
		
	}
	//信息太少，暂时没有需求
	@RequestMapping("/show.do")
	public String show(Model model,SysDepartment sysDepartment){
	
		return null;
		
	}
	//删除多条
	@RequestMapping("/dels.do")
	@ResponseBody
	public Object dels(Model model,@RequestParam(value = "ids[]") String[] ids){
		sysDepartmentService.deletes(ids);
		   HashMap<String, Object> data = new HashMap<>();
		   data.put("data", "删除");
			return data;
			
		}
}
