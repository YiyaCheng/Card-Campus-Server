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
}
