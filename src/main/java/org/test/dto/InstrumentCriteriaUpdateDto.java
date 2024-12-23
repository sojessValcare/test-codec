package org.test.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.test.enums.TimeUnit;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class InstrumentCriteriaUpdateDto {

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

    @JsonProperty("time_unit")
    private TimeUnit timeUnit;

    @JsonProperty("support_suspension")
    private boolean supportSuspension;

    @JsonProperty("daily_transaction_limits")
    private List<TransactionLimitUpdateDto> transactionLimits;

    @JsonProperty("timed_transaction_limits")
    private List<TimeLimitedTransactionUpdateDto> timeLimitedTransactionLimits;

    @JsonProperty("susp_criterias")
    private List<SuspensionCriteriaUpdateDto> suspensionCriterias;

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

    public @NotNull @NotEmpty @Size(min = 1, max = 50) String getDescription() {
        return description;
    }

    public void setDescription(@NotNull @NotEmpty @Size(min = 1, max = 50) String description) {
        this.description = description;
    }

    public @Max(value = 20) @Min(value = 0) Integer getNumberOfDailyDeclineAllowed() {
        return numberOfDailyDeclineAllowed;
    }

    public void setNumberOfDailyDeclineAllowed(@Max(value = 20) @Min(value = 0) Integer numberOfDailyDeclineAllowed) {
        this.numberOfDailyDeclineAllowed = numberOfDailyDeclineAllowed;
    }

    public @Max(value = 60) @Min(value = 0) Integer getCoolOfPeriod() {
        return coolOfPeriod;
    }

    public void setCoolOfPeriod(@Max(value = 60) @Min(value = 0) Integer coolOfPeriod) {
        this.coolOfPeriod = coolOfPeriod;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }

    public boolean isSupportSuspension() {
        return supportSuspension;
    }

    public void setSupportSuspension(boolean supportSuspension) {
        this.supportSuspension = supportSuspension;
    }

    public List<TransactionLimitUpdateDto> getTransactionLimits() {
        return transactionLimits;
    }

    public void setTransactionLimits(List<TransactionLimitUpdateDto> transactionLimits) {
        this.transactionLimits = transactionLimits;
    }

    public List<TimeLimitedTransactionUpdateDto> getTimeLimitedTransactionLimits() {
        return timeLimitedTransactionLimits;
    }

    public void setTimeLimitedTransactionLimits(List<TimeLimitedTransactionUpdateDto> timeLimitedTransactionLimits) {
        this.timeLimitedTransactionLimits = timeLimitedTransactionLimits;
    }

    public List<SuspensionCriteriaUpdateDto> getSuspensionCriterias() {
        return suspensionCriterias;
    }

    public void setSuspensionCriterias(List<SuspensionCriteriaUpdateDto> suspensionCriterias) {
        this.suspensionCriterias = suspensionCriterias;
    }

    public boolean isCheckForExpiry() {
        return checkForExpiry;
    }

    public void setCheckForExpiry(boolean checkForExpiry) {
        this.checkForExpiry = checkForExpiry;
    }

    public @Max(value = 12) Integer getMonthsToPurge() {
        return monthsToPurge;
    }

    public void setMonthsToPurge(@Max(value = 12) Integer monthsToPurge) {
        this.monthsToPurge = monthsToPurge;
    }

    public boolean isValidateInstrumentId() {
        return validateInstrumentId;
    }

    public void setValidateInstrumentId(boolean validateInstrumentId) {
        this.validateInstrumentId = validateInstrumentId;
    }
}
