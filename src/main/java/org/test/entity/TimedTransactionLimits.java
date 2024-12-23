package org.test.entity;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.test.enums.TimeUnit;

public class TimedTransactionLimits extends TransactionLimits{

    @BsonProperty("time_limit")
    private Integer timeLimit;

    @BsonProperty("time_unit")
    private TimeUnit timeUnit;


    public Integer getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(Integer timeLimit) {
        this.timeLimit = timeLimit;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }
}
