package com.logistics.system.modlues.ctn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logistics.system.common.baseService.CrudService;
import com.logistics.system.modlues.ctn.dao.CtnFoodDao;
import com.logistics.system.modlues.ctn.entity.CtnFood;
import com.logistics.system.modlues.nt.dao.NtNoticeDao;
import com.logistics.system.modlues.nt.entity.NtNotice;
import com.logistics.system.modlues.sys.dao.SysDepartmentDao;
import com.logistics.system.modlues.sys.dao.SysUserDao;
import com.logistics.system.modlues.sys.entity.SysDepartment;
import com.logistics.system.modlues.sys.entity.SysUser;




@Service
@Transactional(readOnly = false)
public class CtnFoodService extends CrudService<CtnFoodDao, CtnFood>{
	
	@Autowired
	CtnFoodDao ctnFoodDao;
	
	public void dateOutAndRecovery(CtnFood ctnFood){
		ctnFoodDao.updateStatus(ctnFood);
	}
	
	

}
