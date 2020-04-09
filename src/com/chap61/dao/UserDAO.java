package com.chap61.dao;

import java.util.List;

import com.chap61.domain.Users;

/**
 * UserDAO接口，可以实现用户登录验证
 * @author Administrator
 *
 */
public interface UserDAO {
	/**
	 * 用户登录验证
	 * @param loginId  ：用户名
	 * @param loginPwd  ：密码
	 * @return  true，登录成功；false 登录失败
	 */
	public boolean doLogin(String loginId,String loginPwd);
	/**
	 * 用户注册，将user信息写入数据库的Users表中
	 * @param user
	 * @return  true 注册成功  false 注册失败
	 */
	public boolean addUser(Users  user);
	/**
	 * 按照指定字段模糊查询用户信息
	 * @param name:查找的字段
	 * @param  value:查找的值
	 * @return  返回users表中name字段含有value的所有用户信息
	 */
	public List<Users>  listUsersByCondition(String name,String value);
	public Users findUserById(int id);
}
