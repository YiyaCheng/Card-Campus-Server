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
	
	@RequestMapping("listBookPost")//�൱��struts.xml�е�action������name
	public ModelAndView ListBookPost(){
		ModelAndView mav=new ModelAndView();//�䵱ԭ��set/get����
		List<BookPost> allbookpost=bookPostService.bookpostList();
		//mav���ת����jspҳ��Ĳ���
		mav.addObject("bookpost",allbookpost);//mav�൱��һ��hashmap
		//���뽫Ҫ��ת��jsp�ļ���
		mav.setViewName("BookPostCurd/BookPostList");
		return mav;//return�����
	}
	
	@RequestMapping("deleteBookPost")
	public ModelAndView deleteBookPost(int book_id) {
		ModelAndView mav=new ModelAndView();
		bookPostService.deleteBookPost(book_id);
		//������ɺ����ϻص�list�б�
		List<BookPost> allbookpost=bookPostService.bookpostList();
		//mav���ת����jspҳ��Ĳ���
		mav.addObject("bookpost",allbookpost);//mav�൱��һ��hashmap
		mav.addObject("address","http://localhost:8080/Card-Campus-Server/listBookPost");
		//���뽫Ҫ��ת��jsp�ļ���
		mav.setViewName("index");
		return mav;
	}
}
