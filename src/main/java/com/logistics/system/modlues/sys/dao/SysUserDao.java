package com.logistics.system.modlues.sys.dao;


import org.apache.ibatis.annotations.Param;

import com.logistics.system.common.baseDao.CrudDao;
import com.logistics.system.modlues.sys.entity.SysUser;

import java.util.List;

public interface SysUserDao extends CrudDao<SysUser> {

	public void updatePasswordById(SysUser sysUser);
	
	public void updatePhoto(SysUser sysUser);

}