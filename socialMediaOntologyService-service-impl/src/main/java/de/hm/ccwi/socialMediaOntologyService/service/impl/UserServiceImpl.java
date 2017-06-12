package de.hm.ccwi.socialMediaOntologyService.service.impl;

import org.apache.commons.lang3.Validate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.hm.ccwi.socialMediaOntologyService.service.api.UserService;
import de.hm.ccwi.socialMediaOntologyService.service.api.bo.UserBo;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	// @Inject
	// private UserRepository userRepository;
	//
	// @Inject
	// private UserBoEntityMapper userMapper;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		Validate.notNull(username);

		// final UserEntity user = userRepository.findFirstByUsername(username);
		// return user != null ? userMapper.mapUserEntityToBo(user) : null;

		return new UserBo();
	}

}
