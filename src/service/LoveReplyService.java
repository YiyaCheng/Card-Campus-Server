package service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.LovePost;
import pojo.LoveReply;
import pojo.User;

public interface LoveReplyService {
	public List<LoveReply> lovereplyList();
	public void addLoveReply(LoveReply lovereply);
	public void deleteLoveReply(String lreply_id);
	public LoveReply getLoveReply(String lreply_id);
	public List<LoveReply> getLoveReplyById(String love_id);
	public void updateLoveReply(LoveReply lovereply);
}
