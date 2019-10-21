package com.upgrad.quora.api.controller;

<<<<<<< HEAD
import com.upgrad.quora.api.model.*;
=======
import com.upgrad.quora.api.model.QuestionDetailsResponse;
import com.upgrad.quora.api.model.QuestionEditRequest;
import com.upgrad.quora.api.model.QuestionRequest;
import com.upgrad.quora.api.model.QuestionResponse;
>>>>>>> 1bdc0adf8f7ffabde15e7800110ddec0071f776e
import com.upgrad.quora.service.business.*;
import com.upgrad.quora.service.entity.QuestionEntity;
import com.upgrad.quora.service.exception.AuthorizationFailedException;
import com.upgrad.quora.service.exception.InvalidQuestionException;
import com.upgrad.quora.service.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
=======
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
>>>>>>> 1bdc0adf8f7ffabde15e7800110ddec0071f776e
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

<<<<<<< HEAD

=======
>>>>>>> 1bdc0adf8f7ffabde15e7800110ddec0071f776e
@RestController
@RequestMapping("/")
public class QuestionController {

<<<<<<< HEAD
    @Autowired
    private CreateQuestionBusinessService createQuestionBusinessService;

    @Autowired
    private GetAllQuestionsBusinessService getAllQuestionsBusinessService;

    @Autowired
    private GetAllQuestionsByUserBusinessService getAllQuestionsByUserBusinessService;

    @Autowired
    UserAdminBusinessService userAdminBusinessService;

    @Autowired
    EditQuestionContentBusinessService editQuestionContentBusinessService;

    @Autowired
    DeleteQuestionBusinessService deleteQuestionBusinessService;


