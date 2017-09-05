package com.service;

import com.common.Result;
import com.entity.User;

/**
 * 用户接口
 * @author lixiong
 *
 */
public interface UserService {

	/**
	 * 获得列表
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	Result getList(Integer pageNo, Integer pageSize);
	
	/**
	 * 获得详细信息
	 * @param id
	 * @return
	 */
	Result detail(Integer id);
	
	/**
	 * 新增或修改
	 * @param user
	 * @return
	 */
	Result save(User user);
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	Result delete(Integer id);
}
