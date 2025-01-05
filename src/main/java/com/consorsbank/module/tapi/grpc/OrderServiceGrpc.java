package com.consorsbank.module.tapi.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 **
 * Order service provide functionality to control orders. 
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: TradingAPI.proto")
public final class OrderServiceGrpc {

  private OrderServiceGrpc() {}

  public static final String SERVICE_NAME = "com.consorsbank.module.tapi.grpc.OrderService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getStreamOrdersMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.account.TradingAccountRequest,
      com.consorsbank.module.tapi.grpc.order.Orders> METHOD_STREAM_ORDERS = getStreamOrdersMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.account.TradingAccountRequest,
      com.consorsbank.module.tapi.grpc.order.Orders> getStreamOrdersMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.account.TradingAccountRequest,
      com.consorsbank.module.tapi.grpc.order.Orders> getStreamOrdersMethod() {
    return getStreamOrdersMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.account.TradingAccountRequest,
      com.consorsbank.module.tapi.grpc.order.Orders> getStreamOrdersMethodHelper() {
    io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.account.TradingAccountRequest, com.consorsbank.module.tapi.grpc.order.Orders> getStreamOrdersMethod;
    if ((getStreamOrdersMethod = OrderServiceGrpc.getStreamOrdersMethod) == null) {
      synchronized (OrderServiceGrpc.class) {
        if ((getStreamOrdersMethod = OrderServiceGrpc.getStreamOrdersMethod) == null) {
          OrderServiceGrpc.getStreamOrdersMethod = getStreamOrdersMethod = 
              io.grpc.MethodDescriptor.<com.consorsbank.module.tapi.grpc.account.TradingAccountRequest, com.consorsbank.module.tapi.grpc.order.Orders>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "com.consorsbank.module.tapi.grpc.OrderService", "StreamOrders"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.consorsbank.module.tapi.grpc.account.TradingAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.consorsbank.module.tapi.grpc.order.Orders.getDefaultInstance()))
                  .setSchemaDescriptor(new OrderServiceMethodDescriptorSupplier("StreamOrders"))
                  .build();
          }
        }
     }
     return getStreamOrdersMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateOrdersMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.account.TradingAccountRequest,
      com.consorsbank.module.tapi.grpc.common.Empty> METHOD_UPDATE_ORDERS = getUpdateOrdersMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.account.TradingAccountRequest,
      com.consorsbank.module.tapi.grpc.common.Empty> getUpdateOrdersMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.account.TradingAccountRequest,
      com.consorsbank.module.tapi.grpc.common.Empty> getUpdateOrdersMethod() {
    return getUpdateOrdersMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.account.TradingAccountRequest,
      com.consorsbank.module.tapi.grpc.common.Empty> getUpdateOrdersMethodHelper() {
    io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.account.TradingAccountRequest, com.consorsbank.module.tapi.grpc.common.Empty> getUpdateOrdersMethod;
    if ((getUpdateOrdersMethod = OrderServiceGrpc.getUpdateOrdersMethod) == null) {
      synchronized (OrderServiceGrpc.class) {
        if ((getUpdateOrdersMethod = OrderServiceGrpc.getUpdateOrdersMethod) == null) {
          OrderServiceGrpc.getUpdateOrdersMethod = getUpdateOrdersMethod = 
              io.grpc.MethodDescriptor.<com.consorsbank.module.tapi.grpc.account.TradingAccountRequest, com.consorsbank.module.tapi.grpc.common.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.consorsbank.module.tapi.grpc.OrderService", "UpdateOrders"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.consorsbank.module.tapi.grpc.account.TradingAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.consorsbank.module.tapi.grpc.common.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new OrderServiceMethodDescriptorSupplier("UpdateOrders"))
                  .build();
          }
        }
     }
     return getUpdateOrdersMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetQuoteMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.order.QuoteRequest,
      com.consorsbank.module.tapi.grpc.order.QuoteReply> METHOD_GET_QUOTE = getGetQuoteMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.order.QuoteRequest,
      com.consorsbank.module.tapi.grpc.order.QuoteReply> getGetQuoteMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.order.QuoteRequest,
      com.consorsbank.module.tapi.grpc.order.QuoteReply> getGetQuoteMethod() {
    return getGetQuoteMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.order.QuoteRequest,
      com.consorsbank.module.tapi.grpc.order.QuoteReply> getGetQuoteMethodHelper() {
    io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.order.QuoteRequest, com.consorsbank.module.tapi.grpc.order.QuoteReply> getGetQuoteMethod;
    if ((getGetQuoteMethod = OrderServiceGrpc.getGetQuoteMethod) == null) {
      synchronized (OrderServiceGrpc.class) {
        if ((getGetQuoteMethod = OrderServiceGrpc.getGetQuoteMethod) == null) {
          OrderServiceGrpc.getGetQuoteMethod = getGetQuoteMethod = 
              io.grpc.MethodDescriptor.<com.consorsbank.module.tapi.grpc.order.QuoteRequest, com.consorsbank.module.tapi.grpc.order.QuoteReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.consorsbank.module.tapi.grpc.OrderService", "GetQuote"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.consorsbank.module.tapi.grpc.order.QuoteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.consorsbank.module.tapi.grpc.order.QuoteReply.getDefaultInstance()))
                  .setSchemaDescriptor(new OrderServiceMethodDescriptorSupplier("GetQuote"))
                  .build();
          }
        }
     }
     return getGetQuoteMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getAcceptQuoteMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.order.AcceptQuoteRequest,
      com.consorsbank.module.tapi.grpc.order.OrderReply> METHOD_ACCEPT_QUOTE = getAcceptQuoteMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.order.AcceptQuoteRequest,
      com.consorsbank.module.tapi.grpc.order.OrderReply> getAcceptQuoteMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.order.AcceptQuoteRequest,
      com.consorsbank.module.tapi.grpc.order.OrderReply> getAcceptQuoteMethod() {
    return getAcceptQuoteMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.order.AcceptQuoteRequest,
      com.consorsbank.module.tapi.grpc.order.OrderReply> getAcceptQuoteMethodHelper() {
    io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.order.AcceptQuoteRequest, com.consorsbank.module.tapi.grpc.order.OrderReply> getAcceptQuoteMethod;
    if ((getAcceptQuoteMethod = OrderServiceGrpc.getAcceptQuoteMethod) == null) {
      synchronized (OrderServiceGrpc.class) {
        if ((getAcceptQuoteMethod = OrderServiceGrpc.getAcceptQuoteMethod) == null) {
          OrderServiceGrpc.getAcceptQuoteMethod = getAcceptQuoteMethod = 
              io.grpc.MethodDescriptor.<com.consorsbank.module.tapi.grpc.order.AcceptQuoteRequest, com.consorsbank.module.tapi.grpc.order.OrderReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.consorsbank.module.tapi.grpc.OrderService", "AcceptQuote"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.consorsbank.module.tapi.grpc.order.AcceptQuoteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.consorsbank.module.tapi.grpc.order.OrderReply.getDefaultInstance()))
                  .setSchemaDescriptor(new OrderServiceMethodDescriptorSupplier("AcceptQuote"))
                  .build();
          }
        }
     }
     return getAcceptQuoteMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getAddOrderMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.order.AddOrderRequest,
      com.consorsbank.module.tapi.grpc.order.OrderReply> METHOD_ADD_ORDER = getAddOrderMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.order.AddOrderRequest,
      com.consorsbank.module.tapi.grpc.order.OrderReply> getAddOrderMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.order.AddOrderRequest,
      com.consorsbank.module.tapi.grpc.order.OrderReply> getAddOrderMethod() {
    return getAddOrderMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.order.AddOrderRequest,
      com.consorsbank.module.tapi.grpc.order.OrderReply> getAddOrderMethodHelper() {
    io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.order.AddOrderRequest, com.consorsbank.module.tapi.grpc.order.OrderReply> getAddOrderMethod;
    if ((getAddOrderMethod = OrderServiceGrpc.getAddOrderMethod) == null) {
      synchronized (OrderServiceGrpc.class) {
        if ((getAddOrderMethod = OrderServiceGrpc.getAddOrderMethod) == null) {
          OrderServiceGrpc.getAddOrderMethod = getAddOrderMethod = 
              io.grpc.MethodDescriptor.<com.consorsbank.module.tapi.grpc.order.AddOrderRequest, com.consorsbank.module.tapi.grpc.order.OrderReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.consorsbank.module.tapi.grpc.OrderService", "AddOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.consorsbank.module.tapi.grpc.order.AddOrderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.consorsbank.module.tapi.grpc.order.OrderReply.getDefaultInstance()))
                  .setSchemaDescriptor(new OrderServiceMethodDescriptorSupplier("AddOrder"))
                  .build();
          }
        }
     }
     return getAddOrderMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getChangeOrderMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.order.ChangeOrderRequest,
      com.consorsbank.module.tapi.grpc.order.OrderReply> METHOD_CHANGE_ORDER = getChangeOrderMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.order.ChangeOrderRequest,
      com.consorsbank.module.tapi.grpc.order.OrderReply> getChangeOrderMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.order.ChangeOrderRequest,
      com.consorsbank.module.tapi.grpc.order.OrderReply> getChangeOrderMethod() {
    return getChangeOrderMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.order.ChangeOrderRequest,
      com.consorsbank.module.tapi.grpc.order.OrderReply> getChangeOrderMethodHelper() {
    io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.order.ChangeOrderRequest, com.consorsbank.module.tapi.grpc.order.OrderReply> getChangeOrderMethod;
    if ((getChangeOrderMethod = OrderServiceGrpc.getChangeOrderMethod) == null) {
      synchronized (OrderServiceGrpc.class) {
        if ((getChangeOrderMethod = OrderServiceGrpc.getChangeOrderMethod) == null) {
          OrderServiceGrpc.getChangeOrderMethod = getChangeOrderMethod = 
              io.grpc.MethodDescriptor.<com.consorsbank.module.tapi.grpc.order.ChangeOrderRequest, com.consorsbank.module.tapi.grpc.order.OrderReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.consorsbank.module.tapi.grpc.OrderService", "ChangeOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.consorsbank.module.tapi.grpc.order.ChangeOrderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.consorsbank.module.tapi.grpc.order.OrderReply.getDefaultInstance()))
                  .setSchemaDescriptor(new OrderServiceMethodDescriptorSupplier("ChangeOrder"))
                  .build();
          }
        }
     }
     return getChangeOrderMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCancelOrderMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.order.CancelOrderRequest,
      com.consorsbank.module.tapi.grpc.order.OrderReply> METHOD_CANCEL_ORDER = getCancelOrderMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.order.CancelOrderRequest,
      com.consorsbank.module.tapi.grpc.order.OrderReply> getCancelOrderMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.order.CancelOrderRequest,
      com.consorsbank.module.tapi.grpc.order.OrderReply> getCancelOrderMethod() {
    return getCancelOrderMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.order.CancelOrderRequest,
      com.consorsbank.module.tapi.grpc.order.OrderReply> getCancelOrderMethodHelper() {
    io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.order.CancelOrderRequest, com.consorsbank.module.tapi.grpc.order.OrderReply> getCancelOrderMethod;
    if ((getCancelOrderMethod = OrderServiceGrpc.getCancelOrderMethod) == null) {
      synchronized (OrderServiceGrpc.class) {
        if ((getCancelOrderMethod = OrderServiceGrpc.getCancelOrderMethod) == null) {
          OrderServiceGrpc.getCancelOrderMethod = getCancelOrderMethod = 
              io.grpc.MethodDescriptor.<com.consorsbank.module.tapi.grpc.order.CancelOrderRequest, com.consorsbank.module.tapi.grpc.order.OrderReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.consorsbank.module.tapi.grpc.OrderService", "CancelOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.consorsbank.module.tapi.grpc.order.CancelOrderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.consorsbank.module.tapi.grpc.order.OrderReply.getDefaultInstance()))
                  .setSchemaDescriptor(new OrderServiceMethodDescriptorSupplier("CancelOrder"))
                  .build();
          }
        }
     }
     return getCancelOrderMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getActivateOrderMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.order.ActivateOrderRequest,
      com.consorsbank.module.tapi.grpc.order.OrderReply> METHOD_ACTIVATE_ORDER = getActivateOrderMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.order.ActivateOrderRequest,
      com.consorsbank.module.tapi.grpc.order.OrderReply> getActivateOrderMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.order.ActivateOrderRequest,
      com.consorsbank.module.tapi.grpc.order.OrderReply> getActivateOrderMethod() {
    return getActivateOrderMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.order.ActivateOrderRequest,
      com.consorsbank.module.tapi.grpc.order.OrderReply> getActivateOrderMethodHelper() {
    io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.order.ActivateOrderRequest, com.consorsbank.module.tapi.grpc.order.OrderReply> getActivateOrderMethod;
    if ((getActivateOrderMethod = OrderServiceGrpc.getActivateOrderMethod) == null) {
      synchronized (OrderServiceGrpc.class) {
        if ((getActivateOrderMethod = OrderServiceGrpc.getActivateOrderMethod) == null) {
          OrderServiceGrpc.getActivateOrderMethod = getActivateOrderMethod = 
              io.grpc.MethodDescriptor.<com.consorsbank.module.tapi.grpc.order.ActivateOrderRequest, com.consorsbank.module.tapi.grpc.order.OrderReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.consorsbank.module.tapi.grpc.OrderService", "ActivateOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.consorsbank.module.tapi.grpc.order.ActivateOrderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.consorsbank.module.tapi.grpc.order.OrderReply.getDefaultInstance()))
                  .setSchemaDescriptor(new OrderServiceMethodDescriptorSupplier("ActivateOrder"))
                  .build();
          }
        }
     }
     return getActivateOrderMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeactivateOrderMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.order.DeactivateOrderRequest,
      com.consorsbank.module.tapi.grpc.order.OrderReply> METHOD_DEACTIVATE_ORDER = getDeactivateOrderMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.order.DeactivateOrderRequest,
      com.consorsbank.module.tapi.grpc.order.OrderReply> getDeactivateOrderMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.order.DeactivateOrderRequest,
      com.consorsbank.module.tapi.grpc.order.OrderReply> getDeactivateOrderMethod() {
    return getDeactivateOrderMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.order.DeactivateOrderRequest,
      com.consorsbank.module.tapi.grpc.order.OrderReply> getDeactivateOrderMethodHelper() {
    io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.order.DeactivateOrderRequest, com.consorsbank.module.tapi.grpc.order.OrderReply> getDeactivateOrderMethod;
    if ((getDeactivateOrderMethod = OrderServiceGrpc.getDeactivateOrderMethod) == null) {
      synchronized (OrderServiceGrpc.class) {
        if ((getDeactivateOrderMethod = OrderServiceGrpc.getDeactivateOrderMethod) == null) {
          OrderServiceGrpc.getDeactivateOrderMethod = getDeactivateOrderMethod = 
              io.grpc.MethodDescriptor.<com.consorsbank.module.tapi.grpc.order.DeactivateOrderRequest, com.consorsbank.module.tapi.grpc.order.OrderReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.consorsbank.module.tapi.grpc.OrderService", "DeactivateOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.consorsbank.module.tapi.grpc.order.DeactivateOrderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.consorsbank.module.tapi.grpc.order.OrderReply.getDefaultInstance()))
                  .setSchemaDescriptor(new OrderServiceMethodDescriptorSupplier("DeactivateOrder"))
                  .build();
          }
        }
     }
     return getDeactivateOrderMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static OrderServiceStub newStub(io.grpc.Channel channel) {
    return new OrderServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static OrderServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new OrderServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static OrderServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new OrderServiceFutureStub(channel);
  }

  /**
   * <pre>
   **
   * Order service provide functionality to control orders. 
   * </pre>
   */
  public static abstract class OrderServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     **
     * Subscribes one trading account for orders updates
     * &#64;param TradingAccount 
     *      Trading account for push
     * &#64;stream Orders
     *      Orders list for seleted account 
     * </pre>
     */
    public void streamOrders(com.consorsbank.module.tapi.grpc.account.TradingAccountRequest request,
        io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.order.Orders> responseObserver) {
      asyncUnimplementedUnaryCall(getStreamOrdersMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     **
     * Initiates orders update action. All changes come by the 
     * StreamOrders subscription. This function doesn't wait for the action result.
     * &#64;param TradingAccount 
     *      Trading account for update
     * </pre>
     */
    public void updateOrders(com.consorsbank.module.tapi.grpc.account.TradingAccountRequest request,
        io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.common.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateOrdersMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     **
     * Request market quote for the selected security on the selected stock exchanges.
     * &#64;param QuoteRequest
     *    quote request with interested security and stock exchanges
     * &#64;return QuoteReply
     *    quote reply with quotes
     * </pre>
     */
    public void getQuote(com.consorsbank.module.tapi.grpc.order.QuoteRequest request,
        io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.order.QuoteReply> responseObserver) {
      asyncUnimplementedUnaryCall(getGetQuoteMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     **
     * Sends accept quote order request to the short term market
     * &#64;param AcceptQuoteRequest 
     *     accept quote request with order parameters
     * &#64;return OrderReply
     *     result order or error
     * </pre>
     */
    public void acceptQuote(com.consorsbank.module.tapi.grpc.order.AcceptQuoteRequest request,
        io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.order.OrderReply> responseObserver) {
      asyncUnimplementedUnaryCall(getAcceptQuoteMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     **
     * Sends long term order to the market
     * &#64;param AddOrderRequest
     *     order request with order parameters
     * &#64;return OrderReply
     *     result order or error
     * </pre>
     */
    public void addOrder(com.consorsbank.module.tapi.grpc.order.AddOrderRequest request,
        io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.order.OrderReply> responseObserver) {
      asyncUnimplementedUnaryCall(getAddOrderMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     **
     * Sends order change request to the market
     * &#64;param ChangeOrderRequest
     *     changed order request with order parameters
     * &#64;return OrderReply
     *     result order or error
     * </pre>
     */
    public void changeOrder(com.consorsbank.module.tapi.grpc.order.ChangeOrderRequest request,
        io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.order.OrderReply> responseObserver) {
      asyncUnimplementedUnaryCall(getChangeOrderMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     **
     * Sends order cancel request to the market
     * &#64;param CancelOrderRequest
     *     cancel order request with order reference
     * &#64;return OrderReply
     *     result order or error
     * </pre>
     */
    public void cancelOrder(com.consorsbank.module.tapi.grpc.order.CancelOrderRequest request,
        io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.order.OrderReply> responseObserver) {
      asyncUnimplementedUnaryCall(getCancelOrderMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     **
     * Sends order activate request to the market. #pro# only
     * &#64;param ActivateOrderRequest
     *     activate order request with order parameters
     * &#64;return OrderReply
     *     result order or error
     * </pre>
     */
    public void activateOrder(com.consorsbank.module.tapi.grpc.order.ActivateOrderRequest request,
        io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.order.OrderReply> responseObserver) {
      asyncUnimplementedUnaryCall(getActivateOrderMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     **
     * Sends order deactivate request to the market. #pro# only
     * &#64;param DeactivateOrderRequest
     *     deactivate order request with order parameters
     * &#64;return OrderReply
     *     result order or error
     * </pre>
     */
    public void deactivateOrder(com.consorsbank.module.tapi.grpc.order.DeactivateOrderRequest request,
        io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.order.OrderReply> responseObserver) {
      asyncUnimplementedUnaryCall(getDeactivateOrderMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getStreamOrdersMethodHelper(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.consorsbank.module.tapi.grpc.account.TradingAccountRequest,
                com.consorsbank.module.tapi.grpc.order.Orders>(
                  this, METHODID_STREAM_ORDERS)))
          .addMethod(
            getUpdateOrdersMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.consorsbank.module.tapi.grpc.account.TradingAccountRequest,
                com.consorsbank.module.tapi.grpc.common.Empty>(
                  this, METHODID_UPDATE_ORDERS)))
          .addMethod(
            getGetQuoteMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.consorsbank.module.tapi.grpc.order.QuoteRequest,
                com.consorsbank.module.tapi.grpc.order.QuoteReply>(
                  this, METHODID_GET_QUOTE)))
          .addMethod(
            getAcceptQuoteMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.consorsbank.module.tapi.grpc.order.AcceptQuoteRequest,
                com.consorsbank.module.tapi.grpc.order.OrderReply>(
                  this, METHODID_ACCEPT_QUOTE)))
          .addMethod(
            getAddOrderMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.consorsbank.module.tapi.grpc.order.AddOrderRequest,
                com.consorsbank.module.tapi.grpc.order.OrderReply>(
                  this, METHODID_ADD_ORDER)))
          .addMethod(
            getChangeOrderMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.consorsbank.module.tapi.grpc.order.ChangeOrderRequest,
                com.consorsbank.module.tapi.grpc.order.OrderReply>(
                  this, METHODID_CHANGE_ORDER)))
          .addMethod(
            getCancelOrderMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.consorsbank.module.tapi.grpc.order.CancelOrderRequest,
                com.consorsbank.module.tapi.grpc.order.OrderReply>(
                  this, METHODID_CANCEL_ORDER)))
          .addMethod(
            getActivateOrderMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.consorsbank.module.tapi.grpc.order.ActivateOrderRequest,
                com.consorsbank.module.tapi.grpc.order.OrderReply>(
                  this, METHODID_ACTIVATE_ORDER)))
          .addMethod(
            getDeactivateOrderMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.consorsbank.module.tapi.grpc.order.DeactivateOrderRequest,
                com.consorsbank.module.tapi.grpc.order.OrderReply>(
                  this, METHODID_DEACTIVATE_ORDER)))
          .build();
    }
  }

  /**
   * <pre>
   **
   * Order service provide functionality to control orders. 
   * </pre>
   */
  public static final class OrderServiceStub extends io.grpc.stub.AbstractStub<OrderServiceStub> {
    private OrderServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private OrderServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrderServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new OrderServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     **
     * Subscribes one trading account for orders updates
     * &#64;param TradingAccount 
     *      Trading account for push
     * &#64;stream Orders
     *      Orders list for seleted account 
     * </pre>
     */
    public void streamOrders(com.consorsbank.module.tapi.grpc.account.TradingAccountRequest request,
        io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.order.Orders> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getStreamOrdersMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     **
     * Initiates orders update action. All changes come by the 
     * StreamOrders subscription. This function doesn't wait for the action result.
     * &#64;param TradingAccount 
     *      Trading account for update
     * </pre>
     */
    public void updateOrders(com.consorsbank.module.tapi.grpc.account.TradingAccountRequest request,
        io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.common.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateOrdersMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     **
     * Request market quote for the selected security on the selected stock exchanges.
     * &#64;param QuoteRequest
     *    quote request with interested security and stock exchanges
     * &#64;return QuoteReply
     *    quote reply with quotes
     * </pre>
     */
    public void getQuote(com.consorsbank.module.tapi.grpc.order.QuoteRequest request,
        io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.order.QuoteReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetQuoteMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     **
     * Sends accept quote order request to the short term market
     * &#64;param AcceptQuoteRequest 
     *     accept quote request with order parameters
     * &#64;return OrderReply
     *     result order or error
     * </pre>
     */
    public void acceptQuote(com.consorsbank.module.tapi.grpc.order.AcceptQuoteRequest request,
        io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.order.OrderReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAcceptQuoteMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     **
     * Sends long term order to the market
     * &#64;param AddOrderRequest
     *     order request with order parameters
     * &#64;return OrderReply
     *     result order or error
     * </pre>
     */
    public void addOrder(com.consorsbank.module.tapi.grpc.order.AddOrderRequest request,
        io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.order.OrderReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddOrderMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     **
     * Sends order change request to the market
     * &#64;param ChangeOrderRequest
     *     changed order request with order parameters
     * &#64;return OrderReply
     *     result order or error
     * </pre>
     */
    public void changeOrder(com.consorsbank.module.tapi.grpc.order.ChangeOrderRequest request,
        io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.order.OrderReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getChangeOrderMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     **
     * Sends order cancel request to the market
     * &#64;param CancelOrderRequest
     *     cancel order request with order reference
     * &#64;return OrderReply
     *     result order or error
     * </pre>
     */
    public void cancelOrder(com.consorsbank.module.tapi.grpc.order.CancelOrderRequest request,
        io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.order.OrderReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCancelOrderMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     **
     * Sends order activate request to the market. #pro# only
     * &#64;param ActivateOrderRequest
     *     activate order request with order parameters
     * &#64;return OrderReply
     *     result order or error
     * </pre>
     */
    public void activateOrder(com.consorsbank.module.tapi.grpc.order.ActivateOrderRequest request,
        io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.order.OrderReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getActivateOrderMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     **
     * Sends order deactivate request to the market. #pro# only
     * &#64;param DeactivateOrderRequest
     *     deactivate order request with order parameters
     * &#64;return OrderReply
     *     result order or error
     * </pre>
     */
    public void deactivateOrder(com.consorsbank.module.tapi.grpc.order.DeactivateOrderRequest request,
        io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.order.OrderReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeactivateOrderMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   **
   * Order service provide functionality to control orders. 
   * </pre>
   */
  public static final class OrderServiceBlockingStub extends io.grpc.stub.AbstractStub<OrderServiceBlockingStub> {
    private OrderServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private OrderServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrderServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new OrderServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     **
     * Subscribes one trading account for orders updates
     * &#64;param TradingAccount 
     *      Trading account for push
     * &#64;stream Orders
     *      Orders list for seleted account 
     * </pre>
     */
    public java.util.Iterator<com.consorsbank.module.tapi.grpc.order.Orders> streamOrders(
        com.consorsbank.module.tapi.grpc.account.TradingAccountRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getStreamOrdersMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     **
     * Initiates orders update action. All changes come by the 
     * StreamOrders subscription. This function doesn't wait for the action result.
     * &#64;param TradingAccount 
     *      Trading account for update
     * </pre>
     */
    public com.consorsbank.module.tapi.grpc.common.Empty updateOrders(com.consorsbank.module.tapi.grpc.account.TradingAccountRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateOrdersMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     **
     * Request market quote for the selected security on the selected stock exchanges.
     * &#64;param QuoteRequest
     *    quote request with interested security and stock exchanges
     * &#64;return QuoteReply
     *    quote reply with quotes
     * </pre>
     */
    public com.consorsbank.module.tapi.grpc.order.QuoteReply getQuote(com.consorsbank.module.tapi.grpc.order.QuoteRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetQuoteMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     **
     * Sends accept quote order request to the short term market
     * &#64;param AcceptQuoteRequest 
     *     accept quote request with order parameters
     * &#64;return OrderReply
     *     result order or error
     * </pre>
     */
    public com.consorsbank.module.tapi.grpc.order.OrderReply acceptQuote(com.consorsbank.module.tapi.grpc.order.AcceptQuoteRequest request) {
      return blockingUnaryCall(
          getChannel(), getAcceptQuoteMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     **
     * Sends long term order to the market
     * &#64;param AddOrderRequest
     *     order request with order parameters
     * &#64;return OrderReply
     *     result order or error
     * </pre>
     */
    public com.consorsbank.module.tapi.grpc.order.OrderReply addOrder(com.consorsbank.module.tapi.grpc.order.AddOrderRequest request) {
      return blockingUnaryCall(
          getChannel(), getAddOrderMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     **
     * Sends order change request to the market
     * &#64;param ChangeOrderRequest
     *     changed order request with order parameters
     * &#64;return OrderReply
     *     result order or error
     * </pre>
     */
    public com.consorsbank.module.tapi.grpc.order.OrderReply changeOrder(com.consorsbank.module.tapi.grpc.order.ChangeOrderRequest request) {
      return blockingUnaryCall(
          getChannel(), getChangeOrderMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     **
     * Sends order cancel request to the market
     * &#64;param CancelOrderRequest
     *     cancel order request with order reference
     * &#64;return OrderReply
     *     result order or error
     * </pre>
     */
    public com.consorsbank.module.tapi.grpc.order.OrderReply cancelOrder(com.consorsbank.module.tapi.grpc.order.CancelOrderRequest request) {
      return blockingUnaryCall(
          getChannel(), getCancelOrderMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     **
     * Sends order activate request to the market. #pro# only
     * &#64;param ActivateOrderRequest
     *     activate order request with order parameters
     * &#64;return OrderReply
     *     result order or error
     * </pre>
     */
    public com.consorsbank.module.tapi.grpc.order.OrderReply activateOrder(com.consorsbank.module.tapi.grpc.order.ActivateOrderRequest request) {
      return blockingUnaryCall(
          getChannel(), getActivateOrderMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     **
     * Sends order deactivate request to the market. #pro# only
     * &#64;param DeactivateOrderRequest
     *     deactivate order request with order parameters
     * &#64;return OrderReply
     *     result order or error
     * </pre>
     */
    public com.consorsbank.module.tapi.grpc.order.OrderReply deactivateOrder(com.consorsbank.module.tapi.grpc.order.DeactivateOrderRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeactivateOrderMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   **
   * Order service provide functionality to control orders. 
   * </pre>
   */
  public static final class OrderServiceFutureStub extends io.grpc.stub.AbstractStub<OrderServiceFutureStub> {
    private OrderServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private OrderServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrderServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new OrderServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     **
     * Initiates orders update action. All changes come by the 
     * StreamOrders subscription. This function doesn't wait for the action result.
     * &#64;param TradingAccount 
     *      Trading account for update
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.consorsbank.module.tapi.grpc.common.Empty> updateOrders(
        com.consorsbank.module.tapi.grpc.account.TradingAccountRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateOrdersMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     **
     * Request market quote for the selected security on the selected stock exchanges.
     * &#64;param QuoteRequest
     *    quote request with interested security and stock exchanges
     * &#64;return QuoteReply
     *    quote reply with quotes
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.consorsbank.module.tapi.grpc.order.QuoteReply> getQuote(
        com.consorsbank.module.tapi.grpc.order.QuoteRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetQuoteMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     **
     * Sends accept quote order request to the short term market
     * &#64;param AcceptQuoteRequest 
     *     accept quote request with order parameters
     * &#64;return OrderReply
     *     result order or error
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.consorsbank.module.tapi.grpc.order.OrderReply> acceptQuote(
        com.consorsbank.module.tapi.grpc.order.AcceptQuoteRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAcceptQuoteMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     **
     * Sends long term order to the market
     * &#64;param AddOrderRequest
     *     order request with order parameters
     * &#64;return OrderReply
     *     result order or error
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.consorsbank.module.tapi.grpc.order.OrderReply> addOrder(
        com.consorsbank.module.tapi.grpc.order.AddOrderRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAddOrderMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     **
     * Sends order change request to the market
     * &#64;param ChangeOrderRequest
     *     changed order request with order parameters
     * &#64;return OrderReply
     *     result order or error
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.consorsbank.module.tapi.grpc.order.OrderReply> changeOrder(
        com.consorsbank.module.tapi.grpc.order.ChangeOrderRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getChangeOrderMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     **
     * Sends order cancel request to the market
     * &#64;param CancelOrderRequest
     *     cancel order request with order reference
     * &#64;return OrderReply
     *     result order or error
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.consorsbank.module.tapi.grpc.order.OrderReply> cancelOrder(
        com.consorsbank.module.tapi.grpc.order.CancelOrderRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCancelOrderMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     **
     * Sends order activate request to the market. #pro# only
     * &#64;param ActivateOrderRequest
     *     activate order request with order parameters
     * &#64;return OrderReply
     *     result order or error
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.consorsbank.module.tapi.grpc.order.OrderReply> activateOrder(
        com.consorsbank.module.tapi.grpc.order.ActivateOrderRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getActivateOrderMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     **
     * Sends order deactivate request to the market. #pro# only
     * &#64;param DeactivateOrderRequest
     *     deactivate order request with order parameters
     * &#64;return OrderReply
     *     result order or error
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.consorsbank.module.tapi.grpc.order.OrderReply> deactivateOrder(
        com.consorsbank.module.tapi.grpc.order.DeactivateOrderRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeactivateOrderMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_STREAM_ORDERS = 0;
  private static final int METHODID_UPDATE_ORDERS = 1;
  private static final int METHODID_GET_QUOTE = 2;
  private static final int METHODID_ACCEPT_QUOTE = 3;
  private static final int METHODID_ADD_ORDER = 4;
  private static final int METHODID_CHANGE_ORDER = 5;
  private static final int METHODID_CANCEL_ORDER = 6;
  private static final int METHODID_ACTIVATE_ORDER = 7;
  private static final int METHODID_DEACTIVATE_ORDER = 8;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final OrderServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(OrderServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_STREAM_ORDERS:
          serviceImpl.streamOrders((com.consorsbank.module.tapi.grpc.account.TradingAccountRequest) request,
              (io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.order.Orders>) responseObserver);
          break;
        case METHODID_UPDATE_ORDERS:
          serviceImpl.updateOrders((com.consorsbank.module.tapi.grpc.account.TradingAccountRequest) request,
              (io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.common.Empty>) responseObserver);
          break;
        case METHODID_GET_QUOTE:
          serviceImpl.getQuote((com.consorsbank.module.tapi.grpc.order.QuoteRequest) request,
              (io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.order.QuoteReply>) responseObserver);
          break;
        case METHODID_ACCEPT_QUOTE:
          serviceImpl.acceptQuote((com.consorsbank.module.tapi.grpc.order.AcceptQuoteRequest) request,
              (io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.order.OrderReply>) responseObserver);
          break;
        case METHODID_ADD_ORDER:
          serviceImpl.addOrder((com.consorsbank.module.tapi.grpc.order.AddOrderRequest) request,
              (io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.order.OrderReply>) responseObserver);
          break;
        case METHODID_CHANGE_ORDER:
          serviceImpl.changeOrder((com.consorsbank.module.tapi.grpc.order.ChangeOrderRequest) request,
              (io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.order.OrderReply>) responseObserver);
          break;
        case METHODID_CANCEL_ORDER:
          serviceImpl.cancelOrder((com.consorsbank.module.tapi.grpc.order.CancelOrderRequest) request,
              (io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.order.OrderReply>) responseObserver);
          break;
        case METHODID_ACTIVATE_ORDER:
          serviceImpl.activateOrder((com.consorsbank.module.tapi.grpc.order.ActivateOrderRequest) request,
              (io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.order.OrderReply>) responseObserver);
          break;
        case METHODID_DEACTIVATE_ORDER:
          serviceImpl.deactivateOrder((com.consorsbank.module.tapi.grpc.order.DeactivateOrderRequest) request,
              (io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.order.OrderReply>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class OrderServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    OrderServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.consorsbank.module.tapi.grpc.TradingAPI.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("OrderService");
    }
  }

  private static final class OrderServiceFileDescriptorSupplier
      extends OrderServiceBaseDescriptorSupplier {
    OrderServiceFileDescriptorSupplier() {}
  }

  private static final class OrderServiceMethodDescriptorSupplier
      extends OrderServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    OrderServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (OrderServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new OrderServiceFileDescriptorSupplier())
              .addMethod(getStreamOrdersMethodHelper())
              .addMethod(getUpdateOrdersMethodHelper())
              .addMethod(getGetQuoteMethodHelper())
              .addMethod(getAcceptQuoteMethodHelper())
              .addMethod(getAddOrderMethodHelper())
              .addMethod(getChangeOrderMethodHelper())
              .addMethod(getCancelOrderMethodHelper())
              .addMethod(getActivateOrderMethodHelper())
              .addMethod(getDeactivateOrderMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
