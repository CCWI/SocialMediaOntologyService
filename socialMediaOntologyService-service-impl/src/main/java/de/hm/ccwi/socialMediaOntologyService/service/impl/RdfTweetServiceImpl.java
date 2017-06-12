package de.hm.ccwi.socialMediaOntologyService.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.hm.ccwi.socialMediaOntologyService.base.dto.Triplet;
import de.hm.ccwi.socialMediaOntologyService.dal.rdf.RdfException;
import de.hm.ccwi.socialMediaOntologyService.dal.rdf.RdfTdbRepository;
import de.hm.ccwi.socialMediaOntologyService.service.api.RdfTweetService;
import de.hm.ccwi.socialMediaOntologyService.service.api.bo.RdfTweetBo;
import de.hm.ccwi.socialMediaOntologyService.service.api.exception.RdfTweetException;

/**
 * Implementation of {@link RdfTweetService}.
 */
@Service
@Transactional
public class RdfTweetServiceImpl implements RdfTweetService {

	private static final Logger LOG = LoggerFactory.getLogger(RdfTweetServiceImpl.class);

	@Inject
	private RdfTdbRepository rdfTweetRepository;

	@Override
	@Transactional(readOnly = true)
	public RdfTweetBo getBySearchParameter(final RdfTweetBo rdfTweetBo) {
		LOG.info("Get RDF-Tweets with search parameter: {}", rdfTweetBo.toString());

		List<Triplet<String, String, String>> rdfTweetResult = rdfTweetRepository.getTriples(rdfTweetBo.getModel(),
				rdfTweetBo.getSubjectForSearch(), rdfTweetBo.getPredicateForSearch(), rdfTweetBo.getObjectForSearch(),
				rdfTweetBo.getUri());

		if (rdfTweetResult != null) {
			rdfTweetBo.setTripleList(rdfTweetResult);
		}

		return rdfTweetBo;
	}

	@Override
	public void save(final RdfTweetBo rdfTweetBo) throws RdfTweetException {
		Validate.notNull(rdfTweetBo);
		Validate.validState(rdfTweetBo.getId() == null);
		Validate.validState(rdfTweetBo.getUri() != null);
		Validate.validState(rdfTweetBo.getModel() != null);
		
		LOG.info("{}: Saving RDF-Triple: {}, {}, {}", rdfTweetBo.getSubjectForSearch(),
				rdfTweetBo.getPredicateForSearch(), rdfTweetBo.getObjectForSearch());

		try {
			rdfTweetRepository.addTriples(rdfTweetBo.getModel(), rdfTweetBo.getSubjectForSearch(),
					rdfTweetBo.getPredicateForSearch(), rdfTweetBo.getObjectForSearch(), rdfTweetBo.getUri());
		} catch (RdfException e) {
			LOG.error("Error while creating a triple. Message: {}, {}", e.getMessage(), e.getStackTrace().toString());
		}
	}

	@Override
	public void delete(final RdfTweetBo rdfTweetBo) {
		Validate.notNull(rdfTweetBo);
		LOG.info("Deleting RDF-Triple: {}", rdfTweetBo);

		rdfTweetRepository.removeTriples(rdfTweetBo.getModel(), rdfTweetBo.getSubjectForSearch(),
				rdfTweetBo.getPredicateForSearch(), rdfTweetBo.getObjectForSearch(), rdfTweetBo.getUri());
	}
}
