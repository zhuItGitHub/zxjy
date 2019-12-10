/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.zxjy.service;

import java.util.List;

import com.jeesite.modules.zxjy.dao.ZxjyStudentsDao;
import com.jeesite.modules.zxjy.entity.ZxjyStudents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.zxjy.entity.ZxjyRegistration;
import com.jeesite.modules.zxjy.dao.ZxjyRegistrationDao;

/**
 * 报名登记表Service
 * @author 阿健
 * @version 2019-12-09
 */
@Service
@Transactional(readOnly=true)
public class ZxjyRegistrationService extends CrudService<ZxjyRegistrationDao, ZxjyRegistration> {

	@Autowired
	private ZxjyStudentsDao zxjyStudentsDao;
	
	/**
	 * 获取单条数据
	 * @param zxjyRegistration
	 * @return
	 */
	@Override
	public ZxjyRegistration get(ZxjyRegistration zxjyRegistration) {
		return super.get(zxjyRegistration);
	}
	
	/**
	 * 查询分页数据
	 * @param zxjyRegistration 查询条件
	 * @return
	 */
	@Override
	public Page<ZxjyRegistration> findPage(ZxjyRegistration zxjyRegistration) {
		return super.findPage(zxjyRegistration);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param zxjyRegistration
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(ZxjyRegistration zxjyRegistration) {
		super.save(zxjyRegistration);
	}
	
	/**
	 * 更新状态
	 * @param zxjyRegistration
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(ZxjyRegistration zxjyRegistration) {
		super.updateStatus(zxjyRegistration);
	}
	
	/**
	 * 删除数据
	 * @param zxjyRegistration
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(ZxjyRegistration zxjyRegistration) {
		super.delete(zxjyRegistration);
	}

	public List<ZxjyStudents> getStudentsAll(String name) {
		return zxjyStudentsDao.getStudentsAll(name);
	}
}