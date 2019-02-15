package com.logistics.system.modlues.ctn.dao;


import org.apache.ibatis.annotations.Param;

import com.logistics.system.common.baseDao.CrudDao;
import com.logistics.system.modlues.ctn.entity.CtnFood;
import com.logistics.system.modlues.nt.entity.NtNotice;
import com.logistics.system.modlues.sys.entity.SysDepartment;
import com.logistics.system.modlues.sys.entity.SysUser;

import java.util.List;

public interface CtnFoodDao extends CrudDao<CtnFood> {

}