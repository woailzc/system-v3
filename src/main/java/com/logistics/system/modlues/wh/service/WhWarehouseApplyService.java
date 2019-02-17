package com.logistics.system.modlues.wh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logistics.system.common.baseService.CrudService;

import com.logistics.system.modlues.wh.dao.WhWarehouseApplyDao;
import com.logistics.system.modlues.wh.dao.WhWarehouseDao;
import com.logistics.system.modlues.wh.entity.WhWarehouse;
import com.logistics.system.modlues.wh.entity.WhWarehouseApply;




@Service
@Transactional(readOnly = false)
public class WhWarehouseApplyService extends CrudService<WhWarehouseApplyDao, WhWarehouseApply>{
	@Autowired
	WhWarehouseDao warehouseDao;
	
	public void save(WhWarehouseApply whWarehouseApply){
		super.save(whWarehouseApply);
		WhWarehouse whWarehouse = whWarehouseApply.getWhWarehouse();
		whWarehouse.setStatus("审核");
		warehouseDao.update(whWarehouse);
	}
	

}
