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
import pojo.User;
import service.LovePostService;
import service.LoveReplyService;
import service.UserService;

@Controller
@RequestMapping("")
public class LoveReplyController {
	@Autowired
	LoveReplyService loveReplyService;
	@Autowired
	LovePostService lovePostService;
	@Autowired
	UserService userService;
	
	
	@RequestMapping("listLoveReply")//�൱��struts.xml�е�action������name
	public ModelAndView listLoveReply(){
		ModelAndView mav=new ModelAndView();//�䵱ԭ��set/get����
		List<LoveReply> alllovereply=loveReplyService.lovereplyList();
		//mav���ת����jspҳ��Ĳ���
		mav.addObject("lovereply",alllovereply);//mav�൱��һ��hashmap
		//���뽫Ҫ��ת��jsp�ļ���
		mav.setViewName("LovePostReplyCurd/LovePostReplyList");
		return mav;//return�����
	}
	
	@RequestMapping("deleteLoveReply")
	public ModelAndView deleteLoveReply(String lreply_id) {
		ModelAndView mav=new ModelAndView();
		loveReplyService.deleteLoveReply(lreply_id);
		//������ɺ����ϻص�list�б�
		List<LoveReply> alllovereply=loveReplyService.lovereplyList();
		//mav���ת����jspҳ��Ĳ���
		mav.addObject("lovereply",alllovereply);//mav�൱��һ��hashmap
		//mav.addObject("address","http://localhost:8080/Card-Campus-Server/listLoveReply");
		//���뽫Ҫ��ת��jsp�ļ���
		mav.setViewName("LovePostReplyCurd/LovePostReplyList");
		
		return mav;
	}
	
	@RequestMapping("getLoveReplyList")
	public void getLoveReplyList(HttpServletRequest request, HttpServletResponse response) {
		JSONObject jsonObject = new JSONObject();
		List<LoveReply> allReply=loveReplyService.lovereplyList();
		JSONArray arrayReply = JSONArray.fromObject(allReply);
		response.setContentType("text/json;charset=utf-8");
		response.setCharacterEncoding("utf-8");
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
	
	@RequestMapping("addLoveReply")
	public void addLoveReply(HttpServletRequest request, HttpServletResponse response) {
		String love_id=request.getParameter("love_id");
		String lreply_id=request.getParameter("lreply_id");
		String user_sno = request.getParameter("user_sno");
        String time = request.getParameter("lreply_time");
        String lreply_content = request.getParameter("lreply_content");
		
        LovePost lovePost=lovePostService.getLovePost(love_id);
        User user=userService.getUserBySno(user_sno);
        time=time.substring(0,time.length()-2);
        long time1 = Long.parseLong(time);
        Timestamp lreply_time = new Timestamp(time1);
        
        LoveReply loveReply = new LoveReply();
        loveReply.setLovepost(lovePost);
        loveReply.setLreply_id(lreply_id);
        loveReply.setUser(user);
        loveReply.setLreply_content(lreply_content);
        loveReply.setLreply_time(lreply_time);
       
        loveReplyService.addLoveReply(loveReply);
	}
	
	
}
