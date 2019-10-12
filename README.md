Trello_quora
Repository For Group Project

REST API endpoints - 1
The following API endpoints are implemented in 'UserController' class:
signup - "/user/signup"
This endpoint is used to register a new user in the Quora Application.

signin - "/user/signin"
This endpoint is used for user authentication. The user authenticates in the application and after successful authentication, JWT token is given to a user.

signout - "/user/signout"
This endpoint is used to sign out from the Quora Application. The user cannot access any other endpoint once he is signed out of the application.

The following API endpoints areimplemented in 'CommonController' class:
userProfile - "/userprofile/{userId}"
This endpoint is used to get the details of any user in the Quora Application. This endpoint can be accessed by any user in the application.

The following API endpoints are implemented in 'AdminController' class:
userDelete - "/admin/user/{userId}"
This endpoint is used to delete a user from the Quora Application. Only an admin is authorized to access this endpoint.

REST API endpoints - 2
The following API endpoints are implemented in 'QuestionController' class:
createQuestion - "/question/create"
This endpoint is used to create a question in the Quora Application which will be shown to all the users. Any user can access this endpoint.

getAllQuestions - "/question/all"
This endpoint is used to fetch all the questions that have been posted in the application by any user. Any user can access this endpoint.

editQuestionContent - "/question/edit/{questionId}"
This endpoint is used to edit a question that has been posted by a user. Note, only the owner of the question can edit the question.

deleteQuestion - "/question/delete/{questionId}"
This endpoint is used to delete a question that has been posted by a user. Note, only the question owner of the question or admin can delete a question.

getAllQuestionsByUser - "question/all/{userId}"
This endpoint is used to fetch all the questions posed by a specific user. Any user can access this endpoint.

REST API endpoints - 3
The following API endpoints are implemented in 'AnswerController' class:
createAnswer - "/question/{questionId}/answer/create"
This endpoint is used to create an answer to a particular question. Any user can access this endpoint.

editAnswerContent - "/answer/edit/{answerId}"
This endpoint is used to edit an answer. Only the owner of the answer can edit the answer.

deleteAnswer - "/answer/delete/{answerId}"
This endpoint is used to delete an answer. Only the owner of the answer or admin can delete an answer.

getAllAnswersToQuestion - "answer/all/{questionId}"
This endpoint is used to get all answers to a particular question. Any user can access this endpoint.
