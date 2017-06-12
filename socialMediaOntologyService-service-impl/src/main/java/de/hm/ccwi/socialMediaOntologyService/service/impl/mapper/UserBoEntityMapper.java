//package de.hm.ccwi.socialMediaOntologyService.service.impl.mapper;
//
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//
//import de.hm.ccwi.socialMediaOntologyService.dal.entity.RoleEntity;
//import de.hm.ccwi.socialMediaOntologyService.dal.entity.UserEntity;
//import de.hm.ccwi.socialMediaOntologyService.service.api.bo.RoleBo;
//import de.hm.ccwi.socialMediaOntologyService.service.api.bo.UserBo;
//
//@Mapper
//public interface UserBoEntityMapper {
//
//	@Mapping(target = "authorities", ignore = true)
//	UserBo mapUserEntityToBo(UserEntity userEntity);
//
//	UserEntity mapUserBoToEntity(UserBo userBo);
//
//	RoleBo mapRoleEntityToBo(RoleEntity roleEntity);
//
//	RoleEntity mapRoleBoToEntity(RoleBo roleBo);
//}
