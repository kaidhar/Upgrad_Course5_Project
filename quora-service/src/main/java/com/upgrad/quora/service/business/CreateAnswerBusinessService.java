package com.upgrad.quora.service.business;

<<<<<<< HEAD
import com.upgrad.quora.service.common.EndPointIdentifier;
=======
>>>>>>> 82632bb4550a45568c2a3f99160a8d1dc4201f75
import com.upgrad.quora.service.dao.AnswerDao;
import com.upgrad.quora.service.dao.QuestionDao;
import com.upgrad.quora.service.dao.UserDao;
import com.upgrad.quora.service.entity.AnswerEntity;
import com.upgrad.quora.service.entity.QuestionEntity;
import com.upgrad.quora.service.entity.UserAuthTokenEntity;
import com.upgrad.quora.service.exception.AuthorizationFailedException;
import com.upgrad.quora.service.exception.InvalidQuestionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.UUID;

@Service
<<<<<<< HEAD
public class CreateAnswerBusinessService implements EndPointIdentifier {
=======
public class CreateAnswerBusinessService {
>>>>>>> 82632bb4550a45568c2a3f99160a8d1dc4201f75

    @Autowired
    AnswerDao answerDao;

    @Autowired
    UserDao userDao;

    @Autowired
    QuestionDao questionDao;

    /**
     * @param  answerEntity the first {@code AnswerEntity} object to store answer
     * @param  questionId the second {@code String} to associate the answer to that question.
     * @param  authorization the third {@code String} to check if the access is available.
     * @return AnswerEntity object is returned after persisting in the database.
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public AnswerEntity createAnswer(final AnswerEntity answerEntity, final String questionId, final String authorization) throws AuthorizationFailedException, InvalidQuestionException {
        UserAuthTokenEntity userAuthEntity = userDao.getUserAuthToken(authorization);

        // Validate if user is signed in or not
        if (userAuthEntity == null) {
            throw new AuthorizationFailedException("ATHR-001", "User has not signed in");
        }

        // Validate if user has signed out
        if (userAuthEntity.getLogoutAt() != null) {
            throw new AuthorizationFailedException("ATHR-002", "User is signed out.Sign in first to post an answer");
        }

        // Validate if requested question exist
<<<<<<< HEAD
        QuestionEntity questionEntity = questionDao.getQuestionById(questionId);
=======
        QuestionEntity questionEntity = questionDao.getQuestionByQUuid(questionId);
>>>>>>> 82632bb4550a45568c2a3f99160a8d1dc4201f75
        if (questionEntity == null) {
            throw new InvalidQuestionException("QUES-001", "The question entered is invalid");
        }

        answerEntity.setUuid(UUID.randomUUID().toString());
        answerEntity.setDate(ZonedDateTime.now());
        answerEntity.setUser(userAuthEntity.getUser());
        answerEntity.setQuestion(questionEntity);

        return answerDao.createAnswer(answerEntity);
    }

}