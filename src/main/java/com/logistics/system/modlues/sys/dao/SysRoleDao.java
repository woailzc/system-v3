package com.logistics.system.modlues.sys.dao;


import org.apache.ibatis.annotations.Param;

import com.logistics.system.common.baseDao.CrudDao;
import com.logistics.system.modlues.sys.entity.SysDepartment;
import com.logistics.system.modlues.sys.entity.SysRole;
import com.logistics.system.modlues.sys.entity.SysUser;

import java.util.List;

public interface SysRoleDao extends CrudDao<SysRole> {
	
	public void savePermissonByid(String roleId,String pid);

}