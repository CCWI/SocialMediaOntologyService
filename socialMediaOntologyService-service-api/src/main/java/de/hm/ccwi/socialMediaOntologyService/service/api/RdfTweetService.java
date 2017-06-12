package de.hm.ccwi.socialMediaOntologyService.service.api;

import org.springframework.security.access.prepost.PreAuthorize;

import de.hm.ccwi.socialMediaOntologyService.base.security.Permission;
import de.hm.ccwi.socialMediaOntologyService.service.api.bo.RdfTweetBo;
import de.hm.ccwi.socialMediaOntologyService.service.api.exception.RdfTweetException;

/**
 * RDF-Tweet-Service.
 */
@PreAuthorize("hasAuthority('" + Permission.PERMISSION_READ + "')")
public interface RdfTweetService {

	/**
	 * Get {@link RdfTweetBo} with a list of {@link Triplets}.
	 *
	 * @param RdfTweetBo
	 */
	public RdfTweetBo getBySearchParameter(final RdfTweetBo rdfTweetBo);

	/**
	 * Save {@link RdfTweetBo}.
	 *
	 * @param rdfTweetBo
	 */
	@PreAuthorize("hasAuthority('" + Permission.PERMISSION_SAVE + "')")
	public void save(RdfTweetBo rdfTweetBo) throws RdfTweetException;

	/**
	 * Delete {@link RdfTweetBo}.
	 * 
	 * @param rdfTweetBo
	 */
	@PreAuthorize("hasAuthority('" + Permission.PERMISSION_DELETE + "')")
	public void delete(final RdfTweetBo rdfTweetBo);

}
