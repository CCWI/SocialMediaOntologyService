package de.hm.ccwi.socialMediaOntologyService.service.impl;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.hm.ccwi.socialMediaOntologyService.dal.repo.RelationalTweetRepository;
import de.hm.ccwi.socialMediaOntologyService.service.api.TweetMigrationService;
import de.hm.ccwi.socialMediaOntologyService.service.api.bo.RdfTweetBo;

/**
 * Implementation of {@link TweetMigrationService}.
 */
@Service
@Transactional
public class TweetMigrationServiceImpl implements TweetMigrationService {

	private static final Logger LOG = LoggerFactory.getLogger(TweetMigrationServiceImpl.class);

	// @Inject
	// private RdfTdbRepository rdfTweetRepository;

	@Inject
	private RelationalTweetRepository relationalTweetRepository;

	@Override
	public RdfTweetBo migrateRelationalTweetsToRdf() {
		LOG.debug("MigrationService (method: migrateRelationalTweetsToRdf) started.");

		// TODO migration logic!

		List<Map<String, Object>> rteList = relationalTweetRepository.getPagedTwitterData(10, 0);
		RdfTweetBo rdfTweetBo = null;
		if(rteList != null) {
			LOG.info("ReceivedList with size: {}" + rteList.size());
			
			for (Map<String, Object> rte : rteList) {
				for (Map.Entry<String, Object> entry : rte.entrySet()) {
					if (entry.getKey() != null && entry.getValue() != null) {
						LOG.info("ReceivedEntry: {} / {}",entry.getKey(), entry.getValue().toString());
					} else {
						LOG.warn("entry is null!");
					}
				}
			}

			rdfTweetBo = new RdfTweetBo();		
		}

		// TODO return migrated RDF-Structure

		return rdfTweetBo;
	}

}
