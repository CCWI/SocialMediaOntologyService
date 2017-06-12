package de.hm.ccwi.socialMediaOntologyService.rest.resource;

import java.net.URI;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.lang3.Validate;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.stereotype.Component;

import de.hm.ccwi.socialMediaOntologyService.model.rest.RdfTweetDto;
import de.hm.ccwi.socialMediaOntologyService.rest.dto.mapper.RdfTweetDtoBoMapper;
import de.hm.ccwi.socialMediaOntologyService.service.api.RdfTweetService;
import de.hm.ccwi.socialMediaOntologyService.service.api.bo.RdfTweetBo;
import de.hm.ccwi.socialMediaOntologyService.service.api.exception.RdfTweetException;

@Component
@Path("rdf/tweet")
@ExposesResourceFor(RdfTweetDto.class)
@Produces({ MediaType.APPLICATION_JSON + ";qs=1", MediaType.APPLICATION_XML + ";qs=.5" })
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class RdfTweetResource {

	@Inject
	private RdfTweetService rdfTweetService;

	@Inject
	private RdfTweetDtoBoMapper rdfTweetMapper;

	@GET
	public Response getBySearchParameter(final RdfTweetDto rdfTweetDto) {
		Validate.notNull(rdfTweetDto);

		final RdfTweetBo rdfTweetBo = rdfTweetService.getBySearchParameter(rdfTweetMapper.mapDtoToBo(rdfTweetDto));
		if (rdfTweetBo != null) {
			final RdfTweetDto rdfTweetResultDto = rdfTweetMapper.mapBoToDto(rdfTweetBo);
			return Response.ok(rdfTweetResultDto).build();
		} else {
			return Response.status(Status.NOT_FOUND).entity(Status.NOT_FOUND.getReasonPhrase()).build();
		}
	}

	@POST
	public Response createNewRdfTweet(final RdfTweetDto rdfTweetDto) {
		Validate.notNull(rdfTweetDto);
		saveImpl(rdfTweetDto);
		return Response.created(URI.create(rdfTweetDto.getUri())).entity(rdfTweetDto).build();
	}

	@PUT
	public Response updateRdfTweet(final RdfTweetDto rdfTweetDto) {
		Validate.notNull(rdfTweetDto);
		Validate.notNull(rdfTweetDto.getId());
		saveImpl(rdfTweetDto);
		return Response.ok(rdfTweetDto).build();
	}

	@Path("/delete")
	@DELETE
	public Response deleteById(final RdfTweetDto rdfTweetDto) {
		Validate.notNull(rdfTweetDto);

		rdfTweetService.delete(rdfTweetMapper.mapDtoToBo(rdfTweetDto));
		return Response.noContent().build();
	}

	private void saveImpl(final RdfTweetDto rdfTweetDto) {
		try {
			rdfTweetService.save(rdfTweetMapper.mapDtoToBo(rdfTweetDto));
		} catch (final RdfTweetException e) {
			throw new WebApplicationException(e);
		}
	}
}
