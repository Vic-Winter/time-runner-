package com.timeSlide.domain;

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
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import com.event.domain.Event;


/**
 * Created by yeleilu on 14/03/2017.
 */
@Entity
@Table(name = "time_slides")
public class TimeSlide
{
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "time_slide_id", updatable=false, columnDefinition = "serial")
    @Generated(GenerationTime.INSERT)
    private Integer id;
    @JoinColumn(name="event_id", updatable = false, foreignKey=@ForeignKey(name = "time_slides_event_id_fkey"))
    @NotNull
    @ManyToOne(cascade = CascadeType.REFRESH, targetEntity=Event.class, fetch= FetchType.LAZY)
    private Event event;
    @CreationTimestamp
    @NotNull
    @Column(name="starttime", columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private Date startTime;
    @Column(name="endtime", insertable = false, columnDefinition = "DATE")
    private Date endTime;

    public Integer getId()
    {
        return id;
    }

    public void setId(final Integer id)
    {
        this.id = id;
    }

    public Event getEvent()
    {
        return event;
    }

    public void setEvent(final Event event)
    {
        this.event = event;
    }

    public Date getStartTime()
    {
        return startTime;
    }

    public void setStartTime(final Date startTime)
    {
        this.startTime = startTime;
    }

    public Date getEndTime()
    {
        return endTime;
    }

    public void setEndTime(final Date endTime)
    {
        this.endTime = endTime;
    }
}
