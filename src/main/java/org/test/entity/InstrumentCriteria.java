package org.test.entity;

import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;
import io.smallrye.mutiny.Uni;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.List;
import java.util.Optional;

@MongoEntity(database = "catalog", collection = "criteria")
public class InstrumentCriteria extends ReactivePanacheMongoEntity {

    @BsonProperty("criteria")
    private Integer criteriaId;

    @BsonProperty("description")
    private String description;

    @BsonProperty("no_declines_daily")
    private Integer noOfDailyDeclinesAllowed;

    @BsonProperty("cool_of_period")
    private Integer coolOfPeriod;

    @BsonProperty("support_susp")
    private boolean supportSuspension;

    @BsonProperty("transaction_limits")
    private List<TransactionLimits> transactionLimits;

    @BsonProperty("timed_transaction_limits")
    private List<TimedTransactionLimits> timeLimitedTransactionLimits;

    @BsonProperty("susp_criterias")
    private List<SuspensionCriteria> suspensionCriterias;

    @BsonProperty("check_expiry")
    private boolean checkForExpiry;

    @BsonProperty("months_to_purge")
    private Integer monthsToPurge;

    @BsonProperty("validate_instr_id")
    private boolean validateInstrument;



    public Integer getCriteriaId() {
        return criteriaId;
    }

    public void setCriteriaId(Integer criteriaId) {
        this.criteriaId = criteriaId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNoOfDailyDeclinesAllowed() {
        return noOfDailyDeclinesAllowed;
    }

    public void setNoOfDailyDeclinesAllowed(Integer noOfDailyDeclinesAllowed) {
        this.noOfDailyDeclinesAllowed = noOfDailyDeclinesAllowed;
    }

    public static Uni<Optional<InstrumentCriteria>> findByCriteriaId(Integer criteriaId){

        return find("criteria",criteriaId).firstResultOptional();
    }
    public Integer getCoolOfPeriod() {
        return coolOfPeriod;
    }

    public void setCoolOfPeriod(Integer coolOfPeriod) {
        this.coolOfPeriod = coolOfPeriod;
    }

    public boolean isSupportSuspension() {
        return supportSuspension;
    }

    public void setSupportSuspension(boolean supportSuspension) {
        this.supportSuspension = supportSuspension;
    }


    public List<SuspensionCriteria> getSuspensionCriterias() {
        return suspensionCriterias;
    }

    public void setSuspensionCriterias(List<SuspensionCriteria> suspensionCriterias) {
        this.suspensionCriterias = suspensionCriterias;
    }

    public boolean getCheckForExpiry() {
        return checkForExpiry;
    }

    public void setCheckForExpiry(boolean checkForExpiry) {
        this.checkForExpiry = checkForExpiry;
    }

    public Integer getMonthsToPurge() {
        return monthsToPurge;
    }

    public void setMonthsToPurge(Integer monthsToPurge) {
        this.monthsToPurge = monthsToPurge;
    }

    public boolean isValidateInstrument() {
        return validateInstrument;
    }

    public void setValidateInstrument(boolean validateInstrument) {
        this.validateInstrument = validateInstrument;
    }

    public List<TransactionLimits> getTransactionLimits() {
        return transactionLimits;
    }

    public void setTransactionLimits(List<TransactionLimits> transactionLimits) {
        this.transactionLimits = transactionLimits;
    }

    public List<TimedTransactionLimits> getTimeLimitedTransactionLimits() {
        return timeLimitedTransactionLimits;
    }

    public void setTimeLimitedTransactionLimits(List<TimedTransactionLimits> timeLimitedTransactionLimits) {
        this.timeLimitedTransactionLimits = timeLimitedTransactionLimits;
    }

    public boolean isCheckForExpiry() {
        return checkForExpiry;
    }
}
