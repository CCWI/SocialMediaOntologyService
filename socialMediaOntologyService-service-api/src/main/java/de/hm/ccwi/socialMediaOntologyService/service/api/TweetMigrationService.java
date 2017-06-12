package de.hm.ccwi.socialMediaOntologyService.service.api;

import org.springframework.security.access.prepost.PreAuthorize;

import de.hm.ccwi.socialMediaOntologyService.base.security.Permission;
import de.hm.ccwi.socialMediaOntologyService.service.api.bo.RdfTweetBo;

/**
 * RDF-Tweet-Service.
 */
@PreAuthorize("hasAuthority('" + Permission.PERMISSION_READ + "')")
public interface TweetMigrationService {

	/**
	 * Get {@link RdfTweetBo} with a list of {@link Triplets}.
	 *
	 * @param RdfTweetBo
	 */
	@PreAuthorize("hasAuthority('" + Permission.PERMISSION_SAVE + "')")
	public RdfTweetBo migrateRelationalTweetsToRdf();

}
