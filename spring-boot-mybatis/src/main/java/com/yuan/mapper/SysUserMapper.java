package com.yuan.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.yuan.model.SysUser;

@Mapper
public interface SysUserMapper {
	
	
	SysUser getUser(Long id);
	
	@Select("select * from sys_user ")
	List<SysUser> getUserList();
}
