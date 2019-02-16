package com.logistics.system.modlues.sys.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.logistics.system.common.baseService.CrudService;
import com.logistics.system.modlues.sys.dao.SysUserDao;
import com.logistics.system.modlues.sys.entity.SysUser;




@Service
@Transactional(readOnly = false)
public class SysUserService extends CrudService<SysUserDao, SysUser>{
	@Autowired
	SysUserDao sysUserDao;
	
	//修改密码
	public void updatePasswordById(SysUser sysUser){
			sysUserDao.updatePasswordById(sysUser);
	}
	//修改头像
	public void updatePhoto(SysUser sysUser,MultipartFile Mphoto,HttpSession session) throws IllegalStateException, IOException{
		String path = session.getServletContext().getRealPath("/sysUserPhoto");//获取应用根目录下的sysOUserPhoto文件夹
		String fileName = Mphoto.getOriginalFilename();//上传文件名
   		File file = new File(path, fileName);
   		Mphoto.transferTo(file);//将上传文件写到服务器上指定的文件。
   		sysUser.setPhoto(fileName);
		sysUserDao.updatePhoto(sysUser);
	}
	//保存
	public void save(SysUser sysUser,MultipartFile Mphoto,HttpSession session) throws IllegalStateException, IOException{

		String path = session.getServletContext().getRealPath("/sysUserPhoto");//获取应用根目录下的sysOUserPhoto文件夹
		String fileName = Mphoto.getOriginalFilename();//上传文件名
   		File file = new File(path, fileName);
   		Mphoto.transferTo(file);//将上传文件写到服务器上指定的文件。
   		sysUser.setPhoto(fileName);
   		super.save(sysUser);
   		
	}
	

}
