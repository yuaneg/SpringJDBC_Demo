package com.yuan.mybatis.dao;

import org.apache.ibatis.annotations.Select;

import com.yuan.mybatis.model.MybatisUser;

@SuppressWarnings("unused")
public interface ImybatisUserMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(MybatisUser record);

    int insertSelective(MybatisUser record);
    
    //通过注解的方式实现 
    //@Select("select * from mybatis_user where id = #{id}")
    MybatisUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MybatisUser record);

    int updateByPrimaryKey(MybatisUser record);
    
    
}