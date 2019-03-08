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

import com.logistics.system.modlues.cl.entity.ClCleanArea;
import com.logistics.system.modlues.cl.entity.PaiBan;
import com.logistics.system.modlues.cl.service.ClCleanAreaService;
import com.logistics.system.modlues.cl.service.PaiBanService;
import com.logistics.system.modlues.sys.entity.SysUser;


@Controller
@RequestMapping("/a/paiBan")
public class PaiBanController {
	
	@Autowired
	PaiBanService paiBanService;
	@Autowired
	ClCleanAreaService clCleanAreaService;
	
	@RequestMapping("/save.do")
	public String save(Model model,PaiBan paiBan){
		
		if (paiBan !=null && paiBan.getDelFlag().equals("0")) {
			paiBanService.save(paiBan);
			String msg = "添加成功!";
			model.addAttribute("msg", msg);
			return "moudlues/cl/paiBan_add";
		}
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		return "moudlues/cl/paiBan_add";
		
	}
	@RequestMapping("/inti.do")
	public String inti(Model model,PaiBan paiBan){
		
		if (paiBan.getBeginTime1()!=null&&!paiBan.getBeginTime1().equals("") && paiBan.getDelFlag().equals("0")) {
			paiBanService.intit(paiBan);
			String msg = "添加成功!";
			model.addAttribute("msg", msg);
		}
		model.addAttribute("clCleanAreas",clCleanAreaService.findList(new ClCleanArea()));
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		return "moudlues/cl/initPaiBan";
		
	}


	@RequestMapping("/del.do")
	@ResponseBody
	public Object del(Model model,PaiBan paiBan){
		paiBanService.delete(paiBan);
		HashMap<String,Object> hashMap = new HashMap<>();
		hashMap.put("del", "删除成功");
	    return hashMap;
		
	}
	
	@RequestMapping("/list.do")
	public String list(Model model,PaiBan paiBan){
		SysUser sysUser = (SysUser)SecurityUtils.getSubject().getPrincipal();
		model.addAttribute("currentUser", sysUser);
		List<PaiBan> paiBans = paiBanService.findList(paiBan);
		model.addAttribute("paiBans", paiBans);
		return "moudlues/cl/paiBan_list";
	}
	
	@RequestMapping("/update.do")
	public String update(Model model,PaiBan paiBan){
		if (paiBan !=null && paiBan.getDelFlag().equals("0")) {
			paiBanService.update(paiBan);
			String msg = "修改成功!";
			model.addAttribute("msg", msg);
		}
		//早班
		paiBan.setBanci(1);
	    List<PaiBan> paiBans1 = paiBanService.findList(paiBan);
	    model.addAttribute("paiBans1", paiBans1);
	    //中班
	    paiBan.setBanci(2);
	    List<PaiBan> paiBans2 = paiBanService.findList(paiBan);
	    model.addAttribute("paiBans2", paiBans2);
	    //晚班
	    paiBan.setBanci(3);
	    List<PaiBan> paiBans3 = paiBanService.findList(paiBan);
	    model.addAttribute("paiBans1", paiBans3);
	    //获取当前用户
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		return "moudlues/cl/paiBan_update";
		
	}
	@RequestMapping("/show.do")
	public String show(Model model,PaiBan paiBan){
		PaiBan paiBan2 = paiBanService.get(paiBan);
	   model.addAttribute("paiBan", paiBan2);
		return "moudlues/cl/paiBan_show";
		
	}
/*	//接受
		@RequestMapping("/acceptAndFinish.do")
		@ResponseBody
		public Object accept(Model model,paiBan paiBan){
			 if(paiBan.getStatus().equals("已完成")) paiBan.setUpdateDate(new Date());
		   paiBanService.acceptAndFinish(paiBan);
		   HashMap<String, Object> data = new HashMap<>();
		   data.put("status", "已完成");
			return data;
		}*/
			
		

}
