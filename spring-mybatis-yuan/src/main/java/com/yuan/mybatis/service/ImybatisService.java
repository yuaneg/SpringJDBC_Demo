package com.yuan.mybatis.service;

import com.yuan.mybatis.model.MybatisUser;

public interface ImybatisService {
	
    int deleteByPrimaryKey(Integer id);

    int insert(MybatisUser record);

    int insertSelective(MybatisUser record);

    MybatisUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MybatisUser record);

    int updateByPrimaryKey(MybatisUser record);
}
