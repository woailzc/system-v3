package com.logistics.system.common.baseService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.logistics.system.common.baseDao.CrudDao;
import com.logistics.system.common.baseEntity.DataEntity;




/**
 * Service基类
 * @author lzc
 * 
 */
@Transactional(readOnly = true)
public abstract class CrudService<D extends CrudDao<T>, T extends DataEntity<T>>  {
	
	/**
	 * 持久层对象
	 */
	@Autowired
	protected D dao;
	
	/**
	 * 获取单条数据
	 * @param id
	 * @return
	 */
	public T get(String id) {
		return dao.get(id);
	}
	
	/**
	 * 获取单条数据
	 * @param entity
	 * @return
	 */
	public T get(T entity) {
		return dao.get(entity);
	}
	
	/**
	 * 查询列表数据
	 * @param entity
	 * @return
	 */
	public List<T> findList(T entity) {
		return dao.findList(entity);
	}
	
	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param entity
	 * @return
	 */
//	public Page<T> findPage(Page<T> page, T entity) {
//		entity.setPage(page);
//		page.setList(dao.findList(entity));
//		return page;
//	}

	/**
	 * 保存数据（插入）
	 * @param entity
	 */
	@Transactional(readOnly = false)
	public void save(T entity) {
			dao.insert(entity);
	}
	/**
	 * 更新数据
	 */
	@Transactional(readOnly = false)
	public void update(T entity) {
			dao.update(entity);
	}
	/**
	 * 删除数据
	 * @param entity
	 */
	@Transactional(readOnly = false)
	public void delete(T entity) {
		dao.delete(entity);
	}
	/**
	 * 删除多条数据
	 * @param entity
	 */
	@Transactional(readOnly = false)
	public void deletes(int ids) {
		dao.deletes(ids);
	}

}
