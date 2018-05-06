package service;

import java.util.List;
import pojo.QuestionPost;
import pojo.User;

public interface QuestionPostService {
	public List<QuestionPost> questionpostList();
	public void addQuestionPost(QuestionPost questionpost);
	public void deleteQuestionPost(int bpost_id);
	public QuestionPost getQuestionPost(int bpost_id);
	public void updateQuestionPost(QuestionPost questionpost);

}
