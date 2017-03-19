package com.user.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;


/**
 * Created by yeleilu on 13/03/2017.
 */
@Entity
@Table(
    name = "user_roles",
    uniqueConstraints = @UniqueConstraint(name = "user_roles_username_role_key", columnNames = {"username", "role"}))
public class UserRole
{
    @Id
    @NotNull
    @Column(updatable=false, columnDefinition = "serial")
    @Generated(GenerationTime.INSERT)
    private Integer user_role_id;
    @NotNull
    @Column(length = 20)
    private String role;
    @NotNull
    @Column(length = 20)
    private String username;

    public UserRole()
    {
    }

    public UserRole(String username, String role)
    {
        this.role = role;
        this.username = username;
    }

    public Integer getUser_role_id()
    {
        return user_role_id;
    }

    public void setUser_role_id(Integer user_role_id)
    {
        this.user_role_id = user_role_id;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }
}
