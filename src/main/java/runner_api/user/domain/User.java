package runner_api.user.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by yeleilu on 12/03/2017.
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    private String username;
    private String email;
    private String password;

    @OneToMany(cascade = CascadeType.ALL, targetEntity=UserRole.class, fetch=FetchType.EAGER)
    @JoinColumn(name="username")
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
}
