package org.test.entity;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.test.enums.Channel;
import org.test.enums.Suspension;
import org.test.enums.TimeUnit;

public class SuspensionCriteria {

    @BsonProperty("channel")
    private Channel channel;

    @BsonProperty("response_code")
    private String responseCode;

    @BsonProperty("temp_perm")
    private Suspension temporaryOrPermanent;

    @BsonProperty("susp_duration")
    private Integer suspensionDuration;

    @BsonProperty("no_declines")
    private Integer noOfDeclines;

    @BsonProperty("susp_timeunit")
    private TimeUnit timeUnit;

    public Channel getChannel() {
        return channel;
    }

    public Integer getNoOfDeclines() {
        return noOfDeclines;
    }

    public void setNoOfDeclines(Integer noOfDeclines) {
        this.noOfDeclines = noOfDeclines;
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

    public Suspension getTemporaryOrPermanent() {
        return temporaryOrPermanent;
    }

    public void setTemporaryOrPermanent(Suspension temporaryOrPermanent) {
        this.temporaryOrPermanent = temporaryOrPermanent;
    }

    public Integer getSuspensionDuration() {
        return suspensionDuration;
    }

    public void setSuspensionDuration(Integer suspensionDuration) {
        this.suspensionDuration = suspensionDuration;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }
}
