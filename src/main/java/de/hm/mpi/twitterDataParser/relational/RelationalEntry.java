package de.hm.mpi.twitterDataParser.relational;

import net.sf.jsefa.csv.annotation.CsvDataType;
import net.sf.jsefa.csv.annotation.CsvField;

@CsvDataType()
public class RelationalEntry {

	@CsvField(pos = 1)
	private String resultid;

	@CsvField(pos = 2)
	private String dbidTwitterUser;

	@CsvField(pos = 3)
	private String tweet_id;

	@CsvField(pos = 4)
	private String accountAgeInDays;

	@CsvField(pos = 5)
	private String statuses_count;

	@CsvField(pos = 6)
	private String follower_count;

	@CsvField(pos = 7)
	private String friends_count;

	@CsvField(pos = 8)
	private String listed_count;

	@CsvField(pos = 9)
	private String strategic_position;

	@CsvField(pos = 10)
	private String activity;

	@CsvField(pos = 11)
	private String activityNegativ;

	@CsvField(pos = 12)
	private String username;

	@CsvField(pos = 13)
	private String userId;

	@CsvField(pos = 14)
	private String userDescription;

	@CsvField(pos = 15)
	private String tweetText;

	
	
	public String getResultid() {
		return resultid;
	}

	public void setResultid(String resultid) {
		this.resultid = resultid;
	}

	public String getDbidTwitterUser() {
		return dbidTwitterUser;
	}

	public void setDbidTwitterUser(String dbidTwitterUser) {
		this.dbidTwitterUser = dbidTwitterUser;
	}

	public String getTweet_id() {
		return tweet_id;
	}

	public void setTweet_id(String tweet_id) {
		this.tweet_id = tweet_id;
	}

	public String getAccountAgeInDays() {
		return accountAgeInDays;
	}

	public void setAccountAgeInDays(String accountAgeInDays) {
		this.accountAgeInDays = accountAgeInDays;
	}

	public String getStatuses_count() {
		return statuses_count;
	}

	public void setStatuses_count(String statuses_count) {
		this.statuses_count = statuses_count;
	}

	public String getFollower_count() {
		return follower_count;
	}

	public void setFollower_count(String follower_count) {
		this.follower_count = follower_count;
	}

	public String getFriends_count() {
		return friends_count;
	}

	public void setFriends_count(String friends_count) {
		this.friends_count = friends_count;
	}

	public String getListed_count() {
		return listed_count;
	}

	public void setListed_count(String listed_count) {
		this.listed_count = listed_count;
	}

	public String getStrategic_position() {
		return strategic_position;
	}

	public void setStrategic_position(String strategic_position) {
		this.strategic_position = strategic_position;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getActivityNegativ() {
		return activityNegativ;
	}

	public void setActivityNegativ(String activityNegativ) {
		this.activityNegativ = activityNegativ;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserDescription() {
		return userDescription;
	}

	public void setUserDescription(String userDescription) {
		this.userDescription = userDescription;
	}

	public String getTweetText() {
		return tweetText;
	}

	public void setTweetText(String tweetText) {
		this.tweetText = tweetText;
	}
}
