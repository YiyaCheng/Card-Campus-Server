package control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pojo.BookPost;
import pojo.User;
import service.BookPostService;
import service.UserService;

@Controller
@RequestMapping("")
public class BookPostController {
	@Autowired
	BookPostService bookPostService;
	
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
	public ModelAndView deleteBookPost(int book_id) {
		ModelAndView mav=new ModelAndView();
		bookPostService.deleteBookPost(book_id);
		//插入完成后马上回到list列表
		List<BookPost> allbookpost=bookPostService.bookpostList();
		//mav存放转发到jsp页面的参数
		mav.addObject("bookpost",allbookpost);//mav相当于一个hashmap
		mav.addObject("address","http://localhost:8080/Card-Campus-Server/listBookPost");
		//放入将要跳转的jsp文件名
		mav.setViewName("index");
		return mav;
	}
}
