// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: SecurityService.proto

package com.consorsbank.module.tapi.grpc.security;

public interface SecurityInfoRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.consorsbank.module.tapi.grpc.SecurityInfoRequest)
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
   * <pre>
   **
   * Security code with security type (WKN, ISIN) 
   * </pre>
   *
   * <code>.com.consorsbank.module.tapi.grpc.SecurityCode security_code = 2;</code>
   */
  boolean hasSecurityCode();
  /**
   * <pre>
   **
   * Security code with security type (WKN, ISIN) 
   * </pre>
   *
   * <code>.com.consorsbank.module.tapi.grpc.SecurityCode security_code = 2;</code>
   */
  com.consorsbank.module.tapi.grpc.security.SecurityCode getSecurityCode();
  /**
   * <pre>
   **
   * Security code with security type (WKN, ISIN) 
   * </pre>
   *
   * <code>.com.consorsbank.module.tapi.grpc.SecurityCode security_code = 2;</code>
   */
  com.consorsbank.module.tapi.grpc.security.SecurityCodeOrBuilder getSecurityCodeOrBuilder();
}
