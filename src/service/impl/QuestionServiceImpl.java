package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.QuestionPostMapper;
import pojo.QuestionPost;
import pojo.QuestionReply;
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
	
	public List<String> questionpostIdList() {
		return questionpostMapper.questionpostIdList();
	}
	
	public int userBSTPostNum(String user_sno) {
		return questionpostMapper.userBSTPostNum(user_sno);
	}

	@Override
	public void addQuestionPost(QuestionPost questionpost) {
		// TODO Auto-generated method stub
		questionpostMapper.addQuestionPost(questionpost);
	}

	@Override
	public void deleteQuestionPost(String bpost_id) {
		// TODO Auto-generated method stub
		questionpostMapper.deleteQuestionPost(bpost_id);
	}

	@Override
	public QuestionPost getQuestionPost(String bpost_id) {
		// TODO Auto-generated method stub
		return questionpostMapper.getQuestionPost(bpost_id);
	}

	@Override
	public void updateQuestionPost(QuestionPost questionpost) {
		// TODO Auto-generated method stub
		questionpostMapper.updateQuestionPost(questionpost);
	}
	
	

}
