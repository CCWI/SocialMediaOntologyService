package de.hm.ccwi.socialMediaOntologyService.dal.repo;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import de.hm.ccwi.socialMediaOntologyService.dal.entity.DataSourceBean;

@Service
public class RelationalTweetRepositoryImpl implements RelationalTweetRepository {

	@Inject
	private DataSourceBean dataSource;

	private JdbcTemplate jdbcTemplate;

	@PostConstruct
    public void init(){
		jdbcTemplate = new JdbcTemplate(dataSource.getDataSource());
	}
	
	final static String SQL = "Select tu.dbid, tt.id as Tweetid, period_diff(date_format(now(), '%Y%m%d'), "
			+ "date_format(tu.created_at, '%Y%m%d')) as AccountAgeInDays, tu.statuses_count, "
			+ "tu.followers_count, tu.friends_count, tu.listed_count, "
			+ "tu.friends_count / (tu.friends_count + tu.followers_count) as strategicPosition, "
			+ "period_diff( date_format(now(), '%Y%m%d'), date_format(tu.created_at, '%Y%m%d')) / (period_diff(date_format(now(), '%Y%m%d'), "
			+ "date_format(tu.created_at, '%Y%m%d')) + tu.statuses_count) as activity, tu.statuses_count / (tu.statuses_count + (period_diff(date_format(now(), '%Y%m%d'), "
			+ "date_format(tu.created_at, '%Y%m%d')))) as activityGegenseite, tu.name, tu.id, tu.description, tt.text from db_socialmediacrawler.TwitterUser tu, "
			+ "db_socialmediacrawler.TwitterTweet tt where tt.user_dbid = tu.dbid and tt.lang = 'en' LIMIT ? OFFSET ?";

	public List<Map<String, Object>> getPagedTwitterData(Integer limit, Integer offset) {
		return jdbcTemplate.queryForList(SQL, new Object[] { limit, offset });
	}

}
