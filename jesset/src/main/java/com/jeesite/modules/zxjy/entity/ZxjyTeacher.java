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
 * 教师表Entity
 * @author 阿健
 * @version 2019-12-09
 */
@Table(name="zxjy_teacher", alias="a", columns={
		@Column(name="id", attrName="id", label="主键", isPK=true),
		@Column(name="name", attrName="name", label="姓名", queryType=QueryType.LIKE),
		@Column(name="sex", attrName="sex", label="性别", comment="性别(0女1男)"),
		@Column(name="age", attrName="age", label="年龄"),
		@Column(name="phone", attrName="phone", label="联系方式"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class ZxjyTeacher extends DataEntity<ZxjyTeacher> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 姓名
	private String sex;		// 性别(0女1男)
	private Integer age;		// 年龄
	private Long phone;		// 联系方式
	
	public ZxjyTeacher() {
		this(null);
	}

	public ZxjyTeacher(String id){
		super(id);
	}
	
	@Length(min=0, max=5, message="姓名长度不能超过 5 个字符")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}
	
}