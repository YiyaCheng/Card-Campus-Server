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
	public ModelAndView deleteBookPost(String book_id) {
		ModelAndView mav=new ModelAndView();
		bookPostService.deleteBookPost(book_id);
		//������ɺ����ϻص�list�б�
		List<BookPost> allbookpost=bookPostService.bookpostList();
		//mav���ת����jspҳ��Ĳ���
		mav.addObject("bookpost",allbookpost);//mav�൱��һ��hashmap
		//mav.addObject("address","http://localhost:8080/Card-Campus-Server/listBookPost");
		//���뽫Ҫ��ת��jsp�ļ���
		mav.setViewName("BookPostCurd/BookPostList");
		return mav;
	}
	
	
	/**
	 * �ͻ���
	 */
	//�������Կͻ��˵����󣬲���json��ʽ�����ݴ��������ء�
    @RequestMapping("getBookList")
    public void getQuestionPostFromClient(HttpServletRequest request, HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        List<BookPost> allBookPost=bookPostService.bookpostList();
        JSONArray arrayBookPost = JSONArray.fromObject(allBookPost);
        System.out.println(allBookPost.get(0).getIs_sold());
        /*
		 * �ȷ�װ��text���ַ��� ��ת����JSON
		 * ��׿Activity��������ʾֻ��UTF-8��GBK������Ŷ
		 * ������ָ�ڿͻ�����ʾ�ı����ʽ
		 */
		response.setContentType("text/json;charset=utf-8");
		
		/*
		 * ������ָ�����紫������еı��뷽ʽ
		 */
		response.setCharacterEncoding("utf-8");
		
		/*
		 * �ùܵ�����������
		 * ��JSONת����byte�ٴ�
		 * ���뷽ʽUTF-8��
		 */
		try {
			byte[] bytes = arrayBookPost.toString().getBytes("utf-8");
			
			//���ֽ�����д�������
			response.getOutputStream().write(bytes);
			
			//���ô������ݵĳ��ȣ�����response����
			response.setContentLength(bytes.length);
			
			//��ջ��棨�ѻ������ȫ������ȥ
			response.getOutputStream().flush();
			
			//����Ҫ����
			response.getOutputStream().close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};

    }
    
    /**
	 * �ͻ���
	 * 
	 */
	//�������Կͻ��˵����󣬲���json��ʽ�����ݴ��������ء�
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
	 * �ͻ���
	 * �û��޸��Լ��Ķ�����
	 */
	//�������Կͻ��˵����󣬲���json��ʽ�����ݴ��������ء�
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
