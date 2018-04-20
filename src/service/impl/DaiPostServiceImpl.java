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
	
	@Override
	public List<DaiPost> daikeList() {
		// TODO Auto-generated method stub
		return daipostMapper.daikeList();
	}

	@Override
	public void addDaike(DaiPost daipost, User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteDaike(int dpost_id) {
		// TODO Auto-generated method stub

	}

	@Override
	public DaiPost getDaike(int dpost_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateDaike(DaiPost daipost) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<DaiPost> daifoodList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addDaifood(DaiPost daipost, User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteDaifood(int dpost_id) {
		// TODO Auto-generated method stub

	}

	@Override
	public DaiPost getDaifood(int dpost_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateDaifood(DaiPost daipost) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<DaiPost> daideliverList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addDaideliver(DaiPost daipost, User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteDaideliver(int dpost_id) {
		// TODO Auto-generated method stub

	}

	@Override
	public DaiPost getDaideliver(int dpost_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateDaideliver(DaiPost daipost) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<DaiPost> daiactivityList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addDaiactivity(DaiPost daipost, User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteDaiactivity(int dpost_id) {
		// TODO Auto-generated method stub

	}

	@Override
	public DaiPost getDaiactivity(int dpost_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateDaiactivity(DaiPost daipost) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<DaiPost> daiwalkList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addDaiwalk(DaiPost daipost, User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteDaiwalk(int dpost_id) {
		// TODO Auto-generated method stub

	}

	@Override
	public DaiPost getDaiwalk(int dpost_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateDaiwalk(DaiPost daipost) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<DaiPost> daibuyList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addDaibuy(DaiPost daipost, User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteDaibuy(int dpost_id) {
		// TODO Auto-generated method stub

	}

	@Override
	public DaiPost getDaibuy(int dpost_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateDaibuy(DaiPost daipost) {
		// TODO Auto-generated method stub

	}

}
