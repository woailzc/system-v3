package com.logistics.system.common.baseWeb;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.logistics.system.modlues.redisTest.service.RedisSendService;
import com.logistics.system.modlues.shiroTest.entity.User;
import com.logistics.system.modlues.sys.entity.SysUser;


@Controller
@RequestMapping("/a")
public class LoginController {
	@Autowired
	RedisSendService redisSendService;
	
	@RequestMapping("/login.do")
	public String login(Model model ,SysUser sysUser){
		
	        //主体,当前状态为没有认证的状态“未认证”
	        Subject subject = SecurityUtils.getSubject();
	        if(sysUser == null || sysUser.getLoginName()==null||sysUser.getLoginName()==""){
	        	return "common/login";
	        }
	        // 登录后存放进shiro token
	        UsernamePasswordToken token=new UsernamePasswordToken(sysUser.getLoginName(),sysUser.getPassword());
	        //登录方法（认证是否通过）
	        //使用subject调用securityManager,安全管理器调用Realm
	        try {
	            //利用异常操作
	            //需要开始调用到Realm中
	            System.out.println("========================================");
	            System.out.println("1、进入认证方法");
	            subject.login(token);
	            model.addAttribute("message", "登录完成");
	            System.out.println("登录完成");
	            redisSendService.sendMessage("channel1", "登录完成");
	            return "redirect:" + "/a/index.do";	
	        } catch (UnknownAccountException e) {
	            model.addAttribute("message", "账号密码不正确");
	            return "common/login";
	        }
	    }
	 @RequestMapping("/check.do")
	    public String check(HttpSession session){

//	        Subject subject=(Subject)session.getAttribute("user");
	        Subject subject = SecurityUtils.getSubject();
	        User user=(User)subject.getPrincipal();
	        System.out.println(user.toString());
	        return "permission";
	    }

	    @RequestMapping("/readName.do")
	    public String readName(HttpSession session){

	        return "name";
	    }

	    @RequestMapping("/readData.do")
	    public String readData(){

	        return "data";
	    }


	    @RequestMapping("/nopermission.do")
	    public String noPermission(){
	        return "error";
	    }

}
