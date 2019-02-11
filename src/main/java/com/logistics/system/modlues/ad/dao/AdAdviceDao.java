package com.logistics.system.modlues.ad.dao;


import org.apache.ibatis.annotations.Param;

import com.logistics.system.common.baseDao.CrudDao;
import com.logistics.system.modlues.ad.entity.AdAdvice;
import com.logistics.system.modlues.nt.entity.NtNotice;
import com.logistics.system.modlues.sys.entity.SysDepartment;
import com.logistics.system.modlues.sys.entity.SysUser;

import java.util.List;

public interface AdAdviceDao extends CrudDao<AdAdvice> {

}