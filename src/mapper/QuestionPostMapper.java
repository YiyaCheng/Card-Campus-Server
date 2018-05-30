package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import pojo.QuestionPost;
import pojo.User;

public interface QuestionPostMapper {
	public List<QuestionPost> questionpostList();
	//public void addQuestionPost(@Param("questionpost")QuestionPost questionpost,@Param("user")String user);
	public void addQuestionPost(QuestionPost questionpost);
	public void deleteQuestionPost(String bpost_id);
	public QuestionPost getQuestionPost(String bpost_id);
	public void updateQuestionPost(QuestionPost questionpost);
	
	/**
	 * 重新做之后加的
	 */
	public List<String> questionpostIdList();
	public int userBSTPostNum(String user_sno);
}
