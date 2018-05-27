package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.LoveReplyMapper;
import pojo.LovePost;
import pojo.LoveReply;
import pojo.QuestionReply;
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
	public void addLoveReply(LoveReply lovereply) {
		// TODO Auto-generated method stub
		loveReplyMapper.addLoveReply(lovereply);
	}

	@Override
	public void deleteLoveReply(String lreply_id) {
		// TODO Auto-generated method stub
		loveReplyMapper.deleteLoveReply(lreply_id);
	}

	@Override
	public LoveReply getLoveReply(String lreply_id) {
		// TODO Auto-generated method stub
		return loveReplyMapper.getLovereply(lreply_id);
	}
	
	@Override
	public List<LoveReply> getLoveReplyById(String love_id) {
		// TODO Auto-generated method stub
		return loveReplyMapper.getLoveReplyById(love_id);
	}

	@Override
	public void updateLoveReply(LoveReply lovereply) {
		// TODO Auto-generated method stub
		loveReplyMapper.updateLovereply(lovereply);
	}

}
