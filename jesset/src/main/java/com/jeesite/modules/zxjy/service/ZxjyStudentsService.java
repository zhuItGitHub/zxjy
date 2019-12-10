/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.zxjy.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.zxjy.entity.ZxjyStudents;
import com.jeesite.modules.zxjy.dao.ZxjyStudentsDao;

/**
 * 学生表Service
 * @author 阿健
 * @version 2019-12-09
 */
@Service
@Transactional(readOnly=true)
public class ZxjyStudentsService extends CrudService<ZxjyStudentsDao, ZxjyStudents> {
	
	/**
	 * 获取单条数据
	 * @param zxjyStudents
	 * @return
	 */
	@Override
	public ZxjyStudents get(ZxjyStudents zxjyStudents) {
		return super.get(zxjyStudents);
	}
	
	/**
	 * 查询分页数据
	 * @param zxjyStudents 查询条件
	 * @param zxjyStudents.page 分页对象
	 * @return
	 */
	@Override
	public Page<ZxjyStudents> findPage(ZxjyStudents zxjyStudents) {
		return super.findPage(zxjyStudents);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param zxjyStudents
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(ZxjyStudents zxjyStudents) {
		super.save(zxjyStudents);
	}
	
	/**
	 * 更新状态
	 * @param zxjyStudents
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(ZxjyStudents zxjyStudents) {
		super.updateStatus(zxjyStudents);
	}
	
	/**
	 * 删除数据
	 * @param zxjyStudents
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(ZxjyStudents zxjyStudents) {
		super.delete(zxjyStudents);
	}
	
}