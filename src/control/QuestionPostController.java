package control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pojo.BookPost;
import pojo.QuestionPost;
import service.QuestionPostService;

@Controller
@RequestMapping("")
public class QuestionPostController {
	@Autowired
	QuestionPostService questionPostService;
	@RequestMapping("listQuestionPost")//相当于struts.xml中的action的名字name
	public ModelAndView listQuestionPost(){
		ModelAndView mav=new ModelAndView();//充当原来set/get方法
		List<QuestionPost> allquestionpost=questionPostService.questionpostList();
		//mav存放转发到jsp页面的参数
		mav.addObject("questionpost",allquestionpost);//mav相当于一个hashmap
		//放入将要跳转的jsp文件名
		mav.setViewName("QuestionPostCurd/QuestionPostList");
		return mav;//return给框架
	}
	
	@RequestMapping("deleteQuestionPost")
	public ModelAndView deleteQuestionPost(int bpost_id) {
		ModelAndView mav=new ModelAndView();
		questionPostService.deleteQuestionPost(bpost_id);
		//插入完成后马上回到list列表
		List<QuestionPost> allquestionpost=questionPostService.questionpostList();
		//mav存放转发到jsp页面的参数
		mav.addObject("questionpost",allquestionpost);//mav相当于一个hashmap
		//放入将要跳转的jsp文件名
		mav.setViewName("QuestionPostCurd/QuestionPostList");
		return mav;
	}
	
}
