package com.logistics.system.modlues.ctn.dao;



import com.logistics.system.common.baseDao.CrudDao;
import com.logistics.system.modlues.ctn.entity.CtnFood;


public interface CtnFoodDao extends CrudDao<CtnFood> {
	
	public void updateStatus(CtnFood ctnFood);

}