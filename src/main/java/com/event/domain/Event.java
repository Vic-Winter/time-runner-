package com.event.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
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
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import com.user.domain.User;


/**
 * Created by yeleilu on 14/03/2017.
 */
@Entity
@Table(name = "events")
public class Event {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "event_id", updatable=false, columnDefinition = "serial")
    @Generated(GenerationTime.INSERT)
    private Integer id;
    @NotNull
    @Column(length = 80)
    private String title;
    @Column
    @NotNull
    private String description;
    @NotNull
    @JoinColumn(name="username", foreignKey=@ForeignKey(name = "events_username_fkey"), updatable = false)
    @ManyToOne(cascade = CascadeType.REFRESH, targetEntity=User.class, fetch= FetchType.LAZY)
    private User user;
    @CreationTimestamp
    @NotNull
    @Column(name="created_on", updatable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
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

    public User getUser()
    {
        return user;
    }

    public void setUser(final User user)
    {
        this.user = user;
    }

    public Date getCreatedOn()
    {
        return createdOn;
    }

    public void setCreatedOn(final Date createdOn)
    {
        this.createdOn = createdOn;
    }
}
