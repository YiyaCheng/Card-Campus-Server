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
	
	/**
	 * 1.���ε���ز���
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
		//���뽫Ҫ��ת��jsp�ļ���
		mav.setViewName("DaiPostCurd/DaikeList");
		return mav;
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
		//���뽫Ҫ��ת��jsp�ļ���
		mav.setViewName("DaiPostCurd/DaifoodList");
		return mav;
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
		//���뽫Ҫ��ת��jsp�ļ���
		mav.setViewName("DaiPostCurd/DaideliverList");
		return mav;
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
		//���뽫Ҫ��ת��jsp�ļ���
		mav.setViewName("DaiPostCurd/DaiactivityList");
		return mav;
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
		//���뽫Ҫ��ת��jsp�ļ���
		mav.setViewName("DaiPostCurd/DaiwalkList");
		return mav;
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
		//���뽫Ҫ��ת��jsp�ļ���
		mav.setViewName("DaiPostCurd/DaibuyList");
		return mav;
	}
}
