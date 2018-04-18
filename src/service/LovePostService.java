package service;

import java.util.List;

import pojo.LovePost;
import pojo.User;

public interface LovePostService {
	public List<LovePost> lovepostList();
	public void addLovePost(LovePost lovepost);
	public void deleteLovePost(int love_id);
	public User getLovePost(int love_id);
	public void updateLovePost(LovePost lovepost);
}
