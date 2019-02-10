package com.logistics.system.modlues.sys.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logistics.system.common.baseService.CrudService;
import com.logistics.system.modlues.sys.dao.SysMenuDao;
import com.logistics.system.modlues.sys.entity.SysMenu;



@Service
@Transactional(readOnly = true)
public class SysMenuService extends CrudService<SysMenuDao, SysMenu>{
	
	

}
