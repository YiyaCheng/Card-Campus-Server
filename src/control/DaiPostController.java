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
	 * 1.代课的相关操作
	 */
	@RequestMapping("listDaike")//相当于struts.xml中的action的名字name
	public ModelAndView ListDaike(){
		ModelAndView mav=new ModelAndView();//充当原来set/get方法
		List<DaiPost> alldaike=daiPostService.daikeList();
		//mav存放转发到jsp页面的参数
		mav.addObject("daike",alldaike);//mav相当于一个hashmap
		//放入将要跳转的jsp文件名
		mav.setViewName("DaiPostCurd/DaikeList");
		return mav;//return给框架
	}
	
	@RequestMapping("deleteDaike")
	public ModelAndView deleteDaike(int dpost_id) {
		ModelAndView mav=new ModelAndView();
		daiPostService.deleteDaike(dpost_id);
		//插入完成后马上回到list列表
		List<DaiPost> alldaike=daiPostService.daikeList();
		//mav存放转发到jsp页面的参数
		mav.addObject("daike",alldaike);//mav相当于一个hashmap
		//放入将要跳转的jsp文件名
		mav.setViewName("DaiPostCurd/DaikeList");
		return mav;
	}
	
	/**
	 * 2.代拿外卖的相关操作
	 */
	@RequestMapping("listDaifood")//相当于struts.xml中的action的名字name
	public ModelAndView ListDaifood(){
		ModelAndView mav=new ModelAndView();//充当原来set/get方法
		List<DaiPost> alldaifood=daiPostService.daifoodList();
		//mav存放转发到jsp页面的参数
		mav.addObject("daifood",alldaifood);//mav相当于一个hashmap
		//放入将要跳转的jsp文件名
		mav.setViewName("DaiPostCurd/DaifoodList");
		return mav;//return给框架
	}
	
	@RequestMapping("deleteDaifood")
	public ModelAndView deleteDaifood(int dpost_id) {
		ModelAndView mav=new ModelAndView();
		daiPostService.deleteDaifood(dpost_id);
		//插入完成后马上回到list列表
		List<DaiPost> alldaifood=daiPostService.daifoodList();
		//mav存放转发到jsp页面的参数
		mav.addObject("daifood",alldaifood);//mav相当于一个hashmap
		//放入将要跳转的jsp文件名
		mav.setViewName("DaiPostCurd/DaifoodList");
		return mav;
	}
	
	/**
	 * 3.代拿快递的相关操作
	 */
	@RequestMapping("listDaideliver")//相当于struts.xml中的action的名字name
	public ModelAndView ListDaideliver(){
		ModelAndView mav=new ModelAndView();//充当原来set/get方法
		List<DaiPost> alldaideliver=daiPostService.daideliverList();
		//mav存放转发到jsp页面的参数
		mav.addObject("daideliver",alldaideliver);//mav相当于一个hashmap
		//放入将要跳转的jsp文件名
		mav.setViewName("DaiPostCurd/DaideliverList");
		return mav;//return给框架
	}
	
	@RequestMapping("deleteDaideliver")
	public ModelAndView deleteDaideliver(int dpost_id) {
		ModelAndView mav=new ModelAndView();
		daiPostService.deleteDaideliver(dpost_id);
		//插入完成后马上回到list列表
		List<DaiPost> alldaideliver=daiPostService.daideliverList();
		//mav存放转发到jsp页面的参数
		mav.addObject("daideliver",alldaideliver);//mav相当于一个hashmap
		//放入将要跳转的jsp文件名
		mav.setViewName("DaiPostCurd/DaideliverList");
		return mav;
	}
	
	/**
	 * 4.代活动的相关操作
	 */
	@RequestMapping("listDaiactivity")//相当于struts.xml中的action的名字name
	public ModelAndView ListDaiactivity(){
		ModelAndView mav=new ModelAndView();//充当原来set/get方法
		List<DaiPost> alldaiactivity=daiPostService.daiactivityList();
		//mav存放转发到jsp页面的参数
		mav.addObject("daiactivity",alldaiactivity);//mav相当于一个hashmap
		//放入将要跳转的jsp文件名
		mav.setViewName("DaiPostCurd/DaiactivityList");
		return mav;//return给框架
	}
	
	@RequestMapping("deleteDaiactivity")
	public ModelAndView deleteDaiactivity(int dpost_id) {
		ModelAndView mav=new ModelAndView();
		daiPostService.deleteDaiactivity(dpost_id);
		//插入完成后马上回到list列表
		List<DaiPost> alldaiactivity=daiPostService.daiactivityList();
		//mav存放转发到jsp页面的参数
		mav.addObject("daiactivity",alldaiactivity);//mav相当于一个hashmap
		//放入将要跳转的jsp文件名
		mav.setViewName("DaiPostCurd/DaiactivityList");
		return mav;
	}
	
	
	/**
	 * 5.代健步走的相关操作
	 */
	@RequestMapping("listDaiwalk")//相当于struts.xml中的action的名字name
	public ModelAndView ListDaiwalk(){
		ModelAndView mav=new ModelAndView();//充当原来set/get方法
		List<DaiPost> alldaiwalk=daiPostService.daiwalkList();
		//mav存放转发到jsp页面的参数
		mav.addObject("daiwalk",alldaiwalk);//mav相当于一个hashmap
		//放入将要跳转的jsp文件名
		mav.setViewName("DaiPostCurd/DaiwalkList");
		return mav;//return给框架
	}
	
	@RequestMapping("deleteDaiwalk")
	public ModelAndView deleteDaiwalk(int dpost_id) {
		ModelAndView mav=new ModelAndView();
		daiPostService.deleteDaiwalk(dpost_id);
		//插入完成后马上回到list列表
		List<DaiPost> alldaiwalk=daiPostService.daiwalkList();
		//mav存放转发到jsp页面的参数
		mav.addObject("daiwalk",alldaiwalk);//mav相当于一个hashmap
		//放入将要跳转的jsp文件名
		mav.setViewName("DaiPostCurd/DaiwalkList");
		return mav;
	}
	
	/**
	 * 6.代购的相关操作
	 */
	@RequestMapping("listDaibuy")//相当于struts.xml中的action的名字name
	public ModelAndView ListDaibuy(){
		ModelAndView mav=new ModelAndView();//充当原来set/get方法
		List<DaiPost> alldaibuy=daiPostService.daibuyList();
		//mav存放转发到jsp页面的参数
		mav.addObject("daibuy",alldaibuy);//mav相当于一个hashmap
		//放入将要跳转的jsp文件名
		mav.setViewName("DaiPostCurd/DaibuyList");
		return mav;//return给框架
	}
	
	@RequestMapping("deleteDaibuy")
	public ModelAndView deleteDaibuy(int dpost_id) {
		ModelAndView mav=new ModelAndView();
		daiPostService.deleteDaibuy(dpost_id);
		//插入完成后马上回到list列表
		List<DaiPost> alldaibuy=daiPostService.daibuyList();
		//mav存放转发到jsp页面的参数
		mav.addObject("daibuy",alldaibuy);//mav相当于一个hashmap
		//放入将要跳转的jsp文件名
		mav.setViewName("DaiPostCurd/DaibuyList");
		return mav;
	}
}
