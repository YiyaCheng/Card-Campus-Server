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
import pojo.LovePost;
import pojo.LoveReply;
import pojo.User;
import service.LovePostService;
import service.LoveReplyService;
import service.UserService;

@Controller
@RequestMapping("")
public class LoveReplyController {
	@Autowired
	LoveReplyService loveReplyService;
	@Autowired
	LovePostService lovePostService;
	@Autowired
	UserService userService;
	
	
	@RequestMapping("listLoveReply")//相当于struts.xml中的action的名字name
	public ModelAndView listLoveReply(){
		ModelAndView mav=new ModelAndView();//充当原来set/get方法
		List<LoveReply> alllovereply=loveReplyService.lovereplyList();
		//mav存放转发到jsp页面的参数
		mav.addObject("lovereply",alllovereply);//mav相当于一个hashmap
		//放入将要跳转的jsp文件名
		mav.setViewName("LovePostReplyCurd/LovePostReplyList");
		return mav;//return给框架
	}
	
	@RequestMapping("deleteLoveReply")
	public ModelAndView deleteLoveReply(String lreply_id) {
		ModelAndView mav=new ModelAndView();
		loveReplyService.deleteLoveReply(lreply_id);
		//插入完成后马上回到list列表
		List<LoveReply> alllovereply=loveReplyService.lovereplyList();
		//mav存放转发到jsp页面的参数
		mav.addObject("lovereply",alllovereply);//mav相当于一个hashmap
		//mav.addObject("address","http://localhost:8080/Card-Campus-Server/listLoveReply");
		//放入将要跳转的jsp文件名
		mav.setViewName("LovePostReplyCurd/LovePostReplyList");
		
		return mav;
	}
	
	@RequestMapping("getLoveReplyList")
	public void getLoveReplyList(HttpServletRequest request, HttpServletResponse response) {
		JSONObject jsonObject = new JSONObject();
		List<LoveReply> allReply=loveReplyService.lovereplyList();
		JSONArray arrayReply = JSONArray.fromObject(allReply);
		response.setContentType("text/json;charset=utf-8");
		response.setCharacterEncoding("utf-8");
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
	
	@RequestMapping("addLoveReply")
	public void addLoveReply(HttpServletRequest request, HttpServletResponse response) {
		String love_id=request.getParameter("love_id");
		String lreply_id=request.getParameter("lreply_id");
		String user_sno = request.getParameter("user_sno");
        String time = request.getParameter("lreply_time");
        String lreply_content = request.getParameter("lreply_content");
		
        LovePost lovePost=lovePostService.getLovePost(love_id);
        User user=userService.getUserBySno(user_sno);
        time=time.substring(0,time.length()-2);
        long time1 = Long.parseLong(time);
        Timestamp lreply_time = new Timestamp(time1);
        
        LoveReply loveReply = new LoveReply();
        loveReply.setLovepost(lovePost);
        loveReply.setLreply_id(lreply_id);
        loveReply.setUser(user);
        loveReply.setLreply_content(lreply_content);
        loveReply.setLreply_time(lreply_time);
       
        loveReplyService.addLoveReply(loveReply);
	}
	
	
}
