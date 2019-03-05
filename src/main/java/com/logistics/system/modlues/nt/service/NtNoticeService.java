package com.logistics.system.modlues.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logistics.system.common.baseService.CrudService;
import com.logistics.system.modlues.nt.dao.NtNoticeDao;
import com.logistics.system.modlues.nt.entity.NtNotice;
import com.logistics.system.modlues.sys.dao.SysDepartmentDao;
import com.logistics.system.modlues.sys.dao.SysUserDao;
import com.logistics.system.modlues.sys.entity.SysDepartment;
import com.logistics.system.modlues.sys.entity.SysUser;




@Service
@Transactional(readOnly = false)
public class NtNoticeService extends CrudService<NtNoticeDao, NtNotice>{
	@Autowired
	NtNoticeDao ntNoticeDao;
	//发布公告
	public void pushAndStop(NtNotice ntNotice){
		ntNoticeDao.updateStatus(ntNotice);
	}
	//查看所有发布的公告
	public List<NtNotice> shows(NtNotice ntNotice){
		
		List<NtNotice> ntNotices = ntNoticeDao.shows(ntNotice);
		return ntNotices;
		
	}
	

}
