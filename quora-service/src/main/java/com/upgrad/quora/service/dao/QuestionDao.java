package com.upgrad.quora.service.dao;

import com.upgrad.quora.service.entity.QuestionEntity;
<<<<<<< HEAD
=======
import com.upgrad.quora.service.entity.UserAuthTokenEntity;
>>>>>>> 1bdc0adf8f7ffabde15e7800110ddec0071f776e
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

<<<<<<< HEAD
@Repository
public class QuestionDao {
    @PersistenceContext
    private EntityManager entityManager;

=======

@Repository
public class QuestionDao {

    @PersistenceContext
    private EntityManager entityManager;
>>>>>>> 1bdc0adf8f7ffabde15e7800110ddec0071f776e
    public QuestionEntity createQuestion(QuestionEntity questionEntity) {
        entityManager.persist(questionEntity);
        return questionEntity;
    }

<<<<<<< HEAD
    public QuestionEntity getQuestionByQUuid(final String uuid) {
        try {
            return entityManager.createNamedQuery("questionByQUuid", QuestionEntity.class).setParameter("uuid", uuid).getSingleResult();
=======
    public UserAuthTokenEntity getUserAuthToken(final String accesstoken) {
        try {
            return entityManager.createNamedQuery("userAuthTokenByAccessToken", UserAuthTokenEntity.class).setParameter("accessToken", accesstoken).getSingleResult();
>>>>>>> 1bdc0adf8f7ffabde15e7800110ddec0071f776e
        } catch (NoResultException nre) {
            return null;
        }
    }

<<<<<<< HEAD
    public List < QuestionEntity > getAllQuestionsByUser(final String uuid) {
        try {
            return entityManager.createNamedQuery("allQuestionsByUserId", QuestionEntity.class).setParameter("uuid", uuid).getResultList();
=======

    public List<QuestionEntity> getAllQuestions() {
        try {
            return entityManager.createNamedQuery("allQuestions", QuestionEntity.class).getResultList();
>>>>>>> 1bdc0adf8f7ffabde15e7800110ddec0071f776e
        } catch (NoResultException nre) {
            return null;
        }
    }

<<<<<<< HEAD
    public List < QuestionEntity > getAllQuestions() {
        try {
            return entityManager.createNamedQuery("allQuestions", QuestionEntity.class).getResultList();
        } catch (NoResultException nre) {

            return null;
        }
    }
    public QuestionEntity updateQuestion(final QuestionEntity questionEntity) {
        return entityManager.merge(questionEntity);
    }

    public void deleteQuestion(final String uuid) {
        QuestionEntity questionEntity = getQuestionByQUuid(uuid);
        entityManager.remove(questionEntity);
    }

    /**
     * Method to get the QuestionEntity by uuid
     *
     * @param questionId
     * @return QuestionEntity
     */

    public QuestionEntity getQuestionById(String questionId) {
        try {
            return entityManager.createNamedQuery("questionById", QuestionEntity.class).setParameter("uuid", questionId).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
}
=======

    public QuestionEntity getQuestion(final String uuid) {

        try {
            return entityManager.createNamedQuery("oneQuestion", QuestionEntity.class).setParameter("uuid", uuid).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }


    }

    public QuestionEntity editQuestion(QuestionEntity questionEntity) {

        return entityManager.merge(questionEntity);
        //entityManager.createNamedQuery("editQuestion").setParameter("uuid", questionEntity.getUuid()).setParameter("content", questionEntity.getContent());

    }

    public void deleteQuestion(QuestionEntity questionEntity) {
        //entityManager.createNamedQuery("deleteQuestion").setParameter("uuid", questionEntity.getUuid())
        entityManager.merge(questionEntity);
        entityManager.remove(questionEntity);

    }

    public List<QuestionEntity> getAllQuestionsByUserId(String userId) {

        try {
            return entityManager.createNamedQuery("allQuestionsByUserId", QuestionEntity.class).setParameter("uuid",userId).getResultList();
        } catch (NoResultException nre) {
            return null;
        }

    }
}
>>>>>>> 1bdc0adf8f7ffabde15e7800110ddec0071f776e
