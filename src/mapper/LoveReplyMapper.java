package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import pojo.LovePost;
import pojo.LoveReply;
import pojo.User;

public interface LoveReplyMapper {
	public List<LoveReply> lovereplyList();
	public void addLovereply(@Param("lovereply")LoveReply lovereply,@Param("lovepost")LovePost lovepost,@Param("user")User user);
	public void deleteLoveReply(int lreply_id);
	public User getLovereply(int lreply_id);
	public void updateLovereply(LoveReply lovereply);
}
