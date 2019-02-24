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

import com.logistics.system.modlues.pty.entity.PtyProperty;
import com.logistics.system.modlues.pty.entity.PtyPropertyType;
import com.logistics.system.modlues.pty.service.PtyPropertyService;
import com.logistics.system.modlues.pty.service.PtyPropertyTypeService;
import com.logistics.system.modlues.sys.entity.SysUser;
import com.logistics.system.modlues.sys.service.SysDepartmentService;

@Controller
@RequestMapping("/a/ptyProperty")
public class PtyPropertyController {
	
	@Autowired
	PtyPropertyService ptyPropertyService;
	
	@Autowired
	PtyPropertyTypeService ptyPropertyTypeService;
	
	@RequestMapping("/save.do")
	public String save(Model model,PtyProperty ptyProperty){
		
		if (ptyProperty !=null && ptyProperty.getDelFlag().equals("0")) {
			ptyPropertyService.save(ptyProperty);
			String msg = "添加成功!";
			model.addAttribute("msg", msg);
		}
		List<PtyPropertyType> ptyPropertyTypes = ptyPropertyTypeService.findList(new PtyPropertyType());
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		model.addAttribute("ptyPropertyTypes", ptyPropertyTypes);
		return "moudlues/pty/ptyProperty_add";
		
	}
	


	@RequestMapping("/del.do")
	@ResponseBody
	public Object del(Model model,PtyProperty ptyProperty){
		ptyPropertyService.delete(ptyProperty);
		HashMap<String,Object> hashMap = new HashMap<>();
		hashMap.put("del", "删除成功");
	    return hashMap;
		
	}
	
	@RequestMapping("/list.do")
	public String list(Model model,PtyProperty ptyProperty){
		List<PtyProperty> ptyPropertys = ptyPropertyService.findList(ptyProperty);
		model.addAttribute("ptyPropertys", ptyPropertys);
		return "moudlues/pty/ptyProperty_list";
	}
	
	@RequestMapping("/update.do")
	public String update(Model model,PtyProperty ptyProperty){
		if (ptyProperty !=null && ptyProperty.getDelFlag().equals("0")) {
			ptyPropertyService.update(ptyProperty);
			String msg = "修改成功!";
			model.addAttribute("msg", msg);
			return "moudlues/pty/ptyProperty_update";
		}
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		return "moudlues/pty/ptyProperty_update";
		
	}
	@RequestMapping("/show.do")
	public String show(Model model,PtyProperty ptyProperty){
	   PtyProperty ptyProperty2 = ptyPropertyService.get(ptyProperty);
	   model.addAttribute("ptyProperty", ptyProperty2);
		return "moudlues/pty/ptyProperty_show";
		
	}
	//删除多条
	@RequestMapping("/dels.do")
	@ResponseBody
	public Object dels(Model model,@RequestParam(value = "ids[]") String[] ids){
		ptyPropertyService.deletes(ids);
		   HashMap<String, Object> data = new HashMap<>();
		   data.put("data", "删除");
			return data;
			
		}
}
