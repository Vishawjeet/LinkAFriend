# LinkAFriend

DB Creation on Cassendra
CREATE KEYSPACE linking
WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 1};
==============================================================================
UserController:

Get:
http://localhost:8080/user/{id}

Put:
http://localhost:8080/user/{id}
JSON:
{
	"firstName": "Vishu",
	"lastName": "Saini",
	"email": "vishawjeet.saini@gmail.com",
	"password": "password",
	"gender": "Male",
	"dateOfBirth": "02/08/1981"
}


Post:http://localhost:8080/user/
JSON:
{
	"firstName": "Vishawjeet",
	"lastName": "Saini",
	"email": "vishawjeet.saini@gmail.com",
	"password": "password",
	"gender": "Male",
	"dateOfBirth": "02/08/1981"
}
Delete:
http://localhost:8080/user/{id}
Rseponse JSON
{
    "success": true
}

GetAll:
http://localhost:8080/user/all

===============================================================================

UserController:

Get:
http://localhost:8080/feedback/{id}

Put:
http://localhost:8080/feedback/{id}

{
    "feedBackId": "-1511221040",
    "userId": "146850147",
    "feedBack": "My First Feedback",
    "feedbackDate": "2020-11-08T18:33:40.653+00:00"
}

Post:http://localhost:8080/feedback/
JSON:
{
	"userId": "1947541272",
	"feedBack": "My First Feedback",
}

Response:
{
    "feedBackId": "-1511221040",
    "userId": "146850147",
    "feedBack": "My First Feedback",
    "feedbackDate": "2020-11-08T18:33:40.653+00:00"
}
Delete:
http://localhost:8080/feedback/{id}

Response:
{
    "success": true
}

GetAll:
http://localhost:8080/feedback/all
