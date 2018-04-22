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
	
	@RequestMapping("listLoveReply")//相当于struts.xml中的action的名字name
	public ModelAndView listLoveReply(){
		ModelAndView mav=new ModelAndView();//充当原来set/get方法
		List<LoveReply> alllovereply=loveReplyService.lovereplyList();
		//mav存放转发到jsp页面的参数
		mav.addObject("lovereply",alllovereply);//mav相当于一个hashmap
		//放入将要跳转的jsp文件名
		mav.setViewName("LovePostReplyCurd/LovePostReplyList");
		return mav;//return给框架
	}
	
	@RequestMapping("deleteLoveReply")
	public ModelAndView deleteLoveReply(int lreply_id) {
		ModelAndView mav=new ModelAndView();
		loveReplyService.deleteLoveReply(lreply_id);
		//插入完成后马上回到list列表
		List<LoveReply> alllovereply=loveReplyService.lovereplyList();
		//mav存放转发到jsp页面的参数
		mav.addObject("lovereply",alllovereply);//mav相当于一个hashmap
		mav.addObject("address","http://localhost:8080/Card-Campus-Server/listLoveReply");
		//放入将要跳转的jsp文件名
		mav.setViewName("index");
		
		return mav;
	}
}
