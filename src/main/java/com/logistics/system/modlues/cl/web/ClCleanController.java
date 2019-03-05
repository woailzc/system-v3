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
import com.logistics.system.modlues.cl.service.ClCleanService;
import com.logistics.system.modlues.re.entity.ReRepairOrder;
import com.logistics.system.modlues.sys.entity.SysDepartment;
import com.logistics.system.modlues.sys.entity.SysUser;
import com.logistics.system.modlues.sys.service.SysDepartmentService;
import com.logistics.system.modlues.sys.service.SysUserService;

@Controller
@RequestMapping("/a/clClean")
public class ClCleanController {
	
	@Autowired
	ClCleanService clCleanService;
	
	@Autowired
	SysDepartmentService sysDepartmentService;
	
	@Autowired
	SysUserService sysUserService;

	@RequestMapping("/save.do")
	public String save(Model model,ClClean clClean){
		
		if (clClean !=null && clClean.getDelFlag().equals("0")) {
			clCleanService.save(clClean);
			String msg = "添加成功!";
			model.addAttribute("msg", msg);
			return "moudlues/cl/clClean_add";
		}
		SysDepartment sysDepartment = sysDepartmentService.get(new SysDepartment(null,"保洁部"));//保洁部
		SysUser sysUser = new SysUser();
		sysUser.setSysDepartment(sysDepartment);
		List<SysUser> clCleanUsers = sysUserService.findList(sysUser);
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		model.addAttribute("clCleanUsers", clCleanUsers);
		return "moudlues/cl/clClean_add";
		
	}
	


	@RequestMapping("/del.do")
	@ResponseBody
	public Object del(Model model,ClClean clClean){
		clCleanService.delete(clClean);
		HashMap<String,Object> hashMap = new HashMap<>();
		hashMap.put("del", "删除成功");
	    return hashMap;
		
	}
	
	@RequestMapping("/list.do")
	public String list(Model model,ClClean clClean){
		SysUser sysUser = (SysUser)SecurityUtils.getSubject().getPrincipal();
		model.addAttribute("currentUser", sysUser);
		clClean.setApplicant(sysUser);
		clClean.setCleanBy(sysUser);
		List<ClClean> clCleans = clCleanService.findList(clClean);
		model.addAttribute("clCleans", clCleans);
		return "moudlues/cl/clClean_list";
	}
	
	@RequestMapping("/update.do")
	public String update(Model model,ClClean clClean){
		if (clClean !=null && clClean.getDelFlag().equals("0")) {
			clCleanService.update(clClean);
			String msg = "修改成功!";
			model.addAttribute("msg", msg);
		}
		SysDepartment sysDepartment = sysDepartmentService.get(new SysDepartment(null,"保洁部"));//保洁部
		SysUser sysUser = new SysUser();
		sysUser.setSysDepartment(sysDepartment);
		List<SysUser> clCleanUsers = sysUserService.findList(sysUser);
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		model.addAttribute("clCleanUsers", clCleanUsers);
		model.addAttribute("clClean", clCleanService.get(clClean));
		return "moudlues/cl/clClean_update";
		
	}
	@RequestMapping("/show.do")
	public String show(Model model,ClClean clClean){
	   ClClean clClean2 = clCleanService.get(clClean);
	   model.addAttribute("clClean", clClean2);
		return "moudlues/cl/clClean_show";
		
	}
	//接受
		@RequestMapping("/acceptAndFinish.do")
		@ResponseBody
		public Object accept(Model model,ClClean clClean){
			 if(clClean.getStatus().equals("已完成")) clClean.setUpdateDate(new Date());
		   clCleanService.acceptAndFinish(clClean);
		   HashMap<String, Object> data = new HashMap<>();
		   data.put("status", "已完成");
			return data;
		}
			
		

}
