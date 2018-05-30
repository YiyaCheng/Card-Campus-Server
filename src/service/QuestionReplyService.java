package service;

import java.util.List;


import pojo.QuestionPost;
import pojo.QuestionReply;
import pojo.User;

public interface QuestionReplyService {
	public List<QuestionReply> questionreplyList();
	public void addQuestionReply(QuestionReply questionreply);
	public void deleteQuestionReply(String breply_id);
	public QuestionReply getQuestionReply(String breply_id);
	public void updateQuestionReply(QuestionReply questionreply);
	
	/**
	 * 通过bpost_id从回复表里取出所有回复的内容
	 */
	public List<QuestionReply> getReplysByPostId(String bpost_id);
	
	/**
	 * 重新写的
	 */
	public int getReplyNumByPostId(String bpost_id);
}
