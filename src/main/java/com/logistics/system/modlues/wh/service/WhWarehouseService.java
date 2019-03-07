package com.logistics.system.modlues.wh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logistics.system.common.baseService.CrudService;
import com.logistics.system.modlues.ad.dao.AdAdviceDao;
import com.logistics.system.modlues.ad.entity.AdAdvice;
import com.logistics.system.modlues.ast.dao.AstFixedCapitalDao;
import com.logistics.system.modlues.ast.entity.AstFixedCapital;
import com.logistics.system.modlues.nt.dao.NtNoticeDao;
import com.logistics.system.modlues.nt.entity.NtNotice;
import com.logistics.system.modlues.sys.dao.SysDepartmentDao;
import com.logistics.system.modlues.sys.dao.SysUserDao;
import com.logistics.system.modlues.sys.entity.SysDepartment;
import com.logistics.system.modlues.sys.entity.SysUser;
import com.logistics.system.modlues.wh.dao.WhWarehouseApplyDao;
import com.logistics.system.modlues.wh.dao.WhWarehouseDao;
import com.logistics.system.modlues.wh.entity.WhWarehouse;
import com.logistics.system.modlues.wh.entity.WhWarehouseApply;




@Service
@Transactional(readOnly = false)
public class WhWarehouseService extends CrudService<WhWarehouseDao, WhWarehouse>{
	
	@Autowired
	WhWarehouseDao whWarehouseDao;
	@Autowired
	WhWarehouseApplyDao whWarehouseApplyDao;
	@Autowired
	AstFixedCapitalDao astFixedCapitalDao;
	
	public void aduit(WhWarehouse whWarehouse,WhWarehouseApply whWarehouseApply){
		whWarehouseDao.updateStatus(whWarehouse);
		whWarehouseApplyDao.updateSuggestion(whWarehouseApply);
	}

	public void stop(WhWarehouse whWarehouse) {
		whWarehouseDao.updateStatus(whWarehouse);
	}
	
	//申请入库审核
	public void aduitApply(AstFixedCapital astFixedCapital){
	
		astFixedCapitalDao.updateStatus(astFixedCapital);
	    if(astFixedCapital.getStatus().equals("已入仓")){
	    	if(astFixedCapital.getWhWarehouse()!= null){
	    	WhWarehouse whWarehouse = whWarehouseDao.get(astFixedCapital.getWhWarehouse());
			whWarehouse.setCurrentInventory(whWarehouse.getCurrentInventory()-astFixedCapital.getNum());
			whWarehouseDao.updateCurrentInventory(whWarehouse);
	    	}
		}
			
	}

}
