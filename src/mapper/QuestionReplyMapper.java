package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.QuestionPost;
import pojo.QuestionReply;
import pojo.User;

public interface QuestionReplyMapper {
	public List<QuestionReply> questionreplyList();
	public void addQuestionReply(QuestionReply questionreply);
	public void deleteQuestionReply(String breply_id);
	public QuestionReply getQuestionReply(String breply_id);
	public void updateQuestionReply(QuestionReply questionreply);
	/**
	 * ͨ��bpost_idȡ������һ������ͨ��������лظ�����
	 * @return
	 */
	public List<QuestionReply> getReplysByPostId(String bpost_id);
	
	/**
	 * ����д��
	 */
	public int getReplyNumByPostId(String bpost_id);
}
