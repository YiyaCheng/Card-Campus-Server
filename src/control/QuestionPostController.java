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
	 * ������
	 */
	@RequestMapping("listQuestionPost")//�൱��struts.xml�е�action������name
	public ModelAndView listQuestionPost(){
		ModelAndView mav=new ModelAndView();//�䵱ԭ��set/get����
		List<QuestionPost> allquestionpost=questionPostService.questionpostList();
		//mav���ת����jspҳ��Ĳ���
		mav.addObject("questionpost",allquestionpost);//mav�൱��һ��hashmap
		//���뽫Ҫ��ת��jsp�ļ���
		mav.setViewName("QuestionPostCurd/QuestionPostList");
		return mav;//return�����
	}
	
	@RequestMapping("deleteQuestionPost")
	public ModelAndView deleteQuestionPost(int bpost_id) {
		ModelAndView mav=new ModelAndView();
		questionPostService.deleteQuestionPost(bpost_id);
		//������ɺ����ϻص�list�б�
		List<QuestionPost> allquestionpost=questionPostService.questionpostList();
		//mav���ת����jspҳ��Ĳ���
		mav.addObject("questionpost",allquestionpost);//mav�൱��һ��hashmap
		//mav.addObject("address","http://localhost:8080/Card-Campus-Server/listQuestionPost");
		//���뽫Ҫ��ת��jsp�ļ���
		mav.setViewName("QuestionPostCurd/QuestionPostList");
		return mav;
	}
	
	/**
	 * �ͻ���
	 */
	//�������Կͻ��˵����󣬲���json��ʽ�����ݴ��������ء�
    @RequestMapping("getQuestionPostList")
    public void getQuestionPostFromClient(HttpServletRequest request, HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        List<QuestionPost> allQuestionPost=questionPostService.questionpostList();
        JSONArray arrayQuestionPost = JSONArray.fromObject(allQuestionPost);
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
			byte[] bytes = arrayQuestionPost.toString().getBytes("utf-8");
			
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
	 * �õ��������ӵĻظ�����
	 */
	//�������Կͻ��˵����󣬲���json��ʽ�����ݴ��������ء�
    @RequestMapping("getQuestionPostReplyNum")
    public void getQuestionPostReplyNum(HttpServletRequest request, HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        
        //��ȡandroid�ͻ��˴���ֵ�ķ�ʽ���������õ���Ҫ���һظ����İ���ͨ����id
        String bpost_id=request.getParameter("bpost_id");
        int post_id = Integer.parseInt(bpost_id);
        
        List<QuestionReply> allReply=questionReplyService.getReplysByPostId(post_id);
        JSONArray arrayReply = JSONArray.fromObject(allReply);
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
			byte[] bytes = arrayReply.toString().getBytes("utf-8");
			
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
	 * ������ɾ��һ��ָ��id�ļ�¼���������κβ���
	 */
	//�������Կͻ��˵����󣬲���json��ʽ�����ݴ��������ء�
    @RequestMapping("deleteSelectedPost")
    public void deleteSelectedPost(HttpServletRequest request, HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        
        //��ȡandroid�ͻ��˴���ֵ�ķ�ʽ���������õ���Ҫ���һظ����İ���ͨ����id
        String bpost_id=request.getParameter("bpost_id");
        int post_id = Integer.parseInt(bpost_id);
        
        questionPostService.deleteQuestionPost(post_id);
        
    }
    
    
    /**
	 * �ͻ���
	 * ���һ������ͨ��¼
	 */
	//�������Կͻ��˵����󣬲���json��ʽ�����ݴ��������ء�
    @RequestMapping("addQuestionPost")
    public void addQuestionPost(HttpServletRequest request, HttpServletResponse response){
        //��ȡandroid�ͻ��˴���ֵ�ķ�ʽ���������õ���Ҫ���һظ����İ���ͨ����id
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
	 * �ͻ���
	 * ����һ������ͨ��¼
	 */
	//�������Կͻ��˵����󣬲���json��ʽ�����ݴ��������ء�
    @RequestMapping("editQuestionPost")
    public void editQuestionPost(HttpServletRequest request, HttpServletResponse response){
        //��ȡandroid�ͻ��˴���ֵ�ķ�ʽ���������õ���Ҫ���һظ����İ���ͨ����id
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
        
        System.out.println("��������");
        
    }
}
