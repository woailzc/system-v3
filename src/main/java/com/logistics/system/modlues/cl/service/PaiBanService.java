package com.logistics.system.modlues.cl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logistics.system.common.baseService.CrudService;
import com.logistics.system.modlues.cl.dao.ClCleanAreaDao;
import com.logistics.system.modlues.cl.dao.ClCleanDao;
import com.logistics.system.modlues.cl.dao.PaiBanDao;
import com.logistics.system.modlues.cl.entity.ClClean;
import com.logistics.system.modlues.cl.entity.ClCleanArea;
import com.logistics.system.modlues.cl.entity.PaiBan;
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
public class PaiBanService extends CrudService<PaiBanDao, PaiBan>{
	@Autowired
	PaiBanDao paiBanDao;

	public void intit(PaiBan paiBan) {
		//早班
		for(int j = 1; j<8; j++){
			paiBan.setBeginTime(paiBan.getBeginTime1());
			paiBan.setEndTime(paiBan.getEndTime1());
			paiBan.setBanci(1);
			paiBan.setWeek(j);
			paiBanDao.insert(paiBan);
		}
		//中班
		for(int j = 1; j<8; j++){
			paiBan.setBeginTime(paiBan.getBeginTime2());
			paiBan.setEndTime(paiBan.getEndTime2());
			paiBan.setBanci(2);
			paiBan.setWeek(j);
			paiBanDao.insert(paiBan);
		}
		//晚班
		for(int j = 1; j<8; j++){
			paiBan.setBeginTime(paiBan.getBeginTime3());
			paiBan.setEndTime(paiBan.getEndTime3());
			paiBan.setBanci(3);
			paiBan.setWeek(j);
			paiBanDao.insert(paiBan);
		}		
  }
}
