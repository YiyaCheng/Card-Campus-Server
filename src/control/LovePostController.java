package control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pojo.BookPost;
import pojo.LovePost;
import service.LovePostService;

@Controller
@RequestMapping("")
public class LovePostController {
	@Autowired
	LovePostService lovePostService;
	
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
	
	@RequestMapping("deleteLovePost")
	public ModelAndView deleteLovePost(int love_id) {
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
}
