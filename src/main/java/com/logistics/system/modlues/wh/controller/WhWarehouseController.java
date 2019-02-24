package com.logistics.system.modlues.wh.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.logistics.system.modlues.sys.entity.SysUser;
import com.logistics.system.modlues.wh.entity.WhWarehouse;
import com.logistics.system.modlues.wh.entity.WhWarehouseAndApplyCode;
import com.logistics.system.modlues.wh.entity.WhWarehouseApply;
import com.logistics.system.modlues.wh.entity.WhWarehouseType;
import com.logistics.system.modlues.wh.service.WhWarehouseAndApplyCodeService;
import com.logistics.system.modlues.wh.service.WhWarehouseService;
import com.logistics.system.modlues.wh.service.WhWarehouseTypeService;

@Controller
@RequestMapping("/a/whWarehouse")
public class WhWarehouseController {
	
	@Autowired
	WhWarehouseService whWarehouseService;
	
	@Autowired
	WhWarehouseTypeService whWarehouseTypeService;
	
	@Autowired
	WhWarehouseAndApplyCodeService whWarehouseAndApplyCodeService;
	
	@RequestMapping("/save.do")
	public String save(Model model,WhWarehouse whWarehouse){
		
		if (whWarehouse !=null && whWarehouse.getDelFlag().equals("0")) {
			whWarehouse.setCurrentInventory(whWarehouse.getMaxInventory());
			whWarehouseService.save(whWarehouse);
			String msg = "添加成功!";
			model.addAttribute("msg", msg);
		}
		List<WhWarehouseType> whWarehouseTypes = whWarehouseTypeService.findList(new WhWarehouseType());
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		model.addAttribute("whWarehouseTypes", whWarehouseTypes);
		return "moudlues/wh/whWarehouse_add";
		
	}
	


	@RequestMapping("/del.do")
	@ResponseBody
	public Object del(Model model,WhWarehouse whWarehouse){
		whWarehouseService.delete(whWarehouse);
		   HashMap<String, Object> data = new HashMap<>();
		   data.put("del","删除成功" );
			return data;
		
	}
	
	@RequestMapping("/list.do")
	public String list(Model model,WhWarehouse whWarehouse){
		List<WhWarehouse> whWarehouses = whWarehouseService.findList(whWarehouse);
		model.addAttribute("whWarehouses", whWarehouses);
		return "moudlues/wh/whWarehouse_list";
	}
	
	@RequestMapping("/update.do")
	public String update(Model model,WhWarehouse whWarehouse){
		if (whWarehouse !=null && whWarehouse.getDelFlag().equals("0")) {
			whWarehouseService.update(whWarehouse);
			String msg = "修改成功!";
			model.addAttribute("msg", msg);
			return "moudlues/wh/whWarehouse_update";
		}
		model.addAttribute("whWarehouse",whWarehouseService.get(whWarehouse.getId()));
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		return "moudlues/wh/whWarehouse_update";
		
	}
	@RequestMapping("/show.do")
	public String show(Model model,WhWarehouse whWarehouse){
	   WhWarehouse whWarehouse2 = whWarehouseService.get(whWarehouse);
	   model.addAttribute("WhWarehouse", whWarehouse2);
		return "moudlues/wh/whWarehouse_show";
		
	}
	//审核
	@RequestMapping("/audit.do")
	@ResponseBody
	public Object audit(Model model,WhWarehouse whWarehouse){
		WhWarehouse whWarehouse2 =  whWarehouseService.get(whWarehouse);
		if(whWarehouse2 == null) return null;
		WhWarehouseAndApplyCode whWarehouseAndApplyCode = whWarehouseAndApplyCodeService.get(whWarehouse2.getWhWarehouseAndApplyCode());
		if(whWarehouseAndApplyCode == null) return null;
		WhWarehouseApply whWarehouseApply = whWarehouseAndApplyCode.getWhWarehouseApply();
		if(whWarehouseApply == null) return null;
		if(whWarehouse.getStatus().equals("空闲")) {
			
			whWarehouseApply.setSuggestion("不通过！");
			
		}
		if(whWarehouse.getStatus().equals("启用中")){ 
			whWarehouseApply.setSuggestion("通过！");
		
		}
	    whWarehouseService.aduit(whWarehouse, whWarehouseApply);
	   model.addAttribute("WhWarehouse", whWarehouseApply);
	   HashMap<String, Object> data = new HashMap<>();
	   data.put("status", whWarehouse.getStatus());
		return data;
		
	}
//查看申请记录详情
	@RequestMapping("showApply")
	public String showApply(WhWarehouseAndApplyCode whWarehouseAndApplyCode,Model model){
		WhWarehouseAndApplyCode whWarehouseAndApplyCode2 = whWarehouseAndApplyCodeService.get(whWarehouseAndApplyCode);
		WhWarehouseApply whWarehouseApply = whWarehouseAndApplyCode2.getWhWarehouseApply();
		model.addAttribute("whWarehouseApply", whWarehouseApply);
	
		return "moudlues/wh/whWarehouse_apply_show";
		
	}
//停用
	@RequestMapping("/stop.do")
	@ResponseBody
	public Object stop(Model model,WhWarehouse whWarehouse){
	   whWarehouseService.stop(whWarehouse);
	   HashMap<String, Object> data = new HashMap<>();
	   data.put("status", whWarehouse.getStatus());
		return data;
		
	}
	//删除多条
	@RequestMapping("/dels.do")
	@ResponseBody
	public Object dels(Model model,@RequestParam(value = "ids[]") String[] ids){
		   whWarehouseService.deletes(ids);
		   HashMap<String, Object> data = new HashMap<>();
		   data.put("data", "删除");
			return data;
			
		}

}
