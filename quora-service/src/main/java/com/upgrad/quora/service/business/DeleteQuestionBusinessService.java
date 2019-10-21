package com.upgrad.quora.service.business;

import com.upgrad.quora.service.dao.QuestionDao;
<<<<<<< HEAD
import com.upgrad.quora.service.dao.UserDao;
=======
import com.upgrad.quora.service.entity.QuestionEntity;
>>>>>>> 82632bb4550a45568c2a3f99160a8d1dc4201f75
import com.upgrad.quora.service.entity.UserAuthTokenEntity;
import com.upgrad.quora.service.exception.AuthorizationFailedException;
import com.upgrad.quora.service.exception.InvalidQuestionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeleteQuestionBusinessService {

<<<<<<< HEAD
    @Autowired
    private UserDao userDao;
=======
>>>>>>> 82632bb4550a45568c2a3f99160a8d1dc4201f75

    @Autowired
    private QuestionDao questionDao;

<<<<<<< HEAD
    /**
     * @param  questionId the first {@code String} id of the question to be deleted
     * @param  authorization the second {@code String} to check if the access is available.
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void userQuestionDelete(final String questionId, final String authorization) throws InvalidQuestionException, AuthorizationFailedException {
        UserAuthTokenEntity userAuthEntity = userDao.getUserAuthToken(authorization);

        // Validate if user is signed in or not
        if (userAuthEntity == null) {
            throw new AuthorizationFailedException("ATHR-001", "User has not signed in");
        }

        // Validate if user has signed out
        if (userAuthEntity.getLogoutAt() != null) {
            throw new AuthorizationFailedException("ATHR-002", "User is signed out.Sign in first to delete a question");
        }

        // Validate if requested question exist or not
        if (questionDao.getQuestionByQUuid(questionId) == null) {
            throw new InvalidQuestionException("QUES-001", "Entered question uuid does not exist");
        }

        // Validate if current user is the owner of requested question or the role of user is not nonadmin
        if (!userAuthEntity.getUser().getUuid().equals(questionDao.getQuestionByQUuid(questionId).getUser().getUuid())) {
            if (userAuthEntity.getUser().getRole().equals("nonadmin")) {
                throw new AuthorizationFailedException("ATHR-003", "Oly the question owner or admin can delete the question");
            }
        }

        questionDao.deleteQuestion(questionId);
    }
}
=======
    @Transactional(propagation = Propagation.REQUIRED)
    public QuestionEntity deleteQuestion(QuestionEntity questionEntity, final String authorizationToken) throws
            AuthorizationFailedException, InvalidQuestionException {
        UserAuthTokenEntity userAuthTokenEntity = questionDao.getUserAuthToken(authorizationToken);
        if (userAuthTokenEntity == null) {
            throw new AuthorizationFailedException("ATHR-001", "User has not signed in");
        } else if (userAuthTokenEntity.getLogoutAt() != null) {
            throw new AuthorizationFailedException("ATHR-002", "User is signed out.Sign in first to delete a question");
        }

        questionEntity.setUser(userAuthTokenEntity.getUser());

        QuestionEntity questionEditEntity = questionDao.getQuestionByQUuid(questionEntity.getUuid());

        if (questionEditEntity == null) {
            throw new InvalidQuestionException("QUES-001", "Entered question uuid does not exist");
        } else if (questionEntity.getUser().getEmail() != questionEditEntity.getUser().getEmail()) {
            throw new AuthorizationFailedException("ATHR-003", "Only the question owner can delete the question");
        } else {
            questionDao.deleteQuestion(questionEditEntity);
        }

        return questionEditEntity;
    }

}







>>>>>>> 82632bb4550a45568c2a3f99160a8d1dc4201f75
