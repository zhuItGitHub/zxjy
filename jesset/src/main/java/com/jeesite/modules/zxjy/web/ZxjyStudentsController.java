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
import com.jeesite.modules.zxjy.entity.ZxjyStudents;
import com.jeesite.modules.zxjy.service.ZxjyStudentsService;

/**
 * 学生表Controller
 * @author 阿健
 * @version 2019-12-09
 */
@Controller
@RequestMapping(value = "${adminPath}/zxjy/zxjyStudents")
public class ZxjyStudentsController extends BaseController {

	@Autowired
	private ZxjyStudentsService zxjyStudentsService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public ZxjyStudents get(String id, boolean isNewRecord) {
		return zxjyStudentsService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("zxjy:zxjyStudents:view")
	@RequestMapping(value = {"list", ""})
	public String list(ZxjyStudents zxjyStudents, Model model) {
		model.addAttribute("zxjyStudents", zxjyStudents);
		return "modules/zxjy/zxjyStudentsList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("zxjy:zxjyStudents:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<ZxjyStudents> listData(ZxjyStudents zxjyStudents, HttpServletRequest request, HttpServletResponse response) {
		zxjyStudents.setPage(new Page<>(request, response));
		Page<ZxjyStudents> page = zxjyStudentsService.findPage(zxjyStudents);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("zxjy:zxjyStudents:view")
	@RequestMapping(value = "form")
	public String form(ZxjyStudents zxjyStudents, Model model) {
		model.addAttribute("zxjyStudents", zxjyStudents);
		return "modules/zxjy/zxjyStudentsForm";
	}

	/**
	 * 保存学生表
	 */
	@RequiresPermissions("zxjy:zxjyStudents:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated ZxjyStudents zxjyStudents) {
		zxjyStudentsService.save(zxjyStudents);
		return renderResult(Global.TRUE, text("保存学生表成功！"));
	}
	
	/**
	 * 停用学生表
	 */
	@RequiresPermissions("zxjy:zxjyStudents:edit")
	@RequestMapping(value = "disable")
	@ResponseBody
	public String disable(ZxjyStudents zxjyStudents) {
		zxjyStudents.setStatus(ZxjyStudents.STATUS_DISABLE);
		zxjyStudentsService.updateStatus(zxjyStudents);
		return renderResult(Global.TRUE, text("停用学生表成功"));
	}
	
	/**
	 * 启用学生表
	 */
	@RequiresPermissions("zxjy:zxjyStudents:edit")
	@RequestMapping(value = "enable")
	@ResponseBody
	public String enable(ZxjyStudents zxjyStudents) {
		zxjyStudents.setStatus(ZxjyStudents.STATUS_NORMAL);
		zxjyStudentsService.updateStatus(zxjyStudents);
		return renderResult(Global.TRUE, text("启用学生表成功"));
	}
	
	/**
	 * 删除学生表
	 */
	@RequiresPermissions("zxjy:zxjyStudents:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(ZxjyStudents zxjyStudents) {
		zxjyStudentsService.delete(zxjyStudents);
		return renderResult(Global.TRUE, text("删除学生表成功！"));
	}
	
}