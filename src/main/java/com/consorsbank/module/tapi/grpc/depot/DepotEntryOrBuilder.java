// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: DepotService.proto

package com.consorsbank.module.tapi.grpc.depot;

public interface DepotEntryOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.consorsbank.module.tapi.grpc.DepotEntry)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   **
   * Security code
   * </pre>
   *
   * <code>.com.consorsbank.module.tapi.grpc.SecurityCode security_code = 1;</code>
   */
  boolean hasSecurityCode();
  /**
   * <pre>
   **
   * Security code
   * </pre>
   *
   * <code>.com.consorsbank.module.tapi.grpc.SecurityCode security_code = 1;</code>
   */
  com.consorsbank.module.tapi.grpc.security.SecurityCode getSecurityCode();
  /**
   * <pre>
   **
   * Security code
   * </pre>
   *
   * <code>.com.consorsbank.module.tapi.grpc.SecurityCode security_code = 1;</code>
   */
  com.consorsbank.module.tapi.grpc.security.SecurityCodeOrBuilder getSecurityCodeOrBuilder();

  /**
   * <pre>
   **
   * List of linked depot positions. This list contains at least one element
   * </pre>
   *
   * <code>repeated .com.consorsbank.module.tapi.grpc.DepotPosition positions = 2;</code>
   */
  java.util.List<com.consorsbank.module.tapi.grpc.depot.DepotPosition> 
      getPositionsList();
  /**
   * <pre>
   **
   * List of linked depot positions. This list contains at least one element
   * </pre>
   *
   * <code>repeated .com.consorsbank.module.tapi.grpc.DepotPosition positions = 2;</code>
   */
  com.consorsbank.module.tapi.grpc.depot.DepotPosition getPositions(int index);
  /**
   * <pre>
   **
   * List of linked depot positions. This list contains at least one element
   * </pre>
   *
   * <code>repeated .com.consorsbank.module.tapi.grpc.DepotPosition positions = 2;</code>
   */
  int getPositionsCount();
  /**
   * <pre>
   **
   * List of linked depot positions. This list contains at least one element
   * </pre>
   *
   * <code>repeated .com.consorsbank.module.tapi.grpc.DepotPosition positions = 2;</code>
   */
  java.util.List<? extends com.consorsbank.module.tapi.grpc.depot.DepotPositionOrBuilder> 
      getPositionsOrBuilderList();
  /**
   * <pre>
   **
   * List of linked depot positions. This list contains at least one element
   * </pre>
   *
   * <code>repeated .com.consorsbank.module.tapi.grpc.DepotPosition positions = 2;</code>
   */
  com.consorsbank.module.tapi.grpc.depot.DepotPositionOrBuilder getPositionsOrBuilder(
      int index);

  /**
   * <pre>
   **
   * Effective amount
   * </pre>
   *
   * <code>double effective_amount = 3;</code>
   */
  double getEffectiveAmount();

  /**
   * <pre>
   **
   * Scheduled amount
   * </pre>
   *
   * <code>double scheduled_amount = 4;</code>
   */
  double getScheduledAmount();

  /**
   * <pre>
   **
   * Total amount of the securities
   * </pre>
   *
   * <code>double total_amount = 5;</code>
   */
  double getTotalAmount();

  /**
   * <pre>
   **
   * True if sell possible for this entry or false otherwise. This value 
   * can be true only if all child positions have sell_possible = true
   * </pre>
   *
   * <code>bool sell_possible = 6;</code>
   */
  boolean getSellPossible();

  /**
   * <pre>
   **
   * Unit note
   * </pre>
   *
   * <code>.com.consorsbank.module.tapi.grpc.UnitNote unit_note = 7;</code>
   */
  int getUnitNoteValue();
  /**
   * <pre>
   **
   * Unit note
   * </pre>
   *
   * <code>.com.consorsbank.module.tapi.grpc.UnitNote unit_note = 7;</code>
   */
  com.consorsbank.module.tapi.grpc.common.UnitNote getUnitNote();

  /**
   * <pre>
   **
   * True if entry is blocked or false otherwise
   * </pre>
   *
   * <code>bool blocked = 10;</code>
   */
  boolean getBlocked();

  /**
   * <pre>
   **
   * Purchase quotation or NaN if not defined
   * </pre>
   *
   * <code>double purchase_quotation = 11;</code>
   */
  double getPurchaseQuotation();

  /**
   * <pre>
   **
   * Purchase currency or empty value if not defined 
   * </pre>
   *
   * <code>string purchase_currency = 12;</code>
   */
  java.lang.String getPurchaseCurrency();
  /**
   * <pre>
   **
   * Purchase currency or empty value if not defined 
   * </pre>
   *
   * <code>string purchase_currency = 12;</code>
   */
  com.google.protobuf.ByteString
      getPurchaseCurrencyBytes();

  /**
   * <pre>
   **
   * Purchase currency rate or NaN if not defined
   * </pre>
   *
   * <code>double purchase_currency_rate = 13;</code>
   */
  double getPurchaseCurrencyRate();

  /**
   * <pre>
   **
   * Open sales
   * </pre>
   *
   * <code>double open_sales = 14;</code>
   */
  double getOpenSales();
}
