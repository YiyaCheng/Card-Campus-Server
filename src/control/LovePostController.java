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
import service.LovePostService;
import service.LoveReplyService;
import service.UserService;

@Controller
@RequestMapping("")
public class LovePostController {
	@Autowired
	LovePostService lovePostService;
	@Autowired
	LoveReplyService loveReplyService;
	@Autowired
	UserService userService;
	
	@RequestMapping("listLovePost")//相当于struts.xml中的action的名字name
	public ModelAndView ListLovePost(){
		ModelAndView mav=new ModelAndView();//充当原来set/get方法
		List<LovePost> alllovepost=lovePostService.lovepostList();
		//mav存放转发到jsp页面的参数
		mav.addObject("lovepost",alllovepost);//mav相当于一个hashmap
		//放入将要跳转的jsp文件名
		mav.setViewName("LovePostCurd/LovePostList");
		return mav;//return给框架
	}
	
	@RequestMapping("getLovePostList")
    public void getLovePostFromClient(HttpServletRequest request, HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        List<LovePost> alllovepost=lovePostService.lovepostList();
        JSONArray arrayLovepost = JSONArray.fromObject(alllovepost);
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
			byte[] bytes = arrayLovepost.toString().getBytes("utf-8");
			
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
	 * 添加一条表白记录
	 */
  
    
    @RequestMapping("addLovepost")
	public void addLovepost(HttpServletRequest request, HttpServletResponse response) {
    	String love_id=request.getParameter("love_id");
    	String love_username=request.getParameter("love_username");
        String time = request.getParameter("love_time");
        String love_content = request.getParameter("love_content");
        String love_title = request.getParameter("love_title");
        String is_anonymous = request.getParameter("is_anonymous");
        
        
        int namestate=Integer.parseInt(is_anonymous);
        //User user = userService.getUserBySno(user_sno);
        
        long time1 = Long.parseLong(time);
        Timestamp post_time = new Timestamp(time1);
      
        LovePost lovepost = new LovePost();
        lovepost.setLove_id(love_id);
        lovepost.setLove_title(love_title);
        lovepost.setLove_content(love_content);
        lovepost.setLove_username(love_username);
        lovepost.setLove_time(post_time);
        lovepost.setIs_anonymous(namestate);
        
        lovePostService.addLovePost(lovepost);
	}
	
	
	
	@RequestMapping("deleteLovePost")
	public ModelAndView deleteLovePost(String love_id) {
		ModelAndView mav=new ModelAndView();
		lovePostService.deleteLovePost(love_id);
		//插入完成后马上回到list列表
		List<LovePost> alllovepost=lovePostService.lovepostList();
		//mav存放转发到jsp页面的参数
		mav.addObject("lovepost",alllovepost);//mav相当于一个hashmap
		//mav.addObject("address","http://localhost:8080/Card-Campus-Server/listLovePost");
		//放入将要跳转的jsp文件名
		mav.setViewName("LovePostCurd/LovePostList");
		return mav;
	}
	/**
	 * 客户端
	 * 得到所有帖子的回复
	 */
	@RequestMapping("getLoveReplyNum")
	public void getLoveReplyNum(HttpServletRequest request, HttpServletResponse response){
		
		String love_id=request.getParameter("love_id");
		System.out.println("kalskaoaos"+love_id);
		
		List<LoveReply> allReply=loveReplyService.getLoveReplyById(love_id);
		//jsonObject.put("lovereply",allReply);
		
		for(int i=0;i<allReply.size();i++) {
			System.out.println(allReply.get(i).getLreply_content());
			System.out.println(allReply.get(i).getLovepost().getLove_id());
		}
		
		JSONArray arrayReply = JSONArray.fromObject(allReply);
		
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
}
