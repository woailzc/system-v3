package com.logistics.system.modlues.cl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logistics.system.common.baseService.CrudService;
import com.logistics.system.modlues.cl.dao.ClCleanDao;
import com.logistics.system.modlues.cl.entity.ClClean;
import com.logistics.system.modlues.nt.dao.NtNoticeDao;
import com.logistics.system.modlues.nt.entity.NtNotice;
import com.logistics.system.modlues.re.dao.ReRepairOrderDao;
import com.logistics.system.modlues.re.entity.ReRepairOrder;
import com.logistics.system.modlues.sys.dao.SysDepartmentDao;
import com.logistics.system.modlues.sys.dao.SysUserDao;
import com.logistics.system.modlues.sys.entity.SysDepartment;
import com.logistics.system.modlues.sys.entity.SysUser;




@Service
@Transactional(readOnly = false)
public class ClCleanService extends CrudService<ClCleanDao, ClClean>{
	@Autowired
	ClCleanDao clCleanDao;
	
	public void acceptAndFinish(ClClean clClean){
		clCleanDao.updateStatus(clClean);
		if(clClean.getStatus().equals("已完成")){
			clCleanDao.updateDate(clClean);
		}
	}
	

}
