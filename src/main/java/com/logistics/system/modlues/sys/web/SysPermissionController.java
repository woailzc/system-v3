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
import com.logistics.system.modlues.sys.entity.SysMenu;
import com.logistics.system.modlues.sys.entity.SysPermission;
import com.logistics.system.modlues.sys.entity.SysUser;
import com.logistics.system.modlues.sys.service.SysDepartmentService;
import com.logistics.system.modlues.sys.service.SysMenuService;
import com.logistics.system.modlues.sys.service.SysPermissionService;

@Controller
@RequestMapping("/a/sysPermission")
public class SysPermissionController {
	
	@Autowired
	SysPermissionService sysPermissionService;
	
	@Autowired
	SysMenuService sysMenuService;
	
	@RequestMapping("/save.do")
	public String save(Model model,SysPermission sysPermission){
		
		if (sysPermission !=null && sysPermission.getDelFlag().equals("0")) {
			sysPermissionService.save(sysPermission);
			String msg = "添加成功!";
			model.addAttribute("msg", msg);
		}
		SysMenu sysMenu = new SysMenu();
		SysMenu fSysMenu = new SysMenu("");
		sysMenu.setFatherMenu(fSysMenu);
		List<SysMenu> sysMenus = sysMenuService.findList(sysMenu);
		model.addAttribute("sysMenus", sysMenus);
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		return "moudlues/sys/sysPermission_add";
		
	}
	
	@RequestMapping("/del.do")
	@ResponseBody
	public Object del(Model model,SysPermission sysPermission){
		sysPermissionService.delete(sysPermission);
		HashMap<String,Object> hashMap = new HashMap<>();
		hashMap.put("del", "删除成功");
	    return hashMap;
		
	}
	
	@RequestMapping("/list.do")
	public String list(Model model,SysPermission sysPermission){
		List<SysPermission> sysPermissions = sysPermissionService.findList(sysPermission);
		model.addAttribute("sysPermissions", sysPermissions);
		return "moudlues/sys/sysPermission_list";
	}
	
	@RequestMapping("/update.do")
	public String update(Model model,SysPermission sysPermission){
		if (sysPermission !=null && sysPermission.getDelFlag().equals("0")) {
			sysPermissionService.update(sysPermission);
			String msg = "修改成功!";
			model.addAttribute("msg", msg);
			return "moudlues/sys/sysPermission_update";
		}
		model.addAttribute("sysPermission", sysPermissionService.get(sysPermission));
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		return "moudlues/sys/sysPermission_update";
		
	}
	//信息太少，暂时没有需求
	@RequestMapping("/show.do")
	public String show(Model model,SysPermission sysPermission){
	
		return null;
		
	}
	//获取子菜单
	@RequestMapping("/getSonMenu.do")
	@ResponseBody
	public Object getSonMenu(Model model,SysMenu sysMenu){
		SysMenu sysMenu2 = sysMenuService.get(sysMenu);
		List<SysMenu> sonMenu = sysMenu2.getSonMenu();
		HashMap<String,Object> hashMap = new HashMap<>();
		hashMap.put("sonMenu", sonMenu);
	    return hashMap;
		
	}
	//删除多条
	@RequestMapping("/dels.do")
	@ResponseBody
	public Object dels(Model model,@RequestParam(value = "ids[]") String[] ids){
		sysPermissionService.deletes(ids);
		   HashMap<String, Object> data = new HashMap<>();
		   data.put("data", "删除");
			return data;
			
		}
}
