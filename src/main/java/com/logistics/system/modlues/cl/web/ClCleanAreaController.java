package com.logistics.system.modlues.cl.web;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.logistics.system.modlues.cl.entity.ClClean;
import com.logistics.system.modlues.cl.entity.ClCleanArea;
import com.logistics.system.modlues.cl.service.ClCleanAreaService;
import com.logistics.system.modlues.cl.service.ClCleanService;
import com.logistics.system.modlues.re.entity.ReRepairOrder;
import com.logistics.system.modlues.sys.entity.SysDepartment;
import com.logistics.system.modlues.sys.entity.SysUser;
import com.logistics.system.modlues.sys.service.SysDepartmentService;
import com.logistics.system.modlues.sys.service.SysUserService;

@Controller
@RequestMapping("/a/clCleanArea")
public class ClCleanAreaController {
	
	@Autowired
	ClCleanAreaService clCleanAreaService;
	
	@RequestMapping("/save.do")
	public String save(Model model,ClCleanArea clCleanArea){
		
		if (clCleanArea !=null && clCleanArea.getDelFlag().equals("0")) {
			clCleanAreaService.save(clCleanArea);
			String msg = "添加成功!";
			model.addAttribute("msg", msg);
			return "moudlues/cl/clCleanArea_add";
		}
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		return "moudlues/cl/clCleanArea_add";
		
	}
	


	@RequestMapping("/del.do")
	@ResponseBody
	public Object del(Model model,ClCleanArea clCleanArea){
		clCleanAreaService.delete(clCleanArea);
		HashMap<String,Object> hashMap = new HashMap<>();
		hashMap.put("del", "删除成功");
	    return hashMap;
		
	}
	
	@RequestMapping("/list.do")
	public String list(Model model,ClCleanArea clCleanArea){
		SysUser sysUser = (SysUser)SecurityUtils.getSubject().getPrincipal();
		model.addAttribute("currentUser", sysUser);
		List<ClCleanArea> clCleanAreas = clCleanAreaService.findList(clCleanArea);
		model.addAttribute("clCleanAreas", clCleanAreas);
		return "moudlues/cl/clCleanArea_list";
	}
	
	@RequestMapping("/update.do")
	public String update(Model model,ClCleanArea clCleanArea){
		if (clCleanArea !=null && clCleanArea.getDelFlag().equals("0")) {
			clCleanAreaService.update(clCleanArea);
			String msg = "修改成功!";
			model.addAttribute("msg", msg);
		}
	
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		model.addAttribute("clCleanArea", clCleanAreaService.get(clCleanArea));
		return "moudlues/cl/clCleanArea_update";
		
	}
	@RequestMapping("/show.do")
	public String show(Model model,ClCleanArea clCleanArea){
		ClCleanArea clCleanArea2 = clCleanAreaService.get(clCleanArea);
	   model.addAttribute("clCleanArea", clCleanArea2);
		return "moudlues/cl/clCleanArea_show";
		
	}
/*	//接受
		@RequestMapping("/acceptAndFinish.do")
		@ResponseBody
		public Object accept(Model model,ClCleanArea clCleanArea){
			 if(clCleanArea.getStatus().equals("已完成")) clCleanArea.setUpdateDate(new Date());
		   clCleanAreaService.acceptAndFinish(clCleanArea);
		   HashMap<String, Object> data = new HashMap<>();
		   data.put("status", "已完成");
			return data;
		}*/
			
		

}
