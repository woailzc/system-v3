package com.logistics.system.modlues.sys.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.logistics.system.modlues.sys.entity.SysDepartment;
import com.logistics.system.modlues.sys.entity.SysRole;
import com.logistics.system.modlues.sys.entity.SysUser;
import com.logistics.system.modlues.sys.service.SysDepartmentService;
import com.logistics.system.modlues.sys.service.SysRoleService;
import com.logistics.system.modlues.sys.service.SysUserService;

/**
 * 个人信息和用户的所有信息模块
 * @author lzc
 *
 */
@Controller
@RequestMapping("/a/sysUser")
public class SysUserController {
	@Autowired
	SysUserService sysUserService;
	
	@Autowired
	SysRoleService sysRoleService;
	
	@Autowired
	SysDepartmentService sysDepartmentService;
//    //保存
//	@RequestMapping(value="/save.do")
//	public String save(Model model,@RequestParam MultipartFile Mphoto,SysUser sysUser,HttpSession session) throws IllegalStateException, IOException {
//		//如果del_flag是0的话代表是post提交，要做数据保存
//		if (sysUser !=null && sysUser.getDelFlag().equals("0")) {
//			sysUserService.save(sysUser,Mphoto,session);
//			String msg = "添加成功!";
//			model.addAttribute("msg", msg);
////			return "moudlues/sys/sysOUser_add";
//		}
//		List<SysDepartment> sysDepartments = sysDepartmentService.findList(new SysDepartment());
//		List<SysRole> sysRoles = sysRoleService.findList(new SysRole());
//		model.addAttribute("sysDepartments", sysDepartments);
//		model.addAttribute("sysRoles", sysRoles);
//		model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
//		return "moudlues/sys/sysOUser_add";
//	}
//	 //保存
		@RequestMapping(value="/save.do",method=RequestMethod.POST)
		public String save(Model model,@RequestParam MultipartFile Mphoto,SysUser sysUser,HttpSession session) throws IllegalStateException, IOException{
			
			if (sysUser !=null && sysUser.getDelFlag().equals("0")) {
				sysUserService.save(sysUser,Mphoto,session);
				String msg = "添加成功!";
				model.addAttribute("msg", msg);
			}
			return "moudlues/sys/sysUser_add";
		}
		@RequestMapping(value="/save.do",method=RequestMethod.GET)
		public String save2(Model model,SysUser sysUser){
			List<SysDepartment> sysDepartments = sysDepartmentService.findList(new SysDepartment());
			List<SysRole> sysRoles = sysRoleService.findList(new SysRole());
			model.addAttribute("sysDepartments", sysDepartments);
			model.addAttribute("sysRoles", sysRoles);
			model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
			return "moudlues/sys/sysUser_add";
		}
	//列表上用户的信息，post请求的更新，要做更新
	@RequestMapping(value="/update.do",method=RequestMethod.POST)
	public String updateForPost(Model model,SysUser sysUser){
//		String passwordMD5 =DigestUtils.md5Hex(sysOUser.getPassword());
//		sysOUser.setPassword(passwordMD5);
		if(sysUser.getId()==null || sysUser.getId()==""){
			SysUser currentUser = (SysUser)SecurityUtils.getSubject().getPrincipal();
			sysUser.setId(currentUser.getId());
			}
		sysUserService.update(sysUser);
		String msg = "修改成功!";
		model.addAttribute("msg", msg);
		return "moudlues/sysMsgM/sysMsgM_SysOUserUpdate";
	}
	//get请求的更新，不做更新，只负责跳转页面
	@RequestMapping(value="/update.do",method=RequestMethod.GET)
	public String updateForGet(Model model,SysUser sysUser){
		model.addAttribute("currentSysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		if(sysUser.getId() == null || sysUser.getId() == ""){
			model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
			return "moudlues/sys/sysUser_update";
		}
		sysUserService.get(sysUser);
		model.addAttribute("sysUser", sysUser);
		return "moudlues/sys/sysUser_update";
	}
	//post更新密码
	@RequestMapping(value="/updatePassword.do",method=RequestMethod.POST)
	public String updatePasswordForPost(Model model,SysUser sysUser){
//		String passwordMD5 =DigestUtils.md5Hex(sysOUser.getPassword());
		sysUserService.updatePasswordById(sysUser);
		return "moudlues/sys/sysUser_updatePassword";
	}
	//get更新密码
	@RequestMapping(value="/updatePassword.do",method=RequestMethod.GET)
	public String updatePasswordForGet(Model model,SysUser sysUser){
		 model.addAttribute("currentSysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
	     if(sysUser.getId() == null || sysUser.getId() == ""){
	    	 model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
			 return "moudlues/sys/sysUser_updatePassword";
	     }
	     SysUser sysUser2 = sysUserService.get(sysUser);
	     model.addAttribute("sysUser", sysUser2);
		return "moudlues/sys/sysUser_updatePassword";
	}
	//更新头像
	@RequestMapping(value="/updatePhoto.do",method=RequestMethod.POST)
	public String updatePhotoForPost(Model model,@RequestParam MultipartFile Mphoto,SysUser sysUser,HttpSession session) throws IllegalStateException, IOException{
		 model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		 sysUserService.updatePhoto(sysUser, Mphoto, session);
		return "moudlues/sys/sysUser_updatePhoto";
		
	}
	@RequestMapping(value="/updatePhoto.do",method=RequestMethod.GET)
	public String updatePhotoForGet(Model model,SysUser sysUser){
		 model.addAttribute("sysUser", (SysUser)SecurityUtils.getSubject().getPrincipal());
		return "moudlues/sys/sysUser_updatePhoto";
		
	}
	//逻辑上删除
	@RequestMapping("/del.do")
	@ResponseBody
	public String del(Model model,SysUser sysUser){
		sysUserService.delete(sysUser);
	    return "删除成功";
	}
	//查询个人信息
	@RequestMapping("/show.do")
	public String from(Model model,SysUser sysUser){
	    SysUser sysUser2 = sysUserService.get(sysUser);
	    model.addAttribute("sysUser", sysUser2);
		return "moudlues/sys/sysUser_show";
	}
	//展示所有用户和分页查询用户（前台已做好分页）
	@RequestMapping("/list.do")
	public String list(Model model,SysUser sysUser){
		List<SysUser> sysUserList = sysUserService.findList(sysUser);
		model.addAttribute("sysUserList", sysUserList);
		return "moudlues/sys/sysUser_list";
	}

}
