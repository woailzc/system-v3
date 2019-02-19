package com.logistics.system.modlues.wh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logistics.system.common.baseService.CrudService;
import com.logistics.system.modlues.wh.dao.WhWarehouseAndApplyCodeDao;
import com.logistics.system.modlues.wh.dao.WhWarehouseApplyDao;
import com.logistics.system.modlues.wh.dao.WhWarehouseDao;
import com.logistics.system.modlues.wh.entity.WhWarehouse;
import com.logistics.system.modlues.wh.entity.WhWarehouseAndApplyCode;
import com.logistics.system.modlues.wh.entity.WhWarehouseApply;




@Service
@Transactional(readOnly = false)
public class WhWarehouseAndApplyCodeService extends CrudService<WhWarehouseAndApplyCodeDao, WhWarehouseAndApplyCode>{	

}
