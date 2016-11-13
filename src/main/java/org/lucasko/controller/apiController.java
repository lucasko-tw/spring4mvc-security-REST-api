package org.lucasko.controller;

import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = { "/api" }, produces = "application/json; charset=utf-8")
public class apiController {

	@RequestMapping(value = { "/admin/list" }, method =  { RequestMethod.GET,  RequestMethod.POST } )
	public @ResponseBody String admin() {

		JSONArray userList = new JSONArray();
		for (int i = 1; i <= 5; i++) {
			String user = "admin00" + i;
			userList.put(user);
		}
		String response = userList.toString();
		return response;
	}


	@RequestMapping(value = { "/user/list" }, method = RequestMethod.GET )
	public @ResponseBody String user() {

		JSONArray userList = new JSONArray();
		for (int i = 1; i <= 5; i++) {
			String user = "user00" + i;
			userList.put(user);
		}
		String response = userList.toString();
		return response;
	}

}
