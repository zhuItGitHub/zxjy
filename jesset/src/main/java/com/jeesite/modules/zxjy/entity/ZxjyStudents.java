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
 * 学生表Entity
 * @author 阿健
 * @version 2019-12-09
 */
@Table(name="zxjy_students", alias="a", columns={
		@Column(name="id", attrName="id", label="主键", isPK=true),
		@Column(name="name", attrName="name", label="姓名", queryType=QueryType.LIKE),
		@Column(name="sex", attrName="sex", label="性别", comment="性别(0女1男)"),
		@Column(name="age", attrName="age", label="年龄"),
		@Column(name="address", attrName="address", label="住址"),
		@Column(name="school", attrName="school", label="学校"),
		@Column(name="grade", attrName="grade", label="年级"),
		@Column(name="phone", attrName="phone", label="手机号"),
		@Column(name="score", attrName="score", label="最近一次考试成绩"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class ZxjyStudents extends DataEntity<ZxjyStudents> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 姓名
	private String sex;		// 性别(0女1男)
	private Integer age;		// 年龄
	private String address;		// 住址
	private String school;		// 学校
	private String grade;		// 年级
	private Long phone;		// 手机号
	private String score;		// 最近一次考试成绩

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public ZxjyStudents() {
		this(null);
	}

	public ZxjyStudents(String id){
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
	
	@Length(min=0, max=50, message="住址长度不能超过 50 个字符")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Length(min=0, max=20, message="学校长度不能超过 20 个字符")
	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
	
	@Length(min=0, max=20, message="年级长度不能超过 20 个字符")
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}
	
}