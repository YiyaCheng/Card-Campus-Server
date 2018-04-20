package control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pojo.QuestionReply;
import service.QuestionReplyService;

@Controller
@RequestMapping("")
public class QuestionReplyController {
	@Autowired
	QuestionReplyService questionReplyService;
	@RequestMapping("listQuestionReply")//相当于struts.xml中的action的名字name
	public ModelAndView listQuestionReply(){
		ModelAndView mav=new ModelAndView();//充当原来set/get方法
		List<QuestionReply> allquestionreply=questionReplyService.questionreplyList();
		//mav存放转发到jsp页面的参数
		mav.addObject("questionreply",allquestionreply);//mav相当于一个hashmap
		//放入将要跳转的jsp文件名
		mav.setViewName("QuestionReplyCurd/QuestionReplyList");
		return mav;//return给框架
	}
	
	@RequestMapping("deleteQuestionReply")
	public ModelAndView deleteQuestionReply(int breply_id) {
		ModelAndView mav=new ModelAndView();
		questionReplyService.deleteQuestionReply(breply_id);
		//插入完成后马上回到list列表
		List<QuestionReply> allquestionreply=questionReplyService.questionreplyList();
		//mav存放转发到jsp页面的参数
		mav.addObject("questionreply",allquestionreply);//mav相当于一个hashmap
		//放入将要跳转的jsp文件名
		mav.setViewName("QuestionReplyCurd/QuestionReplyList");
		return mav;
	}
}
