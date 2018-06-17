package org.leagueofcole.musicFoundationProject;

import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

/**
 * Class that tells spring to go to /lessons after logging in
 */
public class RefererRedirectionAuthenticationSuccessHandler 
  extends SimpleUrlAuthenticationSuccessHandler
  implements AuthenticationSuccessHandler {
 
    public RefererRedirectionAuthenticationSuccessHandler() {
        setDefaultTargetUrl("/lessons");
    }
 
}