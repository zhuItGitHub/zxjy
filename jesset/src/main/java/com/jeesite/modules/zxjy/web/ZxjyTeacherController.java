/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.zxjy.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.zxjy.entity.ZxjyTeacher;
import com.jeesite.modules.zxjy.service.ZxjyTeacherService;

/**
 * 教师表Controller
 * @author 阿健
 * @version 2019-12-09
 */
@Controller
@RequestMapping(value = "${adminPath}/zxjy/zxjyTeacher")
public class ZxjyTeacherController extends BaseController {

	@Autowired
	private ZxjyTeacherService zxjyTeacherService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public ZxjyTeacher get(String id, boolean isNewRecord) {
		return zxjyTeacherService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("zxjy:zxjyTeacher:view")
	@RequestMapping(value = {"list", ""})
	public String list(ZxjyTeacher zxjyTeacher, Model model) {
		model.addAttribute("zxjyTeacher", zxjyTeacher);
		return "modules/zxjy/zxjyTeacherList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("zxjy:zxjyTeacher:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<ZxjyTeacher> listData(ZxjyTeacher zxjyTeacher, HttpServletRequest request, HttpServletResponse response) {
		zxjyTeacher.setPage(new Page<>(request, response));
		Page<ZxjyTeacher> page = zxjyTeacherService.findPage(zxjyTeacher);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("zxjy:zxjyTeacher:view")
	@RequestMapping(value = "form")
	public String form(ZxjyTeacher zxjyTeacher, Model model) {
		model.addAttribute("zxjyTeacher", zxjyTeacher);
		return "modules/zxjy/zxjyTeacherForm";
	}

	/**
	 * 保存教师表
	 */
	@RequiresPermissions("zxjy:zxjyTeacher:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated ZxjyTeacher zxjyTeacher) {
		zxjyTeacherService.save(zxjyTeacher);
		return renderResult(Global.TRUE, text("保存教师表成功！"));
	}
	
	/**
	 * 停用教师表
	 */
	@RequiresPermissions("zxjy:zxjyTeacher:edit")
	@RequestMapping(value = "disable")
	@ResponseBody
	public String disable(ZxjyTeacher zxjyTeacher) {
		zxjyTeacher.setStatus(ZxjyTeacher.STATUS_DISABLE);
		zxjyTeacherService.updateStatus(zxjyTeacher);
		return renderResult(Global.TRUE, text("停用教师表成功"));
	}
	
	/**
	 * 启用教师表
	 */
	@RequiresPermissions("zxjy:zxjyTeacher:edit")
	@RequestMapping(value = "enable")
	@ResponseBody
	public String enable(ZxjyTeacher zxjyTeacher) {
		zxjyTeacher.setStatus(ZxjyTeacher.STATUS_NORMAL);
		zxjyTeacherService.updateStatus(zxjyTeacher);
		return renderResult(Global.TRUE, text("启用教师表成功"));
	}
	
	/**
	 * 删除教师表
	 */
	@RequiresPermissions("zxjy:zxjyTeacher:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(ZxjyTeacher zxjyTeacher) {
		zxjyTeacherService.delete(zxjyTeacher);
		return renderResult(Global.TRUE, text("删除教师表成功！"));
	}
	
}