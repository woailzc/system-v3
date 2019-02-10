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

import com.logistics.system.modlues.nt.entity.NtNotice;
import com.logistics.system.modlues.nt.entity.NtNoticeType;
import com.logistics.system.modlues.nt.service.NtNoticeService;
import com.logistics.system.modlues.nt.service.NtNoticeTypeService;
import com.logistics.system.modlues.sys.entity.SysUser;
import com.logistics.system.modlues.sys.service.SysDepartmentService;

@Controller
@RequestMapping("/a/ntNtice")
public class NtNoticeController {
	
	@Autowired
	NtNoticeService ntNoticeService;
	
	@Autowired
	NtNoticeTypeService ntNoticeTypeService;
	
	@RequestMapping("/save.do")
	public String save(Model model,NtNotice ntNotice){
		
		if (ntNotice !=null && ntNotice.getDelFlag().equals("0")) {
			ntNoticeService.save(ntNotice);
			String msg = "添加成功!";
			model.addAttribute("msg", msg);
		}
		List<NtNoticeType> ntNoticeTypes = ntNoticeTypeService.findList(new NtNoticeType());
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		model.addAttribute("ntNoticeTypes", ntNoticeTypes);
		return "moudlues/sys/ntNotice_add.jsp";
		
	}
	


	@RequestMapping("/del.do")
	@ResponseBody
	public String del(Model model,NtNotice ntNotice){
		ntNoticeService.delete(ntNotice);
		  return "删除成功";
		
	}
	
	@RequestMapping("/list.do")
	public String list(Model model,NtNotice ntNotice){
		List<NtNotice> ntNotices = ntNoticeService.findList(ntNotice);
		model.addAttribute("ntNotices", ntNotices);
		return "moudlues/sys/ntNotice_list";
	}
	
	@RequestMapping("/update.do")
	public String update(Model model,NtNotice ntNotice){
		if (ntNotice !=null && ntNotice.getDelFlag().equals("0")) {
			ntNoticeService.update(ntNotice);
			String msg = "修改成功!";
			model.addAttribute("msg", msg);
			return "moudlues/sys/ntNotice_update";
		}
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		return "moudlues/sys/ntNotice_update";
		
	}
	//信息太少，暂时没有需求
	@RequestMapping("/show.do")
	public String show(Model model,NtNotice ntNotice){
	
		return null;
		
	}

}
