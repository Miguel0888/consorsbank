// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: OrderService.proto

package com.consorsbank.module.tapi.grpc.order;

public interface OrderCostsOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.consorsbank.module.tapi.grpc.OrderCosts)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   **
   * Estimated total cost for order action
   * </pre>
   *
   * <code>double estimated_total_costs = 1;</code>
   */
  double getEstimatedTotalCosts();

  /**
   * <pre>
   **
   * Reference backend cost id
   * </pre>
   *
   * <code>string cost_id = 2;</code>
   */
  java.lang.String getCostId();
  /**
   * <pre>
   **
   * Reference backend cost id
   * </pre>
   *
   * <code>string cost_id = 2;</code>
   */
  com.google.protobuf.ByteString
      getCostIdBytes();

  /**
   * <pre>
   ** 
   * List of the cost categories.  Filled only by validation request with detailed information.
   * </pre>
   *
   * <code>repeated .com.consorsbank.module.tapi.grpc.OrderCosts.CategoryCost categorie_costs = 3;</code>
   */
  java.util.List<com.consorsbank.module.tapi.grpc.order.OrderCosts.CategoryCost> 
      getCategorieCostsList();
  /**
   * <pre>
   ** 
   * List of the cost categories.  Filled only by validation request with detailed information.
   * </pre>
   *
   * <code>repeated .com.consorsbank.module.tapi.grpc.OrderCosts.CategoryCost categorie_costs = 3;</code>
   */
  com.consorsbank.module.tapi.grpc.order.OrderCosts.CategoryCost getCategorieCosts(int index);
  /**
   * <pre>
   ** 
   * List of the cost categories.  Filled only by validation request with detailed information.
   * </pre>
   *
   * <code>repeated .com.consorsbank.module.tapi.grpc.OrderCosts.CategoryCost categorie_costs = 3;</code>
   */
  int getCategorieCostsCount();
  /**
   * <pre>
   ** 
   * List of the cost categories.  Filled only by validation request with detailed information.
   * </pre>
   *
   * <code>repeated .com.consorsbank.module.tapi.grpc.OrderCosts.CategoryCost categorie_costs = 3;</code>
   */
  java.util.List<? extends com.consorsbank.module.tapi.grpc.order.OrderCosts.CategoryCostOrBuilder> 
      getCategorieCostsOrBuilderList();
  /**
   * <pre>
   ** 
   * List of the cost categories.  Filled only by validation request with detailed information.
   * </pre>
   *
   * <code>repeated .com.consorsbank.module.tapi.grpc.OrderCosts.CategoryCost categorie_costs = 3;</code>
   */
  com.consorsbank.module.tapi.grpc.order.OrderCosts.CategoryCostOrBuilder getCategorieCostsOrBuilder(
      int index);

  /**
   * <pre>
   **
   * Aggregated costs for the order.  Filled only by validation request with validation information.
   * </pre>
   *
   * <code>.com.consorsbank.module.tapi.grpc.OrderCosts.AggregatedCosts aggregated_costs = 4;</code>
   */
  boolean hasAggregatedCosts();
  /**
   * <pre>
   **
   * Aggregated costs for the order.  Filled only by validation request with validation information.
   * </pre>
   *
   * <code>.com.consorsbank.module.tapi.grpc.OrderCosts.AggregatedCosts aggregated_costs = 4;</code>
   */
  com.consorsbank.module.tapi.grpc.order.OrderCosts.AggregatedCosts getAggregatedCosts();
  /**
   * <pre>
   **
   * Aggregated costs for the order.  Filled only by validation request with validation information.
   * </pre>
   *
   * <code>.com.consorsbank.module.tapi.grpc.OrderCosts.AggregatedCosts aggregated_costs = 4;</code>
   */
  com.consorsbank.module.tapi.grpc.order.OrderCosts.AggregatedCostsOrBuilder getAggregatedCostsOrBuilder();
}
