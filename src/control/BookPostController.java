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
import pojo.BookPost;
import pojo.DaiPost;
import pojo.QuestionPost;
import pojo.User;
import service.BookPostService;
import service.UserService;

@Controller
@RequestMapping("")
public class BookPostController {
	@Autowired
	BookPostService bookPostService;
	@Autowired
	UserService userService;
	
	@RequestMapping("listBookPost")//相当于struts.xml中的action的名字name
	public ModelAndView ListBookPost(){
		ModelAndView mav=new ModelAndView();//充当原来set/get方法
		List<BookPost> allbookpost=bookPostService.bookpostList();
		//mav存放转发到jsp页面的参数
		mav.addObject("bookpost",allbookpost);//mav相当于一个hashmap
		//放入将要跳转的jsp文件名
		mav.setViewName("BookPostCurd/BookPostList");
		return mav;//return给框架
	}
	
	@RequestMapping("deleteBookPost")
	public ModelAndView deleteBookPost(String book_id) {
		ModelAndView mav=new ModelAndView();
		bookPostService.deleteBookPost(book_id);
		//插入完成后马上回到list列表
		List<BookPost> allbookpost=bookPostService.bookpostList();
		//mav存放转发到jsp页面的参数
		mav.addObject("bookpost",allbookpost);//mav相当于一个hashmap
		//mav.addObject("address","http://localhost:8080/Card-Campus-Server/listBookPost");
		//放入将要跳转的jsp文件名
		mav.setViewName("BookPostCurd/BookPostList");
		return mav;
	}
	
	
	/**
	 * 客户端
	 */
	//处理来自客户端的请求，并将json格式的数据处理结果返回。
    @RequestMapping("getBookList")
    public void getQuestionPostFromClient(HttpServletRequest request, HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        List<BookPost> allBookPost=bookPostService.bookpostList();
        JSONArray arrayBookPost = JSONArray.fromObject(allBookPost);
        System.out.println(allBookPost.get(0).getIs_sold());
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
			byte[] bytes = arrayBookPost.toString().getBytes("utf-8");
			
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
	 * 
	 */
	//处理来自客户端的请求，并将json格式的数据处理结果返回。
    @RequestMapping("addBookPost")
    public void addQuestionPost(HttpServletRequest request, HttpServletResponse response){
         
        String book_id=request.getParameter("book_id");
        String book_img=request.getParameter("book_img");
        String user_sno = request.getParameter("user_sno");
        String time = request.getParameter("book_time");
        String book_describe = request.getParameter("book_describe");
        String book_title = request.getParameter("book_title");
        int is_sold = Integer.parseInt(request.getParameter("is_sold"));
        
        
        User user = userService.getUserBySno(user_sno);
        
        long time1 = Long.parseLong(time);
        Timestamp post_time = new Timestamp(time1);
      
        BookPost bookpost = new BookPost();
        bookpost.setBook_describe(book_describe);
        bookpost.setBook_id(book_id);
        bookpost.setBook_img(book_img);
        bookpost.setBook_time(post_time);
        bookpost.setBook_title(book_title);
        bookpost.setUser(user);
        bookpost.setIs_sold(is_sold);

        bookPostService.addBookPost(bookpost);
 
    }
    
    
    /**
	 * 客户端
	 * 用户修改自己的二手书
	 */
	//处理来自客户端的请求，并将json格式的数据处理结果返回。
    @RequestMapping("editBookPost")
    public void editDaiPost(HttpServletRequest request, HttpServletResponse response){
        
        String book_id=request.getParameter("book_id");
        String user_sno = request.getParameter("user_sno");
        String time = request.getParameter("book_time");
        String book_describe = request.getParameter("book_describe");
        
        String book_title = request.getParameter("book_title");
        int is_sold=Integer.parseInt(request.getParameter("is_sold"));
        
         
        User user = userService.getUserBySno(user_sno);
        
        long time1 = Long.parseLong(time);
        Timestamp post_time = new Timestamp(time1);
      
        BookPost bookpost = new BookPost();
        bookpost.setBook_describe(book_describe);
        bookpost.setBook_id(book_id);
        
        bookpost.setBook_time(post_time);
        bookpost.setBook_title(book_title);
        bookpost.setIs_sold(is_sold);
        bookpost.setUser(user);
       
 
        
        bookPostService.updateBookPost(bookpost);
        
    }
    
}
