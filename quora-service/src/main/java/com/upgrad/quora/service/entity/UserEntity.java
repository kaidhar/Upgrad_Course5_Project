package com.upgrad.quora.service.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

<<<<<<< HEAD

@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = "userByEmail", query = "select u from UserEntity u where u.email = :email"),
        @NamedQuery(name = "userByUserName", query = "select u from UserEntity u where u.userName = :userName"),
        @NamedQuery(name ="userByUuid",query="select u from UserEntity u where u.uuid =:uuid"),
        @NamedQuery(name ="userByRole",query="select u from UserEntity u where u.role=:role"),
        @NamedQuery(name = "authenticateUserQuery", query = "select u from UserEntity u where u.userName= :userName and u.password= :password")
})

public class UserEntity implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "uuid")
    @NotNull
    @Size(max = 64)
    private String uuid;

    @Column(name = "firstname")
=======
@Entity
@Table(name = "USERS")
@NamedQueries({
        @NamedQuery(name = "userByEmail", query = "select u from UserEntity u where u.email = :email")
})
public class UserEntity implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "UUID")
    @Size(max = 64)
    private String uuid;

    @Column(name = "FIRSTNAME")
>>>>>>> 1bdc0adf8f7ffabde15e7800110ddec0071f776e
    @NotNull
    @Size(max = 200)
    private String firstName;

<<<<<<< HEAD
    @Column(name = "lastname")
=======
    @Column(name = "LASTNAME")
>>>>>>> 1bdc0adf8f7ffabde15e7800110ddec0071f776e
    @NotNull
    @Size(max = 200)
    private String lastName;

<<<<<<< HEAD
    @Column(name = "username")
=======
    @Column(name = "USERNAME")
>>>>>>> 1bdc0adf8f7ffabde15e7800110ddec0071f776e
    @NotNull
    @Size(max = 200)
    private String userName;

<<<<<<< HEAD
    @Column(name = "email")
=======
    @Column(name = "EMAIL")
>>>>>>> 1bdc0adf8f7ffabde15e7800110ddec0071f776e
    @NotNull
    @Size(max = 200)
    private String email;

<<<<<<< HEAD
    @Column(name = "password")
    private String password;

    @Column(name = "salt")
=======
    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "SALT")
>>>>>>> 1bdc0adf8f7ffabde15e7800110ddec0071f776e
    @NotNull
    @Size(max = 200)
    private String salt;

<<<<<<< HEAD
    @Column(name = "country")
    @Size(max = 50)
    private String country;

    @Column(name = "aboutme")
    @Size(max = 50)
    private String aboutMe;

    @Column(name = "dob")
    @Size(max = 50)
    private String dob;

    @Column(name = "role")
    @Size(max = 50)
    private String role;

    @Column(name = "contactnumber")
    @Size(max = 50)
    private String contactNumber;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
=======
    @Column(name = "COUNTRY")
    @NotNull
    @Size(max = 200)
    private String country;

    @Column(name = "ABOUTME")
    @NotNull
    @Size(max = 200)
    private String aboutMe;

    @Column(name = "DOB")
    @NotNull
    @Size(max = 200)
    private String dob;

    @Column(name = "ROLE")
    @NotNull
    @Size(max = 200)
    private String role;


    @Column(name = "CONTACTNUMBER")
    @NotNull
    @Size(max = 50)
    private String contactNumber;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
>>>>>>> 1bdc0adf8f7ffabde15e7800110ddec0071f776e
    }

    @Override
    public boolean equals(Object obj) {
        return new EqualsBuilder().append(this, obj).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this).hashCode();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
<<<<<<< HEAD


=======
>>>>>>> 1bdc0adf8f7ffabde15e7800110ddec0071f776e
}