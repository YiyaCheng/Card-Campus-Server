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
	public ModelAndView deleteQuestionReply(int breply_id) {
		ModelAndView mav=new ModelAndView();
		questionReplyService.deleteQuestionReply(breply_id);
		//������ɺ����ϻص�list�б�
		List<QuestionReply> allquestionreply=questionReplyService.questionreplyList();
		//mav���ת����jspҳ��Ĳ���
		mav.addObject("questionreply",allquestionreply);//mav�൱��һ��hashmap
		//���뽫Ҫ��ת��jsp�ļ���
		mav.setViewName("QuestionReplyCurd/QuestionReplyList");
		return mav;
	}
}
