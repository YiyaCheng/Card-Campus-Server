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
public class QuestionReplyController {
	@Autowired
	QuestionReplyService questionReplyService;
	
	@Autowired
	QuestionPostService questionPostService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping("listQuestionReply")//相当于struts.xml中的action的名字name
	public ModelAndView listQuestionReply(){
		ModelAndView mav=new ModelAndView();//充当原来set/get方法
		List<QuestionReply> allquestionreply=questionReplyService.questionreplyList();
		//mav存放转发到jsp页面的参数
		mav.addObject("questionreply",allquestionreply);//mav相当于一个hashmap
		//放入将要跳转的jsp文件名
		mav.setViewName("QuestionReplyCurd/QuestionReplyList");
		return mav;//return给框架
	}
	
	@RequestMapping("deleteQuestionReply")
	public ModelAndView deleteQuestionReply(String breply_id) {
		ModelAndView mav=new ModelAndView();
		questionReplyService.deleteQuestionReply(breply_id);
		//插入完成后马上回到list列表
		List<QuestionReply> allquestionreply=questionReplyService.questionreplyList();
		//mav存放转发到jsp页面的参数
		mav.addObject("questionreply",allquestionreply);//mav相当于一个hashmap
		//哈哈
		//mav.addObject("address","http://localhost:8080/Card-Campus-Server/listQuestionReply");
		//放入将要跳转的jsp文件名
		mav.setViewName("QuestionReplyCurd/QuestionReplyList");
		return mav;
	}
	
	/**
	 * 客户端
	 */
	//处理来自客户端的请求，并将json格式的数据处理结果返回。
    @RequestMapping("getQuestionReplyList")
    public void getQuestionReplyList(HttpServletRequest request, HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        List<QuestionReply> allReply=questionReplyService.questionreplyList();
        JSONArray arrayReply = JSONArray.fromObject(allReply);
        System.out.println("咋了这是"+allReply.size());
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
	 */
	//处理来自客户端的请求，并将json格式的数据处理结果返回。
    @RequestMapping("addQuestionReply")
    public void addQuestionReply(HttpServletRequest request, HttpServletResponse response){
    	//获取android客户端传递值的方式：在这里拿到需要查找回复数的百事通问题id
        String bpost_id=request.getParameter("bpost_id");
        String breply_id=request.getParameter("breply_id");
        String user_sno = request.getParameter("user_sno");
        String time = request.getParameter("breply_time");
        String breply_content = request.getParameter("breply_content");
         
   
        QuestionPost questionpost = questionPostService.getQuestionPost(bpost_id);
        User user = userService.getUserBySno(user_sno);
        
        long time1 = Long.parseLong(time);
        Timestamp post_time = new Timestamp(time1);
      
        QuestionReply questionreply = new QuestionReply();
        questionreply.setBreply_content(breply_content);
        questionreply.setBreply_id(breply_id);
        questionreply.setBreply_time(post_time);
        questionreply.setQuestionPost(questionpost);
        questionreply.setUser(user);
        
        questionReplyService.addQuestionReply(questionreply);
         

    }
    
    @RequestMapping("getBSTReplysByPostId")
    public void getBSTReplysByPostId(HttpServletRequest request, HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        String bpost_id = request.getParameter("bpost_id");
        List<QuestionReply> allQuestionReplys=questionReplyService.getReplysByPostId(bpost_id);
        JSONArray arrayReplys = JSONArray.fromObject(allQuestionReplys);
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
			byte[] bytes = arrayReplys.toString().getBytes("utf-8");
			
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
