package com.yuan.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.yuan.model.SysUser;

@Mapper
public interface SysUserMapper {
	
	//@Select("select * from sys_user ")
	SysUser getUser(Long id);
	
}
