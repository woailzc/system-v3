package com.logistics.system.common.baseWeb;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.logistics.system.modlues.sys.entity.SysUser;

/**
 * 访问主页
 * @author 
 *
 */
@Controller
@RequestMapping("/a")
public class IndexController {
	
	@RequestMapping(value={"/index.do",""})
	public String index(Model model){
		   Subject subject = SecurityUtils.getSubject();
		   SysUser sysUser = (SysUser) subject.getPrincipal();
		   model.addAttribute("currentSysUser",sysUser);
			return "common/index";

		
	}

}
