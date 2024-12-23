package org.test.entity;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.test.enums.LimitType;

public class TransactionLimits {

    @BsonProperty("limit_type")
    private LimitType limitType;

    @BsonProperty("transaction_amt")
    private Long transactionAmount;

    @BsonProperty("transaction_count")
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

    public TransactionLimits() {
    }

    public LimitType getLimitType() {
        return limitType;
    }

    public void setLimitType(LimitType limitType) {
        this.limitType = limitType;
    }
}
