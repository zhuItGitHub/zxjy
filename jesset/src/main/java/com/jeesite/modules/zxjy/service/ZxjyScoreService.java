/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.zxjy.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.zxjy.entity.ZxjyScore;
import com.jeesite.modules.zxjy.dao.ZxjyScoreDao;

/**
 * 成绩分数表Service
 * @author 阿健
 * @version 2019-12-09
 */
@Service
@Transactional(readOnly=true)
public class ZxjyScoreService extends CrudService<ZxjyScoreDao, ZxjyScore> {
	
	/**
	 * 获取单条数据
	 * @param zxjyScore
	 * @return
	 */
	@Override
	public ZxjyScore get(ZxjyScore zxjyScore) {
		return super.get(zxjyScore);
	}
	
	/**
	 * 查询分页数据
	 * @param zxjyScore 查询条件
	 * @param zxjyScore.page 分页对象
	 * @return
	 */
	@Override
	public Page<ZxjyScore> findPage(ZxjyScore zxjyScore) {
		return super.findPage(zxjyScore);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param zxjyScore
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(ZxjyScore zxjyScore) {
		super.save(zxjyScore);
	}
	
	/**
	 * 更新状态
	 * @param zxjyScore
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(ZxjyScore zxjyScore) {
		super.updateStatus(zxjyScore);
	}
	
	/**
	 * 删除数据
	 * @param zxjyScore
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(ZxjyScore zxjyScore) {
		super.delete(zxjyScore);
	}
	
}