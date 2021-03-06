package com.logistics.system.modlues.pty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logistics.system.common.baseService.CrudService;
import com.logistics.system.modlues.ast.entity.AstFixedCapital;
import com.logistics.system.modlues.nt.dao.NtNoticeDao;
import com.logistics.system.modlues.nt.entity.NtNotice;
import com.logistics.system.modlues.pty.dao.PtyPropertyDao;
import com.logistics.system.modlues.pty.entity.PtyProperty;
import com.logistics.system.modlues.sys.dao.SysDepartmentDao;
import com.logistics.system.modlues.sys.dao.SysUserDao;
import com.logistics.system.modlues.sys.entity.SysDepartment;
import com.logistics.system.modlues.sys.entity.SysUser;




@Service
@Transactional(readOnly = false)
public class PtyPropertyService extends CrudService<PtyPropertyDao, PtyProperty>{
	
	@Autowired
	PtyPropertyDao propertyDao;
	
	public PtyProperty getByName(String name){
		return propertyDao.getByName(name);
	}
	
	public void updateStatus(PtyProperty ptyProperty){
		
	       propertyDao.updateStatus(ptyProperty);
	}
	

}
