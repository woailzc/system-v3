package com.logistics.system.modlues.re.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logistics.system.common.baseService.CrudService;
import com.logistics.system.modlues.ast.dao.AstFixedCapitalDao;
import com.logistics.system.modlues.ast.entity.AstFixedCapital;
import com.logistics.system.modlues.nt.dao.NtNoticeDao;
import com.logistics.system.modlues.nt.entity.NtNotice;
import com.logistics.system.modlues.re.dao.ReRepairOrderDao;
import com.logistics.system.modlues.re.entity.ReRepairOrder;
import com.logistics.system.modlues.sys.dao.SysDepartmentDao;
import com.logistics.system.modlues.sys.dao.SysUserDao;
import com.logistics.system.modlues.sys.entity.SysDepartment;
import com.logistics.system.modlues.sys.entity.SysUser;
import com.sun.org.apache.xpath.internal.operations.And;




@Service
@Transactional(readOnly = false)
public class ReRepairOrderService extends CrudService<ReRepairOrderDao, ReRepairOrder>{
	
	@Autowired
	ReRepairOrderDao repairOrderDao;
	@Autowired
	AstFixedCapitalDao astFixedCapitalDao;
	
	public void acceptAndFinish(ReRepairOrder reRepairOrder){
		repairOrderDao.updateStatus(reRepairOrder);
		if(reRepairOrder.getStatus().equals("已完成")){
//			reRepairOrder.setUpdateDate(new Date());
			repairOrderDao.updateDate(reRepairOrder);
			AstFixedCapital astFixedCapital = astFixedCapitalDao.getByName(reRepairOrder.getContex());
			astFixedCapitalDao.updateRepairStatus(astFixedCapital);
		}
		
	}
	

}
