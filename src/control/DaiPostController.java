package control;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import pojo.DaiPost;
import pojo.User;
import service.DaiPostService;
import service.UserService;

@Controller
@RequestMapping("")
public class DaiPostController {
	@Autowired
	DaiPostService daiPostService;
	
	@RequestMapping("daiNum")
	public void daiNum(HttpServletResponse response) {
		
		JSONObject jsonObject = new JSONObject();
        int count=daiPostService.daiNum();
        jsonObject.put("count", count);
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
	 * 1.代课的相关操作
	 */
	
	/**
	 * 服务器
	 */
	@RequestMapping("listDaike")//相当于struts.xml中的action的名字name
	public ModelAndView ListDaike(){
		ModelAndView mav=new ModelAndView();//充当原来set/get方法
		List<DaiPost> alldaike=daiPostService.daikeList();
		//mav存放转发到jsp页面的参数
		mav.addObject("daike",alldaike);//mav相当于一个hashmap
		//放入将要跳转的jsp文件名
		mav.setViewName("DaiPostCurd/DaikeList");
		return mav;//return给框架
	}
	
	@RequestMapping("deleteDaike")
	public ModelAndView deleteDaike(int dpost_id) {
		ModelAndView mav=new ModelAndView();
		daiPostService.deleteDaike(dpost_id);
		//插入完成后马上回到list列表
		List<DaiPost> alldaike=daiPostService.daikeList();
		//mav存放转发到jsp页面的参数
		mav.addObject("daike",alldaike);//mav相当于一个hashmap
		//mav.addObject("address","http://localhost:8080/Card-Campus-Server/listDaike");
		//放入将要跳转的jsp文件名
		mav.setViewName("DaiPostCurd/DaikeList");
		return mav;
	}
	
	
	/**
	 * 客户端
	 */
	//处理来自客户端的请求，并将json格式的数据处理结果返回。
    @RequestMapping("getDaikeList")
    public void getDaikeFromClient(HttpServletRequest request, HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        List<DaiPost> alldaike=daiPostService.daikeList();
        JSONArray arrayDaike = JSONArray.fromObject(alldaike);
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
			byte[] bytes = arrayDaike.toString().getBytes("utf-8");
			
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
	/*
	 * 客户端
	 * 添加一条代课记录
	 */
    @Autowired
	UserService userService;
    
    @RequestMapping("addDaike")
	public void addDaike(HttpServletRequest request, HttpServletResponse response) {
    	String dpost_id=request.getParameter("dpost_id");
        String user_sno = request.getParameter("user_sno");
        String time = request.getParameter("dpost_time");
        String dpost_content = request.getParameter("dpost_content");
        String dpost_title = request.getParameter("dpost_title");
        //String user_qq=request.getParameter("user_qq");
        String dpost_type=request.getParameter("dpost_type");
        String is_solved = request.getParameter("is_solved");
        
        
        int post_id = Integer.parseInt(dpost_id);
        int solved=Integer.parseInt(is_solved);
        User user = userService.getUserBySno(user_sno);
        //System.out.println("QQ:"+user.getUser_qq());
        
        long time1 = Long.parseLong(time);
        Timestamp post_time = new Timestamp(time1);
      
        DaiPost daipost = new DaiPost();
        daipost.setDpost_content(dpost_content);
        daipost.setDpost_id(post_id);
        daipost.setDpost_time(post_time);
        daipost.setDpost_title(dpost_title);
        daipost.setIs_solved(solved);
        daipost.setUser(user);
        daipost.setDpost_type(dpost_type);
        
        System.out.println("dddddddaike");
        daiPostService.addDaike(daipost);
	}
	
	
	/**
	 * 2.代拿外卖的相关操作
	 */
	@RequestMapping("listDaifood")//相当于struts.xml中的action的名字name
	public ModelAndView ListDaifood(){
		ModelAndView mav=new ModelAndView();//充当原来set/get方法
		List<DaiPost> alldaifood=daiPostService.daifoodList();
		//mav存放转发到jsp页面的参数
		mav.addObject("daifood",alldaifood);//mav相当于一个hashmap
		//放入将要跳转的jsp文件名
		mav.setViewName("DaiPostCurd/DaifoodList");
		return mav;//return给框架
	}
	
	@RequestMapping("deleteDaifood")
	public ModelAndView deleteDaifood(int dpost_id) {
		ModelAndView mav=new ModelAndView();
		daiPostService.deleteDaifood(dpost_id);
		//插入完成后马上回到list列表
		List<DaiPost> alldaifood=daiPostService.daifoodList();
		//mav存放转发到jsp页面的参数
		mav.addObject("daifood",alldaifood);//mav相当于一个hashmap
		//mav.addObject("address","http://localhost:8080/Card-Campus-Server/listDaifood");
		//放入将要跳转的jsp文件名
		mav.setViewName("DaiPostCurd/DaifoodList");
		return mav;
	}
	
	@RequestMapping("getDaifoodList")
    public void getDaifoodFromClient(HttpServletRequest request, HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        List<DaiPost> alldaifood=daiPostService.daifoodList();
        JSONArray arrayDaifood = JSONArray.fromObject(alldaifood);
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
			byte[] bytes = arrayDaifood.toString().getBytes("utf-8");
			
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
	 * 3.代拿快递的相关操作
	 */
	@RequestMapping("listDaideliver")//相当于struts.xml中的action的名字name
	public ModelAndView ListDaideliver(){
		ModelAndView mav=new ModelAndView();//充当原来set/get方法
		List<DaiPost> alldaideliver=daiPostService.daideliverList();
		//mav存放转发到jsp页面的参数
		mav.addObject("daideliver",alldaideliver);//mav相当于一个hashmap
		//放入将要跳转的jsp文件名
		mav.setViewName("DaiPostCurd/DaideliverList");
		return mav;//return给框架
	}
	
	@RequestMapping("deleteDaideliver")
	public ModelAndView deleteDaideliver(int dpost_id) {
		ModelAndView mav=new ModelAndView();
		daiPostService.deleteDaideliver(dpost_id);
		//插入完成后马上回到list列表
		List<DaiPost> alldaideliver=daiPostService.daideliverList();
		//mav存放转发到jsp页面的参数
		mav.addObject("daideliver",alldaideliver);//mav相当于一个hashmap
		//mav.addObject("address","http://localhost:8080/Card-Campus-Server/listDaideliver");
		//放入将要跳转的jsp文件名
		mav.setViewName("DaiPostCurd/DaideliverList");
		return mav;
	}
	
	@RequestMapping("getDaideliverList")
    public void getDaideliverFromClient(HttpServletRequest request, HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        List<DaiPost> alldaideliver=daiPostService.daideliverList();
        JSONArray arrayDaideliver = JSONArray.fromObject(alldaideliver);
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
			byte[] bytes = arrayDaideliver.toString().getBytes("utf-8");
			
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
	 * 4.代活动的相关操作
	 */
	@RequestMapping("listDaiactivity")//相当于struts.xml中的action的名字name
	public ModelAndView ListDaiactivity(){
		ModelAndView mav=new ModelAndView();//充当原来set/get方法
		List<DaiPost> alldaiactivity=daiPostService.daiactivityList();
		//mav存放转发到jsp页面的参数
		mav.addObject("daiactivity",alldaiactivity);//mav相当于一个hashmap
		//放入将要跳转的jsp文件名
		mav.setViewName("DaiPostCurd/DaiactivityList");
		return mav;//return给框架
	}
	
	@RequestMapping("deleteDaiactivity")
	public ModelAndView deleteDaiactivity(int dpost_id) {
		ModelAndView mav=new ModelAndView();
		daiPostService.deleteDaiactivity(dpost_id);
		//插入完成后马上回到list列表
		List<DaiPost> alldaiactivity=daiPostService.daiactivityList();
		//mav存放转发到jsp页面的参数
		mav.addObject("daiactivity",alldaiactivity);//mav相当于一个hashmap
		//mav.addObject("address","http://localhost:8080/Card-Campus-Server/listDaiactivity");
		//放入将要跳转的jsp文件名
		mav.setViewName("DaiPostCurd/DaiactivityList");
		return mav;
	}
	
	@RequestMapping("getDaiactivityList")
    public void getDaiactivityFromClient(HttpServletRequest request, HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        List<DaiPost> alldaiactivity=daiPostService.daiactivityList();
        JSONArray arrayDaiactivity = JSONArray.fromObject(alldaiactivity);
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
			byte[] bytes = arrayDaiactivity.toString().getBytes("utf-8");
			
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
	 * 5.代健步走的相关操作
	 */
	@RequestMapping("listDaiwalk")//相当于struts.xml中的action的名字name
	public ModelAndView ListDaiwalk(){
		ModelAndView mav=new ModelAndView();//充当原来set/get方法
		List<DaiPost> alldaiwalk=daiPostService.daiwalkList();
		//mav存放转发到jsp页面的参数
		mav.addObject("daiwalk",alldaiwalk);//mav相当于一个hashmap
		//放入将要跳转的jsp文件名
		mav.setViewName("DaiPostCurd/DaiwalkList");
		return mav;//return给框架
	}
	
	@RequestMapping("deleteDaiwalk")
	public ModelAndView deleteDaiwalk(int dpost_id) {
		ModelAndView mav=new ModelAndView();
		daiPostService.deleteDaiwalk(dpost_id);
		//插入完成后马上回到list列表
		List<DaiPost> alldaiwalk=daiPostService.daiwalkList();
		//mav存放转发到jsp页面的参数
		mav.addObject("daiwalk",alldaiwalk);//mav相当于一个hashmap
		//mav.addObject("address","http://localhost:8080/Card-Campus-Server/listDaiwalk");
		//放入将要跳转的jsp文件名
		mav.setViewName("DaiPostCurd/DaiwalkList");
		return mav;
	}
	
	@RequestMapping("getDaiwalkList")
    public void getDaiwalkFromClient(HttpServletRequest request, HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        List<DaiPost> alldaiwalk=daiPostService.daiwalkList();
        JSONArray arrayDaiwalk = JSONArray.fromObject(alldaiwalk);
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
			byte[] bytes = arrayDaiwalk.toString().getBytes("utf-8");
			
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
	 * 6.代购的相关操作
	 */
	@RequestMapping("listDaibuy")//相当于struts.xml中的action的名字name
	public ModelAndView ListDaibuy(){
		ModelAndView mav=new ModelAndView();//充当原来set/get方法
		List<DaiPost> alldaibuy=daiPostService.daibuyList();
		//mav存放转发到jsp页面的参数
		mav.addObject("daibuy",alldaibuy);//mav相当于一个hashmap
		//放入将要跳转的jsp文件名
		mav.setViewName("DaiPostCurd/DaibuyList");
		return mav;//return给框架
	}
	
	@RequestMapping("deleteDaibuy")
	public ModelAndView deleteDaibuy(int dpost_id) {
		ModelAndView mav=new ModelAndView();
		daiPostService.deleteDaibuy(dpost_id);
		//插入完成后马上回到list列表
		List<DaiPost> alldaibuy=daiPostService.daibuyList();
		//mav存放转发到jsp页面的参数
		mav.addObject("daibuy",alldaibuy);//mav相当于一个hashmap
		//mav.addObject("address","http://localhost:8080/Card-Campus-Server/listDaibuy");
		//放入将要跳转的jsp文件名
		mav.setViewName("DaiPostCurd/DaibuyList");
		return mav;
	}
	
	@RequestMapping("getDaibuyList")
    public void getDaibuyFromClient(HttpServletRequest request, HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        List<DaiPost> alldaibuy=daiPostService.daibuyList();
        JSONArray arrayDaibuy = JSONArray.fromObject(alldaibuy);
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
			byte[] bytes = arrayDaibuy.toString().getBytes("utf-8");
			
			//把字节数组写入输出流/
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
