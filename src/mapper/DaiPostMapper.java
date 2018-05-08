package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.BookPost;
import pojo.DaiPost;
import pojo.User;

public interface DaiPostMapper {
	
	public int daiNum();
	//1.代课
	public List<DaiPost> daikeList();
	//public void addDaike(@Param("daipost")DaiPost daipost,@Param("user")User user);
	public void addDaike(DaiPost daipost);
	public void deleteDaike(int dpost_id);
	public DaiPost getDaike(int dpost_id);
	public void updateDaike(DaiPost daipost);

	//2.代拿外卖
	public List<DaiPost> daifoodList();
	public void addDaifood(DaiPost daipost);
	public void deleteDaifood(int dpost_id);
	public DaiPost getDaifood(int dpost_id);
	public void updateDaifood(DaiPost daipost);
	
	//3.代拿快递 
	public List<DaiPost> daideliverList();
	public void addDaideliver(DaiPost daipost);
	public void deleteDaideliver(int dpost_id);
	public DaiPost getDaideliver(int dpost_id);
	public void updateDaideliver(DaiPost daipost);
	
	//4.代活动
	public List<DaiPost> daiactivityList();
	public void addDaiactivity(DaiPost daipost);
	public void deleteDaiactivity(int dpost_id);
	public DaiPost getDaiactivity(int dpost_id);
	public void updateDaiactivity(DaiPost daipost);
	
	//5.代健步走
	public List<DaiPost> daiwalkList();
	public void addDaiwalk(DaiPost daipost);
	public void deleteDaiwalk(int dpost_id);
	public DaiPost getDaiwalk(int dpost_id);
	public void updateDaiwalk(DaiPost daipost);
	
	//6.代购
	public List<DaiPost> daibuyList();
	public void addDaibuy(DaiPost daipost);
	public void deleteDaibuy(int dpost_id);
	public DaiPost getDaibuy(int dpost_id);
	public void updateDaibuy(DaiPost daipost);
	
}
