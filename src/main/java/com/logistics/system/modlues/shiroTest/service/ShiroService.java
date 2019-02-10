package com.logistics.system.modlues.shiroTest.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logistics.system.modlues.shiroTest.dao.ShiroDao;
import com.logistics.system.modlues.shiroTest.entity.Permission;
import com.logistics.system.modlues.shiroTest.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/10.
 */
@Service("shiroService")
public class ShiroService {

    @Autowired
    private ShiroDao shiroDao;
    
 /*   @Autowired
    JedisUtil jedisUtil;*/

    public User getUserByUserName(String username) {
        //根据账号获取账号密码
        User userByUserName = shiroDao.getUserByUserName(username);
        return userByUserName;
    }

    public List<Permission> getPermissionsByUser(User user) {
        //获取到用户角色userRole
        List<Integer> roleId = shiroDao.getUserRoleByUserId(user.getId());
        List<User> _users =  shiroDao.findAllUser(new User());
//        if(jedisUtil.getObjs("users") != null && jedisUtil.getObjs("users").size()>0){
//        	List<User> users = jedisUtil.getObjs("users");
//        }else {
//			jedisUtil.addObjs("users",_users);
//		}
        List<Permission> perArrary = new ArrayList<>();

        if (roleId!=null&&roleId.size()!=0) {
            //根据roleid获取peimission
            for (Integer i : roleId) {
                perArrary.addAll(shiroDao.getPermissionsByRoleId(i));
            }
        }

        System.out.println(perArrary);
        return perArrary;
    }


}
