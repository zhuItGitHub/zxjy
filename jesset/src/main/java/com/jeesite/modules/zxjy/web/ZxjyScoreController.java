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
import com.jeesite.modules.zxjy.entity.ZxjyScore;
import com.jeesite.modules.zxjy.service.ZxjyScoreService;

/**
 * 成绩分数表Controller
 * @author 阿健
 * @version 2019-12-09
 */
@Controller
@RequestMapping(value = "${adminPath}/zxjy/zxjyScore")
public class ZxjyScoreController extends BaseController {

	@Autowired
	private ZxjyScoreService zxjyScoreService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public ZxjyScore get(String id, boolean isNewRecord) {
		return zxjyScoreService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("zxjy:zxjyScore:view")
	@RequestMapping(value = {"list", ""})
	public String list(ZxjyScore zxjyScore, Model model) {
		model.addAttribute("zxjyScore", zxjyScore);
		return "modules/zxjy/zxjyScoreList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("zxjy:zxjyScore:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<ZxjyScore> listData(ZxjyScore zxjyScore, HttpServletRequest request, HttpServletResponse response) {
		zxjyScore.setPage(new Page<>(request, response));
		Page<ZxjyScore> page = zxjyScoreService.findPage(zxjyScore);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("zxjy:zxjyScore:view")
	@RequestMapping(value = "form")
	public String form(ZxjyScore zxjyScore, Model model) {
		model.addAttribute("zxjyScore", zxjyScore);
		return "modules/zxjy/zxjyScoreForm";
	}

	/**
	 * 保存成绩分数表
	 */
	@RequiresPermissions("zxjy:zxjyScore:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated ZxjyScore zxjyScore) {
		zxjyScoreService.save(zxjyScore);
		return renderResult(Global.TRUE, text("保存成绩分数表成功！"));
	}
	
}