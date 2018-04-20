package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.QuestionPostMapper;
import pojo.QuestionPost;
import pojo.User;
import service.QuestionPostService;
@Service
public class QuestionServiceImpl implements QuestionPostService {

	@Autowired
	QuestionPostMapper questionpostMapper;
	@Override
	public List<QuestionPost> questionpostList() {
		// TODO Auto-generated method stub
		return questionpostMapper.questionpostList();
	}

	@Override
	public void addQuestionPost(QuestionPost questionpost, User user) {
		// TODO Auto-generated method stub
		questionpostMapper.addQuestionPost(questionpost, user);
	}

	@Override
	public void deleteQuestionPost(int bpost_id) {
		// TODO Auto-generated method stub
		questionpostMapper.deleteQuestionPost(bpost_id);
	}

	@Override
	public QuestionPost getQuestionPost(int bpost_id) {
		// TODO Auto-generated method stub
		return questionpostMapper.getQuestionPost(bpost_id);
	}

	@Override
	public void updateQuestionPost(QuestionPost questionpost) {
		// TODO Auto-generated method stub
		questionpostMapper.updateQuestionPost(questionpost);
	}

}
