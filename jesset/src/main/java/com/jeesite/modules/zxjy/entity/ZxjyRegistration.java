/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.zxjy.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.common.mybatis.annotation.JoinTable.Type;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 报名登记表Entity
 * @author 阿健
 * @version 2019-12-09
 */
@Table(name="zxjy_registration", alias="a", columns={
		@Column(name="id", attrName="id", label="主键", isPK=true),
		@Column(name="students_id", attrName="studentsId", label="学生id"),
		@Column(name="subjects_id", attrName="subjectsId", label="科目id"),
		@Column(name="teacher_id", attrName="teacherId", label="教师id"),
		@Column(name="cost_id", attrName="costId", label="费用id"),
		@Column(name="pay_type", attrName="payType", label="支付方式", comment="课程类型(0:1V1课程 1:班课)"),
		@Column(name="course_type", attrName="courseType", label="课程类型", comment="课程类型(0:1V1课程 1:班课)"),
		@Column(name="subjects_date", attrName="subjectsDate", label="上课时间"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class ZxjyRegistration extends DataEntity<ZxjyRegistration> {
	
	private static final long serialVersionUID = 1L;
	private String studentsId;		// 学生id
	private String subjectsId;		// 科目id
	private String teacherId;		// 教师id
	private String costId;		// 费用id
	private Integer payType;		// 支付类型(0:支付宝 1:微信支付 2:现金支付 3:刷卡支付 4:银行转账
	private Integer courseType;		// 课程类型(0:1V1课程 1:班课)
	private Date subjectsDate;		// 上课时间

	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public ZxjyRegistration() {
		this(null);
	}

	public ZxjyRegistration(String id){
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
	
	@Length(min=0, max=32, message="教师id长度不能超过 32 个字符")
	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	
	@Length(min=0, max=32, message="费用id长度不能超过 32 个字符")
	public String getCostId() {
		return costId;
	}

	public void setCostId(String costId) {
		this.costId = costId;
	}
	
	public Integer getCourseType() {
		return courseType;
	}

	public void setCourseType(Integer courseType) {
		this.courseType = courseType;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getSubjectsDate() {
		return subjectsDate;
	}

	public void setSubjectsDate(Date subjectsDate) {
		this.subjectsDate = subjectsDate;
	}
	
}