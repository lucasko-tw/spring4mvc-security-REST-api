package org.lucasko.filter;



import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

public class CorsFilter extends OncePerRequestFilter {
	
	private String origin;
	private String methods;
	private String headers;
	private String maxAge;
	private String credentials;
	
	public CorsFilter(String origin,String methods,String headers,String maxAge, String credentials){
		
		this.origin =origin;
		this.methods = methods;
		this.headers = headers;
		this.maxAge = maxAge;
		this.credentials = credentials;
		
	}
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
 

		// CORS "pre-flight" request
		response.addHeader("Access-Control-Allow-Origin", this.origin);
		response.addHeader("Access-Control-Allow-Methods", this.methods);
		response.addHeader("Access-Control-Allow-Headers", this.headers);
		response.addHeader("Access-Control-Max-Age",this.maxAge);
		response.addHeader("Access-Control-Allow-Credentials", this.credentials);
		

		

		filterChain.doFilter(request, response);
	}
}