package org.test.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class InstrumentCriteriaDto {

    @NotNull
    @JsonProperty("criteria_id")
    private Integer criteriaId;

    @NotNull
    @NotEmpty
    @JsonProperty("description")
    @Size(min = 1,max = 50)
    private String description;

    @JsonProperty("daily_declines_allowed")
    @Max(value = 20)
    @Min(value = 0)
    private Integer numberOfDailyDeclineAllowed;

    @JsonProperty("cool_of_period")
    @Max(value = 60)
    @Min(value = 0)
    private Integer coolOfPeriod;

    @JsonProperty("support_suspension")
    private boolean supportSuspension;

    @JsonProperty("daily_transaction_limits")
    private List<TransactionLimitDto> transactionLimits;

    @JsonProperty("timed_transaction_limits")
    private List<TimeLimitedTransactionDto> timeLimitedTransactionLimits;

    @JsonProperty("susp_criterias")
    private List<SuspensionCriteriaDto> suspensionCriterias;

    @JsonProperty("chck_expiry")
    private boolean checkForExpiry;

    @JsonProperty("mnts_to_purge")
    @Max(value = 12)
    private Integer monthsToPurge;

    @JsonProperty("validate_instr_id")
    private boolean validateInstrumentId;

    public @NotNull Integer getCriteriaId() {
        return criteriaId;
    }

    public void setCriteriaId(@NotNull Integer criteriaId) {
        this.criteriaId = criteriaId;
    }

    public @NotNull @NotEmpty String getDescription() {
        return description;
    }

    public void setDescription(@NotNull @NotEmpty String description) {
        this.description = description;
    }

    public Integer getNumberOfDailyDeclineAllowed() {
        return numberOfDailyDeclineAllowed;
    }

    public void setNumberOfDailyDeclineAllowed(Integer numberOfDailyDeclineAllowed) {
        this.numberOfDailyDeclineAllowed = numberOfDailyDeclineAllowed;
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

    public void setSuspensionCriterias(List<SuspensionCriteriaDto> suspensionCriterias) {
        this.suspensionCriterias = suspensionCriterias;
    }

    public void setSupportSuspension(boolean supportSuspension) {
        this.supportSuspension = supportSuspension;
    }


    public List<SuspensionCriteriaDto> getSuspensionCriterias() {
        return suspensionCriterias;
    }

    public boolean isCheckForExpiry() {
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

    public boolean isValidateInstrumentId() {
        return validateInstrumentId;
    }

    public void setValidateInstrumentId(boolean validateInstrumentId) {
        this.validateInstrumentId = validateInstrumentId;
    }

    public List<TransactionLimitDto> getTransactionLimits() {
        return transactionLimits;
    }

    public void setTransactionLimits(List<TransactionLimitDto> transactionLimits) {
        this.transactionLimits = transactionLimits;
    }

    public List<TimeLimitedTransactionDto> getTimeLimitedTransactionLimits() {
        return timeLimitedTransactionLimits;
    }

    public void setTimeLimitedTransactionLimits(List<TimeLimitedTransactionDto> timeLimitedTransactionLimits) {
        this.timeLimitedTransactionLimits = timeLimitedTransactionLimits;
    }
}
