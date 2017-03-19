package com.user.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
@ApiModel( value = "UserRest", description = "UserRest resource representation" )
public class UserRest {
    @ApiModelProperty(value = "UserRest name", required = true )
    private String name;
    @ApiModelProperty(value = "UserRest email", required = true )
    private String email;
    @ApiModelProperty(value = "UserRest password", required = true )
    private String password;
    @ApiModelProperty(value = "UserRest password hash")
    private String passwordHash;

    // Jackson auto mapping
    public UserRest() {
    }

    public UserRest(String name, String email, String passwordHash) {
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
