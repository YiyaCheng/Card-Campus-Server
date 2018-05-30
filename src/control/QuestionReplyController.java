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
	
	@RequestMapping("listQuestionReply")//�൱��struts.xml�е�action������name
	public ModelAndView listQuestionReply(){
		ModelAndView mav=new ModelAndView();//�䵱ԭ��set/get����
		List<QuestionReply> allquestionreply=questionReplyService.questionreplyList();
		//mav���ת����jspҳ��Ĳ���
		mav.addObject("questionreply",allquestionreply);//mav�൱��һ��hashmap
		//���뽫Ҫ��ת��jsp�ļ���
		mav.setViewName("QuestionReplyCurd/QuestionReplyList");
		return mav;//return�����
	}
	
	@RequestMapping("deleteQuestionReply")
	public ModelAndView deleteQuestionReply(String breply_id) {
		ModelAndView mav=new ModelAndView();
		questionReplyService.deleteQuestionReply(breply_id);
		//������ɺ����ϻص�list�б�
		List<QuestionReply> allquestionreply=questionReplyService.questionreplyList();
		//mav���ת����jspҳ��Ĳ���
		mav.addObject("questionreply",allquestionreply);//mav�൱��һ��hashmap
		//����
		//mav.addObject("address","http://localhost:8080/Card-Campus-Server/listQuestionReply");
		//���뽫Ҫ��ת��jsp�ļ���
		mav.setViewName("QuestionReplyCurd/QuestionReplyList");
		return mav;
	}
	
	/**
	 * �ͻ���
	 */
	//�������Կͻ��˵����󣬲���json��ʽ�����ݴ��������ء�
    @RequestMapping("getQuestionReplyList")
    public void getQuestionReplyList(HttpServletRequest request, HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        List<QuestionReply> allReply=questionReplyService.questionreplyList();
        JSONArray arrayReply = JSONArray.fromObject(allReply);
        System.out.println("զ������"+allReply.size());
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
	 */
	//�������Կͻ��˵����󣬲���json��ʽ�����ݴ��������ء�
    @RequestMapping("addQuestionReply")
    public void addQuestionReply(HttpServletRequest request, HttpServletResponse response){
    	//��ȡandroid�ͻ��˴���ֵ�ķ�ʽ���������õ���Ҫ���һظ����İ���ͨ����id
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
			byte[] bytes = arrayReplys.toString().getBytes("utf-8");
			
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
}
