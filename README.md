Spring Security - REST API
----------------

### Get data from REST API 
Using curl to get json data.

	 curl  http://localhost:8080/spring4mvc-security-rest-api/api/user/list
	 
The response is following, then it doesn't need any cookie.
```JSON
["user001","user002","user003","user004","user005"]
```

### Cannot get data from restricting REST API 

/api/admin/ need to have ROLE_ADMIN.

	 curl  http://localhost:8080/spring4mvc-security-rest-api/api/admin/list


### Login for getting cookie

	curl -i -X POST -d username=admin -d password=P@ssw0rd http://localhost:8080/spring4mvc-security-rest-api/login

The response is following, it have to take username & passwod to login.
You can get json of response that includes JESSIONID.

	HTTP/1.1 200 OK
	Server: Apache-Coyote/1.1
	Cache-Control: no-cache, no-store, max-age=0, must-revalidate
	Pragma: no-cache
	Expires: 0
	X-XSS-Protection: 1; mode=block
	X-Frame-Options: DENY
	X-Content-Type-Options: nosniff
	Set-Cookie: JSESSIONID=45C3CEA43872E69DDBCA3047DA985FDD; Path=/spring4mvc-security-rest-api/
	Access-Control-Allow-Origin: http://localhost:8080
	Access-Control-Allow-Methods: GET, POST, PUT, DELETE
	Access-Control-Allow-Headers: Authorization
	Access-Control-Max-Age: 1800
	Access-Control-Allow-Credentials: true
	Content-Length: 50
	Date: Mon, 17 Oct 2016 04:42:52 GMT
	
	{"JSESSIONID":"45C3CEA43872E69DDBCA3047DA985FDD"}


### Get data from REST API by attaching cookie.

	curl --cookie "JSESSIONID=45C3CEA43872E69DDBCA3047DA985FDD"   http://localhost:8080/spring4mvc-security-rest-api/api/admin/list

The response is follwing :
``` JSON
["admin001","admin002","admin003","admin004","admin005"]
``` 
