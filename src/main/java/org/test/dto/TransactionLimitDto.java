package org.test.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import org.test.enums.LimitType;

public class TransactionLimitDto {

    @JsonProperty("limit_type")
    private LimitType limitType;

    @JsonProperty("transaction_amount")
    private Long transactionAmount;

    @JsonProperty("transaction_count")
    @Max(value = 10)
    private Integer transactionCount;

    public Long getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Long transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Integer getTransactionCount() {
        return transactionCount;
    }

    public void setTransactionCount(Integer transactionCount) {
        this.transactionCount = transactionCount;
    }

    public LimitType getLimitType() {
        return limitType;
    }

    public void setLimitType(LimitType limitType) {
        this.limitType = limitType;
    }
}
