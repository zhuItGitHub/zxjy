/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.zxjy.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.zxjy.entity.ZxjySubjects;
import com.jeesite.modules.zxjy.dao.ZxjySubjectsDao;

/**
 * 科目表Service
 * @author 阿健
 * @version 2019-12-09
 */
@Service
@Transactional(readOnly=true)
public class ZxjySubjectsService extends CrudService<ZxjySubjectsDao, ZxjySubjects> {
	
	/**
	 * 获取单条数据
	 * @param zxjySubjects
	 * @return
	 */
	@Override
	public ZxjySubjects get(ZxjySubjects zxjySubjects) {
		return super.get(zxjySubjects);
	}
	
	/**
	 * 查询分页数据
	 * @param zxjySubjects 查询条件
	 * @return
	 */
	@Override
	public Page<ZxjySubjects> findPage(ZxjySubjects zxjySubjects) {
		return super.findPage(zxjySubjects);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param zxjySubjects
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(ZxjySubjects zxjySubjects) {
		super.save(zxjySubjects);
	}
	
	/**
	 * 更新状态
	 * @param zxjySubjects
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(ZxjySubjects zxjySubjects) {
		super.updateStatus(zxjySubjects);
	}
	
	/**
	 * 删除数据
	 * @param zxjySubjects
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(ZxjySubjects zxjySubjects) {
		super.delete(zxjySubjects);
	}
	
}