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
@RequestMapping("/a/ntNticeType")
public class NtNoticeTypeController {
	
	@Autowired
	NtNoticeTypeService ntNoticeTypeService;
	
	@RequestMapping("/save.do")
	public String save(Model model,NtNoticeType noticeType){
		
		if (noticeType !=null && noticeType.getDelFlag().equals("0")) {
			ntNoticeTypeService.save(noticeType);
			String msg = "添加成功!";
			model.addAttribute("msg", msg);
		}
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		return "moudlues/sys/ntNticeType_add";
		
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
	public String del(Model model,NtNoticeType noticeType){
		ntNoticeTypeService.delete(noticeType);
		  return "删除成功";
		
	}
	
	@RequestMapping("/list.do")
	public String list(Model model,NtNoticeType noticeType){
		List<NtNoticeType> ntNoticeTypes = ntNoticeTypeService.findList(noticeType);
		model.addAttribute("ntNoticeTypes", ntNoticeTypes);
		return "moudlues/sys/ntNticeType_list";
	}
	
	@RequestMapping("/update.do")
	public String update(Model model,NtNoticeType noticeType){
		if (noticeType !=null && noticeType.getDelFlag().equals("0")) {
			ntNoticeTypeService.update(noticeType);
			String msg = "修改成功!";
			model.addAttribute("msg", msg);
			return "moudlues/sys/ntNticeType_update";
		}
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		return "moudlues/sys/ntNticeType_update";
		
	}
	//信息太少，暂时没有需求
	@RequestMapping("/show.do")
	public String show(Model model,NtNoticeType noticeType){
	
		return null;
		
	}

}
