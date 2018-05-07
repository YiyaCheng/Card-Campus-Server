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
	
	@RequestMapping("listLovePost")//相当于struts.xml中的action的名字name
	public ModelAndView ListLovePost(){
		ModelAndView mav=new ModelAndView();//充当原来set/get方法
		List<LovePost> alllovepost=lovePostService.lovepostList();
		//mav存放转发到jsp页面的参数
		mav.addObject("lovepost",alllovepost);//mav相当于一个hashmap
		//放入将要跳转的jsp文件名
		mav.setViewName("LovePostCurd/LovePostList");
		return mav;//return给框架
	}
	
	@RequestMapping("deleteLovePost")
	public ModelAndView deleteLovePost(int love_id) {
		ModelAndView mav=new ModelAndView();
		lovePostService.deleteLovePost(love_id);
		//插入完成后马上回到list列表
		List<LovePost> alllovepost=lovePostService.lovepostList();
		//mav存放转发到jsp页面的参数
		mav.addObject("lovepost",alllovepost);//mav相当于一个hashmap
		//mav.addObject("address","http://localhost:8080/Card-Campus-Server/listLovePost");
		//放入将要跳转的jsp文件名
		mav.setViewName("LovePostCurd/LovePostList");
		return mav;
	}
}
