package runner_api.event.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import runner_api.user.domain.User;


/**
 * Created by yeleilu on 14/03/2017.
 */
@Entity
@Table(name = "events")
public class Event {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "event_id", updatable=false)
    private Integer id;
    @Column
    @NotNull
    private String title;
    @Column
    private String description;
    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="usename")
    @NotNull
    private User user;
    private String username;
    @CreationTimestamp
    @Column(name="created_on", insertable = false, updatable = false)
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    public Integer getId()
    {
        return id;
    }

    public void setId(final Integer id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(final String title)
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(final String description)
    {
        this.description = description;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(final String username)
    {
        this.username = username;
    }

    public Date getCreatedOn()
    {
        return createdOn;
    }

    public void setCreatedOn(final Date createdOn)
    {
        this.createdOn = createdOn;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(final User user)
    {
        this.user = user;
    }
}
