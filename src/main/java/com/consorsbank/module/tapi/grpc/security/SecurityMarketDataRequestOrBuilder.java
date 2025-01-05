// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: SecurityService.proto

package com.consorsbank.module.tapi.grpc.security;

public interface SecurityMarketDataRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.consorsbank.module.tapi.grpc.SecurityMarketDataRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   **
   * Access token
   * </pre>
   *
   * <code>string access_token = 1;</code>
   */
  java.lang.String getAccessToken();
  /**
   * <pre>
   **
   * Access token
   * </pre>
   *
   * <code>string access_token = 1;</code>
   */
  com.google.protobuf.ByteString
      getAccessTokenBytes();

  /**
   * <code>.com.consorsbank.module.tapi.grpc.SecurityWithStockExchange security_with_stockexchange = 2;</code>
   */
  boolean hasSecurityWithStockexchange();
  /**
   * <code>.com.consorsbank.module.tapi.grpc.SecurityWithStockExchange security_with_stockexchange = 2;</code>
   */
  com.consorsbank.module.tapi.grpc.security.SecurityWithStockExchange getSecurityWithStockexchange();
  /**
   * <code>.com.consorsbank.module.tapi.grpc.SecurityWithStockExchange security_with_stockexchange = 2;</code>
   */
  com.consorsbank.module.tapi.grpc.security.SecurityWithStockExchangeOrBuilder getSecurityWithStockexchangeOrBuilder();

  /**
   * <pre>
   ** Currency 
   * </pre>
   *
   * <code>string currency = 3;</code>
   */
  java.lang.String getCurrency();
  /**
   * <pre>
   ** Currency 
   * </pre>
   *
   * <code>string currency = 3;</code>
   */
  com.google.protobuf.ByteString
      getCurrencyBytes();
}
