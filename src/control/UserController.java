package control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pojo.User;
import service.UserService;

@Controller
@RequestMapping("")
public class UserController {
	@Autowired
	UserService userService;
	
	
	@RequestMapping("listUser")//相当于struts.xml中的action的名字name
	public ModelAndView ListUser(){
		ModelAndView mav=new ModelAndView();//充当原来set/get方法
		List<User> alluser=userService.userList();
		//mav存放转发到jsp页面的参数
		mav.addObject("user",alluser);//mav相当于一个hashmap
		//放入将要跳转的jsp文件名
		mav.setViewName("UserCurd/UserList");
		return mav;//return给框架
	}
	
	@RequestMapping("deleteUser")
	public ModelAndView deleteUser(int user_sno) {
		ModelAndView mav=new ModelAndView();
		userService.deleteUser(user_sno);
		//插入完成后马上回到list列表
		List<User> alluser=userService.userList();
		//mav存放转发到jsp页面的参数
		mav.addObject("user",alluser);//mav相当于一个hashmap
		//放入将要跳转的jsp文件名
		mav.setViewName("UserCurd/UserList");
		return mav;
	}
}
