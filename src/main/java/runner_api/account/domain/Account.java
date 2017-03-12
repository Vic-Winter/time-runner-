package runner_api.account.domain;

import javax.persistence.*;

/**
 * Created by yeleilu on 12/03/2017.
 */
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    private String email;
    private String password;

    // @OneToMany(targetEntity=Event.class, fetch=FetchType.EAGER)
    // @JoinColumn(name="account_id")
    // private List<Event> events;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
}
