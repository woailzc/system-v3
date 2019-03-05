package com.logistics.system.modlues.pch.dao;


import org.apache.ibatis.annotations.Param;

import com.logistics.system.common.baseDao.CrudDao;
import com.logistics.system.modlues.ad.entity.AdAdvice;
import com.logistics.system.modlues.nt.entity.NtNotice;
import com.logistics.system.modlues.pch.entity.PchPurchaseMessage;
import com.logistics.system.modlues.sys.entity.SysDepartment;
import com.logistics.system.modlues.sys.entity.SysUser;
import com.logistics.system.modlues.wh.entity.WhWarehouse;

import java.util.List;

public interface PchPurchaseMessageDao extends CrudDao<PchPurchaseMessage> {
	public void updateStatus(PchPurchaseMessage pchPurchaseMessage);
	

}