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

import com.logistics.system.modlues.shiroTest.entity.Permission;
import com.logistics.system.modlues.shiroTest.entity.Role;
import com.logistics.system.modlues.sys.entity.SysDepartment;
import com.logistics.system.modlues.sys.entity.SysMenu;
import com.logistics.system.modlues.sys.entity.SysPermission;
import com.logistics.system.modlues.sys.entity.SysRole;
import com.logistics.system.modlues.sys.entity.SysUser;
import com.logistics.system.modlues.sys.service.SysDepartmentService;
import com.logistics.system.modlues.sys.service.SysMenuService;
import com.logistics.system.modlues.sys.service.SysPermissionService;
import com.logistics.system.modlues.sys.service.SysRoleService;

@Controller
@RequestMapping("/a/sysRole")
public class SysRoleController {
	
	@Autowired
	SysRoleService sysRoleService;
	
	@Autowired
	SysMenuService sysMenuService;
	
	@Autowired
	SysPermissionService sysPermissionService;
	
	@RequestMapping("/save.do")
	public String save(Model model,SysRole sysRole,String[] premissionIds){
		
		if (sysRole !=null && sysRole.getDelFlag().equals("0")) {
			sysRoleService.save(sysRole, premissionIds);
			String msg = "添加成功!";
			model.addAttribute("msg", msg);
		}
		//创建一个sysMenu带有空id的fatherSysMenu,以便查询顶级菜单
		SysMenu sysMenu = new SysMenu();
		SysMenu fSysMenu = new SysMenu("");
		sysMenu.setFatherMenu(fSysMenu);
		List<SysMenu> sysMenus = sysMenuService.findList(sysMenu);
		model.addAttribute("sysMenus", sysMenus);
		List<SysPermission> permissions = sysPermissionService.findList(new SysPermission());
		model.addAttribute("permissions", permissions);
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		return "moudlues/sys/sysRole_add";
		
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
	public Object del(Model model,SysRole sysRole){
		sysRoleService.delete(sysRole);
		HashMap<String,Object> hashMap = new HashMap<>();
		hashMap.put("del", "删除成功");
	    return hashMap;
		
	}
	
	@RequestMapping("/list.do")
	public String list(Model model,SysRole sysRole){
		List<SysRole> sysRoles = sysRoleService.findList(sysRole);
		model.addAttribute("sysRoles", sysRoles);
		return "moudlues/sys/sysRole_list";
	}
	
	@RequestMapping("/update.do")
	public String update(Model model,SysRole sysRole,String[] premissionIds){
		if (sysRole !=null && sysRole.getDelFlag().equals("0")) {
			sysRoleService.update(sysRole,premissionIds);
			String msg = "update Suucesss!";
			model.addAttribute("updateMsg", msg);
			return "redirect:" + "/a/sysRole/list.do";	
		}
		//创建一个sysMenu带有空id的fatherSysMenu,以便查询顶级菜单
		        SysUser currentSysUser = (SysUser)SecurityUtils.getSubject().getPrincipal();
				SysMenu sysMenu = new SysMenu();
				SysMenu fSysMenu = new SysMenu("");
				sysMenu.setFatherMenu(fSysMenu);
				List<SysMenu> sysMenus = sysMenuService.findList(sysMenu);
				model.addAttribute("sysMenus", sysMenus);
				//查找角色
				SysRole sysRole2 = sysRoleService.get(sysRole);
				model.addAttribute("sysRole", sysRole2);
				//查找权限
				List<SysPermission> permissions = sysPermissionService.findList(new SysPermission());
				model.addAttribute("permissions", permissions);
				//查找角色的权限
				List<SysPermission> rolePermissions = sysRole2.getSysPermissions();
				model.addAttribute("rolePermissions", rolePermissions);
				
				
				model.addAttribute("sysUser", currentSysUser);
		return "moudlues/sys/sysRole_update";
		
	}
	//信息太少，暂时没有需求
	@RequestMapping("/show.do")
	public String show(Model model,SysRole sysRole){
	
		return null;
		
	}
	//删除多条
	@RequestMapping("/dels.do")
	@ResponseBody
	public Object dels(Model model,@RequestParam(value = "ids[]") String[] ids){
		sysRoleService.deletes(ids);
		   HashMap<String, Object> data = new HashMap<>();
		   data.put("data", "删除");
			return data;
			
		}
}
