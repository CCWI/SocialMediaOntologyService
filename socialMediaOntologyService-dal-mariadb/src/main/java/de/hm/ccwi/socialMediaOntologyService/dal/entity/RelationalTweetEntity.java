//package de.hm.ccwi.socialMediaOntologyService.dal.entity;
//
//import java.math.BigInteger;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.NamedNativeQuery;
//import javax.persistence.SqlResultSetMapping;
//import javax.persistence.ColumnResult;
//import javax.persistence.ConstructorResult;
//
//import org.apache.commons.lang3.builder.EqualsBuilder;
//import org.apache.commons.lang3.builder.HashCodeBuilder;
//import org.apache.commons.lang3.builder.ToStringBuilder;
//
///**
// * Relational-Twitter-Businessobject.
// */
//@Entity
////@SqlResultSetMapping(
////	    name="twitterDataMapping",
////	    classes={
////	        @ConstructorResult(
////	            targetClass=RelationalTweetEntity.class,
////	            columns={
////	                @ColumnResult(name="GROUP_ID"),
////	                @ColumnResult(name="USER_ID")
////	            }
////	        )
////	    }
////	)
////@NamedNativeQuery(name="getTwitterDataInRange", query="Select tu.dbid, tt.id as Tweetid, period_diff(date_format(now(), '%Y%m%d'), "
////			+ "date_format(tu.created_at, '%Y%m%d')) as AccountAgeInDays, tu.statuses_count, "
////			+ "tu.followers_count, tu.friends_count, tu.listed_count, "
////			+ "tu.friends_count / (tu.friends_count + tu.followers_count) as strategicPosition, "
////			+ "period_diff( date_format(now(), '%Y%m%d'), date_format(tu.created_at, '%Y%m%d')) / (period_diff(date_format(now(), '%Y%m%d'), "
////			+ "date_format(tu.created_at, '%Y%m%d')) + tu.statuses_count) as activity, tu.statuses_count / (tu.statuses_count + (period_diff(date_format(now(), '%Y%m%d'), "
////			+ "date_format(tu.created_at, '%Y%m%d')))) as activityGegenseite, tu.name, tu.id, tu.description, tt.text from db_socialmediacrawler.TwitterUser tu, "
////			+ "db_socialmediacrawler.TwitterTweet tt where tt.user_dbid = tu.dbid and tt.lang = 'en' LIMIT :queryLimit OFFSET :queryOffset", resultSetMapping="twitterDataMapping")
////@NamedNativeQuery(name="getGroupDetails", query="SELECT g.*, gm.* FROM group g LEFT JOIN group_members gm ON g.group_id = gm.group_id and gm.user_id = :userId WHERE g.group_id = :groupId", resultSetMapping="groupDetailsMapping")
//public class RelationalTweetEntity {
//
//	@Id
//	@Column
//	private BigInteger resultid;
//
//	@Column
//	private String username;
//
//	@Column
//	private BigInteger userId;
//
//	@Column
//	private String userDescription;
//
//	@Column
//	private BigInteger follower_count;
//	
//	@Column
//	private BigInteger tweet_id;
//
//	@Column
//	private String tweetText;
//	
//	
//	
//	
//	@Column
//	private String dbidTwitterUser;
//
//	@Column
//	private Integer accountAgeInDays;
//
//	@Column
//	private BigInteger statuses_count;
//
//	@Column
//	private BigInteger friends_count;
//
//	@Column
//	private BigInteger listed_count;
//
//	@Column
//	private float strategic_position;
//
//	@Column
//	private float activity;
//
//	@Column
//	private float activityNegativ;
//
//
//	/**
//	 * Default-Constructor.
//	 */
//	public RelationalTweetEntity() {
//	}
//
//	/**
//	 * Constructor for all attributes.
//	 * 
//	 * @param resultid
//	 * @param dbidTwitterUser
//	 * @param tweet_id
//	 * @param accountAgeInDays
//	 * @param statuses_count
//	 * @param follower_count
//	 * @param friends_count
//	 * @param listed_count
//	 * @param strategic_position
//	 * @param activity
//	 * @param activityNegativ
//	 * @param username
//	 * @param userId
//	 * @param userDescription
//	 * @param tweetText
//	 */
//	public RelationalTweetEntity(BigInteger resultid, String dbidTwitterUser, BigInteger tweet_id,
//			Integer accountAgeInDays, BigInteger statuses_count, BigInteger follower_count, BigInteger friends_count,
//			BigInteger listed_count, float strategic_position, float activity, float activityNegativ, String username,
//			BigInteger userId, String userDescription, String tweetText) {
//		super();
//		this.resultid = resultid;
//		this.dbidTwitterUser = dbidTwitterUser;
//		this.tweet_id = tweet_id;
//		this.accountAgeInDays = accountAgeInDays;
//		this.statuses_count = statuses_count;
//		this.follower_count = follower_count;
//		this.friends_count = friends_count;
//		this.listed_count = listed_count;
//		this.strategic_position = strategic_position;
//		this.activity = activity;
//		this.activityNegativ = activityNegativ;
//		this.username = username;
//		this.userId = userId;
//		this.userDescription = userDescription;
//		this.tweetText = tweetText;
//	}
//
//	public BigInteger getResultid() {
//		return resultid;
//	}
//
//	public void setResultid(BigInteger resultid) {
//		this.resultid = resultid;
//	}
//
//	public String getDbidTwitterUser() {
//		return dbidTwitterUser;
//	}
//
//	public void setDbidTwitterUser(String dbidTwitterUser) {
//		this.dbidTwitterUser = dbidTwitterUser;
//	}
//
//	public BigInteger getTweet_id() {
//		return tweet_id;
//	}
//
//	public void setTweet_id(BigInteger tweet_id) {
//		this.tweet_id = tweet_id;
//	}
//
//	public Integer getAccountAgeInDays() {
//		return accountAgeInDays;
//	}
//
//	public void setAccountAgeInDays(Integer accountAgeInDays) {
//		this.accountAgeInDays = accountAgeInDays;
//	}
//
//	public BigInteger getStatuses_count() {
//		return statuses_count;
//	}
//
//	public void setStatuses_count(BigInteger statuses_count) {
//		this.statuses_count = statuses_count;
//	}
//
//	public BigInteger getFollower_count() {
//		return follower_count;
//	}
//
//	public void setFollower_count(BigInteger follower_count) {
//		this.follower_count = follower_count;
//	}
//
//	public BigInteger getFriends_count() {
//		return friends_count;
//	}
//
//	public void setFriends_count(BigInteger friends_count) {
//		this.friends_count = friends_count;
//	}
//
//	public BigInteger getListed_count() {
//		return listed_count;
//	}
//
//	public void setListed_count(BigInteger listed_count) {
//		this.listed_count = listed_count;
//	}
//
//	public float getStrategic_position() {
//		return strategic_position;
//	}
//
//	public void setStrategic_position(float strategic_position) {
//		this.strategic_position = strategic_position;
//	}
//
//	public float getActivity() {
//		return activity;
//	}
//
//	public void setActivity(float activity) {
//		this.activity = activity;
//	}
//
//	public float getActivityNegativ() {
//		return activityNegativ;
//	}
//
//	public void setActivityNegativ(float activityNegativ) {
//		this.activityNegativ = activityNegativ;
//	}
//
//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public BigInteger getUserId() {
//		return userId;
//	}
//
//	public void setUserId(BigInteger userId) {
//		this.userId = userId;
//	}
//
//	public String getUserDescription() {
//		return userDescription;
//	}
//
//	public void setUserDescription(String userDescription) {
//		this.userDescription = userDescription;
//	}
//
//	public String getTweetText() {
//		return tweetText;
//	}
//
//	public void setTweetText(String tweetText) {
//		this.tweetText = tweetText;
//	}
//
//	@Override
//	public boolean equals(final Object obj) {
//		return EqualsBuilder.reflectionEquals(this, obj);
//	}
//
//	@Override
//	public int hashCode() {
//		return HashCodeBuilder.reflectionHashCode(this);
//	}
//
//	@Override
//	public String toString() {
//		return ToStringBuilder.reflectionToString(this);
//	}
//}
