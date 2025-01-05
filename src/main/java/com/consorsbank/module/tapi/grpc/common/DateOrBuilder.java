// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Common.proto

package com.consorsbank.module.tapi.grpc.common;

public interface DateOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.consorsbank.module.tapi.grpc.Date)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Year of date. Must be from 1 to 9999, or 0 if specifying a date without
   * a year.
   * </pre>
   *
   * <code>int32 year = 1;</code>
   */
  int getYear();

  /**
   * <pre>
   * Month of year. Must be from 1 to 12.
   * </pre>
   *
   * <code>int32 month = 2;</code>
   */
  int getMonth();

  /**
   * <pre>
   * Day of month. Must be from 1 to 31 and valid for the year and month, or 0
   * if specifying a year/month where the day is not significant.
   * </pre>
   *
   * <code>int32 day = 3;</code>
   */
  int getDay();
}
