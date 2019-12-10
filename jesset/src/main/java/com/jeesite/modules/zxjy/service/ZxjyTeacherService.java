/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.zxjy.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.zxjy.entity.ZxjyTeacher;
import com.jeesite.modules.zxjy.dao.ZxjyTeacherDao;
import com.jeesite.modules.file.utils.FileUploadUtils;

/**
 * 教师表Service
 * @author 阿健
 * @version 2019-12-09
 */
@Service
@Transactional(readOnly=true)
public class ZxjyTeacherService extends CrudService<ZxjyTeacherDao, ZxjyTeacher> {
	
	/**
	 * 获取单条数据
	 * @param zxjyTeacher
	 * @return
	 */
	@Override
	public ZxjyTeacher get(ZxjyTeacher zxjyTeacher) {
		return super.get(zxjyTeacher);
	}
	
	/**
	 * 查询分页数据
	 * @param zxjyTeacher 查询条件
	 * @param zxjyTeacher.page 分页对象
	 * @return
	 */
	@Override
	public Page<ZxjyTeacher> findPage(ZxjyTeacher zxjyTeacher) {
		return super.findPage(zxjyTeacher);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param zxjyTeacher
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(ZxjyTeacher zxjyTeacher) {
		super.save(zxjyTeacher);
		// 保存上传图片
		FileUploadUtils.saveFileUpload(zxjyTeacher.getId(), "zxjyTeacher_image");
	}
	
	/**
	 * 更新状态
	 * @param zxjyTeacher
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(ZxjyTeacher zxjyTeacher) {
		super.updateStatus(zxjyTeacher);
	}
	
	/**
	 * 删除数据
	 * @param zxjyTeacher
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(ZxjyTeacher zxjyTeacher) {
		super.delete(zxjyTeacher);
	}
	
}