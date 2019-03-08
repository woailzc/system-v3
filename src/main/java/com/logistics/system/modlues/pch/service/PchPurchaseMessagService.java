package com.logistics.system.modlues.pch.service;

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
import com.logistics.system.modlues.pch.dao.PchPurchaseMessageDao;
import com.logistics.system.modlues.pch.entity.PchPurchaseMessage;
import com.logistics.system.modlues.sys.dao.SysDepartmentDao;
import com.logistics.system.modlues.sys.dao.SysUserDao;
import com.logistics.system.modlues.sys.entity.SysDepartment;
import com.logistics.system.modlues.sys.entity.SysUser;
import com.logistics.system.modlues.wh.dao.WhWarehouseDao;
import com.logistics.system.modlues.wh.entity.WhWarehouse;




@Service
@Transactional(readOnly = false)
public class PchPurchaseMessagService extends CrudService<PchPurchaseMessageDao, PchPurchaseMessage>{
	@Autowired
	WhWarehouseDao whWarehouseDao;
	@Autowired
	PchPurchaseMessageDao pchPurchaseMessageDao;
	@Autowired
	AstFixedCapitalDao astFixedCapitalDao;
	
	public void save(PchPurchaseMessage pchPurchaseMessage){
		super.save(pchPurchaseMessage);
		WhWarehouse whWarehouse = whWarehouseDao.get(pchPurchaseMessage.getWhWarehouse());
		whWarehouse.setCurrentInventory(whWarehouse.getCurrentInventory()-pchPurchaseMessage.getNum());
		whWarehouseDao.updateCurrentInventory(whWarehouse);
	}
	
	public void audit(PchPurchaseMessage pchPurchaseMessage){
		pchPurchaseMessageDao.updateStatus(pchPurchaseMessage);
	}

	public void apply(PchPurchaseMessage pchPurchaseMessage) {
		super.save(pchPurchaseMessage);
		
	}

	public void comfirm(PchPurchaseMessage pchPurchaseMessage) {
		
		pchPurchaseMessageDao.updateStatus(pchPurchaseMessage);
		PchPurchaseMessage pchPurchaseMessage2 = pchPurchaseMessageDao.get(pchPurchaseMessage);
		AstFixedCapital astFixedCapital = new AstFixedCapital();
		astFixedCapital.setSource("采购");
		astFixedCapital.setName(pchPurchaseMessage2.getName());
		astFixedCapital.setUseWay(pchPurchaseMessage2.getUseWay());
		astFixedCapital.setNum(pchPurchaseMessage2.getNum());
		astFixedCapital.setModel(pchPurchaseMessage2.getModel());
		astFixedCapital.setSpecifications(pchPurchaseMessage2.getSpecifications());
		astFixedCapital.setStatus("正常");
		astFixedCapital.setRepairStatus("正常");
		astFixedCapital.setCreateBy(pchPurchaseMessage2.getCreateBy());//采购人
		astFixedCapital.setUnitPrice(pchPurchaseMessage2.getUnitPrice());
		astFixedCapitalDao.insert(astFixedCapital);
		
	}
	

}
