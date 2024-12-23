package org.test.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import org.test.enums.Channel;
import org.test.enums.Suspension;
import org.test.enums.TimeUnit;

public class SuspensionCriteriaDto {

    @JsonProperty("channel")
    private Channel channel;

    @JsonProperty("response_code")
    @Size(min = 1, max = 10)
    private String responseCode;

    @JsonProperty("no_of_declines")
    @Max(value = 20)
    private Integer noOfDeclines;

    @JsonProperty("temp_perm")
    private Suspension temporaryOrPerm;

    @JsonProperty("susp_duration")
    @Max(value = 60)
    private Integer suspensionDuration;

    @JsonProperty("time_unit")
    private TimeUnit timeUnit;

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public Integer getNoOfDeclines() {
        return noOfDeclines;
    }

    public void setNoOfDeclines(Integer noOfDeclines) {
        this.noOfDeclines = noOfDeclines;
    }

    public Suspension getTemporaryOrPerm() {
        return temporaryOrPerm;
    }

    public void setTemporaryOrPerm(Suspension temporaryOrPerm) {
        this.temporaryOrPerm = temporaryOrPerm;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }

    public Integer getSuspensionDuration() {
        return suspensionDuration;
    }

    public void setSuspensionDuration(Integer suspensionDuration) {
        this.suspensionDuration = suspensionDuration;
    }
}
