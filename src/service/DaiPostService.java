package service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.DaiPost;
import pojo.User;

public interface DaiPostService {
		public int daiNum();
		public List<DaiPost> allDaiPostList();
		public void updateDaipost(DaiPost daipost);
		//1.代课
		public List<DaiPost> daikeList();
		public void addDaike(DaiPost daipost);
		public void deleteDaike(String dpost_id);
		public DaiPost getDaike(String dpost_id);
		public void updateDaike(DaiPost daipost);

		//2.代拿外卖
		public List<DaiPost> daifoodList();
		public void addDaifood(DaiPost daipost);
		public void deleteDaifood(String dpost_id);
		public DaiPost getDaifood(String dpost_id);
		public void updateDaifood(DaiPost daipost);
		
		//3.代拿快递
		public List<DaiPost> daideliverList();
		public void addDaideliver(DaiPost daipost);
		public void deleteDaideliver(String dpost_id);
		public DaiPost getDaideliver(String dpost_id);
		public void updateDaideliver(DaiPost daipost);
		
		//4.代活动
		public List<DaiPost> daiactivityList();
		public void addDaiactivity(DaiPost daipost);
		public void deleteDaiactivity(String dpost_id);
		public DaiPost getDaiactivity(String dpost_id);
		public void updateDaiactivity(DaiPost daipost);
		
		//5.代健步走
		public List<DaiPost> daiwalkList();
		public void addDaiwalk(DaiPost daipost);
		public void deleteDaiwalk(String dpost_id);
		public DaiPost getDaiwalk(String dpost_id);
		public void updateDaiwalk(DaiPost daipost);
		
		//6.代购
		public List<DaiPost> daibuyList();
		public void addDaibuy(DaiPost daipost);
		public void deleteDaibuy(String dpost_id);
		public DaiPost getDaibuy(String dpost_id);
		public void updateDaibuy(DaiPost daipost);
}
