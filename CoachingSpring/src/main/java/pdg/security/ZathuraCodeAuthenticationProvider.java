package pdg.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.stereotype.Component;

import pdg.modelo.Coach;
import pdg.modelo.Coachee;
import pdg.modelo.logic.ICoacheeLogic;
import pdg.presentation.businessDelegate.IBusinessDelegate;

import java.util.ArrayList;
import java.util.List;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
@Scope("singleton")
@Component("zathuraCodeAuthenticationProvider")
public class ZathuraCodeAuthenticationProvider implements AuthenticationProvider {
    /**
     * Security Implementation
     */
	

	
	@Autowired
	private IBusinessDelegate delegadoDeNegocio;
	
    @Override
    public Authentication authenticate(Authentication authentication)
        throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        String rol ="";
        try {
			
        	Coachee cliente = delegadoDeNegocio.validarCredencialesCoachee(name, password);
        	//Coach nuevoCoach = delegadoDeNegocio.validarCredencialesCoach(name, password);
			
        	if (cliente!=null) {
				
				rol ="Coachee";
			}
//			if (nuevoCoach!=null) {
//				
//				rol="Coach";
//			}
			
        	final List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
            grantedAuths.add(new SimpleGrantedAuthority("ROLE_" + rol));

            final UserDetails principal = new User(name, password, grantedAuths);
            final Authentication auth = new UsernamePasswordAuthenticationToken(principal,
                    password, grantedAuths);

            return auth;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
			
			try {
				Coach nuevoCoach = delegadoDeNegocio.validarCredencialesCoach(name, password);
				
	        	
				if (nuevoCoach!=null) {
					
					rol="Coach";
				}
				
	        	final List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
	            grantedAuths.add(new SimpleGrantedAuthority("ROLE_" + rol));

	            final UserDetails principal = new User(name, password, grantedAuths);
	            final Authentication auth = new UsernamePasswordAuthenticationToken(principal,
	                    password, grantedAuths);

	            return auth;
			} catch (Exception e2) {
				// TODO: handle exception
				e2.getMessage();
			}
		}
        
        return null;
       // if (name.equals("admin") && password.equals("admin")) {
            
//        } else {
//            return null;
//        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
