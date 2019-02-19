package com.logistics.system.modlues.ast.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.logistics.system.modlues.ast.dao.AstFixedCapitalDao;
import com.logistics.system.modlues.ast.dao.AstSpecialCapitalDao;
import com.logistics.system.modlues.ast.dao.AstWorkingCapitalDao;
import com.logistics.system.modlues.ast.entity.AstWorkingCapital;
import com.logistics.system.modlues.ast.service.AstWorkingCapitalService;
import com.logistics.system.modlues.sys.entity.SysUser;
import com.logistics.system.modlues.sys.service.SysDepartmentService;

@Controller
@RequestMapping("/a/astCapitalStatistics")
public class AstCapitalStatisticsController {
	
	@Autowired
	AstWorkingCapitalDao astWorkingCapitalDao;
	@Autowired
	AstSpecialCapitalDao astSpecialCapitalDao;
	@Autowired
	AstFixedCapitalDao astFixedCapitalDao;
	
	
	@RequestMapping("/lsit.do")
	public String list(Model model){
		
		int astWorkingCapital = astWorkingCapitalDao.statistics();
		int astSpecialCapital = astSpecialCapitalDao.statistics();
		int astFixedCapital = astFixedCapitalDao.statistics();
		
		model.addAttribute("astWorkingCapital", astWorkingCapital);
		model.addAttribute("astSpecialCapital", astSpecialCapital);
		model.addAttribute("astFixedCapital", astFixedCapital);
	
		return "moudlues/ast/astCapitaStatistics";
		
	}

}
