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
		//���뽫Ҫ��ת��jsp�ļ���
		mav.setViewName("QuestionPostCurd/QuestionPostList");
		return mav;
	}
	
}
