package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entity.User;
import com.mapper.UserMapper;

@Repository
public class UserDao {
	
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 获得列表
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<User> getList(Integer pageNo, Integer pageSize) {
		return userMapper.getList(pageNo, pageSize);
	}
	
	/**
	 * 统计
	 * @return
	 */
	public int count() {
		int res = -1;
		res = userMapper.count();
		return res; 
	}
	
	/**
	 * 获得用户
	 * @param id
	 * @return
	 */
	public User getUser(Integer id) {
		return userMapper.getUser(id);
	}
	
	/**
	 * 新增
	 * @param user
	 * @return
	 */
	public int insert(User user) {
		return userMapper.insert(user);
	}
	
	/**
	 * 修改
	 * @param user
	 * @return
	 */
	public int update(User user) {
		return userMapper.update(user);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public int delete(Integer id) {
		return userMapper.delete(id);
	}
}
