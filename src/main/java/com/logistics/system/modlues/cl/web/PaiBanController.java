package com.logistics.system.modlues.cl.web;

import java.util.ArrayList;
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

import com.logistics.system.modlues.cl.dao.PaiBanDao;
import com.logistics.system.modlues.cl.entity.ClCleanArea;
import com.logistics.system.modlues.cl.entity.PaiBan;
import com.logistics.system.modlues.cl.service.ClCleanAreaService;
import com.logistics.system.modlues.cl.service.PaiBanService;
import com.logistics.system.modlues.sys.entity.SysDepartment;
import com.logistics.system.modlues.sys.entity.SysUser;
import com.logistics.system.modlues.sys.service.SysDepartmentService;
import com.logistics.system.modlues.sys.service.SysUserService;


@Controller
@RequestMapping("/a/paiBan")
public class PaiBanController {
	
	@Autowired
	PaiBanService paiBanService;
	@Autowired
	ClCleanAreaService clCleanAreaService;
	@Autowired
	SysUserService sysUserService;
	@Autowired
	SysDepartmentService sysDepartmentService;
	@RequestMapping("/save.do")
	public String save(Model model,String userId,String paibanId){
		if(userId != null && userId != "" ){
			paiBanService.savePaiban(userId,paibanId);
			String msg = "添加成功!";
			model.addAttribute("msg", msg);
		}
		SysDepartment sysDepartment = sysDepartmentService.get(new SysDepartment(null,"保洁部"));//保洁部
		SysUser sysUser = new SysUser();
		sysUser.setSysDepartment(sysDepartment);
		List<SysUser> clCleanUsers = sysUserService.findList(sysUser);
//		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		model.addAttribute("clCleanUsers", clCleanUsers);
		model.addAttribute("paibanId", paibanId);
		return "moudlues/cl/paiBan_add";
		
	}
	//初始化表
	@RequestMapping("/inti.do")
	public String inti(Model model,PaiBan paiBan){
		
		if (paiBan.getBeginTime1()!=null&&!paiBan.getBeginTime1().equals("") && paiBan.getDelFlag().equals("0")) {
			paiBanService.intit(paiBan);
			String msg = "初始化成功!";
			model.addAttribute("msg", msg);
		}
		model.addAttribute("clCleanAreas",clCleanAreaService.findList(new ClCleanArea()));
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		return "moudlues/cl/initPaiBan";
		
	}


