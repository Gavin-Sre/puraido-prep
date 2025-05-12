package com.example.spring_boot.processor;

import com.example.spring_boot.enums.ProcessType;

public class PaymentResult {
  private boolean success;
  private ProcessType processType;

  public PaymentResult() {}

  public PaymentResult(boolean success, ProcessType processType) {
    this.success = success;
    this.processType = processType;
  }

  public boolean isSuccess() {
    return success;
  }

  public ProcessType getProcessType() {
    return processType;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public void setProcessType(ProcessType processType) {
    this.processType = processType;
  }
}
