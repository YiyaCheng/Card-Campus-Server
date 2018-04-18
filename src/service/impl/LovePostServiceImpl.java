package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.LovePostMapper;
import pojo.LovePost;
import pojo.User;
import service.LovePostService;
@Service
public class LovePostServiceImpl implements LovePostService {

	@Autowired
	LovePostMapper lovePostMapper;
	
	@Override
	public List<LovePost> lovepostList() {
		// TODO Auto-generated method stub
		return lovePostMapper.lovepostList();
	}

	@Override
	public void addLovePost(LovePost lovepost) {
		// TODO Auto-generated method stub
		lovePostMapper.addLovePost(lovepost);
	}

	@Override
	public void deleteLovePost(int love_id) {
		// TODO Auto-generated method stub
		lovePostMapper.deleteLovePost(love_id);
	}

	@Override
	public User getLovePost(int love_id) {
		// TODO Auto-generated method stub
		return lovePostMapper.getLovePost(love_id);
	}

	@Override
	public void updateLovePost(LovePost lovepost) {
		// TODO Auto-generated method stub
		lovePostMapper.updateLovePost(lovepost);
	}

}
