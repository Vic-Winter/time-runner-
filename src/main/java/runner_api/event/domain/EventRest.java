package runner_api.event.domain;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * Created by yeleilu on 14/03/2017.
 */

@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
@ApiModel( value = "EventRest", description = "EventRest resource representation" )
public class EventRest {
    @ApiModelProperty(value = "EventRest id")
    private Integer id;
    @ApiModelProperty(value = "EventRest user name", required = true )
    private String username;
    @ApiModelProperty(value = "EventRest title", required = true )
    private String title;
    @ApiModelProperty(value = "EventRest description")
    private String description;
    @ApiModelProperty(value = "EventRest create time")
    private Date createdOn;

    public EventRest()
    {
    }

    public EventRest(final String username, final String title, final String description)
    {
        this.username = username;
        this.title = title;
        this.description = description;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(final Integer id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(final String username)
    {
        this.username = username;
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

    public Date getCreatedOn()
    {
        return createdOn;
    }

    public void setCreatedOn(final Date createdOn)
    {
        this.createdOn = createdOn;
    }
}
