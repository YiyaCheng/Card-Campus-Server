package pojo;

import java.sql.Timestamp;

public class LoveReply {
	User user;
	int lrepy_id;
	LovePost lovepost;
	String lreply_content;
	Timestamp lreply_time;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getLrepy_id() {
		return lrepy_id;
	}
	public void setLrepy_id(int lrepy_id) {
		this.lrepy_id = lrepy_id;
	}
	public LovePost getLovepost() {
		return lovepost;
	}
	public void setLovepost(LovePost lovepost) {
		this.lovepost = lovepost;
	}
	public String getLreply_content() {
		return lreply_content;
	}
	public void setLreply_content(String lreply_content) {
		this.lreply_content = lreply_content;
	}
	public Timestamp getLreply_time() {
		return lreply_time;
	}
	public void setLreply_time(Timestamp lreply_time) {
		this.lreply_time = lreply_time;
	}
	
}
