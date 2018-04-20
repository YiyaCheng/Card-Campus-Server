package service;

import java.util.List;


import pojo.QuestionPost;
import pojo.QuestionReply;
import pojo.User;

public interface QuestionReplyService {
	public List<QuestionReply> questionreplyList();
	public void addQuestionReply(QuestionReply questionreply,QuestionPost questionpost,User user);
	public void deleteQuestionReply(int breply_id);
	public QuestionReply getQuestionReply(int breply_id);
	public void updateQuestionReply(QuestionReply questionreply);
}
