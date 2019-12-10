/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.zxjy.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.zxjy.entity.ZxjyRegistration;

/**
 * 报名登记表DAO接口
 * @author 阿健
 * @version 2019-12-09
 */
@MyBatisDao
public interface ZxjyRegistrationDao extends CrudDao<ZxjyRegistration> {
	
}