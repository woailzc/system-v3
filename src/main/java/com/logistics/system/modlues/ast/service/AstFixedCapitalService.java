package com.logistics.system.modlues.ast.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logistics.system.common.baseService.CrudService;
import com.logistics.system.modlues.ast.dao.AstFixedCapitalDao;
import com.logistics.system.modlues.ast.entity.AstFixedCapital;
import com.logistics.system.modlues.nt.dao.NtNoticeDao;
import com.logistics.system.modlues.nt.entity.NtNotice;
import com.logistics.system.modlues.sys.dao.SysDepartmentDao;
import com.logistics.system.modlues.sys.dao.SysUserDao;
import com.logistics.system.modlues.sys.entity.SysDepartment;
import com.logistics.system.modlues.sys.entity.SysUser;




@Service
@Transactional(readOnly = false)
public class AstFixedCapitalService extends CrudService<AstFixedCapitalDao, AstFixedCapital>{

	@Autowired
	AstFixedCapitalDao astFixedCapitalDao;
	
	public void applyInWarehouse(AstFixedCapital astFixedCapital) {
		
		astFixedCapitalDao.updateStatus(astFixedCapital);
		astFixedCapitalDao.updateWarehouse(astFixedCapital);
		
	}
	
	public AstFixedCapital getByName(String name){
		
		return astFixedCapitalDao.getByName(name);
		
	}
	
	public void updateRepairStatus(AstFixedCapital astFixedCapital){
		astFixedCapitalDao.updateRepairStatus(astFixedCapital);
	}
	

}
