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
import com.logistics.system.modlues.pty.dao.PtyPropertyDao;
import com.logistics.system.modlues.pty.entity.PtyProperty;
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
	@Autowired
	PtyPropertyDao ptyPropertyDao;
	
	public void acceptAndFinish(ReRepairOrder reRepairOrder,String type){
		repairOrderDao.updateStatus(reRepairOrder);
		if(reRepairOrder.getStatus().equals("已完成")){
//			reRepairOrder.setUpdateDate(new Date());
			if(type.equals("1")){//设备
			repairOrderDao.updateDate(reRepairOrder);
			AstFixedCapital astFixedCapital = astFixedCapitalDao.getByName(reRepairOrder.getContex());
			astFixedCapital.setRepairStatus("正常");
			astFixedCapitalDao.updateRepairStatus(astFixedCapital);
			
		}
			if(type.equals("2")){//物业
				repairOrderDao.updateDate(reRepairOrder);
				PtyProperty ptyProperty = ptyPropertyDao.getByName(reRepairOrder.getContex());
				ptyProperty.setStatus("正常");
				ptyPropertyDao.updateStatus(ptyProperty);
				
			}
		
	}
	}

}
