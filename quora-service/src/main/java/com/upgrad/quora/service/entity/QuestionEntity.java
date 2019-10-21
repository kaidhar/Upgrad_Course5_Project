package com.upgrad.quora.service.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
<<<<<<< HEAD
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
=======

import javax.persistence.*;
>>>>>>> 1bdc0adf8f7ffabde15e7800110ddec0071f776e
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.ZonedDateTime;

<<<<<<< HEAD
@Entity
@Table(name = "question")
@NamedQueries({
        @NamedQuery(name = "questionByQUuid", query = "select q from QuestionEntity q where q.uuid =:uuid"),
        @NamedQuery(name= "allQuestionsByUserId",query = "select qe from QuestionEntity qe inner join qe.user usr where usr.uuid = :uuid"),
        @NamedQuery(name= "allQuestions",query = "select q from QuestionEntity q "),
        @NamedQuery(name= "questionById",query = "select q from QuestionEntity q where q.uuid = :uuid")

})
=======
@NamedQueries({
        @NamedQuery(name = "allQuestions", query = "select qt from QuestionEntity qt"),
        @NamedQuery(name = "oneQuestion", query = "select qt from QuestionEntity qt where qt.uuid = :uuid"),
        @NamedQuery(name = "editQuestion", query = "update QuestionEntity qt  set qt.content = :content Where qt.uuid = :uuid"),
        @NamedQuery(name = "deleteQuestion", query = "delete from QuestionEntity qt  Where qt.uuid = :uuid"),
        @NamedQuery(name = "allQuestionsByUserId", query = "select qt from QuestionEntity qt where qt.user.uuid = :uuid")


})

@Entity
@Table(name = "QUESTION")
>>>>>>> 1bdc0adf8f7ffabde15e7800110ddec0071f776e
public class QuestionEntity implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    private Integer id;

    @Column(name = "UUID")
    @Size(max = 200)
    private String uuid;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "USER_ID")
    private UserEntity user;

    @Column(name = "CONTENT")
    @NotNull
    @Size(max = 500)
    private String content;

    @Column(name = "DATE")
    @NotNull
    private ZonedDateTime date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
=======
    private long id;

    @Column(name = "UUID")
    @Size(max = 64)
    private String uuid;


    @Column(name = "CONTENT")
    private String content;

    @Column(name = "DATE")
    private ZonedDateTime created_at;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private UserEntity user;


    public long getId() {
        return id;
    }

    public void setId(long id) {
>>>>>>> 1bdc0adf8f7ffabde15e7800110ddec0071f776e
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

<<<<<<< HEAD
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

=======
>>>>>>> 1bdc0adf8f7ffabde15e7800110ddec0071f776e
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

<<<<<<< HEAD
    public ZonedDateTime getDate() {
        return date;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }
=======
    public ZonedDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(ZonedDateTime created_at) {
        this.created_at = created_at;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

>>>>>>> 1bdc0adf8f7ffabde15e7800110ddec0071f776e
    @Override
    public boolean equals(Object obj) {
        return new EqualsBuilder().append(this, obj).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this).hashCode();
    }

<<<<<<< HEAD
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
=======



}
>>>>>>> 1bdc0adf8f7ffabde15e7800110ddec0071f776e
