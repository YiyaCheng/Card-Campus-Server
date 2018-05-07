package control;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import pojo.QuestionPost;
import pojo.QuestionReply;
import pojo.User;
import service.QuestionPostService;
import service.QuestionReplyService;
import service.UserService;

@Controller
@RequestMapping("")
public class QuestionPostController {
	@Autowired
	QuestionPostService questionPostService;
	
	@Autowired
	QuestionReplyService questionReplyService;
	
	@Autowired
	UserService userService;
	
	/**
	 * 服务器
	 */
	@RequestMapping("listQuestionPost")//相当于struts.xml中的action的名字name
	public ModelAndView listQuestionPost(){
		ModelAndView mav=new ModelAndView();//充当原来set/get方法
		List<QuestionPost> allquestionpost=questionPostService.questionpostList();
		//mav存放转发到jsp页面的参数
		mav.addObject("questionpost",allquestionpost);//mav相当于一个hashmap
		//放入将要跳转的jsp文件名
		mav.setViewName("QuestionPostCurd/QuestionPostList");
		return mav;//return给框架
	}
	
	@RequestMapping("deleteQuestionPost")
	public ModelAndView deleteQuestionPost(int bpost_id) {
		ModelAndView mav=new ModelAndView();
		questionPostService.deleteQuestionPost(bpost_id);
		//插入完成后马上回到list列表
		List<QuestionPost> allquestionpost=questionPostService.questionpostList();
		//mav存放转发到jsp页面的参数
		mav.addObject("questionpost",allquestionpost);//mav相当于一个hashmap
		//mav.addObject("address","http://localhost:8080/Card-Campus-Server/listQuestionPost");
		//放入将要跳转的jsp文件名
		mav.setViewName("QuestionPostCurd/QuestionPostList");
		return mav;
	}
	
	/**
	 * 客户端
	 */
	//处理来自客户端的请求，并将json格式的数据处理结果返回。
    @RequestMapping("getQuestionPostList")
    public void getQuestionPostFromClient(HttpServletRequest request, HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        List<QuestionPost> allQuestionPost=questionPostService.questionpostList();
        JSONArray arrayQuestionPost = JSONArray.fromObject(allQuestionPost);
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
			byte[] bytes = arrayQuestionPost.toString().getBytes("utf-8");
			
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
	 * 得到所有帖子的回复数量
	 */
	//处理来自客户端的请求，并将json格式的数据处理结果返回。
    @RequestMapping("getQuestionPostReplyNum")
    public void getQuestionPostReplyNum(HttpServletRequest request, HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        
        //获取android客户端传递值的方式：在这里拿到需要查找回复数的百事通问题id
        String bpost_id=request.getParameter("bpost_id");
        int post_id = Integer.parseInt(bpost_id);
        
        List<QuestionReply> allReply=questionReplyService.getReplysByPostId(post_id);
        JSONArray arrayReply = JSONArray.fromObject(allReply);
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
			byte[] bytes = arrayReply.toString().getBytes("utf-8");
			
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
	 * 这里是删除一条指定id的记录，无其他任何操作
	 */
	//处理来自客户端的请求，并将json格式的数据处理结果返回。
    @RequestMapping("deleteSelectedPost")
    public void deleteSelectedPost(HttpServletRequest request, HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        
        //获取android客户端传递值的方式：在这里拿到需要查找回复数的百事通问题id
        String bpost_id=request.getParameter("bpost_id");
        int post_id = Integer.parseInt(bpost_id);
        
        questionPostService.deleteQuestionPost(post_id);
        
    }
    
    
    /**
	 * 客户端
	 * 添加一条百事通记录
	 */
	//处理来自客户端的请求，并将json格式的数据处理结果返回。
    @RequestMapping("addQuestionPost")
    public void addQuestionPost(HttpServletRequest request, HttpServletResponse response){
        //获取android客户端传递值的方式：在这里拿到需要查找回复数的百事通问题id
        String bpost_id=request.getParameter("bpost_id");
        String user_sno = request.getParameter("user_sno");
        String time = request.getParameter("bpost_time");
        String bpost_content = request.getParameter("bpost_content");
        String bpost_title = request.getParameter("bpost_title");
        
        int post_id = Integer.parseInt(bpost_id);
        User user = userService.getUserBySno(user_sno);
        
        long time1 = Long.parseLong(time);
        Timestamp post_time = new Timestamp(time1);
      
        QuestionPost questionpost = new QuestionPost();
        questionpost.setBpost_content(bpost_content);
        questionpost.setBpost_id(post_id);
        questionpost.setBpost_time(post_time);
        questionpost.setBpost_title(bpost_title);
        questionpost.setUser(user);
        
        
        questionPostService.addQuestionPost(questionpost);
        
        
        
    }
    
    
    /**
	 * 客户端
	 * 更新一条百事通记录
	 */
	//处理来自客户端的请求，并将json格式的数据处理结果返回。
    @RequestMapping("editQuestionPost")
    public void editQuestionPost(HttpServletRequest request, HttpServletResponse response){
        //获取android客户端传递值的方式：在这里拿到需要查找回复数的百事通问题id
        String bpost_id=request.getParameter("bpost_id");
        String user_sno = request.getParameter("user_sno");
        String time = request.getParameter("bpost_time");
        String bpost_content = request.getParameter("bpost_content");
        String bpost_title = request.getParameter("bpost_title");
        
        int post_id = Integer.parseInt(bpost_id);
        User user = userService.getUserBySno(user_sno);
        
        long time1 = Long.parseLong(time);
        Timestamp post_time = new Timestamp(time1);
      
        QuestionPost questionpost = new QuestionPost();
        questionpost.setBpost_content(bpost_content);
        questionpost.setBpost_id(post_id);
        questionpost.setBpost_time(post_time);
        questionpost.setBpost_title(bpost_title);
        questionpost.setUser(user);
        
        
        questionPostService.updateQuestionPost(questionpost);
        
        System.out.println("？？？？");
        
    }
}
