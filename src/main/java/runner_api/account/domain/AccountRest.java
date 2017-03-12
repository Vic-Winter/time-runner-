package runner_api.account.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
@ApiModel( value = "AccountRest", description = "AccountRest resource representation" )
public class AccountRest {
    @ApiModelProperty(value = "AccountRest id")
    private Integer id;
    @ApiModelProperty(value = "AccountRest name", required = true )
    private String name;
    @ApiModelProperty(value = "AccountRest email", required = true )
    private String email;
    @ApiModelProperty(value = "AccountRest password")
    private String password;
    @ApiModelProperty(value = "AccountRest password hash")
    private String passwordHash;

    // Jackson auto mapping
    public AccountRest() {
    }

    public AccountRest(Integer id, String name, String email, String passwordHash) {
        this.id = id;
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

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
