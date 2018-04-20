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
	
	
	@RequestMapping("listUser")//�൱��struts.xml�е�action������name
	public ModelAndView ListUser(){
		ModelAndView mav=new ModelAndView();//�䵱ԭ��set/get����
		List<User> alluser=userService.userList();
		//mav���ת����jspҳ��Ĳ���
		mav.addObject("user",alluser);//mav�൱��һ��hashmap
		//���뽫Ҫ��ת��jsp�ļ���
		mav.setViewName("UserCurd/UserList");
		return mav;//return�����
	}
	
	@RequestMapping("deleteUser")
	public ModelAndView deleteUser(int user_sno) {
		ModelAndView mav=new ModelAndView();
		userService.deleteUser(user_sno);
		//������ɺ����ϻص�list�б�
		List<User> alluser=userService.userList();
		//mav���ת����jspҳ��Ĳ���
		mav.addObject("user",alluser);//mav�൱��һ��hashmap
		//���뽫Ҫ��ת��jsp�ļ���
		mav.setViewName("UserCurd/UserList");
		return mav;
	}
}
