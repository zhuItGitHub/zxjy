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
 * 成绩分数表Entity
 * @author 阿健
 * @version 2019-12-09
 */
@Table(name="zxjy_score", alias="a", columns={
		@Column(name="id", attrName="id", label="主键", isPK=true),
		@Column(name="students_id", attrName="studentsId", label="学生id"),
		@Column(name="subjects_id", attrName="subjectsId", label="科目id"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class ZxjyScore extends DataEntity<ZxjyScore> {
	
	private static final long serialVersionUID = 1L;
	private String studentsId;		// 学生id
	private String subjectsId;		// 科目id
	
	public ZxjyScore() {
		this(null);
	}

	public ZxjyScore(String id){
		super(id);
	}
	
	@Length(min=0, max=32, message="学生id长度不能超过 32 个字符")
	public String getStudentsId() {
		return studentsId;
	}

	public void setStudentsId(String studentsId) {
		this.studentsId = studentsId;
	}
	
	@Length(min=0, max=32, message="科目id长度不能超过 32 个字符")
	public String getSubjectsId() {
		return subjectsId;
	}

	public void setSubjectsId(String subjectsId) {
		this.subjectsId = subjectsId;
	}
	
}