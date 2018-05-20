package org.leagueofcole.musicFoundationProject.service;

import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl /*implements UserDetailsService*/ {
	/*
    @Autowired
    private UserService userService;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Teacher user = userService.findByUsername(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        //for (Role role : user.getRoles()){
        //    grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        //}

        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), grantedAuthorities);
    }
    */
}