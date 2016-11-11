package org.lucasko.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component("customAuthenticationSuccessHandler")
public class mySuccessHandler implements AuthenticationSuccessHandler {

	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		System.out.println("onAuthenticationSuccess");
		try {
			// System.out.println(authentication.getName());
			// System.out.println(request.getRemoteAddr());
			String username = authentication.getName();
			//System.out.println("username:" + username);
			// Token token = tokenservice.getToken(username);
			//tokenService.renewAccessToken(username);
			HttpSession session = request.getSession();
	        User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        session.setAttribute("username", authUser.getUsername());
	        session.setAttribute("authorities", authentication.getAuthorities());
	        
	        
	        System.out.println(session.getId());
	        JSONObject json = new JSONObject ();
	        json.put("JSESSIONID", session.getId());
	        json.put("success", true);
	        
	        //set our response to OK status
	        response.setStatus(HttpServletResponse.SC_OK);	      
	        response.getWriter().println(json.toString());
	        
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		

		//response.sendRedirect("/CTA");
	}
 
}
