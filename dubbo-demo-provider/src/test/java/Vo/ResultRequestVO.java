package Vo;

import lombok.Builder;

import java.util.Date;

@Builder
public class ResultRequestVO {
    private String itemReportCode;
    private String itemReportName;
    private String instrumentCode;
    private String instrumentName;
    private String testResult;
    private String machineResult;
    private String retestResult;
    private String isRetest;
    private String testJudge;
    private String resultUnit;
    private String referenceValue;
    private String upValue;
    private String downValue;
    private String adviseExplain;
    private String clinicalBak;
    private String recordStatus;
    private String recordStatusDesc;
    private String resultEn;
    private Date recordDate;
    private Date testDate;
    private String criticalValue;
    private String isCritical;
    private String isException;
    private String criticalStatus;
    private String criticalProcessResult;
    private String criticalProcessor;
    private String criticalProcessorId;
    private String criticalProcessorPhone;
    private String criticalProcessorContact;
    private String criticalReturn;
    private String criticalHandleTime;
    private String isAdd;
    private String testTime;
    private String testUserCode;
    private String testUserName;
    private int isCheck;
}
