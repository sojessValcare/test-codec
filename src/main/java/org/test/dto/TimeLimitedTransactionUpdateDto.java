package org.test.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import org.test.enums.TimeUnit;

public class TimeLimitedTransactionUpdateDto extends TransactionLimitUpdateDto{

    @JsonProperty("time_limit")
    @Max(60)
    private Integer timeLimit;

    @JsonProperty("time_unit")
    private TimeUnit timeUnit;

    public @Max(60) Integer getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(@Max(60) Integer timeLimit) {
        this.timeLimit = timeLimit;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }
}
