package com.chap61.test;

import java.util.List;
import java.util.Scanner;

import javax.naming.directory.SearchControls;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chap61.dao.UserDAO;
import com.chap61.domain.Users;

public class TestClass {
	Scanner input = new Scanner(System.in);

	@Test
	public void test() {
		// 得到Spring的核心容器
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		UserDAO userDAO = (UserDAO) context.getBean("userDao");
		System.out.println(userDAO.findUserById(2));
		System.out.println("请选择：1.用户注册 2.用户登录3.模糊查询4.退出程序");
		int choice = input.nextInt();
		while (choice != 4) {
			switch (choice) {
			case 1:
				register(userDAO);
				break;
			case 2:
				login(userDAO);
				break;
			case 3:
				search(userDAO);
				break;
			}
			System.out.println("请选择：1.用户注册 2.用户登录3.退出程序");
			choice = input.nextInt();
		}

	}
	public void search(UserDAO userDAO){
		System.out.println("请输入要查找的字段");
		String name=input.next();
		System.out.println("请输入搜索的值：");
		String value=input.next();
		List<Users>  users=userDAO.listUsersByCondition(name,value);
		for(Users u:users){
			System.out.println(u);
		}
	}
	public void login(UserDAO userDAO) {
		System.out.println("请输入用户名：");
		String nameString = input.next();
		System.out.println("请输入密码：");
		String pwdString = input.next();
		if (userDAO.doLogin(nameString, pwdString)) {
			System.out.println("用户登录成功！");
		} else {
			System.out.println("用户登录失败！");
		}
	}

	public void register(UserDAO userDAO) {
		System.out.println("请输入用户名：");
		String loginId = input.next();
		System.out.println("请输入密码：");
		String loginPwd = input.next();
		System.out.println("请输入真实姓名");
		String name = input.next();
		System.out.println("请输入地址");
		String address = input.next();
		System.out.println("请输入电话");
		String phone = input.next();
		System.out.println("请输入邮箱：");
		String mail = input.next();
		Users users = new Users();
		users.setLoginId(loginId);
		users.setLoginPwd(loginPwd);
		users.setName(name);
		users.setAddress(address);
		users.setPhone(phone);
		users.setMail(mail);
		if (userDAO.addUser(users)) {
			System.out.println("用户注册成功");
		} else {
			System.out.println("用户注册失败！");
		}
	}

}
