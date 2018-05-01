package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import pojo.QuestionReply;
import pojo.User;
import service.UserService;

@Controller
@RequestMapping("")
public class UserController {
	@Autowired
	UserService userService;
	
	/**
	 * ������
	 * @return
	 */
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
	public ModelAndView deleteUser(String user_sno) {
		ModelAndView mav=new ModelAndView();
		userService.deleteUser(user_sno);
		//������ɺ����ϻص�list�б�
		List<User> alluser=userService.userList();
		//mav���ת����jspҳ��Ĳ���
		mav.addObject("user",alluser);//mav�൱��һ��hashmap
		mav.addObject("address","http://localhost:8080/Card-Campus-Server/listUser");
		//���뽫Ҫ��ת��jsp�ļ���
		mav.setViewName("index");
		return mav;
	}
	
	/**
	 * �ͻ���
	 */
	//ͨ��ѧ�Ų��ҵ��û���
	@RequestMapping("getUserBySno")
    public void getUserBySno(HttpServletRequest request, HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        
        //��ȡandroid�ͻ��˴���ֵ�ķ�ʽ���������õ���Ҫ�����û���ѧ��
        String user_sno=request.getParameter("user_sno");

        User user=userService.getUserBySno(user_sno);
         
        jsonObject.put("user", user);
        /*
		 * �ȷ�װ��text���ַ��� ��ת����JSON
		 * ��׿Activity��������ʾֻ��UTF-8��GBK������Ŷ
		 * ������ָ�ڿͻ�����ʾ�ı����ʽ
		 */
		response.setContentType("text/json;charset=utf-8");
		
		/*
		 * ������ָ�����紫������еı��뷽ʽ
		 */
		response.setCharacterEncoding("utf-8");
		
		/*
		 * �ùܵ�����������
		 * ��JSONת����byte�ٴ�
		 * ���뷽ʽUTF-8��
		 */
		try {
			byte[] bytes = jsonObject.toString().getBytes("utf-8");
			
			//���ֽ�����д�������
			response.getOutputStream().write(bytes);
			
			//���ô������ݵĳ��ȣ�����response����
			response.setContentLength(bytes.length);
			
			//��ջ��棨�ѻ������ȫ������ȥ
			response.getOutputStream().flush();
			
			//����Ҫ����
			response.getOutputStream().close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};

    }
	
	
	
	/**
	 * �ͻ���
	 * ����һ���û���¼��
	 */
	@RequestMapping("insertNewUser")
    public void insertUser(HttpServletRequest request, HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        
        //��ȡandroid�ͻ��˴���ֵ�ķ�ʽ���������õ���Ҫ�����û���ѧ��
        String user_sno=request.getParameter("user_sno");
        String user_name=request.getParameter("user_nickname");
        User user=new User();
        user.setUser_avatar("http://p81fp7gd5.bkt.clouddn.com/useravatar.png");
        user.setUser_nickname(user_name);
        user.setUser_sno(user_sno);
        user.setUser_qq("");
        user.setUser_sex("");
        user.setUser_tel("");
        
        userService.addUser(user);
        
        jsonObject.put("addSuccess", "addSuccess");
        /*
		 * �ȷ�װ��text���ַ��� ��ת����JSON
		 * ��׿Activity��������ʾֻ��UTF-8��GBK������Ŷ
		 * ������ָ�ڿͻ�����ʾ�ı����ʽ
		 */
		response.setContentType("text/json;charset=utf-8");
		
		/*
		 * ������ָ�����紫������еı��뷽ʽ
		 */
		response.setCharacterEncoding("utf-8");
		
		/*
		 * �ùܵ�����������
		 * ��JSONת����byte�ٴ�
		 * ���뷽ʽUTF-8��
		 */
		try {
			byte[] bytes = jsonObject.toString().getBytes("utf-8");
			
			//���ֽ�����д�������
			response.getOutputStream().write(bytes);
			
			//���ô������ݵĳ��ȣ�����response����
			response.setContentLength(bytes.length);
			
			//��ջ��棨�ѻ������ȫ������ȥ
			response.getOutputStream().flush();
			
			//����Ҫ����
			response.getOutputStream().close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};

    }
}
