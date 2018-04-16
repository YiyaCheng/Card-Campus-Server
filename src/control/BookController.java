package control;//这个包在springMVC.xml进行了注册

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pojo.Book;
import service.BookService;

@Controller//告诉spring mvc这是一个控制器类
@RequestMapping("")//接收用户请求
public class BookController {
	//所有的调用都是通过这个类
	@Autowired
	BookService bookService;//不需要new
	
	@RequestMapping("listBook")//相当于struts.xml中的action的名字name
	public ModelAndView ListBook(){
		ModelAndView mav=new ModelAndView();//充当原来set/get方法
		List<Book> cs=bookService.list();
		//mav存放转发到jsp页面的参数
		mav.addObject("cs",cs);//mav相当于一个hashmap
		//放入将要跳转的jsp文件名
		mav.setViewName("curp/BookList");
		return mav;//return给框架
	}
	
	@RequestMapping("addBook")
	public ModelAndView addBook(Book book) {
		ModelAndView mav=new ModelAndView();
		bookService.add(book);
		//插入完成后马上回到list列表
		List<Book> cs=bookService.list();
		//mav存放转发到jsp页面的参数
		mav.addObject("cs",cs);//mav相当于一个hashmap
		//放入将要跳转的jsp文件名
		mav.setViewName("BookList");
		return mav;
	}
	
	@RequestMapping("deleBook")
	public ModelAndView deleBook(int bookId) {
		ModelAndView mav=new ModelAndView();
		bookService.delete(bookId);
		//插入完成后马上回到list列表
		List<Book> cs=bookService.list();
		//mav存放转发到jsp页面的参数
		mav.addObject("cs",cs);//mav相当于一个hashmap
		//放入将要跳转的jsp文件名
		mav.setViewName("BookList");
		return mav;
	}
	
	@RequestMapping("loadBook")
	public ModelAndView loadBook(int bookId) {
		ModelAndView mav=new ModelAndView();
		Book book=bookService.get(bookId);
		
		//mav存放转发到jsp页面的参数
		mav.addObject("book",book);//mav相当于一个hashmap
		//放入将要跳转的jsp文件名
		mav.setViewName("BookEdit");
		return mav;
	}
	
	@RequestMapping("editBook")
	public ModelAndView editBook(Book book) {
		ModelAndView mav=new ModelAndView();
		bookService.update(book);
		List<Book> cs=bookService.list();
		//mav存放转发到jsp页面的参数
		mav.addObject("cs",cs);//mav相当于一个hashmap
		//放入将要跳转的jsp文件名
		mav.setViewName("BookList");
		return mav;
	}
}
