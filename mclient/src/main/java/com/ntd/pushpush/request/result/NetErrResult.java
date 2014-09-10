package com.ntd.pushpush.request.result;

/**
 * Result of thread for net error.
 *
 * @author wlei 2012-5-9
 */
public class NetErrResult extends RequestResult {

  private static final long serialVersionUID = 1L;

  private Exception exception;

  public NetErrResult(Exception exception) {
    this.exception = exception;
  }

  public Exception getException() {
    return exception;
  }
}