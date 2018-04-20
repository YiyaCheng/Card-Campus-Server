package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.LoveReplyMapper;
import pojo.LovePost;
import pojo.LoveReply;
import pojo.User;
import service.LoveReplyService;
@Service
public class LoveReplyServiceImpl implements LoveReplyService {
	@Autowired
	LoveReplyMapper loveReplyMapper;
	@Override
	public List<LoveReply> lovereplyList() {
		// TODO Auto-generated method stub
		return loveReplyMapper.lovereplyList();
	}

	@Override
	public void addLoveReply(LoveReply lovereply,LovePost lovepost,User user) {
		// TODO Auto-generated method stub
		loveReplyMapper.addLovereply(lovereply,lovepost,user);
	}

	@Override
	public void deleteLoveReply(int lreply_id) {
		// TODO Auto-generated method stub
		loveReplyMapper.deleteLoveReply(lreply_id);
	}

	@Override
	public User getLoveReply(int lreply_id) {
		// TODO Auto-generated method stub
		return loveReplyMapper.getLovereply(lreply_id);
	}

	@Override
	public void updateLoveReply(LoveReply lovereply) {
		// TODO Auto-generated method stub
		loveReplyMapper.updateLovereply(lovereply);
	}

}
