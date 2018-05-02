package com.success.handler;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	
	
	
	private RedirectStrategy redirectStrategy=new DefaultRedirectStrategy();
	
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication) throws IOException,
			ServletException {
		
		HttpSession session=request.getSession();
		
		
		
		//setting some session variables
		User authUser=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		session.setAttribute("username",authUser.getUsername());
		session.setAttribute("authorites",authentication.getAuthorities());
		//setting the target url to url
		String targetUrl=determineTargetUrl(authentication);
		redirectStrategy.sendRedirect(request,response,targetUrl);
	
	}
	 
	protected String determineTargetUrl(Authentication authentication){
		
		
		
		Set <String> authorities=AuthorityUtils.authorityListToSet(authentication.getAuthorities());
		if(authorities.contains("ROLE_ADMIN")){
			return "/admin";
			
		}
		else if(authorities.contains("ROLE_USER")){
			return "/StudentForm";
		}
		else {throw new IllegalStateException();
		}
		
	}
	
	
	public RedirectStrategy getRedirectStrategy(){
		return redirectStrategy;
	}
	
	
	public void setRedirectStrategy(RedirectStrategy redirectStrategy){
		
		this.redirectStrategy = redirectStrategy;
	}
	
	
	

}
