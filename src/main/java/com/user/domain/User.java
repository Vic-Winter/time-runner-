package com.user.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


/**
 * Created by yeleilu on 12/03/2017.
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @NotNull
    @Column(length = 20)
    private String username;
    @Column(length = 80)
    private String email;
    @NotNull
    private String password;
    @NotNull
    @Column(columnDefinition = "boolean default true")
    private Boolean enabled = true;

    @OneToMany(cascade = CascadeType.ALL, targetEntity=UserRole.class, fetch=FetchType.EAGER)
    @JoinColumn(name="username", foreignKey=@ForeignKey(name = "user_roles_username_fkey"))
    private List<UserRole> roles;
    public String getName() {
        return username;
    }
    public void setName(String username) {
        this.username = username;
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

    public List<UserRole> getRoles()
    {
        return roles;
    }

    public void setRoles(final List<UserRole> roles)
    {
        this.roles = roles;
    }

    public Boolean getEnabled()
    {
        return enabled;
    }

    public void setEnabled(final Boolean enabled)
    {
        this.enabled = enabled;
    }
}
