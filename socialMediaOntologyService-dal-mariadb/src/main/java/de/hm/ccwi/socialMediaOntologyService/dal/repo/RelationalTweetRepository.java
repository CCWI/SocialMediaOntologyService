package de.hm.ccwi.socialMediaOntologyService.dal.repo;

import java.util.List;
import java.util.Map;

public interface RelationalTweetRepository {

//	public List<RelationalTweetEntity> getTwitterDataInRange(@Param("queryLimit") Integer queryLimit, @Param("queryOffset") Integer queryOffset);
	
//	public List<RelationalTweetEntity> getTwitterDataInRange(Pageable pageable);

//	 @Query("Select tu.dbid, tt.id as Tweetid, period_diff(date_format(now(), '%Y%m%d'), "
//			+ "date_format(tu.created_at, '%Y%m%d')) as AccountAgeInDays, tu.statuses_count, "
//			+ "tu.followers_count, tu.friends_count, tu.listed_count, "
//			+ "tu.friends_count / (tu.friends_count + tu.followers_count) as strategicPosition, "
//			+ "period_diff( date_format(now(), '%Y%m%d'), date_format(tu.created_at, '%Y%m%d')) / (period_diff(date_format(now(), '%Y%m%d'), "
//			+ "date_format(tu.created_at, '%Y%m%d')) + tu.statuses_count) as activity, tu.statuses_count / (tu.statuses_count + (period_diff(date_format(now(), '%Y%m%d'), "
//			+ "date_format(tu.created_at, '%Y%m%d')))) as activityGegenseite, tu.name, tu.id, tu.description, tt.text from db_socialmediacrawler.TwitterUser tu, "
//			+ "db_socialmediacrawler.TwitterTweet tt where tt.user_dbid = tu.dbid and tt.lang = 'en' LIMIT :queryLimit OFFSET :queryOffset")
//	 public List<Object[]> getPagedTwitterData(Integer queryLimit, Integer queryOffset);

	public List<Map<String, Object>> getPagedTwitterData(Integer limit, Integer offset);
}
