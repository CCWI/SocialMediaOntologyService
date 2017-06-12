package de.hm.ccwi.socialMediaOntologyService.rest.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import de.hm.ccwi.socialMediaOntologyService.model.rest.RdfTweetDto;
import de.hm.ccwi.socialMediaOntologyService.service.api.bo.RdfTweetBo;

@Mapper
public interface RdfTweetDtoBoMapper {

	@Mapping(target = "links", ignore = true)
	public RdfTweetDto mapBoToDto(RdfTweetBo servicetemplateBo);

	public RdfTweetBo mapDtoToBo(RdfTweetDto servicetemplateDto);
}
