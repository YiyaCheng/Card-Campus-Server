package service;

import java.util.List;
import pojo.QuestionPost;
import pojo.User;

public interface QuestionPostService {
	public List<QuestionPost> questionpostList();
	public void addQuestionPost(QuestionPost questionpost);
	public void deleteQuestionPost(String bpost_id);
	public QuestionPost getQuestionPost(String bpost_id);
	public void updateQuestionPost(QuestionPost questionpost);

	
	/**
	 * 重新做加的
	 */
	public List<String> questionpostIdList();
	public int userBSTPostNum(String user_sno);
}