    /**
     * @param  questionRequest the first {@code QuestionRequest} to create a particular question.
     * @param  authorization the second {@code String} to check if the access is available.
     * @return ResponseEntity is returned with Status CREATED.
     */
    @RequestMapping(method = RequestMethod.POST, path = "/question/create", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<QuestionResponse> createQuestion(final QuestionRequest questionRequest, @RequestHeader("authorization") final String authorization) throws AuthorizationFailedException {
        // Logic to handle Bearer <accesstoken>
        // User can give only Access token or Bearer <accesstoken> as input.
        String bearerToken = null;
        try {
            bearerToken = authorization.split("Bearer ")[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            bearerToken = authorization;
        }
        // Create question entity
        final QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setContent(questionRequest.getContent());
        questionEntity.setUuid(UUID.randomUUID().toString());
        questionEntity.setDate(ZonedDateTime.now());

        // Return response with created question entity
        final QuestionEntity createdQuestionEntity = createQuestionBusinessService.createQuestion(questionEntity, bearerToken);
        QuestionResponse questionResponse = new QuestionResponse().id(createdQuestionEntity.getUuid()).status("QUESTION CREATED");
        return new ResponseEntity<QuestionResponse>(questionResponse, HttpStatus.CREATED);
    }

    /**
     * @param  authorization the first {@code String} to check if the access is available.
     * @return ResponseEntity is returned with Status OK.
     */
    @RequestMapping(method = RequestMethod.GET, path = "/question/all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<QuestionDetailsResponse>> getAllQuestions(@RequestHeader("authorization") final String authorization) throws AuthorizationFailedException {
        // Logic to handle Bearer <accesstoken>
        // User can give only Access token or Bearer <accesstoken> as input.
        String bearerToken = null;
        try {
            bearerToken = authorization.split("Bearer ")[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            bearerToken = authorization;
        }
        // Get all questions
        List<QuestionEntity> allQuestions = getAllQuestionsBusinessService.getAllQuestions(bearerToken);

        // Create response
        List<QuestionDetailsResponse> allQuestionDetailsResponses = new ArrayList<QuestionDetailsResponse>();

        for (int i = 0; i < allQuestions.size(); i++) {
            QuestionDetailsResponse questionDetailsResponse = new QuestionDetailsResponse()
                    .content(allQuestions.get(i).getContent())
                    .id(allQuestions.get(i).getUuid());
            allQuestionDetailsResponses.add(questionDetailsResponse);
        }

        // Return response
        return new ResponseEntity<List<QuestionDetailsResponse>>(allQuestionDetailsResponses, HttpStatus.OK);
    }

    /**
     * @param  userId the first {@code String} to get all question by particular user.
     * @param  authorization the second {@code String} to check if the access is available.
     * @return ResponseEntity is returned with Status FOUND.
     */
    @RequestMapping(method = RequestMethod.GET, path ="/question/all/{userId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<QuestionDetailsResponse>> getAllQuestionsByUser(@PathVariable("userId") final String userId, @RequestHeader("authorization") final String authorization) throws AuthorizationFailedException, UserNotFoundException {
        // Logic to handle Bearer <accesstoken>
        // User can give only Access token or Bearer <accesstoken> as input.
        String bearerToken = null;
        try {
            bearerToken = authorization.split("Bearer ")[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            bearerToken = authorization;
        }
        // Get all questions for requested user
        List<QuestionEntity> allQuestions = getAllQuestionsByUserBusinessService.getAllQuestionsByUser(userId, bearerToken);

        // Create response
        List<QuestionDetailsResponse> allQuestionDetailsResponse = new ArrayList<QuestionDetailsResponse>();

        for (int i = 0; i < allQuestions.size(); i++) {
            QuestionDetailsResponse questionDetailsResponse = new QuestionDetailsResponse()
                    .content(allQuestions.get(i).getContent())
                    .id(allQuestions.get(i).getUuid());
            allQuestionDetailsResponse.add(questionDetailsResponse);
        }

        // Return response
        return new ResponseEntity<List<QuestionDetailsResponse>>(allQuestionDetailsResponse, HttpStatus.FOUND);
    }

    /**
     * @param  questionEditRequest the first {@code QuestionEditRequest} content to edit a particular question
     * @param  questionId the second {@code String} to edit a particular question
     * @param  authorization the third {@code String} to check if the access is available.
     * @return ResponseEntity is returned with Status OK.
     */
    @RequestMapping(method = RequestMethod.PUT, path = "/question/edit/{questionId}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<QuestionEditResponse> editQuestionContent(final QuestionEditRequest questionEditRequest, @PathVariable("questionId") final String questionId, @RequestHeader("authorization") final String authorization) throws AuthorizationFailedException, InvalidQuestionException {
        // Logic to handle Bearer <accesstoken>
        // User can give only Access token or Bearer <accesstoken> as input.
        String bearerToken = null;
        try {
            bearerToken = authorization.split("Bearer ")[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            bearerToken = authorization;
        }

        // Creating question entity for further update
        QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setContent(questionEditRequest.getContent());
        questionEntity.setUuid(questionId);

        // Return response with updated question entity
        QuestionEntity updatedQuestionEntity = editQuestionContentBusinessService.editQuestionContent(questionEntity, bearerToken);
        QuestionEditResponse questionEditResponse = new QuestionEditResponse().id(updatedQuestionEntity.getUuid()).status("QUESTION EDITED");
        return new ResponseEntity<QuestionEditResponse>(questionEditResponse, HttpStatus.OK);
    }

    /**
     * @param  questionId the first {@code String} to delete a particular question.
     * @param  authorization the second {@code String} to check if the access is available.
     * @return ResponseEntity is returned with Status OK.
     */
    @RequestMapping(method = RequestMethod.DELETE, path = "/question/delete/{questionId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<QuestionDeleteResponse> deleteQuestion(@PathVariable("questionId") final String questionId, @RequestHeader("authorization") final String authorization) throws AuthorizationFailedException, InvalidQuestionException {

        // Logic to handle Bearer <accesstoken>
        // User can give only Access token or Bearer <accesstoken> as input.
        String bearerToken = null;
        try {
            bearerToken = authorization.split("Bearer ")[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            bearerToken = authorization;
        }

        // Delete requested question
        deleteQuestionBusinessService.userQuestionDelete(questionId, bearerToken);

        // Return response
        QuestionDeleteResponse questionDeleteResponse = new QuestionDeleteResponse().id(questionId).status("QUESTION DELETED");
        return new ResponseEntity<QuestionDeleteResponse>(questionDeleteResponse, HttpStatus.OK);
    }

}
=======

    @Autowired
    private QuestionUploadService questionUploadService;

    @Autowired
    private QuestionAllService questionAllService;

    @Autowired
    private QuestionEditService questionEditService;

    @Autowired
    private QuestionDeleteService questionDeleteService;

    @Autowired
    QuestionAllByUserIdService questionAllByUserIdService;


    @RequestMapping(method = RequestMethod.POST, path = "/question/create", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<QuestionResponse> questionUpload(final QuestionRequest questionRequest, @RequestHeader("authorization") final String authorization) throws AuthorizationFailedException {
        final QuestionEntity questionEntity = new QuestionEntity();

        questionEntity.setUuid(UUID.randomUUID().toString());
        questionEntity.setContent(questionRequest.getContent());
        questionEntity.setCreated_at(ZonedDateTime.now());

        final QuestionEntity createdQuestionEntity = questionUploadService.upload(questionEntity, authorization);
        QuestionResponse questionUploadResponse = new QuestionResponse().id(createdQuestionEntity.getUuid()).status("QUESTION CREATED");
        return new ResponseEntity<QuestionResponse>(questionUploadResponse, HttpStatus.CREATED);
    }


    @RequestMapping(method = RequestMethod.GET, path = "/question/all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<QuestionDetailsResponse> questionAll(@RequestHeader("authorization") final String authorization) throws AuthorizationFailedException {
        final QuestionEntity questionEntity = new QuestionEntity();

        final List<QuestionEntity> createdQuestionEntity = questionAllService.upload(authorization);

        List<QuestionDetailsResponse> questionDetailsResponses = new ArrayList<>();

        for (QuestionEntity q : createdQuestionEntity) {
            QuestionDetailsResponse questionDetailsResponse = new QuestionDetailsResponse();
            questionDetailsResponse.setId(q.getUuid());
            questionDetailsResponse.setContent(q.getContent());
            questionDetailsResponses.add(questionDetailsResponse);

        }

        return questionDetailsResponses;

    }


    @Transactional(propagation = Propagation.REQUIRED)
    @RequestMapping(method = RequestMethod.PUT, path = "/question/edit/{questionId}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<QuestionResponse> questionUpload(@PathVariable("questionId") final String questionId, final QuestionEditRequest questionEditRequest, @RequestHeader("authorization") final String authorization) throws AuthorizationFailedException, InvalidQuestionException {
        final QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setUuid(questionId);
        questionEntity.setContent(questionEditRequest.getContent());
        questionEntity.setCreated_at(ZonedDateTime.now());

        final QuestionEntity createdQuestionEntity = questionEditService.editQuestion(questionEntity, authorization);
        QuestionResponse questionUploadResponse = new QuestionResponse().id(createdQuestionEntity.getUuid()).status("QUESTION EDITED");
        return new ResponseEntity<QuestionResponse>(questionUploadResponse, HttpStatus.CREATED);
    }


    @RequestMapping(method = RequestMethod.DELETE, path = "/question/delete/{questionId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<QuestionResponse> questionDelete(@RequestHeader("authorization") final String authorization, @PathVariable("questionId") final String questionId) throws AuthorizationFailedException, InvalidQuestionException {
          final QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setUuid(questionId);

        final QuestionEntity createdQuestionEntity = questionDeleteService.deleteQuestion(questionEntity, authorization);

        QuestionResponse questionUploadResponse = new QuestionResponse().id(createdQuestionEntity.getUuid()).status("QUESTION DELETED");
        return new ResponseEntity<QuestionResponse>(questionUploadResponse, HttpStatus.CREATED);


    }


    @RequestMapping(method = RequestMethod.GET, path = "question/all/{userId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<QuestionDetailsResponse> questionAllUserId(@RequestHeader("authorization") final String authorization , @PathVariable("userId") final String userId) throws AuthorizationFailedException, UserNotFoundException {
        final QuestionEntity questionEntity = new QuestionEntity();

        final List<QuestionEntity> createdQuestionEntity = questionAllByUserIdService.questionByUserId(authorization, userId);

        List<QuestionDetailsResponse> questionDetailsResponses = new ArrayList<>();

        for (QuestionEntity q : createdQuestionEntity) {
            QuestionDetailsResponse questionDetailsResponse = new QuestionDetailsResponse();
            questionDetailsResponse.setId(q.getUuid());
            questionDetailsResponse.setContent(q.getContent());
            questionDetailsResponses.add(questionDetailsResponse);

        }

        return questionDetailsResponses;

    }






}
>>>>>>> 1bdc0adf8f7ffabde15e7800110ddec0071f776e
