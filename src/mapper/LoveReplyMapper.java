package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import pojo.LovePost;
import pojo.LoveReply;
import pojo.User;

public interface LoveReplyMapper {
	public List<LoveReply> lovereplyList();
	public void addLoveReply(LoveReply lovereply);
	public void deleteLoveReply(String lreply_id);
	public LoveReply getLovereply(String lreply_id);
	public List<LoveReply> getLoveReplyById(String love_id);
	public void updateLovereply(LoveReply lovereply);
}
