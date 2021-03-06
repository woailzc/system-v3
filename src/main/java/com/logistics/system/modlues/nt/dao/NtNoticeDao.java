package com.logistics.system.modlues.nt.dao;


import org.apache.ibatis.annotations.Param;

import com.logistics.system.common.baseDao.CrudDao;
import com.logistics.system.modlues.nt.entity.NtNotice;
import com.logistics.system.modlues.sys.entity.SysDepartment;
import com.logistics.system.modlues.sys.entity.SysUser;

import java.util.List;

public interface NtNoticeDao extends CrudDao<NtNotice> {
	
	public void updateStatus(NtNotice ntNotice);
	
	public List<NtNotice> shows(NtNotice ntNotice);

}