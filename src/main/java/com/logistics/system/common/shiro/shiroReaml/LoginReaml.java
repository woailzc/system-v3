package com.logistics.system.common.shiro.shiroReaml;



import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.logistics.system.modlues.sys.entity.SysPermission;
import com.logistics.system.modlues.sys.entity.SysRole;
import com.logistics.system.modlues.sys.entity.SysUser;
import com.logistics.system.modlues.sys.service.SysRoleService;
import com.logistics.system.modlues.sys.service.SysUserService;

import java.util.List;



public class LoginReaml extends AuthorizingRealm {
	@Autowired
	SysRoleService sysRoleService;
	@Autowired
	SysUserService sysUserService;
	
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
    	  System.out.println("进来授权了");
        /**
         *
         * 流程
         * 1.根据用户user->2.获取角色id->3.根据角色id获取权限permission
         */
        //方法一：获得user对象
        SysUser sysUser=(SysUser)pc.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获取permission
        if(sysUser!=null) {
//        	SysUser _sysUser = sysUserService.get(sysUser);
//        	SysRole sysRole = sysRoleService.get(_sysUser.getSysRole().getId());
        	if(sysUser.getSysRole() == null) return null;
        	SysRole sysRole = sysRoleService.get(sysUser.getSysRole());
            List<SysPermission> permissions = sysRole.getSysPermissions();
            if (permissions.size()!=0) {
            	
                for (SysPermission p: permissions) {

                    info.addStringPermission(p.getName());
                }
                return info;
            }
        }

        //方法二： 从subject管理器里获取user
//      Subject subject = SecurityUtils.getSubject();
//      User _user = (User) subject.getPrincipal();
//      System.out.println("subject"+_user.getUsername());




        return null;
    }

    // 认证方法
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("进来验证了");
        //验证账号密码
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        System.out.println("1:"+token.getUsername());
//        User user = shiroService.getUserByUserName(token.getUsername());
        SysUser sysUser = sysUserService.get(new SysUser(token.getUsername()));
        System.out.println("2");
        if(sysUser==null){
            return null;
        }
        //最后的比对需要交给安全管理器
        //三个参数进行初步的简单认证信息对象的包装
        AuthenticationInfo info = new SimpleAuthenticationInfo(sysUser, sysUser.getPassword(), this.getClass().getSimpleName());

        return info;
    }
}
