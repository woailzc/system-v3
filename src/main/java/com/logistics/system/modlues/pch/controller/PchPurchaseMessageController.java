package com.logistics.system.modlues.pch.controller;

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

import com.logistics.system.modlues.pch.entity.PchPurchaseMessage;
import com.logistics.system.modlues.pch.entity.PchPurchaseType;
import com.logistics.system.modlues.pch.service.PchPurchaseMessagService;
import com.logistics.system.modlues.pch.service.PchPurchaseTypeService;
import com.logistics.system.modlues.sys.entity.SysUser;
import com.logistics.system.modlues.wh.entity.WhWarehouse;
import com.logistics.system.modlues.wh.service.WhWarehouseService;

@Controller
@RequestMapping("/a/pchPurchaseMessage")
public class PchPurchaseMessageController {
	
	@Autowired
	PchPurchaseMessagService pchPurchaseMessageService;
	
	@Autowired
	PchPurchaseTypeService pchPurchaseTypeService;
	
	@Autowired
	WhWarehouseService whWarehouseService;
	
	@RequestMapping("/save.do")
	public String save(Model model,PchPurchaseMessage pchPurchaseMessage){
		
		if (pchPurchaseMessage !=null && pchPurchaseMessage.getDelFlag().equals("0")) {
			
			pchPurchaseMessageService.save(pchPurchaseMessage);
			String msg = "添加成功!";
			model.addAttribute("msg", msg);
		}
		WhWarehouse whWarehouse = new WhWarehouse();
		whWarehouse.setStatus("启用中");
		List<PchPurchaseType> pchPurchaseTypes = pchPurchaseTypeService.findList(new PchPurchaseType());
		List<WhWarehouse> whWarehouses = whWarehouseService.findList(whWarehouse);
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		model.addAttribute("pchPurchaseTypes", pchPurchaseTypes);
		model.addAttribute("whWarehouses", whWarehouses);
		return "moudlues/pch/pchPurchaseMessage_add";
		
	}
	


	@RequestMapping("/del.do")
	@ResponseBody
	public Object del(Model model,PchPurchaseMessage pchPurchaseMessage){
		pchPurchaseMessageService.delete(pchPurchaseMessage);
		HashMap<String,Object> hashMap = new HashMap<>();
		hashMap.put("del", "删除成功");
	    return hashMap;
		
	}
	
	@RequestMapping("/list.do")
	public String list(Model model,PchPurchaseMessage pchPurchaseMessage){
		List<PchPurchaseMessage> pchPurchaseMessages = pchPurchaseMessageService.findList(pchPurchaseMessage);
		model.addAttribute("pchPurchaseMessages", pchPurchaseMessages);
		return "moudlues/pch/pchPurchaseMessage_list";
	}
	
	@RequestMapping("/update.do")
	public String update(Model model,PchPurchaseMessage pchPurchaseMessage){
		if (pchPurchaseMessage !=null && pchPurchaseMessage.getDelFlag().equals("0")) {
			pchPurchaseMessageService.update(pchPurchaseMessage);
			String msg = "修改成功!";
			model.addAttribute("msg", msg);
		}
		model.addAttribute("pchPurchaseMessage", pchPurchaseMessageService.get(pchPurchaseMessage));
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		return "moudlues/pch/pchPurchaseMessage_update";
		
	}
	@RequestMapping("/show.do")
	public String show(Model model,PchPurchaseMessage pchPurchaseMessage){
	   PchPurchaseMessage pchPurchaseMessage2 = pchPurchaseMessageService.get(pchPurchaseMessage);
	   model.addAttribute("pchPurchaseMessage", pchPurchaseMessage2);
		return "moudlues/pch/pchPurchaseMessage_show";
		
	}
	//获取仓库的计量单位和现库存量
	@RequestMapping("/getWhWharehouseComputingUnit.do")
	@ResponseBody
	public Object getWhWharehouseComputingUnitAndCuttentInventory(Model model,WhWarehouse whWarehouse){
	   WhWarehouse warehouse = whWarehouseService.get(whWarehouse);
	   model.addAttribute("whWarehouse", warehouse);
	   HashMap<String, Object> date = new HashMap<>();
	   date.put("computingUnit", warehouse.getComputingUnit());
	   date.put("cuttentInventory", warehouse.getCurrentInventory());
		return date;
		
	}
	//限制物品的大小
	@RequestMapping("/limitNum.do")
	@ResponseBody
	public Object limitNum(Model model,WhWarehouse whWarehouse){
	  
//	   HashMap<String, Object> date = new HashMap<>();
//	   date.put("computingUnit", warehouse.getComputingUnit());
		return null;
		
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
	//采购申请
	@RequestMapping("/apply.do")
	public String apply(Model model, PchPurchaseMessage pchPurchaseMessage){
		if(pchPurchaseMessage.getName() != null && pchPurchaseMessage.getDelFlag().equals("0")){
			pchPurchaseMessageService.apply(pchPurchaseMessage);
			String msg = "申请成功，等待后勤管理员审核!";
			model.addAttribute("msg", msg);
		}
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		return "moudlues/pch/pchPurchaseMessage_apply";
		
	}
	//审核
	@RequestMapping("/audit.do")
	@ResponseBody
	public Object audit(Model model, PchPurchaseMessage pchPurchaseMessage){
		   pchPurchaseMessageService.audit(pchPurchaseMessage);//只是改变状态
		   HashMap<String, Object> data = new HashMap<>();
		   data.put("data", "shnehe");
			return data;
			
		}
	//确认完成
		@RequestMapping("/comfirm.do")
		@ResponseBody
		public Object comfirm(Model model, PchPurchaseMessage pchPurchaseMessage){
			   pchPurchaseMessageService.comfirm(pchPurchaseMessage);//这只是改变状态
			   HashMap<String, Object> data = new HashMap<>();
			   data.put("data", "完成");
				return data;
				
			}	
}
