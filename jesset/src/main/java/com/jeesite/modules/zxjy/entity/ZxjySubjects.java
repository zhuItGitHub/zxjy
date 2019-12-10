/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.zxjy.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 科目表Entity
 * @author 阿健
 * @version 2019-12-09
 */
@Table(name="zxjy_subjects", alias="a", columns={
		@Column(name="id", attrName="id", label="主键", isPK=true),
		@Column(name="subjects_name", attrName="subjectsName", label="科目名称", queryType=QueryType.LIKE),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class ZxjySubjects extends DataEntity<ZxjySubjects> {
	
	private static final long serialVersionUID = 1L;
	private String subjectsName;		// 科目名称
	
	public ZxjySubjects() {
		this(null);
	}

	public ZxjySubjects(String id){
		super(id);
	}
	
	@Length(min=0, max=100, message="科目名称长度不能超过 100 个字符")
	public String getSubjectsName() {
		return subjectsName;
	}

	public void setSubjectsName(String subjectsName) {
		this.subjectsName = subjectsName;
	}
	
}