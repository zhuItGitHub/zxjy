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
import com.jeesite.modules.zxjy.entity.ZxjySubjects;
import com.jeesite.modules.zxjy.service.ZxjySubjectsService;

/**
 * 科目表Controller
 * @author 阿健
 * @version 2019-12-09
 */
@Controller
@RequestMapping(value = "${adminPath}/zxjy/zxjySubjects")
public class ZxjySubjectsController extends BaseController {

	@Autowired
	private ZxjySubjectsService zxjySubjectsService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public ZxjySubjects get(String id, boolean isNewRecord) {
		return zxjySubjectsService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("zxjy:zxjySubjects:view")
	@RequestMapping(value = {"list", ""})
	public String list(ZxjySubjects zxjySubjects, Model model) {
		model.addAttribute("zxjySubjects", zxjySubjects);
		return "modules/zxjy/zxjySubjectsList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("zxjy:zxjySubjects:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<ZxjySubjects> listData(ZxjySubjects zxjySubjects, HttpServletRequest request, HttpServletResponse response) {
		zxjySubjects.setPage(new Page<>(request, response));
		Page<ZxjySubjects> page = zxjySubjectsService.findPage(zxjySubjects);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("zxjy:zxjySubjects:view")
	@RequestMapping(value = "form")
	public String form(ZxjySubjects zxjySubjects, Model model) {
		model.addAttribute("zxjySubjects", zxjySubjects);
		return "modules/zxjy/zxjySubjectsForm";
	}

	/**
	 * 保存科目表
	 */
	@RequiresPermissions("zxjy:zxjySubjects:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated ZxjySubjects zxjySubjects) {
		zxjySubjectsService.save(zxjySubjects);
		return renderResult(Global.TRUE, text("保存科目表成功！"));
	}
	
	/**
	 * 停用科目表
	 */
	@RequiresPermissions("zxjy:zxjySubjects:edit")
	@RequestMapping(value = "disable")
	@ResponseBody
	public String disable(ZxjySubjects zxjySubjects) {
		zxjySubjects.setStatus(ZxjySubjects.STATUS_DISABLE);
		zxjySubjectsService.updateStatus(zxjySubjects);
		return renderResult(Global.TRUE, text("停用科目表成功"));
	}
	
	/**
	 * 启用科目表
	 */
	@RequiresPermissions("zxjy:zxjySubjects:edit")
	@RequestMapping(value = "enable")
	@ResponseBody
	public String enable(ZxjySubjects zxjySubjects) {
		zxjySubjects.setStatus(ZxjySubjects.STATUS_NORMAL);
		zxjySubjectsService.updateStatus(zxjySubjects);
		return renderResult(Global.TRUE, text("启用科目表成功"));
	}
	
	/**
	 * 删除科目表
	 */
	@RequiresPermissions("zxjy:zxjySubjects:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(ZxjySubjects zxjySubjects) {
		zxjySubjectsService.delete(zxjySubjects);
		return renderResult(Global.TRUE, text("删除科目表成功！"));
	}
	
}