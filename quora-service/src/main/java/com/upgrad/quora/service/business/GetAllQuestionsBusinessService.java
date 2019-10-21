package com.upgrad.quora.service.business;

<<<<<<< HEAD
import com.upgrad.quora.service.common.EndPointIdentifier;
=======
>>>>>>> 82632bb4550a45568c2a3f99160a8d1dc4201f75
import com.upgrad.quora.service.dao.QuestionDao;
import com.upgrad.quora.service.dao.UserDao;
import com.upgrad.quora.service.entity.QuestionEntity;
import com.upgrad.quora.service.entity.UserAuthTokenEntity;
import com.upgrad.quora.service.exception.AuthorizationFailedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
<<<<<<< HEAD
public class GetAllQuestionsBusinessService implements EndPointIdentifier {
=======
public class GetAllQuestionsBusinessService {
>>>>>>> 82632bb4550a45568c2a3f99160a8d1dc4201f75

    @Autowired
    private QuestionDao questionDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    UserAuthTokenValidifierService userAuthTokenValidifierService;

    /**
     * @param  accessToken the first {@code String} to check if the access is available.
     * @return List of AnswerEntity objects.
     */
    public List<QuestionEntity> getAllQuestions(String accessToken) throws AuthorizationFailedException {
        UserAuthTokenEntity userAuthEntity = userDao.getUserAuthToken(accessToken);

        // Validate if user is signed in or not
        if (userAuthEntity == null) {
            throw new AuthorizationFailedException("ATHR-001", "User has not signed in");
        }

        // Validate if user has signed out
        if (userAuthEntity.getLogoutAt() != null) {
            throw new AuthorizationFailedException("ATHR-002", "User is signed out.Sign in first to get all questions");
        }
        return questionDao.getAllQuestions();
    }

}