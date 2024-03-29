/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.zxjy.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.modules.zxjy.entity.ZxjyStudents;
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
import com.jeesite.modules.zxjy.entity.ZxjyRegistration;
import com.jeesite.modules.zxjy.service.ZxjyRegistrationService;

import java.util.List;

/**
 * 报名登记表Controller
 * @author 阿健
 * @version 2019-12-09
 */
@Controller
@RequestMapping(value = "${adminPath}/zxjy/zxjyRegistration")
public class ZxjyRegistrationController extends BaseController {

	@Autowired
	private ZxjyRegistrationService zxjyRegistrationService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public ZxjyRegistration get(String id, boolean isNewRecord) {
		return zxjyRegistrationService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("zxjy:zxjyRegistration:view")
	@RequestMapping(value = {"list", ""})
	public String list(ZxjyRegistration zxjyRegistration, Model model) {
		model.addAttribute("zxjyRegistration", zxjyRegistration);
		return "modules/zxjy/zxjyRegistrationList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("zxjy:zxjyRegistration:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<ZxjyRegistration> listData(ZxjyRegistration zxjyRegistration, HttpServletRequest request, HttpServletResponse response) {
		zxjyRegistration.setPage(new Page<>(request, response));
		Page<ZxjyRegistration> page = zxjyRegistrationService.findPage(zxjyRegistration);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("zxjy:zxjyRegistration:view")
	@RequestMapping(value = "form")
	public String form(ZxjyRegistration zxjyRegistration, Model model) {
		model.addAttribute("zxjyRegistration", zxjyRegistration);
		return "modules/zxjy/zxjyRegistrationForm";
	}

	/**
	 * 保存报名登记表
	 */
	@RequiresPermissions("zxjy:zxjyRegistration:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated ZxjyRegistration zxjyRegistration) {
		zxjyRegistrationService.save(zxjyRegistration);
		return renderResult(Global.TRUE, text("保存报名登记表成功！"));
	}

	/**
	 * 获取所有的学生
	 *
	 * @return
	 */
	@PostMapping(value = "studentsAll")
	@ResponseBody
	public List<ZxjyStudents> getStudentsAll(String name) {
		return zxjyRegistrationService.getStudentsAll(name);
	}
	
}