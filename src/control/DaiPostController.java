package control;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import pojo.DaiPost;
import pojo.User;
import service.DaiPostService;
import service.UserService;

@Controller
@RequestMapping("")
public class DaiPostController {
	@Autowired
	DaiPostService daiPostService;
	
	@RequestMapping("daiNum")
	public void daiNum(HttpServletResponse response) {
		
		JSONObject jsonObject = new JSONObject();
        int count=daiPostService.daiNum();
        jsonObject.put("count", count);
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
			byte[] bytes = jsonObject.toString().getBytes("utf-8");
			
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
	 * 1.���ε���ز���
	 */
	
	/**
	 * ������
	 */
	@RequestMapping("listDaike")//�൱��struts.xml�е�action������name
	public ModelAndView ListDaike(){
		ModelAndView mav=new ModelAndView();//�䵱ԭ��set/get����
		List<DaiPost> alldaike=daiPostService.daikeList();
		//mav���ת����jspҳ��Ĳ���
		mav.addObject("daike",alldaike);//mav�൱��һ��hashmap
		//���뽫Ҫ��ת��jsp�ļ���
		mav.setViewName("DaiPostCurd/DaikeList");
		return mav;//return�����
	}
	
	@RequestMapping("deleteDaike")
	public ModelAndView deleteDaike(int dpost_id) {
		ModelAndView mav=new ModelAndView();
		daiPostService.deleteDaike(dpost_id);
		//������ɺ����ϻص�list�б�
		List<DaiPost> alldaike=daiPostService.daikeList();
		//mav���ת����jspҳ��Ĳ���
		mav.addObject("daike",alldaike);//mav�൱��һ��hashmap
		//mav.addObject("address","http://localhost:8080/Card-Campus-Server/listDaike");
		//���뽫Ҫ��ת��jsp�ļ���
		mav.setViewName("DaiPostCurd/DaikeList");
		return mav;
	}
	
	
	/**
	 * �ͻ���
	 */
	//�������Կͻ��˵����󣬲���json��ʽ�����ݴ��������ء�
    @RequestMapping("getDaikeList")
    public void getDaikeFromClient(HttpServletRequest request, HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        List<DaiPost> alldaike=daiPostService.daikeList();
        JSONArray arrayDaike = JSONArray.fromObject(alldaike);
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
			byte[] bytes = arrayDaike.toString().getBytes("utf-8");
			
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
	 * ���һ�����μ�¼
	 */
    @Autowired
	UserService userService;
    
    @RequestMapping("addDaike")
	public void addDaike(HttpServletRequest request, HttpServletResponse response) {
    	String dpost_id=request.getParameter("dpost_id");
        String user_sno = request.getParameter("user_sno");
        String time = request.getParameter("dpost_time");
        String dpost_content = request.getParameter("dpost_content");
        String dpost_title = request.getParameter("dpost_title");
        //String user_qq=request.getParameter("user_qq");
        String dpost_type=request.getParameter("dpost_type");
        String is_solved = request.getParameter("is_solved");
        
        
        int post_id = Integer.parseInt(dpost_id);
        int solved=Integer.parseInt(is_solved);
        User user = userService.getUserBySno(user_sno);
        //System.out.println("QQ:"+user.getUser_qq());
        
        long time1 = Long.parseLong(time);
        Timestamp post_time = new Timestamp(time1);
      
        DaiPost daipost = new DaiPost();
        daipost.setDpost_content(dpost_content);
        daipost.setDpost_id(post_id);
        daipost.setDpost_time(post_time);
        daipost.setDpost_title(dpost_title);
        daipost.setIs_solved(solved);
        daipost.setUser(user);
        daipost.setDpost_type(dpost_type);
        
        System.out.println("dddddddaike");
        daiPostService.addDaike(daipost);
	}
	
	
	/**
	 * 2.������������ز���
	 */
	@RequestMapping("listDaifood")//�൱��struts.xml�е�action������name
	public ModelAndView ListDaifood(){
		ModelAndView mav=new ModelAndView();//�䵱ԭ��set/get����
		List<DaiPost> alldaifood=daiPostService.daifoodList();
		//mav���ת����jspҳ��Ĳ���
		mav.addObject("daifood",alldaifood);//mav�൱��һ��hashmap
		//���뽫Ҫ��ת��jsp�ļ���
		mav.setViewName("DaiPostCurd/DaifoodList");
		return mav;//return�����
	}
	
	@RequestMapping("deleteDaifood")
	public ModelAndView deleteDaifood(int dpost_id) {
		ModelAndView mav=new ModelAndView();
		daiPostService.deleteDaifood(dpost_id);
		//������ɺ����ϻص�list�б�
		List<DaiPost> alldaifood=daiPostService.daifoodList();
		//mav���ת����jspҳ��Ĳ���
		mav.addObject("daifood",alldaifood);//mav�൱��һ��hashmap
		//mav.addObject("address","http://localhost:8080/Card-Campus-Server/listDaifood");
		//���뽫Ҫ��ת��jsp�ļ���
		mav.setViewName("DaiPostCurd/DaifoodList");
		return mav;
	}
	
	@RequestMapping("getDaifoodList")
    public void getDaifoodFromClient(HttpServletRequest request, HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        List<DaiPost> alldaifood=daiPostService.daifoodList();
        JSONArray arrayDaifood = JSONArray.fromObject(alldaifood);
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
			byte[] bytes = arrayDaifood.toString().getBytes("utf-8");
			
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
	 * 3.���ÿ�ݵ���ز���
	 */
	@RequestMapping("listDaideliver")//�൱��struts.xml�е�action������name
	public ModelAndView ListDaideliver(){
		ModelAndView mav=new ModelAndView();//�䵱ԭ��set/get����
		List<DaiPost> alldaideliver=daiPostService.daideliverList();
		//mav���ת����jspҳ��Ĳ���
		mav.addObject("daideliver",alldaideliver);//mav�൱��һ��hashmap
		//���뽫Ҫ��ת��jsp�ļ���
		mav.setViewName("DaiPostCurd/DaideliverList");
		return mav;//return�����
	}
	
	@RequestMapping("deleteDaideliver")
	public ModelAndView deleteDaideliver(int dpost_id) {
		ModelAndView mav=new ModelAndView();
		daiPostService.deleteDaideliver(dpost_id);
		//������ɺ����ϻص�list�б�
		List<DaiPost> alldaideliver=daiPostService.daideliverList();
		//mav���ת����jspҳ��Ĳ���
		mav.addObject("daideliver",alldaideliver);//mav�൱��һ��hashmap
		//mav.addObject("address","http://localhost:8080/Card-Campus-Server/listDaideliver");
		//���뽫Ҫ��ת��jsp�ļ���
		mav.setViewName("DaiPostCurd/DaideliverList");
		return mav;
	}
	
	@RequestMapping("getDaideliverList")
    public void getDaideliverFromClient(HttpServletRequest request, HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        List<DaiPost> alldaideliver=daiPostService.daideliverList();
        JSONArray arrayDaideliver = JSONArray.fromObject(alldaideliver);
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
			byte[] bytes = arrayDaideliver.toString().getBytes("utf-8");
			
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
	 * 4.�������ز���
	 */
	@RequestMapping("listDaiactivity")//�൱��struts.xml�е�action������name
	public ModelAndView ListDaiactivity(){
		ModelAndView mav=new ModelAndView();//�䵱ԭ��set/get����
		List<DaiPost> alldaiactivity=daiPostService.daiactivityList();
		//mav���ת����jspҳ��Ĳ���
		mav.addObject("daiactivity",alldaiactivity);//mav�൱��һ��hashmap
		//���뽫Ҫ��ת��jsp�ļ���
		mav.setViewName("DaiPostCurd/DaiactivityList");
		return mav;//return�����
	}
	
	@RequestMapping("deleteDaiactivity")
	public ModelAndView deleteDaiactivity(int dpost_id) {
		ModelAndView mav=new ModelAndView();
		daiPostService.deleteDaiactivity(dpost_id);
		//������ɺ����ϻص�list�б�
		List<DaiPost> alldaiactivity=daiPostService.daiactivityList();
		//mav���ת����jspҳ��Ĳ���
		mav.addObject("daiactivity",alldaiactivity);//mav�൱��һ��hashmap
		//mav.addObject("address","http://localhost:8080/Card-Campus-Server/listDaiactivity");
		//���뽫Ҫ��ת��jsp�ļ���
		mav.setViewName("DaiPostCurd/DaiactivityList");
		return mav;
	}
	
	@RequestMapping("getDaiactivityList")
    public void getDaiactivityFromClient(HttpServletRequest request, HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        List<DaiPost> alldaiactivity=daiPostService.daiactivityList();
        JSONArray arrayDaiactivity = JSONArray.fromObject(alldaiactivity);
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
			byte[] bytes = arrayDaiactivity.toString().getBytes("utf-8");
			
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
	 * 5.�������ߵ���ز���
	 */
	@RequestMapping("listDaiwalk")//�൱��struts.xml�е�action������name
	public ModelAndView ListDaiwalk(){
		ModelAndView mav=new ModelAndView();//�䵱ԭ��set/get����
		List<DaiPost> alldaiwalk=daiPostService.daiwalkList();
		//mav���ת����jspҳ��Ĳ���
		mav.addObject("daiwalk",alldaiwalk);//mav�൱��һ��hashmap
		//���뽫Ҫ��ת��jsp�ļ���
		mav.setViewName("DaiPostCurd/DaiwalkList");
		return mav;//return�����
	}
	
	@RequestMapping("deleteDaiwalk")
	public ModelAndView deleteDaiwalk(int dpost_id) {
		ModelAndView mav=new ModelAndView();
		daiPostService.deleteDaiwalk(dpost_id);
		//������ɺ����ϻص�list�б�
		List<DaiPost> alldaiwalk=daiPostService.daiwalkList();
		//mav���ת����jspҳ��Ĳ���
		mav.addObject("daiwalk",alldaiwalk);//mav�൱��һ��hashmap
		//mav.addObject("address","http://localhost:8080/Card-Campus-Server/listDaiwalk");
		//���뽫Ҫ��ת��jsp�ļ���
		mav.setViewName("DaiPostCurd/DaiwalkList");
		return mav;
	}
	
	@RequestMapping("getDaiwalkList")
    public void getDaiwalkFromClient(HttpServletRequest request, HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        List<DaiPost> alldaiwalk=daiPostService.daiwalkList();
        JSONArray arrayDaiwalk = JSONArray.fromObject(alldaiwalk);
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
			byte[] bytes = arrayDaiwalk.toString().getBytes("utf-8");
			
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
	 * 6.��������ز���
	 */
	@RequestMapping("listDaibuy")//�൱��struts.xml�е�action������name
	public ModelAndView ListDaibuy(){
		ModelAndView mav=new ModelAndView();//�䵱ԭ��set/get����
		List<DaiPost> alldaibuy=daiPostService.daibuyList();
		//mav���ת����jspҳ��Ĳ���
		mav.addObject("daibuy",alldaibuy);//mav�൱��һ��hashmap
		//���뽫Ҫ��ת��jsp�ļ���
		mav.setViewName("DaiPostCurd/DaibuyList");
		return mav;//return�����
	}
	
	@RequestMapping("deleteDaibuy")
	public ModelAndView deleteDaibuy(int dpost_id) {
		ModelAndView mav=new ModelAndView();
		daiPostService.deleteDaibuy(dpost_id);
		//������ɺ����ϻص�list�б�
		List<DaiPost> alldaibuy=daiPostService.daibuyList();
		//mav���ת����jspҳ��Ĳ���
		mav.addObject("daibuy",alldaibuy);//mav�൱��һ��hashmap
		//mav.addObject("address","http://localhost:8080/Card-Campus-Server/listDaibuy");
		//���뽫Ҫ��ת��jsp�ļ���
		mav.setViewName("DaiPostCurd/DaibuyList");
		return mav;
	}
	
	@RequestMapping("getDaibuyList")
    public void getDaibuyFromClient(HttpServletRequest request, HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        List<DaiPost> alldaibuy=daiPostService.daibuyList();
        JSONArray arrayDaibuy = JSONArray.fromObject(alldaibuy);
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
			byte[] bytes = arrayDaibuy.toString().getBytes("utf-8");
			
			//���ֽ�����д�������/
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
