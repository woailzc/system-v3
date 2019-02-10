package com.logistics.system.modlues.sys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logistics.system.common.baseService.CrudService;
import com.logistics.system.modlues.sys.dao.SysPermissionDao;
import com.logistics.system.modlues.sys.dao.SysRoleDao;
import com.logistics.system.modlues.sys.dao.SysUserDao;
import com.logistics.system.modlues.sys.entity.SysPermission;
import com.logistics.system.modlues.sys.entity.SysRole;
import com.logistics.system.modlues.sys.entity.SysUser;




@Service
@Transactional(readOnly = false)
public class SysRoleService extends CrudService<SysRoleDao, SysRole>{
	@Autowired 
	SysRoleDao sysRoleDao;
	//保存
	public void save(SysRole sysRole,String[] premissionIds){
		super.save(sysRole);
//		SysRole sysRole2 = super.get(sysRole);
		String roleId = sysRole.getId();
		for(int i=0;i<premissionIds.length;i++){
			sysRoleDao.savePermissonByid(roleId,premissionIds[i]);
		}
		
	}
	

}
