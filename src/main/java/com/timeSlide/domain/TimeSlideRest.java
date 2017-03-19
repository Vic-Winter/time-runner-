package com.timeSlide.domain;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * Created by yeleilu on 14/03/2017.
 */

@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
@ApiModel( value = "TimeSlideRest", description = "TimeSlideRest resource representation" )
public class TimeSlideRest
{
    @ApiModelProperty(value = "TimeSlideRest id")
    private Integer id;
    @ApiModelProperty(value = "TimeSlideRest event id", required = true )
    private Integer eventId;
    @ApiModelProperty(value = "TimeSlideRest start time")
    private Date startTime;
    @ApiModelProperty(value = "TimeSlideRest end time")
    private Date endTime;

    public TimeSlideRest()
    {
    }

    public TimeSlideRest(final Integer id, final Integer eventId, final Date startTime, final Date endTime)
    {
        this.id = id;
        this.eventId = eventId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

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
