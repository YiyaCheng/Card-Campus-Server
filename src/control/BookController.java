package control;//�������springMVC.xml������ע��

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pojo.Book;
import service.BookService;

@Controller//����spring mvc����һ����������
@RequestMapping("")//�����û�����
public class BookController {
	//���еĵ��ö���ͨ�������
	@Autowired
	BookService bookService;//����Ҫnew
	
	@RequestMapping("listBook")//�൱��struts.xml�е�action������name
	public ModelAndView ListBook(){
		ModelAndView mav=new ModelAndView();//�䵱ԭ��set/get����
		List<Book> cs=bookService.list();
		//mav���ת����jspҳ��Ĳ���
		mav.addObject("cs",cs);//mav�൱��һ��hashmap
		//���뽫Ҫ��ת��jsp�ļ���
		mav.setViewName("curp/BookList");
		return mav;//return�����
	}
	
	@RequestMapping("addBook")
	public ModelAndView addBook(Book book) {
		ModelAndView mav=new ModelAndView();
		bookService.add(book);
		//������ɺ����ϻص�list�б�
		List<Book> cs=bookService.list();
		//mav���ת����jspҳ��Ĳ���
		mav.addObject("cs",cs);//mav�൱��һ��hashmap
		//���뽫Ҫ��ת��jsp�ļ���
		mav.setViewName("BookList");
		return mav;
	}
	
	@RequestMapping("deleBook")
	public ModelAndView deleBook(int bookId) {
		ModelAndView mav=new ModelAndView();
		bookService.delete(bookId);
		//������ɺ����ϻص�list�б�
		List<Book> cs=bookService.list();
		//mav���ת����jspҳ��Ĳ���
		mav.addObject("cs",cs);//mav�൱��һ��hashmap
		//���뽫Ҫ��ת��jsp�ļ���
		mav.setViewName("BookList");
		return mav;
	}
	
	@RequestMapping("loadBook")
	public ModelAndView loadBook(int bookId) {
		ModelAndView mav=new ModelAndView();
		Book book=bookService.get(bookId);
		
		//mav���ת����jspҳ��Ĳ���
		mav.addObject("book",book);//mav�൱��һ��hashmap
		//���뽫Ҫ��ת��jsp�ļ���
		mav.setViewName("BookEdit");
		return mav;
	}
	
	@RequestMapping("editBook")
	public ModelAndView editBook(Book book) {
		ModelAndView mav=new ModelAndView();
		bookService.update(book);
		List<Book> cs=bookService.list();
		//mav���ת����jspҳ��Ĳ���
		mav.addObject("cs",cs);//mav�൱��һ��hashmap
		//���뽫Ҫ��ת��jsp�ļ���
		mav.setViewName("BookList");
		return mav;
	}
}
