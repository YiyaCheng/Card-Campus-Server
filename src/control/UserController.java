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
	 * 服务器
	 * @return
	 */
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
	public ModelAndView deleteUser(String user_sno) {
		ModelAndView mav=new ModelAndView();
		userService.deleteUser(user_sno);
		//插入完成后马上回到list列表
		List<User> alluser=userService.userList();
		//mav存放转发到jsp页面的参数
		mav.addObject("user",alluser);//mav相当于一个hashmap
		mav.addObject("address","http://localhost:8080/Card-Campus-Server/listUser");
		//放入将要跳转的jsp文件名
		mav.setViewName("index");
		return mav;
	}
	
	/**
	 * 客户端
	 */
	//通过学号查找到用户！
	@RequestMapping("getUserBySno")
    public void getUserBySno(HttpServletRequest request, HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        
        //获取android客户端传递值的方式：在这里拿到需要查找用户的学号
        String user_sno=request.getParameter("user_sno");

        User user=userService.getUserBySno(user_sno);
         
        jsonObject.put("user", user);
        /*
		 * 先封装成text即字符串 再转换成JSON
		 * 安卓Activity的中文显示只认UTF-8！GBK不可以哦
		 * 这里是指在客户端显示的编码格式
		 */
		response.setContentType("text/json;charset=utf-8");
		
		/*
		 * 这里是指在网络传输过程中的编码方式
		 */
		response.setCharacterEncoding("utf-8");
		
		/*
		 * 用管道流传东西啦
		 * 把JSON转换成byte再传
		 * 编码方式UTF-8！
		 */
		try {
			byte[] bytes = jsonObject.toString().getBytes("utf-8");
			
			//把字节数组写入输出流
			response.getOutputStream().write(bytes);
			
			//设置传输内容的长度，方便response处理
			response.setContentLength(bytes.length);
			
			//清空缓存（把缓存里的全部发出去
			response.getOutputStream().flush();
			
			//用完要关啦
			response.getOutputStream().close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};

    }
	
	
	
	/**
	 * 客户端
	 * 插入一条用户记录！
	 */
	@RequestMapping("insertNewUser")
    public void insertUser(HttpServletRequest request, HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        
        //获取android客户端传递值的方式：在这里拿到需要插入用户的学号
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
		 * 先封装成text即字符串 再转换成JSON
		 * 安卓Activity的中文显示只认UTF-8！GBK不可以哦
		 * 这里是指在客户端显示的编码格式
		 */
		response.setContentType("text/json;charset=utf-8");
		
		/*
		 * 这里是指在网络传输过程中的编码方式
		 */
		response.setCharacterEncoding("utf-8");
		
		/*
		 * 用管道流传东西啦
		 * 把JSON转换成byte再传
		 * 编码方式UTF-8！
		 */
		try {
			byte[] bytes = jsonObject.toString().getBytes("utf-8");
			
			//把字节数组写入输出流
			response.getOutputStream().write(bytes);
			
			//设置传输内容的长度，方便response处理
			response.setContentLength(bytes.length);
			
			//清空缓存（把缓存里的全部发出去
			response.getOutputStream().flush();
			
			//用完要关啦
			response.getOutputStream().close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};

    }
}
