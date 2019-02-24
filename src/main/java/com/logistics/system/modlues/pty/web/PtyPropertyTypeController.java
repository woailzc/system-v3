package com.logistics.system.modlues.pty.web;

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

import com.logistics.system.modlues.pty.entity.PtyPropertyType;
import com.logistics.system.modlues.pty.service.PtyPropertyTypeService;
import com.logistics.system.modlues.sys.entity.SysDepartment;
import com.logistics.system.modlues.sys.entity.SysUser;
import com.logistics.system.modlues.sys.service.SysDepartmentService;

@Controller
@RequestMapping("/a/ptyPropertyType")
public class PtyPropertyTypeController {
	
	@Autowired
	PtyPropertyTypeService ptyPropertyTypeService;
	
	@RequestMapping("/save.do")
	public String save(Model model,PtyPropertyType ptyPropertyType){
		
		if (ptyPropertyType !=null && ptyPropertyType.getDelFlag().equals("0")) {
			ptyPropertyTypeService.save(ptyPropertyType);
			String msg = "添加成功!";
			model.addAttribute("msg", msg);
		}
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		return "moudlues/pty/ptyPropertyType_add";
		
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
	public Object del(Model model,PtyPropertyType ptyPropertyType){
		ptyPropertyTypeService.delete(ptyPropertyType);
		HashMap<String,Object> hashMap = new HashMap<>();
		hashMap.put("del", "删除成功");
	    return hashMap;
		
	}
	
	@RequestMapping("/list.do")
	public String list(Model model,PtyPropertyType ptyPropertyType){
		List<PtyPropertyType> ptyPropertyTypes = ptyPropertyTypeService.findList(ptyPropertyType);
		model.addAttribute("ptyPropertyTypes", ptyPropertyTypes);
		return "moudlues/pty/ptyPropertyType_list";
	}
	
	@RequestMapping("/update.do")
	public String update(Model model,PtyPropertyType ptyPropertyType){
		if (ptyPropertyType !=null && ptyPropertyType.getDelFlag().equals("0")) {
			ptyPropertyTypeService.update(ptyPropertyType);
			String msg = "修改成功!";
			model.addAttribute("msg", msg);
			return "moudlues/pty/ptyPropertyType_update";
		}
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		return "moudlues/pty/ptyPropertyType_update";
		
	}
	//信息太少，暂时没有需求
	@RequestMapping("/show.do")
	public String show(Model model,PtyPropertyType ptyPropertyType){
	
		return null;
		
	}
	//删除多条
	@RequestMapping("/dels.do")
	@ResponseBody
	public Object dels(Model model,@RequestParam(value = "ids[]") String[] ids){
		ptyPropertyTypeService.deletes(ids);
		   HashMap<String, Object> data = new HashMap<>();
		   data.put("data", "删除");
			return data;
			
		}
}
