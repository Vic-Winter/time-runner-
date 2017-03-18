package runner_api.timeSlide.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;


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
    @Column(name = "time_slide_id", updatable=false)
    private Integer id;
    @JoinColumn(name="event_id", updatable = false)
    @NotNull
    private Integer eventId;
    @CreationTimestamp
    @Column(name="starttime", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    @Column(name="endtime", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;

    public Integer getId()
    {
        return id;
    }

    public void setId(final Integer id)
    {
        this.id = id;
    }

    public Integer getEventId()
    {
        return eventId;
    }

    public void setEventId(final Integer eventId)
    {
        this.eventId = eventId;
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