	@RequestMapping("/del.do")
	@ResponseBody
	public Object del(Model model,String userId,String paibanId){
		paiBanService.deletePaiban(userId, paibanId);
		HashMap<String,Object> hashMap = new HashMap<>();
		hashMap.put("del", "删除成功");
	    return hashMap;
		
	}
	
/*	@RequestMapping("/list.do")
	public String list(Model model,PaiBan paiBan){
		SysUser sysUser = (SysUser)SecurityUtils.getSubject().getPrincipal();
		model.addAttribute("currentUser", sysUser);
		List<PaiBan> paiBans = paiBanService.findList(paiBan);
		model.addAttribute("paiBans", paiBans);
		return "moudlues/cl/paiBan_list";
	}*/
	@RequestMapping("/updatePaiBan.do")
	public String updatePaiBan(Model model,String userId,String paibanId){
		if(userId != null && userId != "" ){
			paiBanService.updatePaiban(userId,paibanId);
			String msg = "修改成功!";
			model.addAttribute("msg", msg);
		}
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		 return "moudlues/cl/paiBan_updatePaiban";
		
	}
	@RequestMapping("/update.do")
	public String update(Model model,PaiBan paiBan){
	/*	if (paiBan !=null && paiBan.getDelFlag().equals("0")) {
			paiBanService.update(paiBan);
			String msg = "修改成功!";
			model.addAttribute("msg", msg);
		}*/
		//早班
		paiBan.setBanci(1);
	    List<PaiBan> paiBans1 = paiBanService.findList(paiBan);
	    if(paiBans1.size()>0){
	    model.addAttribute("beginTime1", paiBans1.get(0).getBeginTime());
	    model.addAttribute("endTime1", paiBans1.get(0).getEndTime());
	    for(int i = 0;i<paiBans1.size();i++){
	    	PaiBan paiBan2 = paiBanService.get(paiBans1.get(i));
	    	if (paiBan2 != null) {
				paiBans1.get(i).setSysUsers(paiBan2.getSysUsers());
			}
	    }
	    }
	    model.addAttribute("paiBans1", paiBans1);
	    //中班
	    paiBan.setBanci(2);
	    List<PaiBan> paiBans2 = paiBanService.findList(paiBan);
	    if(paiBans2.size()>0){
	    model.addAttribute("beginTime2", paiBans2.get(0).getBeginTime());
	    model.addAttribute("endTime2", paiBans2.get(0).getEndTime());
	    for(int i = 0;i<paiBans2.size();i++){
	    	PaiBan paiBan2 = paiBanService.get(paiBans2.get(i));
	    	if (paiBan2 != null) {
				paiBans2.get(i).setSysUsers(paiBan2.getSysUsers());
			}
	    }
	    }
	    model.addAttribute("paiBans2", paiBans2);
	    //晚班
	    paiBan.setBanci(3);
	    List<PaiBan> paiBans3 = paiBanService.findList(paiBan);
	    if(paiBans3.size()>0){
	    model.addAttribute("beginTime3", paiBans3.get(0).getBeginTime());
	    model.addAttribute("endTime3", paiBans3.get(0).getEndTime());
	    for(int i = 0;i<paiBans3.size();i++){
	    	PaiBan paiBan2 = paiBanService.get(paiBans3.get(i));
	    	if (paiBan2 != null) {
				paiBans3.get(i).setSysUsers(paiBan2.getSysUsers());
			}
	    }
	    }
	    model.addAttribute("paiBans3", paiBans3);
	    //获取当前用户
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		return "moudlues/cl/paiBan_update";
		
	}
	@RequestMapping("/show.do")
	public String show(Model model,PaiBan paiBan){
		//早班
				paiBan.setBanci(1);
			    List<PaiBan> paiBans1 = paiBanService.findList(paiBan);
			    if(paiBans1.size()>0){
			    model.addAttribute("beginTime1", paiBans1.get(0).getBeginTime());
			    model.addAttribute("endTime1", paiBans1.get(0).getEndTime());
			    for(int i = 0;i<paiBans1.size();i++){
			    	PaiBan paiBan2 = paiBanService.get(paiBans1.get(i));
			    	if (paiBan2 != null) {
						paiBans1.get(i).setSysUsers(paiBan2.getSysUsers());
					}
			    }
			    }
			    model.addAttribute("paiBans1", paiBans1);
			    //中班
			    paiBan.setBanci(2);
			    List<PaiBan> paiBans2 = paiBanService.findList(paiBan);
			    if(paiBans2.size()>0){
			    model.addAttribute("beginTime2", paiBans2.get(0).getBeginTime());
			    model.addAttribute("endTime2", paiBans2.get(0).getEndTime());
			    for(int i = 0;i<paiBans2.size();i++){
			    	PaiBan paiBan2 = paiBanService.get(paiBans2.get(i));
			    	if (paiBan2 != null) {
						paiBans2.get(i).setSysUsers(paiBan2.getSysUsers());
					}
			    }
			    }
			    model.addAttribute("paiBans2", paiBans2);
			    //晚班
			    paiBan.setBanci(3);
			    List<PaiBan> paiBans3 = paiBanService.findList(paiBan);
			    if(paiBans3.size()>0){
			    model.addAttribute("beginTime3", paiBans3.get(0).getBeginTime());
			    model.addAttribute("endTime3", paiBans3.get(0).getEndTime());
			    for(int i = 0;i<paiBans3.size();i++){
			    	PaiBan paiBan2 = paiBanService.get(paiBans3.get(i));
			    	if (paiBan2 != null) {
						paiBans3.get(i).setSysUsers(paiBan2.getSysUsers());
					}
			    }
			    }
			    model.addAttribute("paiBans3", paiBans3);
			    //获取当前用户
				model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
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
