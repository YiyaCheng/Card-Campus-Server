package control;

import java.io.IOException;
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
import service.QuestionPostService;
import service.QuestionReplyService;

@Controller
@RequestMapping("")
public class QuestionPostController {
	@Autowired
	QuestionPostService questionPostService;
	
	@Autowired
	QuestionReplyService questionReplyService;
	
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
		mav.addObject("address","http://localhost:8080/Card-Campus-Server/listQuestionPost");
		//���뽫Ҫ��ת��jsp�ļ���
		mav.setViewName("index");
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
	
}
