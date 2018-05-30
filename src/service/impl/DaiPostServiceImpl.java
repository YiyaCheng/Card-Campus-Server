package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.DaiPostMapper;
import pojo.DaiPost;
import pojo.User;
import service.DaiPostService;

@Service 
public class DaiPostServiceImpl implements DaiPostService {

	@Autowired
	DaiPostMapper daipostMapper;
	
	public int daiNum() {
		return daipostMapper.daiNum();
	}
	
	public List<DaiPost> allDaiPostList(){
		return daipostMapper.allDaiPostList();
	}
	public void updateDaipost(DaiPost daipost) {
		daipostMapper.updateDaipost(daipost);
	}
	
	/**
	 * 1.代课
	 */
	@Override
	public List<DaiPost> daikeList() {
		// TODO Auto-generated method stub
		return daipostMapper.daikeList();
	}

	@Override
	public void addDaike(DaiPost daipost) {
		// TODO Auto-generated method stub
		daipostMapper.addDaike(daipost);
	}

	@Override
	public void deleteDaike(String dpost_id) {
		// TODO Auto-generated method stub
		daipostMapper.deleteDaike(dpost_id);
	}

	@Override
	public DaiPost getDaike(String dpost_id) {
		// TODO Auto-generated method stub
		return daipostMapper.getDaike(dpost_id);
	}

	@Override
	public void updateDaike(DaiPost daipost) {
		// TODO Auto-generated method stub
		daipostMapper.updateDaike(daipost);
	}

	/**
	 * 2.代拿外卖
	 */
	@Override
	public List<DaiPost> daifoodList() {
		// TODO Auto-generated method stub
		return daipostMapper.daifoodList();
	}

	@Override
	public void addDaifood(DaiPost daipost) {
		// TODO Auto-generated method stub
		daipostMapper.addDaifood(daipost);
	}

	@Override
	public void deleteDaifood(String dpost_id) {
		// TODO Auto-generated method stub
		daipostMapper.deleteDaifood(dpost_id);
	}

	@Override
	public DaiPost getDaifood(String dpost_id) {
		// TODO Auto-generated method stub
		return daipostMapper.getDaifood(dpost_id);
	}

	@Override
	public void updateDaifood(DaiPost daipost) {
		// TODO Auto-generated method stub
		daipostMapper.updateDaifood(daipost);
	}

	/**
	 * 3.代拿快递
	 */
	@Override
	public List<DaiPost> daideliverList() {
		// TODO Auto-generated method stub
		return daipostMapper.daideliverList();
	}

	@Override
	public void addDaideliver(DaiPost daipost) {
		// TODO Auto-generated method stub
		daipostMapper.addDaideliver(daipost);
	}

	@Override
	public void deleteDaideliver(String dpost_id) {
		// TODO Auto-generated method stub
		daipostMapper.deleteDaideliver(dpost_id);
	}

	@Override
	public DaiPost getDaideliver(String dpost_id) {
		// TODO Auto-generated method stub
		return daipostMapper.getDaideliver(dpost_id);
	}

	@Override
	public void updateDaideliver(DaiPost daipost) {
		// TODO Auto-generated method stub
		daipostMapper.updateDaideliver(daipost);
	}

	/**
	 * 4.代活动
	 */
	@Override
	public List<DaiPost> daiactivityList() {
		// TODO Auto-generated method stub
		return daipostMapper.daiactivityList();
	}

	@Override
	public void addDaiactivity(DaiPost daipost) {
		// TODO Auto-generated method stub
		daipostMapper.addDaiactivity(daipost);
	}

	@Override
	public void deleteDaiactivity(String dpost_id) {
		// TODO Auto-generated method stub
		daipostMapper.deleteDaiactivity(dpost_id);
	}

	@Override
	public DaiPost getDaiactivity(String dpost_id) {
		// TODO Auto-generated method stub
		return daipostMapper.getDaiactivity(dpost_id);
	}

	@Override
	public void updateDaiactivity(DaiPost daipost) {
		// TODO Auto-generated method stub
		daipostMapper.updateDaiactivity(daipost);
	}

	/**
	 * 5.代健步走
	 */
	@Override
	public List<DaiPost> daiwalkList() {
		// TODO Auto-generated method stub
		return daipostMapper.daiwalkList();
	}

	@Override
	public void addDaiwalk(DaiPost daipost) {
		// TODO Auto-generated method stub
		daipostMapper.addDaiwalk(daipost);
	}

	@Override
	public void deleteDaiwalk(String dpost_id) {
		// TODO Auto-generated method stub
		daipostMapper.deleteDaiwalk(dpost_id);
	}

	@Override
	public DaiPost getDaiwalk(String dpost_id) {
		// TODO Auto-generated method stub
		return daipostMapper.getDaiwalk(dpost_id);
	}

	@Override
	public void updateDaiwalk(DaiPost daipost) {
		// TODO Auto-generated method stub
		daipostMapper.updateDaiwalk(daipost);
	}

	/**
	 * 6.代购
	 */
	@Override
	public List<DaiPost> daibuyList() {
		// TODO Auto-generated method stub
		return daipostMapper.daibuyList();
	}

	@Override
	public void addDaibuy(DaiPost daipost) {
		// TODO Auto-generated method stub
		daipostMapper.addDaibuy(daipost);
	}

	@Override
	public void deleteDaibuy(String dpost_id) {
		// TODO Auto-generated method stub
		daipostMapper.deleteDaibuy(dpost_id);
	}

	@Override
	public DaiPost getDaibuy(String dpost_id) {
		// TODO Auto-generated method stub
		return daipostMapper.getDaibuy(dpost_id);
	}

	@Override
	public void updateDaibuy(DaiPost daipost) {
		// TODO Auto-generated method stub
		daipostMapper.updateDaibuy(daipost);
	}

}
