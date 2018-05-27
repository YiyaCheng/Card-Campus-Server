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
import service.LovePostService;
import service.LoveReplyService;
import service.UserService;

@Controller
@RequestMapping("")
public class LovePostController {
	@Autowired
	LovePostService lovePostService;
	@Autowired
	LoveReplyService loveReplyService;
	@Autowired
	UserService userService;
	
	@RequestMapping("listLovePost")//�൱��struts.xml�е�action������name
	public ModelAndView ListLovePost(){
		ModelAndView mav=new ModelAndView();//�䵱ԭ��set/get����
		List<LovePost> alllovepost=lovePostService.lovepostList();
		//mav���ת����jspҳ��Ĳ���
		mav.addObject("lovepost",alllovepost);//mav�൱��һ��hashmap
		//���뽫Ҫ��ת��jsp�ļ���
		mav.setViewName("LovePostCurd/LovePostList");
		return mav;//return�����
	}
	
	@RequestMapping("getLovePostList")
    public void getLovePostFromClient(HttpServletRequest request, HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        List<LovePost> alllovepost=lovePostService.lovepostList();
        JSONArray arrayLovepost = JSONArray.fromObject(alllovepost);
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
			byte[] bytes = arrayLovepost.toString().getBytes("utf-8");
			
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
	/*
	 * �ͻ���
	 * ���һ����׼�¼
	 */
  
    
    @RequestMapping("addLovepost")
	public void addLovepost(HttpServletRequest request, HttpServletResponse response) {
    	String love_id=request.getParameter("love_id");
    	String love_username=request.getParameter("love_username");
        String time = request.getParameter("love_time");
        String love_content = request.getParameter("love_content");
        String love_title = request.getParameter("love_title");
        String is_anonymous = request.getParameter("is_anonymous");
        
        
        int namestate=Integer.parseInt(is_anonymous);
        //User user = userService.getUserBySno(user_sno);
        
        long time1 = Long.parseLong(time);
        Timestamp post_time = new Timestamp(time1);
      
        LovePost lovepost = new LovePost();
        lovepost.setLove_id(love_id);
        lovepost.setLove_title(love_title);
        lovepost.setLove_content(love_content);
        lovepost.setLove_username(love_username);
        lovepost.setLove_time(post_time);
        lovepost.setIs_anonymous(namestate);
        
        lovePostService.addLovePost(lovepost);
	}
	
	
	
	@RequestMapping("deleteLovePost")
	public ModelAndView deleteLovePost(String love_id) {
		ModelAndView mav=new ModelAndView();
		lovePostService.deleteLovePost(love_id);
		//������ɺ����ϻص�list�б�
		List<LovePost> alllovepost=lovePostService.lovepostList();
		//mav���ת����jspҳ��Ĳ���
		mav.addObject("lovepost",alllovepost);//mav�൱��һ��hashmap
		//mav.addObject("address","http://localhost:8080/Card-Campus-Server/listLovePost");
		//���뽫Ҫ��ת��jsp�ļ���
		mav.setViewName("LovePostCurd/LovePostList");
		return mav;
	}
	/**
	 * �ͻ���
	 * �õ��������ӵĻظ�
	 */
	@RequestMapping("getLoveReplyNum")
	public void getLoveReplyNum(HttpServletRequest request, HttpServletResponse response){
		
		String love_id=request.getParameter("love_id");
		System.out.println("kalskaoaos"+love_id);
		
		List<LoveReply> allReply=loveReplyService.getLoveReplyById(love_id);
		//jsonObject.put("lovereply",allReply);
		
		for(int i=0;i<allReply.size();i++) {
			System.out.println(allReply.get(i).getLreply_content());
			System.out.println(allReply.get(i).getLovepost().getLove_id());
		}
		
		JSONArray arrayReply = JSONArray.fromObject(allReply);
		
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
