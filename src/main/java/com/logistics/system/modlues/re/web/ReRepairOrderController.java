package com.logistics.system.modlues.re.web;

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

import com.logistics.system.modlues.ast.entity.AstFixedCapital;
import com.logistics.system.modlues.ast.service.AstFixedCapitalService;
import com.logistics.system.modlues.pty.entity.PtyProperty;
import com.logistics.system.modlues.pty.service.PtyPropertyService;
import com.logistics.system.modlues.re.entity.ReRepairOrder;
import com.logistics.system.modlues.re.entity.ReRepairOrderType;
import com.logistics.system.modlues.re.service.ReRepairOrderService;
import com.logistics.system.modlues.re.service.ReRepairOrderTypeService;
import com.logistics.system.modlues.sys.entity.SysDepartment;
import com.logistics.system.modlues.sys.entity.SysUser;
import com.logistics.system.modlues.sys.service.SysDepartmentService;
import com.logistics.system.modlues.sys.service.SysUserService;

@Controller
@RequestMapping("/a/reRepairOrder")
public class ReRepairOrderController {
	
	@Autowired
	ReRepairOrderService reRepairOrderService;
	
	@Autowired
	ReRepairOrderTypeService reRepairOrderTypeService;
	
	@Autowired
	SysDepartmentService sysDepartmentService;
	
	@Autowired
	SysUserService sysUserService;
	
	@Autowired
	PtyPropertyService ptyPropertyService;
	
	@Autowired
	AstFixedCapitalService astFixedCapitalService;
	
	@RequestMapping("/save.do")
	public String save(Model model,ReRepairOrder reRepairOrder,String type){
		
		if (reRepairOrder !=null && reRepairOrder.getDelFlag().equals("0")) {
			if(type.equals("1")){
				AstFixedCapital astFixedCapital = astFixedCapitalService.getByName(reRepairOrder.getContex());
				astFixedCapital.setRepairStatus("维修中");
				astFixedCapitalService.updateRepairStatus(astFixedCapital);
			}
			if(type.equals("2")){
				PtyProperty ptyProperty = ptyPropertyService.getByName(reRepairOrder.getContex());
				ptyProperty.setStatus("维修中");
				ptyPropertyService.updateStatus(ptyProperty);
			}
			reRepairOrderService.save(reRepairOrder);
			String msg = "添加成功!";
			model.addAttribute("msg", msg);
		}
		List contexts = new ArrayList<>();
		if(type.equals("1")) contexts = astFixedCapitalService.findList(new AstFixedCapital());//1代表设备维修
		if(type.equals("2"))  contexts = ptyPropertyService.findList(new PtyProperty());//2代表物业维修
		SysDepartment sysDepartment = sysDepartmentService.get(new SysDepartment(null,"维修部"));//维修部
		SysUser sysUser = new SysUser();
		sysUser.setSysDepartment(sysDepartment);
		List<SysUser> reRepairOrderUsers = sysUserService.findList(sysUser);
		List<ReRepairOrderType> reRepairOrderTypes = reRepairOrderTypeService.findList(new ReRepairOrderType());
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		model.addAttribute("reRepairOrderTypes", reRepairOrderTypes);
		model.addAttribute("reRepairOrderUsers", reRepairOrderUsers);
		model.addAttribute("contexts", contexts);
		model.addAttribute("type", type);//维修的内容区别
		return "moudlues/re/reRepairOrder_add";
		
	}
	


	@RequestMapping("/del.do")
	@ResponseBody
	public Object del(Model model,ReRepairOrder reRepairOrder){
		reRepairOrderService.delete(reRepairOrder);
		HashMap<String,Object> hashMap = new HashMap<>();
		hashMap.put("del", "删除成功");
	    return hashMap;
		
	}
	
	@RequestMapping("/list.do")
	public String list(Model model,ReRepairOrder reRepairOrder,String type){
		SysUser sysUser = (SysUser)SecurityUtils.getSubject().getPrincipal();
		reRepairOrder.setApplyer(sysUser);
		reRepairOrder.setReceiver(sysUser);
		List<ReRepairOrder> reRepairOrders = reRepairOrderService.findList(reRepairOrder);
		model.addAttribute("currentUser", sysUser);
		model.addAttribute("reRepairOrders", reRepairOrders);
		model.addAttribute("type", type);
		return "moudlues/re/reRepairOrder_list";
	}
	
	@RequestMapping("/update.do")
	public String update(Model model,ReRepairOrder reRepairOrder){
		if (reRepairOrder !=null && reRepairOrder.getDelFlag().equals("0")) {
			reRepairOrderService.update(reRepairOrder);
			String msg = "修改成功!";
			model.addAttribute("msg", msg);
		}
		SysDepartment sysDepartment = sysDepartmentService.get(new SysDepartment(null,"维修部"));//维修部
		SysUser sysUser = new SysUser();
		sysUser.setSysDepartment(sysDepartment);
		List<SysUser> reRepairOrderUsers = sysUserService.findList(sysUser);
		List<ReRepairOrderType> reRepairOrderTypes = reRepairOrderTypeService.findList(new ReRepairOrderType());
		model.addAttribute("reRepairOrder", reRepairOrderService.get(reRepairOrder));
		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		model.addAttribute("reRepairOrderTypes", reRepairOrderTypes);
		model.addAttribute("reRepairOrderUsers", reRepairOrderUsers);
		return "moudlues/re/reRepairOrder_update";
		
	}
	@RequestMapping("/show.do")
	public String show(Model model,ReRepairOrder reRepairOrder){
	   ReRepairOrder reRepairOrder2 = reRepairOrderService.get(reRepairOrder);
	   model.addAttribute("reRepairOrder", reRepairOrder2);
		return "moudlues/re/reRepairOrder_show";
		
	}
//接受和完成
	@RequestMapping("/acceptAndFinish.do")
	@ResponseBody
	public Object accept(Model model,ReRepairOrder reRepairOrder,String type){
	  if(reRepairOrder.getStatus().equals("已完成")) reRepairOrder.setUpdateDate(new Date());
	  reRepairOrderService.acceptAndFinish(reRepairOrder,type);
	   HashMap<String, Object> data = new HashMap<>();
	   data.put("status",reRepairOrder.getStatus() );
		return data;
		
	}
	
}
