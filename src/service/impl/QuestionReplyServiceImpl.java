package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.QuestionReplyMapper;
import pojo.QuestionPost;
import pojo.QuestionReply;
import pojo.User;
import service.QuestionReplyService;
@Service
public class QuestionReplyServiceImpl implements QuestionReplyService {
	@Autowired
	QuestionReplyMapper questionreplyMapper;
	@Override
	public List<QuestionReply> questionreplyList() {
		// TODO Auto-generated method stub
		return questionreplyMapper.questionreplyList();
	}

	@Override
	public void addQuestionReply(QuestionReply questionreply, QuestionPost questionpost, User user) {
		// TODO Auto-generated method stub
		questionreplyMapper.addQuestionReply(questionreply, questionpost, user);
	}

	@Override
	public void deleteQuestionReply(int breply_id) {
		// TODO Auto-generated method stub
		questionreplyMapper.deleteQuestionReply(breply_id);
	}

	@Override
	public QuestionReply getQuestionReply(int breply_id) {
		// TODO Auto-generated method stub
		return questionreplyMapper.getQuestionReply(breply_id);
	}

	@Override
	public void updateQuestionReply(QuestionReply questionreply) {
		// TODO Auto-generated method stub
		questionreplyMapper.updateQuestionReply(questionreply);
	}

}
