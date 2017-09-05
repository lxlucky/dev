package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.Result;
import com.common.ResultType;
import com.dao.UserDao;
import com.entity.User;
import com.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public Result getList(Integer pageNo, Integer pageSize) {
		List<User> users = null;
		if(null != pageNo && null != pageSize) {
			users = userDao.getList(pageNo, pageSize);
		}
		int count = userDao.count();
		Integer page = 0;
		page = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
		return new Result(ResultType.SUCCESS.getCode(), ResultType.SUCCESS.name(), users, count, page);
	}
	
	@Override
	public Result detail(Integer id) {
		User user = null;
		if(null != id) {
			user = userDao.getUser(id);
		}
		return new Result(ResultType.SUCCESS.getCode(), ResultType.SUCCESS.name(), user);
	}
	
	@Override
	public Result save(User user) {
		int res = -1;
		if(null != user) {
			res = userDao.insert(user);
		}
		return new Result(ResultType.SUCCESS.getCode(), ResultType.SUCCESS.name(), res);
	}
	
	@Override
	public Result delete(Integer id) {
		int res = -1;
		if(null != id) {
			res = userDao.delete(id);
		}
		return new Result(ResultType.SUCCESS.getCode(), ResultType.SUCCESS.name(), res);
	}
}
