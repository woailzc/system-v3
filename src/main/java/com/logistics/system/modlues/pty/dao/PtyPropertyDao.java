package com.logistics.system.modlues.pty.dao;


import org.apache.ibatis.annotations.Param;

import com.logistics.system.common.baseDao.CrudDao;
import com.logistics.system.modlues.ast.entity.AstFixedCapital;
import com.logistics.system.modlues.nt.entity.NtNotice;
import com.logistics.system.modlues.pty.entity.PtyProperty;
import com.logistics.system.modlues.sys.entity.SysDepartment;
import com.logistics.system.modlues.sys.entity.SysUser;

import java.util.List;

public interface PtyPropertyDao extends CrudDao<PtyProperty> {
	
	public void updateStatus(PtyProperty ptyProperty);

	public PtyProperty getByName(String name);

}