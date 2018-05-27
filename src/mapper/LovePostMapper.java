package mapper;

import java.util.List;

import pojo.LovePost;
import pojo.LoveReply;
import pojo.User;

public interface LovePostMapper {
	public List<LovePost> lovepostList();
	public void addLovePost(LovePost lovepost);
	public void deleteLovePost(String love_id);
	public LovePost getLovePost(String love_id);
	public void updateLovePost(LovePost lovepost);
}
