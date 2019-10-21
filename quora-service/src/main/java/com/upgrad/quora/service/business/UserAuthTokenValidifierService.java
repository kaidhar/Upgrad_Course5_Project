package com.upgrad.quora.service.business;

<<<<<<< HEAD
import com.upgrad.quora.service.common.EndPointIdentifier;
=======
>>>>>>> 82632bb4550a45568c2a3f99160a8d1dc4201f75
import com.upgrad.quora.service.dao.UserDao;
import com.upgrad.quora.service.entity.UserAuthTokenEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

/**
 * Method to provide service for validating a user authentication token through a access token
 */
@Service
<<<<<<< HEAD
public class UserAuthTokenValidifierService implements EndPointIdentifier {
=======
public class UserAuthTokenValidifierService {
>>>>>>> 82632bb4550a45568c2a3f99160a8d1dc4201f75


    @Autowired
    UserDao userDao;

    /**
     * @param  authorizationToken the first {@code String} to check if the access is available.
     * @return true or false
     */
    boolean userSignOutStatus(String authorizationToken) {
        UserAuthTokenEntity userAuthTokenEntity = userDao.getUserAuthToken(authorizationToken);
        ZonedDateTime loggedOutStatus = userAuthTokenEntity.getLogoutAt();
        ZonedDateTime loggedInStatus = userAuthTokenEntity.getLoginAt();
        if (loggedOutStatus != null && loggedOutStatus.isAfter(loggedInStatus)) {
            return true;
        } else return false;
    }

}