package com.logistics.system.modlues.wh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logistics.system.common.baseService.CrudService;
import com.logistics.system.modlues.ad.dao.AdAdviceDao;
import com.logistics.system.modlues.ad.entity.AdAdvice;
import com.logistics.system.modlues.nt.dao.NtNoticeDao;
import com.logistics.system.modlues.nt.entity.NtNotice;
import com.logistics.system.modlues.sys.dao.SysDepartmentDao;
import com.logistics.system.modlues.sys.dao.SysUserDao;
import com.logistics.system.modlues.sys.entity.SysDepartment;
import com.logistics.system.modlues.sys.entity.SysUser;
import com.logistics.system.modlues.wh.dao.WhWarehouseTypeDao;
import com.logistics.system.modlues.wh.entity.WhWarehouseType;




@Service
@Transactional(readOnly = true)
public class WhWarehouseTypeService extends CrudService<WhWarehouseTypeDao, WhWarehouseType>{
	

}
