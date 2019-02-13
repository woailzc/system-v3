package com.logistics.system.modlues.re.dao;


import org.apache.ibatis.annotations.Param;

import com.logistics.system.common.baseDao.CrudDao;
import com.logistics.system.modlues.nt.entity.NtNoticeType;
import com.logistics.system.modlues.re.entity.ReRepairOrderType;
import com.logistics.system.modlues.sys.entity.SysDepartment;
import com.logistics.system.modlues.sys.entity.SysUser;

import java.util.List;

public interface ReRepairOrderTypeDao extends CrudDao<ReRepairOrderType> {

}