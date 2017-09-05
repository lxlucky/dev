package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.entity.User;

public interface UserMapper {
	
	/**
	 * 用户列表
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@Select("select * from users limit #{pageNo}, #{pageSize}")
	List<User> getList(@Param("pageNo")Integer pageNo, @Param("pageSize")Integer pageSize);
	
	/**
	 * 统计
	 * @return
	 */
	@Select("select count(id) from users")
	int count();
	
	/**
	 * 获得用户
	 * @param id
	 * @return
	 */
	@Select("select * from users where id= #{id}")
	User getUser(@Param("id") Integer id);
	
	/**
	 * 添加
	 * @param user
	 * @return
	 */
	@Insert("insert into users values(#{id}, #{name}, #{age})")
	int insert(User user);
	
	/**
	 * 修改
	 * @param user
	 * @return
	 */
	@Update("update users set #{name}, #{age} where id = #{id}")
	int update(User user);
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@Delete("delete from users where id =#{id}")
	int delete(@Param("id") Integer id);

}
	
