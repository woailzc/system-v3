package com.logistics.system.modlues.sys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logistics.system.common.baseService.CrudService;
import com.logistics.system.modlues.sys.dao.SysPermissionDao;
import com.logistics.system.modlues.sys.dao.SysUserDao;
import com.logistics.system.modlues.sys.entity.SysPermission;
import com.logistics.system.modlues.sys.entity.SysUser;



@Service
@Transactional(readOnly = true)
public class SysPermissionService extends CrudService<SysPermissionDao, SysPermission>{
	

}
