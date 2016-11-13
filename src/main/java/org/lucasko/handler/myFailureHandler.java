package org.lucasko.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component("customAuthenticationFailureHandler")
public class  myFailureHandler implements AuthenticationFailureHandler {
  

	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException arg2)
			throws IOException, ServletException {
		try {
		// UsernamePasswordAuthenticationToken token =(UsernamePasswordAuthenticationToken) arg2.getAuthentication();
			//	 System.out.println("username="+token.getName());
			//	 System.out.println("password="+token.getCredentials());
		//	System.out.println(request.getRemoteAddr());
			
			JSONObject json = new JSONObject ();
	        json.put("success", false);
	        //set our response to OK status
	        response.setStatus(HttpServletResponse.SC_OK);
	        System.out.println(json.toString());
	      
	        response.getWriter().println(json.toString());
		}
		catch(Exception e){
		}
		// response.sendRedirect("/login?error");
	}
}