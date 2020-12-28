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
	firstName": "Vishawjeet",
	"lastName": "Saini",
    "userName":"vsaini",
    "mobileNumber" : "123444444",
	"email": "vishawjeet.saini@gmail.com",
	"password": "password",
	"gender": "Male",
	"dateOfBirth": "02/08/1981""
}


Post:http://localhost:8080/user/
JSON:
{
	firstName": "Vishawjeet",
	"lastName": "Saini",
    "userName":"vsaini",
    "mobileNumber" : "123444444",
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


===============================================================================

FeedbackController:

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

=================================================================================================
Post Controller

Creating a post:
Post:http://localhost:8080/post/

Request JSON:
{
    "postDateTime": "2020-12-28T20:34:20.7822518",
    "userName": "vsaini",
    "userId": "bef965e8-2052-4303-8ef8-8ec516e5c31f",
    "postType": "text",
    "postURL": "http://localhost:8080/myurl",
    "postContent": "This is first post",
    "postVisibilty": "public"
}
Response:
{
    "postId": "51ccd877-1ab4-44f6-9cd3-05fdc2deb41f",
    "postDateTime": "2020-12-28T22:28:51.5426802",
    "userName": "vsaini",
    "userId": "329e8330-a995-4f2e-bcad-8ad5fc79737f",
    "postType": "text",
    "postURL": "http://localhost:8080/myurl",
    "postContent": "This is my postContent",
    "postVisibilty": "public",
    "likedBy": null,
    "comments": null
}

Liking a post:
Put:http://localhost:8080/post/like/{postId}
Request JSON:
{
    "userId": "329e8330-a995-4f2e-bcad-8ad5fc79737f"
}

Response:
{
    "postId": "bde7ee45-eadf-4f60-928c-81e0456ff68c",
    "postDateTime": "2020-12-28T22:05:25.508",
    "userName": "vsaini",
    "userId": "329e8330-a995-4f2e-bcad-8ad5fc79737f",
    "postType": "text",
    "postURL": "http://localhost:8080/myurl",
    "postContent": "This is my postContent",
    "postVisibilty": "public",
    "likedBy": [
        "329e8330-a995-4f2e-bcad-8ad5fc79737f"
    ],
    "comments": null
}


UnLiking a post:
Put:http://localhost:8080/post/unlike/{postId}
Request JSON:
{
    "userId": "329e8330-a995-4f2e-bcad-8ad5fc79737f"
}

Response:
{
    "postId": "51ccd877-1ab4-44f6-9cd3-05fdc2deb41f",
    "postDateTime": "2020-12-28T22:28:51.5426802",
    "userName": "vsaini",
    "userId": "329e8330-a995-4f2e-bcad-8ad5fc79737f",
    "postType": "text",
    "postURL": "http://localhost:8080/myurl",
    "postContent": "This is my postContent",
    "postVisibilty": "public",
    "likedBy": null,
    "comments": null
}

Posting a comment:
Post:http://localhost:8080/post/comment/
Request JSON:
{
    "postId": "bde7ee45-eadf-4f60-928c-81e0456ff68c",
    "userId": "329e8330-a995-4f2e-bcad-8ad5fc79737f",
    "commentContent" : "This is test comment"
}

Reponse JSON:
{
    "commentId": "8d87a805-f711-44dc-8147-b5b6f27dea6b",
    "commentDateTime": "2020-12-28T22:08:26.4115074",
    "commentContent": "This is test comment",
    "postId": "bde7ee45-eadf-4f60-928c-81e0456ff68c",
    "userId": "329e8330-a995-4f2e-bcad-8ad5fc79737f"
}


Getting post by userName
Get:http://localhost:8080/post/userName/vsaini

Response:
[
    {
        "postId": "bde7ee45-eadf-4f60-928c-81e0456ff68c",
        "postDateTime": "2020-12-28T22:05:25.508",
        "userName": "vsaini",
        "userId": "329e8330-a995-4f2e-bcad-8ad5fc79737f",
        "postType": "text",
        "postURL": "http://localhost:8080/myurl",
        "postContent": "This is my postContent",
        "postVisibilty": "public",
        "likedBy": [
            "329e8330-a995-4f2e-bcad-8ad5fc79737f"
        ],
        "comments": [
            {
                "commentId": "8d87a805-f711-44dc-8147-b5b6f27dea6b",
                "commentDateTime": "2020-12-28T22:08:26.411",
                "commentContent": "This is test comment",
                "postId": "bde7ee45-eadf-4f60-928c-81e0456ff68c",
                "userId": "329e8330-a995-4f2e-bcad-8ad5fc79737f"
            }
        ]
    }
]

Getting post by userId
Get:http://localhost:8080/post/userId/{userId}


Response:
[
    {
        "postId": "bde7ee45-eadf-4f60-928c-81e0456ff68c",
        "postDateTime": "2020-12-28T22:05:25.508",
        "userName": "vsaini",
        "userId": "329e8330-a995-4f2e-bcad-8ad5fc79737f",
        "postType": "text",
        "postURL": "http://localhost:8080/myurl",
        "postContent": "This is my postContent",
        "postVisibilty": "public",
        "likedBy": [
            "329e8330-a995-4f2e-bcad-8ad5fc79737f"
        ],
        "comments": [
            {
                "commentId": "8d87a805-f711-44dc-8147-b5b6f27dea6b",
                "commentDateTime": "2020-12-28T22:08:26.411",
                "commentContent": "This is test comment",
                "postId": "bde7ee45-eadf-4f60-928c-81e0456ff68c",
                "userId": "329e8330-a995-4f2e-bcad-8ad5fc79737f"
            }
        ]
    }
]