package org.leagueofcole.musicFoundationProject.service;

import org.springframework.stereotype.Service;

@Service
<<<<<<< HEAD
public class SecurityServiceImpl implements SecurityService{
   // @Autowired
    //private AuthenticationManager authenticationManager;
=======
public class SecurityServiceImpl /*implements SecurityService */{
	/*
    @Autowired
    private AuthenticationManager authenticationManager;
>>>>>>> LeaguePelicans/master

    @Autowired
    private UserDetailsService userDetailsService;

    private static final Logger logger = LoggerFactory.getLogger(SecurityServiceImpl.class);

    @Override
    public String findLoggedInUsername() {
        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
        if (userDetails instanceof UserDetails) {
            return ((UserDetails)userDetails).getUsername();
        }

        return null;
    }

    @Override
    public void autologin(String username, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());

        //authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        if (usernamePasswordAuthenticationToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            logger.debug(String.format("Auto login %s successfully!", username));
        }
    }*/
}