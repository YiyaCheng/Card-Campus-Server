package control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pojo.DaiPost;
import pojo.LovePost;
import service.DaiPostService;

@Controller
@RequestMapping("")
public class DaiPostController {
	@Autowired
	DaiPostService daiPostService;
	
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
		//���뽫Ҫ��ת��jsp�ļ���
		mav.setViewName("DaiPostCurd/DaikeList");
		return mav;
	}
}
