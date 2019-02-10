package com.logistics.system.modlues.shiroTest.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.logistics.system.modlues.shiroTest.entity.Permission;
import com.logistics.system.modlues.shiroTest.entity.User;




/**
 * Created by Administrator on 2017/10/10.
 */
@Component
public interface ShiroDao {

    /**
     * 根据账号获取账号密码
     * @param username
     * @return UserPojo
     */
    User getUserByUserName(String username);

    /**
     * 根据角色id获取该账号的权限
     * @param roleId
     * @return List
     */
    List<Permission> getPermissionsByRoleId(int roleId);

    /**
     * 根据userId获取角色id
     * @param id
     * @return LIST
     */
    List<Integer> getUserRoleByUserId(int id);
    
    public List<User> findAllUser(User user);

}
