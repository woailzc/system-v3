package com.logistics.system.modlues.nt.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.logistics.system.modlues.nt.entity.NtNoticeType;
import com.logistics.system.modlues.nt.service.NtNoticeTypeService;
import com.logistics.system.modlues.sys.entity.SysDepartment;
import com.logistics.system.modlues.sys.entity.SysUser;
import com.logistics.system.modlues.sys.service.SysDepartmentService;

@Controller
@RequestMapping("/a/ntNoticeType")
public class NtNoticeTypeController {
	
	@Autowired
	NtNoticeTypeService ntNoticeTypeService;
	
	@RequestMapping("/save.do")
	public String save(Model model,NtNoticeType ntNoticeType){
		
		if (ntNoticeType !=null && ntNoticeType.getDelFlag().equals("0")) {
			ntNoticeTypeService.save(ntNoticeType);
			String msg = "添加成功!";
			model.addAttribute("msg", msg);
		}
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		return "moudlues/nt/ntNoticeType_add";
		
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
	public Object del(Model model,NtNoticeType ntNoticeType){
		ntNoticeTypeService.delete(ntNoticeType);
		HashMap<String,Object> hashMap = new HashMap<>();
		hashMap.put("del", "删除成功");
	    return hashMap;
		
	}
	
	@RequestMapping("/list.do")
	public String list(Model model,NtNoticeType ntNoticeType){
		List<NtNoticeType> ntNoticeTypes = ntNoticeTypeService.findList(ntNoticeType);
		model.addAttribute("ntNoticeTypes", ntNoticeTypes);
		return "moudlues/nt/ntNoticeType_list";
	}
	
	@RequestMapping("/update.do")
	public String update(Model model,NtNoticeType ntNoticeType){
		if (ntNoticeType !=null && ntNoticeType.getDelFlag().equals("0")) {
			ntNoticeTypeService.update(ntNoticeType);
			String msg = "修改成功!";
			model.addAttribute("msg", msg);
			return "moudlues/nt/ntNoticeType_update";
		}
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		return "moudlues/nt/ntNoticeType_update";
		
	}
	//信息太少，暂时没有需求
	@RequestMapping("/show.do")
	public String show(Model model,NtNoticeType ntNoticeType){
	
		return null;
		
	}

}
