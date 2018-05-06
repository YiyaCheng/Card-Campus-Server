package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import pojo.QuestionPost;
import pojo.User;

public interface QuestionPostMapper {
	public List<QuestionPost> questionpostList();
	//public void addQuestionPost(@Param("questionpost")QuestionPost questionpost,@Param("user")String user);
	public void addQuestionPost(QuestionPost questionpost);
	public void deleteQuestionPost(int bpost_id);
	public QuestionPost getQuestionPost(int bpost_id);
	public void updateQuestionPost(QuestionPost questionpost);
}
