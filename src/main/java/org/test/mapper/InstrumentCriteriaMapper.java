package org.test.mapper;

import jakarta.enterprise.context.ApplicationScoped;
import org.test.dto.InstrumentCriteriaDto;
import org.test.dto.SuspensionCriteriaDto;
import org.test.dto.SuspensionCriteriaUpdateDto;
import org.test.dto.TimeLimitedTransactionDto;
import org.test.dto.TimeLimitedTransactionUpdateDto;
import org.test.dto.TransactionLimitDto;
import org.test.dto.TransactionLimitUpdateDto;
import org.test.entity.InstrumentCriteria;
import org.test.entity.SuspensionCriteria;
import org.test.entity.TimedTransactionLimits;
import org.test.entity.TransactionLimits;


import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class InstrumentCriteriaMapper {

    /**
     * Method to map instrument criteria mongo document to response format
     * @param instrumentCriteria
     * @return
     */

    public static InstrumentCriteriaDto convertCriteriaEntityToResponse(InstrumentCriteria instrumentCriteria) {

        InstrumentCriteriaDto instrumentCriteriaDto = new InstrumentCriteriaDto();
        instrumentCriteriaDto.setCriteriaId(instrumentCriteria.getCriteriaId());
        instrumentCriteriaDto.setDescription(instrumentCriteria.getDescription());
        instrumentCriteriaDto.setNumberOfDailyDeclineAllowed(instrumentCriteria.getNoOfDailyDeclinesAllowed());
        instrumentCriteriaDto.setSupportSuspension(instrumentCriteria.isSupportSuspension());
        instrumentCriteriaDto.setValidateInstrumentId(instrumentCriteria.isValidateInstrument());
        instrumentCriteriaDto.setCheckForExpiry(instrumentCriteria.getCheckForExpiry());
        instrumentCriteriaDto.setCoolOfPeriod(instrumentCriteria.getCoolOfPeriod());
        instrumentCriteriaDto.setMonthsToPurge(instrumentCriteria.getMonthsToPurge());

        List<TransactionLimitDto> transactionLimitDtos = new ArrayList<>();
        if(instrumentCriteria.getTransactionLimits() != null && !instrumentCriteria.getTransactionLimits().isEmpty()){

            instrumentCriteria.getTransactionLimits().forEach(transactionLimit -> {

                if(transactionLimit != null) {
                    transactionLimitDtos.add(createEntityToTransactionLimitDto(transactionLimit));
                }
            });

        }
        instrumentCriteriaDto.setTransactionLimits(transactionLimitDtos);

        List<SuspensionCriteriaDto> suspensionCriteriaDtos = new ArrayList<>();
        if(instrumentCriteria.isSupportSuspension()){

            if(instrumentCriteria.getSuspensionCriterias() != null && !instrumentCriteria.getSuspensionCriterias().isEmpty()){

                instrumentCriteria.getSuspensionCriterias().forEach( suspensionCriteria -> {

                    if(suspensionCriteria != null) {

                        suspensionCriteriaDtos.add(createSuspensionCriteriaDto(suspensionCriteria));
                    }
                });
            }
        }
        instrumentCriteriaDto.setSuspensionCriterias(suspensionCriteriaDtos);

        List<TimeLimitedTransactionDto> timeLimitedTransactionDtos = new ArrayList<>();
        if(instrumentCriteria.getTimeLimitedTransactionLimits() != null
                && !instrumentCriteria.getTimeLimitedTransactionLimits().isEmpty()){

            instrumentCriteria.getTimeLimitedTransactionLimits().forEach(timedTransactionLimits -> {

                if(timedTransactionLimits != null){

                    timeLimitedTransactionDtos.add(createTimeLimitedTransactionDto(timedTransactionLimits));
                }
            });
        }
        instrumentCriteriaDto.setTimeLimitedTransactionLimits(timeLimitedTransactionDtos);

        return instrumentCriteriaDto;
    }

    private static TimeLimitedTransactionDto createTimeLimitedTransactionDto(TimedTransactionLimits timedTransactionLimits) {

        TimeLimitedTransactionDto timeLimitedTransactionDto = new TimeLimitedTransactionDto();
        timeLimitedTransactionDto.setTimeLimit(timedTransactionLimits.getTimeLimit());
        timeLimitedTransactionDto.setTimeUnit(timedTransactionLimits.getTimeUnit());
        timeLimitedTransactionDto.setLimitType(timedTransactionLimits.getLimitType());
        timeLimitedTransactionDto.setTransactionCount(timedTransactionLimits.getTransactionCount());
        timeLimitedTransactionDto.setTransactionAmount(timedTransactionLimits.getTransactionAmount());


        return timeLimitedTransactionDto;
    }


    public static TimeLimitedTransactionUpdateDto createTimeLimitedTransactionUpdateDto(TimedTransactionLimits timedTransactionLimits) {

        TimeLimitedTransactionUpdateDto timeLimitedTransactionDto = new TimeLimitedTransactionUpdateDto();
        timeLimitedTransactionDto.setTimeLimit(timedTransactionLimits.getTimeLimit());
        timeLimitedTransactionDto.setTimeUnit(timedTransactionLimits.getTimeUnit());
        timeLimitedTransactionDto.setLimitType(timedTransactionLimits.getLimitType());
        timeLimitedTransactionDto.setTransactionCount(timedTransactionLimits.getTransactionCount());
        timeLimitedTransactionDto.setTransactionAmount(timedTransactionLimits.getTransactionAmount());


        return timeLimitedTransactionDto;
    }

    public static SuspensionCriteriaDto createSuspensionCriteriaDto(SuspensionCriteria suspensionCriteria) {

        SuspensionCriteriaDto suspensionCriteriaDto = new SuspensionCriteriaDto();
        suspensionCriteriaDto.setChannel(suspensionCriteria.getChannel());
        suspensionCriteriaDto.setResponseCode(suspensionCriteria.getResponseCode());
        suspensionCriteriaDto.setSuspensionDuration(suspensionCriteria.getSuspensionDuration());
        suspensionCriteriaDto.setTimeUnit(suspensionCriteria.getTimeUnit());
        suspensionCriteriaDto.setNoOfDeclines(suspensionCriteria.getNoOfDeclines());
        suspensionCriteriaDto.setTemporaryOrPerm(suspensionCriteria.getTemporaryOrPermanent());

        return suspensionCriteriaDto;
    }

    public static SuspensionCriteriaUpdateDto createSuspensionCriteriaUpdateDto(SuspensionCriteria suspensionCriteria) {

        SuspensionCriteriaUpdateDto suspensionCriteriaDto = new SuspensionCriteriaUpdateDto();
        suspensionCriteriaDto.setChannel(suspensionCriteria.getChannel());
        suspensionCriteriaDto.setResponseCode(suspensionCriteria.getResponseCode());
        suspensionCriteriaDto.setSuspensionDuration(suspensionCriteria.getSuspensionDuration());
        suspensionCriteriaDto.setTimeUnit(suspensionCriteria.getTimeUnit());
        suspensionCriteriaDto.setNoOfDeclines(suspensionCriteria.getNoOfDeclines());
        suspensionCriteriaDto.setTemporaryOrPerm(suspensionCriteria.getTemporaryOrPermanent());

        return suspensionCriteriaDto;
    }


    /**
     * Method to convert Transaction limit mongo document to response format
     * @param transactionLimit
     * @return
     */
    private static TransactionLimitDto createEntityToTransactionLimitDto(TransactionLimits transactionLimit) {

        TransactionLimitDto transactionLimitDto = new TransactionLimitDto();

        if(transactionLimit.getLimitType() != null) transactionLimitDto.setLimitType(transactionLimit.getLimitType());
        transactionLimitDto.setTransactionCount(transactionLimit.getTransactionCount());
        transactionLimitDto.setTransactionAmount(transactionLimit.getTransactionAmount());

        return transactionLimitDto;
    }

    public static TransactionLimitUpdateDto createEntityToTransactionLimitUpdateDto(TransactionLimits transactionLimit) {

        TransactionLimitUpdateDto transactionLimitDto = new TransactionLimitUpdateDto();

        if(transactionLimit.getLimitType() != null) transactionLimitDto.setLimitType(transactionLimit.getLimitType());
        transactionLimitDto.setTransactionCount(transactionLimit.getTransactionCount());
        transactionLimitDto.setTransactionAmount(transactionLimit.getTransactionAmount());

        return transactionLimitDto;
    }

    /**
     * Method to create the criteria entity from the request
     * @param instrumentCriteriaDto
     * @return
     */
    public static InstrumentCriteria createCriteriaEntityFromDto(InstrumentCriteriaDto instrumentCriteriaDto) {

        InstrumentCriteria instrumentCriteria = new InstrumentCriteria();
        instrumentCriteria.setCriteriaId(instrumentCriteriaDto.getCriteriaId());
        instrumentCriteria.setDescription(instrumentCriteriaDto.getDescription());
        instrumentCriteria.setCheckForExpiry(instrumentCriteriaDto.isCheckForExpiry());
        instrumentCriteria.setCoolOfPeriod(instrumentCriteriaDto.getCoolOfPeriod());
        instrumentCriteria.setMonthsToPurge(instrumentCriteriaDto.getMonthsToPurge());
        instrumentCriteria.setSupportSuspension(instrumentCriteriaDto.isSupportSuspension());
        instrumentCriteria.setValidateInstrument(instrumentCriteriaDto.isValidateInstrumentId());
        instrumentCriteria.setNoOfDailyDeclinesAllowed(instrumentCriteriaDto.getNumberOfDailyDeclineAllowed());

        if(instrumentCriteriaDto.isSupportSuspension()){
            List<SuspensionCriteria> suspensionCriterias =  new ArrayList<>();
            instrumentCriteria.setSuspensionCriterias(suspensionCriterias);

            if(instrumentCriteriaDto.getSuspensionCriterias() != null &&
                    !instrumentCriteriaDto.getSuspensionCriterias().isEmpty()){

                instrumentCriteriaDto.getSuspensionCriterias().forEach(suspCriteria -> {

                    if(suspCriteria != null){
                        SuspensionCriteria suspensionCriteria =  createSuspensionCriteriaEntityFromDto(suspCriteria);
                        suspensionCriterias.add(suspensionCriteria);
                    }
                });
            }

        }

        if(instrumentCriteriaDto.getTransactionLimits() != null  && !instrumentCriteriaDto.getTransactionLimits().isEmpty()){

            List<TransactionLimits> transactionLimits = new ArrayList<>();
            for(TransactionLimitDto transactionLimitDto : instrumentCriteriaDto.getTransactionLimits()){

                if(transactionLimitDto != null) {

                    transactionLimits.add(createTransactionLimitEntityFromDto(transactionLimitDto));
                }
            }

            instrumentCriteria.setTransactionLimits(transactionLimits);
        }

        if(instrumentCriteriaDto.getTimeLimitedTransactionLimits() != null
                && !instrumentCriteriaDto.getTimeLimitedTransactionLimits().isEmpty()){

            List<TimedTransactionLimits> timedTransactionLimit = new ArrayList<>();

            for(TimeLimitedTransactionDto timeLimitedTransactionDto: instrumentCriteriaDto.getTimeLimitedTransactionLimits()){

                if(timeLimitedTransactionDto != null) {

                    timedTransactionLimit.add(createTimedTransactionLimitEntityFromDto(timeLimitedTransactionDto));
                }
            }

            instrumentCriteria.setTimeLimitedTransactionLimits(timedTransactionLimit);
        }

        return instrumentCriteria;
    }

    /**
     * Method to create the Time limited transaction entity from the request
     * @param timedTransactionLimitRequest
     * @return
     */
    public static TimedTransactionLimits createTimedTransactionLimitEntityFromDto(TimeLimitedTransactionDto timedTransactionLimitRequest) {

        TimedTransactionLimits timedTransactionLimit = new TimedTransactionLimits();
        timedTransactionLimit.setTimeLimit(timedTransactionLimitRequest.getTimeLimit());
        timedTransactionLimit.setTransactionCount(timedTransactionLimitRequest.getTransactionCount());
        timedTransactionLimit.setTransactionAmount(timedTransactionLimitRequest.getTransactionAmount());
        timedTransactionLimit.setLimitType(timedTransactionLimitRequest.getLimitType());
        timedTransactionLimit.setTimeUnit(timedTransactionLimitRequest.getTimeUnit());
        return timedTransactionLimit;
    }

    public static TimedTransactionLimits createTimedTransactionLimitEntityFromDto(TimeLimitedTransactionUpdateDto timedTransactionLimitRequest) {

        TimedTransactionLimits timedTransactionLimit = new TimedTransactionLimits();
        timedTransactionLimit.setTimeLimit(timedTransactionLimitRequest.getTimeLimit());
        timedTransactionLimit.setTransactionCount(timedTransactionLimitRequest.getTransactionCount());
        timedTransactionLimit.setTransactionAmount(timedTransactionLimitRequest.getTransactionAmount());
        timedTransactionLimit.setLimitType(timedTransactionLimitRequest.getLimitType());
        timedTransactionLimit.setTimeUnit(timedTransactionLimitRequest.getTimeUnit());
        return timedTransactionLimit;
    }

    /**
     * Method to map the transaction limit request data to mongo entity
     * @param transactionLimitRequest
     * @return
     */
    public static TransactionLimits createTransactionLimitEntityFromDto(TransactionLimitDto transactionLimitRequest) {

        TransactionLimits transactionLimit = new TransactionLimits();
        transactionLimit.setLimitType(transactionLimitRequest.getLimitType());
        transactionLimit.setTransactionCount(transactionLimitRequest.getTransactionCount());
        transactionLimit.setTransactionAmount(transactionLimitRequest.getTransactionAmount());

        return transactionLimit;
    }

    public static TransactionLimits createTransactionLimitEntityFromDto(TransactionLimitUpdateDto transactionLimitRequest) {

        TransactionLimits transactionLimit = new TransactionLimits();
        transactionLimit.setLimitType(transactionLimitRequest.getLimitType());
        transactionLimit.setTransactionCount(transactionLimitRequest.getTransactionCount());
        transactionLimit.setTransactionAmount(transactionLimitRequest.getTransactionAmount());

        return transactionLimit;
    }

    /**
     * Method to create the suspension criteria mongo entity from the request
     * @param suspCriteria
     * @return
     */
    public static SuspensionCriteria createSuspensionCriteriaEntityFromDto(SuspensionCriteriaDto suspCriteria) {

        SuspensionCriteria suspensionCriteria = new SuspensionCriteria();

        suspensionCriteria.setSuspensionDuration(suspCriteria.getSuspensionDuration());
        suspensionCriteria.setChannel(suspCriteria.getChannel());
        suspensionCriteria.setResponseCode(suspCriteria.getResponseCode());
        suspensionCriteria.setTimeUnit(suspCriteria.getTimeUnit());
        suspensionCriteria.setTemporaryOrPermanent(suspCriteria.getTemporaryOrPerm());
        return suspensionCriteria;
    }

    public static SuspensionCriteria createSuspensionCriteriaEntityFromDto(SuspensionCriteriaUpdateDto suspCriteria) {

        SuspensionCriteria suspensionCriteria = new SuspensionCriteria();

        suspensionCriteria.setSuspensionDuration(suspCriteria.getSuspensionDuration());
        suspensionCriteria.setChannel(suspCriteria.getChannel());
        suspensionCriteria.setResponseCode(suspCriteria.getResponseCode());
        suspensionCriteria.setTimeUnit(suspCriteria.getTimeUnit());
        suspensionCriteria.setTemporaryOrPermanent(suspCriteria.getTemporaryOrPerm());
        return suspensionCriteria;
    }
}
