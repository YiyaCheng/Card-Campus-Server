package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.QuestionPost;
import pojo.QuestionReply;
import pojo.User;

public interface QuestionReplyMapper {
	public List<QuestionReply> questionreplyList();
	public void addQuestionReply(@Param("questionreply")QuestionReply questionreply,@Param("questionpost")QuestionPost questionpost,@Param("user")User user);
	public void deleteQuestionReply(int breply_id);
	public QuestionReply getQuestionReply(int breply_id);
	public void updateQuestionReply(QuestionReply questionreply);
	/**
	 * 通过bpost_id取得所有一个百事通问题的所有回复数据
	 * @return
	 */
	public List<QuestionReply> getReplysByPostId(int bpost_id);
}
