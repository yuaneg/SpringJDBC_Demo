package com.yuan.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yuan.mybatis.dao.ImybatisUserMapper;
import com.yuan.mybatis.model.MybatisUser;

@Service

public class MybatisServiceImpl implements ImybatisService{
	
	@Autowired
	private ImybatisUserMapper mybatisUserMapper;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int deleteByPrimaryKey(Integer id) {
		return mybatisUserMapper.deleteByPrimaryKey(id);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int insert(MybatisUser record) {
		return mybatisUserMapper.insert(record);
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS)
	public int insertSelective(MybatisUser record) {
		return mybatisUserMapper.insertSelective(record);
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS)
	public MybatisUser selectByPrimaryKey(Integer id) {
		return mybatisUserMapper.selectByPrimaryKey(id);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int updateByPrimaryKeySelective(MybatisUser record) {
		return mybatisUserMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int updateByPrimaryKey(MybatisUser record) {
		return mybatisUserMapper.updateByPrimaryKey(record);
	}

}
