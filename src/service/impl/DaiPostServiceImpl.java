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
	
	/**
	 * 1.代课
	 */
	@Override
	public List<DaiPost> daikeList() {
		// TODO Auto-generated method stub
		return daipostMapper.daikeList();
	}

	@Override
	public void addDaike(DaiPost daipost, User user) {
		// TODO Auto-generated method stub
		daipostMapper.addDaike(daipost, user);
	}

	@Override
	public void deleteDaike(int dpost_id) {
		// TODO Auto-generated method stub
		daipostMapper.deleteDaike(dpost_id);
	}

	@Override
	public DaiPost getDaike(int dpost_id) {
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
	public void addDaifood(DaiPost daipost, User user) {
		// TODO Auto-generated method stub
		daipostMapper.addDaifood(daipost, user);
	}

	@Override
	public void deleteDaifood(int dpost_id) {
		// TODO Auto-generated method stub
		daipostMapper.deleteDaifood(dpost_id);
	}

	@Override
	public DaiPost getDaifood(int dpost_id) {
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
	public void addDaideliver(DaiPost daipost, User user) {
		// TODO Auto-generated method stub
		daipostMapper.addDaideliver(daipost, user);
	}

	@Override
	public void deleteDaideliver(int dpost_id) {
		// TODO Auto-generated method stub
		daipostMapper.deleteDaideliver(dpost_id);
	}

	@Override
	public DaiPost getDaideliver(int dpost_id) {
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
	public void addDaiactivity(DaiPost daipost, User user) {
		// TODO Auto-generated method stub
		daipostMapper.addDaiactivity(daipost, user);
	}

	@Override
	public void deleteDaiactivity(int dpost_id) {
		// TODO Auto-generated method stub
		daipostMapper.deleteDaiactivity(dpost_id);
	}

	@Override
	public DaiPost getDaiactivity(int dpost_id) {
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
	public void addDaiwalk(DaiPost daipost, User user) {
		// TODO Auto-generated method stub
		daipostMapper.addDaiwalk(daipost, user);
	}

	@Override
	public void deleteDaiwalk(int dpost_id) {
		// TODO Auto-generated method stub
		daipostMapper.deleteDaiwalk(dpost_id);
	}

	@Override
	public DaiPost getDaiwalk(int dpost_id) {
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
	public void addDaibuy(DaiPost daipost, User user) {
		// TODO Auto-generated method stub
		daipostMapper.addDaibuy(daipost, user);
	}

	@Override
	public void deleteDaibuy(int dpost_id) {
		// TODO Auto-generated method stub
		daipostMapper.deleteDaibuy(dpost_id);
	}

	@Override
	public DaiPost getDaibuy(int dpost_id) {
		// TODO Auto-generated method stub
		return daipostMapper.getDaibuy(dpost_id);
	}

	@Override
	public void updateDaibuy(DaiPost daipost) {
		// TODO Auto-generated method stub
		daipostMapper.updateDaibuy(daipost);
	}

}
