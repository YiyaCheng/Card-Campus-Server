package service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.LovePost;
import pojo.LoveReply;
import pojo.User;

public interface LoveReplyService {
	public List<LoveReply> lovereplyList();
	public void addLoveReply(LoveReply lovereply,LovePost lovepost,User user);
	public void deleteLoveReply(int lreply_id);
	public User getLoveReply(int lreply_id);
	public void updateLoveReply(LoveReply lovereply);
}
