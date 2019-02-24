package com.logistics.system.modlues.sys.service;

import java.util.Iterator;

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
	//更新
		public void update(SysRole sysRole ,String[] premissionIds){
			super.update(sysRole);
			sysRoleDao.deleteRolePermisson(sysRole);//先删除原来的权限
			String roleId = sysRole.getId();
			for (int i = 0; i < premissionIds.length; i++) {//然后再插入新的权限,从而达到更新的目的
				sysRoleDao.savePermissonByid(roleId,premissionIds[i]);
			}
		}
	//删除
		public void delete(SysRole sysRole){
			super.delete(sysRole);
			sysRoleDao.deleteRolePermisson(sysRole);
		}


}
