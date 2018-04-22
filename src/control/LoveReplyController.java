package control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pojo.LoveReply;
import service.LoveReplyService;

@Controller
@RequestMapping("")
public class LoveReplyController {
	@Autowired
	LoveReplyService loveReplyService;
	
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
	public ModelAndView deleteLoveReply(int lreply_id) {
		ModelAndView mav=new ModelAndView();
		loveReplyService.deleteLoveReply(lreply_id);
		//������ɺ����ϻص�list�б�
		List<LoveReply> alllovereply=loveReplyService.lovereplyList();
		//mav���ת����jspҳ��Ĳ���
		mav.addObject("lovereply",alllovereply);//mav�൱��һ��hashmap
		mav.addObject("address","http://localhost:8080/Card-Campus-Server/listLoveReply");
		//���뽫Ҫ��ת��jsp�ļ���
		mav.setViewName("index");
		
		return mav;
	}
}
