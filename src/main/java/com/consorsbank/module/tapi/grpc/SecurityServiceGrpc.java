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
 * Security service provides access
 * to the 
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: TradingAPI.proto")
public final class SecurityServiceGrpc {

  private SecurityServiceGrpc() {}

  public static final String SERVICE_NAME = "com.consorsbank.module.tapi.grpc.SecurityService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetSecurityInfoMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.security.SecurityInfoRequest,
      com.consorsbank.module.tapi.grpc.security.SecurityInfoReply> METHOD_GET_SECURITY_INFO = getGetSecurityInfoMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.security.SecurityInfoRequest,
      com.consorsbank.module.tapi.grpc.security.SecurityInfoReply> getGetSecurityInfoMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.security.SecurityInfoRequest,
      com.consorsbank.module.tapi.grpc.security.SecurityInfoReply> getGetSecurityInfoMethod() {
    return getGetSecurityInfoMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.security.SecurityInfoRequest,
      com.consorsbank.module.tapi.grpc.security.SecurityInfoReply> getGetSecurityInfoMethodHelper() {
    io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.security.SecurityInfoRequest, com.consorsbank.module.tapi.grpc.security.SecurityInfoReply> getGetSecurityInfoMethod;
    if ((getGetSecurityInfoMethod = SecurityServiceGrpc.getGetSecurityInfoMethod) == null) {
      synchronized (SecurityServiceGrpc.class) {
        if ((getGetSecurityInfoMethod = SecurityServiceGrpc.getGetSecurityInfoMethod) == null) {
          SecurityServiceGrpc.getGetSecurityInfoMethod = getGetSecurityInfoMethod = 
              io.grpc.MethodDescriptor.<com.consorsbank.module.tapi.grpc.security.SecurityInfoRequest, com.consorsbank.module.tapi.grpc.security.SecurityInfoReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.consorsbank.module.tapi.grpc.SecurityService", "GetSecurityInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.consorsbank.module.tapi.grpc.security.SecurityInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.consorsbank.module.tapi.grpc.security.SecurityInfoReply.getDefaultInstance()))
                  .setSchemaDescriptor(new SecurityServiceMethodDescriptorSupplier("GetSecurityInfo"))
                  .build();
          }
        }
     }
     return getGetSecurityInfoMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getStreamMarketDataMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.security.SecurityMarketDataRequest,
      com.consorsbank.module.tapi.grpc.security.SecurityMarketDataReply> METHOD_STREAM_MARKET_DATA = getStreamMarketDataMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.security.SecurityMarketDataRequest,
      com.consorsbank.module.tapi.grpc.security.SecurityMarketDataReply> getStreamMarketDataMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.security.SecurityMarketDataRequest,
      com.consorsbank.module.tapi.grpc.security.SecurityMarketDataReply> getStreamMarketDataMethod() {
    return getStreamMarketDataMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.security.SecurityMarketDataRequest,
      com.consorsbank.module.tapi.grpc.security.SecurityMarketDataReply> getStreamMarketDataMethodHelper() {
    io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.security.SecurityMarketDataRequest, com.consorsbank.module.tapi.grpc.security.SecurityMarketDataReply> getStreamMarketDataMethod;
    if ((getStreamMarketDataMethod = SecurityServiceGrpc.getStreamMarketDataMethod) == null) {
      synchronized (SecurityServiceGrpc.class) {
        if ((getStreamMarketDataMethod = SecurityServiceGrpc.getStreamMarketDataMethod) == null) {
          SecurityServiceGrpc.getStreamMarketDataMethod = getStreamMarketDataMethod = 
              io.grpc.MethodDescriptor.<com.consorsbank.module.tapi.grpc.security.SecurityMarketDataRequest, com.consorsbank.module.tapi.grpc.security.SecurityMarketDataReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "com.consorsbank.module.tapi.grpc.SecurityService", "StreamMarketData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.consorsbank.module.tapi.grpc.security.SecurityMarketDataRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.consorsbank.module.tapi.grpc.security.SecurityMarketDataReply.getDefaultInstance()))
                  .setSchemaDescriptor(new SecurityServiceMethodDescriptorSupplier("StreamMarketData"))
                  .build();
          }
        }
     }
     return getStreamMarketDataMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getStreamOrderBookMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.security.SecurityOrderBookRequest,
      com.consorsbank.module.tapi.grpc.security.SecurityOrderBookReply> METHOD_STREAM_ORDER_BOOK = getStreamOrderBookMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.security.SecurityOrderBookRequest,
      com.consorsbank.module.tapi.grpc.security.SecurityOrderBookReply> getStreamOrderBookMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.security.SecurityOrderBookRequest,
      com.consorsbank.module.tapi.grpc.security.SecurityOrderBookReply> getStreamOrderBookMethod() {
    return getStreamOrderBookMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.security.SecurityOrderBookRequest,
      com.consorsbank.module.tapi.grpc.security.SecurityOrderBookReply> getStreamOrderBookMethodHelper() {
    io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.security.SecurityOrderBookRequest, com.consorsbank.module.tapi.grpc.security.SecurityOrderBookReply> getStreamOrderBookMethod;
    if ((getStreamOrderBookMethod = SecurityServiceGrpc.getStreamOrderBookMethod) == null) {
      synchronized (SecurityServiceGrpc.class) {
        if ((getStreamOrderBookMethod = SecurityServiceGrpc.getStreamOrderBookMethod) == null) {
          SecurityServiceGrpc.getStreamOrderBookMethod = getStreamOrderBookMethod = 
              io.grpc.MethodDescriptor.<com.consorsbank.module.tapi.grpc.security.SecurityOrderBookRequest, com.consorsbank.module.tapi.grpc.security.SecurityOrderBookReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "com.consorsbank.module.tapi.grpc.SecurityService", "StreamOrderBook"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.consorsbank.module.tapi.grpc.security.SecurityOrderBookRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.consorsbank.module.tapi.grpc.security.SecurityOrderBookReply.getDefaultInstance()))
                  .setSchemaDescriptor(new SecurityServiceMethodDescriptorSupplier("StreamOrderBook"))
                  .build();
          }
        }
     }
     return getStreamOrderBookMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getStreamCurrencyRateMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.security.CurrencyRateRequest,
      com.consorsbank.module.tapi.grpc.security.CurrencyRateReply> METHOD_STREAM_CURRENCY_RATE = getStreamCurrencyRateMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.security.CurrencyRateRequest,
      com.consorsbank.module.tapi.grpc.security.CurrencyRateReply> getStreamCurrencyRateMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.security.CurrencyRateRequest,
      com.consorsbank.module.tapi.grpc.security.CurrencyRateReply> getStreamCurrencyRateMethod() {
    return getStreamCurrencyRateMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.security.CurrencyRateRequest,
      com.consorsbank.module.tapi.grpc.security.CurrencyRateReply> getStreamCurrencyRateMethodHelper() {
    io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.security.CurrencyRateRequest, com.consorsbank.module.tapi.grpc.security.CurrencyRateReply> getStreamCurrencyRateMethod;
    if ((getStreamCurrencyRateMethod = SecurityServiceGrpc.getStreamCurrencyRateMethod) == null) {
      synchronized (SecurityServiceGrpc.class) {
        if ((getStreamCurrencyRateMethod = SecurityServiceGrpc.getStreamCurrencyRateMethod) == null) {
          SecurityServiceGrpc.getStreamCurrencyRateMethod = getStreamCurrencyRateMethod = 
              io.grpc.MethodDescriptor.<com.consorsbank.module.tapi.grpc.security.CurrencyRateRequest, com.consorsbank.module.tapi.grpc.security.CurrencyRateReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "com.consorsbank.module.tapi.grpc.SecurityService", "StreamCurrencyRate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.consorsbank.module.tapi.grpc.security.CurrencyRateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.consorsbank.module.tapi.grpc.security.CurrencyRateReply.getDefaultInstance()))
                  .setSchemaDescriptor(new SecurityServiceMethodDescriptorSupplier("StreamCurrencyRate"))
                  .build();
          }
        }
     }
     return getStreamCurrencyRateMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetSecurityPriceHistoryMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.security.SecurityPriceHistoryRequest,
      com.consorsbank.module.tapi.grpc.security.SecurityPriceHistoryReply> METHOD_GET_SECURITY_PRICE_HISTORY = getGetSecurityPriceHistoryMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.security.SecurityPriceHistoryRequest,
      com.consorsbank.module.tapi.grpc.security.SecurityPriceHistoryReply> getGetSecurityPriceHistoryMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.security.SecurityPriceHistoryRequest,
      com.consorsbank.module.tapi.grpc.security.SecurityPriceHistoryReply> getGetSecurityPriceHistoryMethod() {
    return getGetSecurityPriceHistoryMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.security.SecurityPriceHistoryRequest,
      com.consorsbank.module.tapi.grpc.security.SecurityPriceHistoryReply> getGetSecurityPriceHistoryMethodHelper() {
    io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.security.SecurityPriceHistoryRequest, com.consorsbank.module.tapi.grpc.security.SecurityPriceHistoryReply> getGetSecurityPriceHistoryMethod;
    if ((getGetSecurityPriceHistoryMethod = SecurityServiceGrpc.getGetSecurityPriceHistoryMethod) == null) {
      synchronized (SecurityServiceGrpc.class) {
        if ((getGetSecurityPriceHistoryMethod = SecurityServiceGrpc.getGetSecurityPriceHistoryMethod) == null) {
          SecurityServiceGrpc.getGetSecurityPriceHistoryMethod = getGetSecurityPriceHistoryMethod = 
              io.grpc.MethodDescriptor.<com.consorsbank.module.tapi.grpc.security.SecurityPriceHistoryRequest, com.consorsbank.module.tapi.grpc.security.SecurityPriceHistoryReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.consorsbank.module.tapi.grpc.SecurityService", "GetSecurityPriceHistory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.consorsbank.module.tapi.grpc.security.SecurityPriceHistoryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.consorsbank.module.tapi.grpc.security.SecurityPriceHistoryReply.getDefaultInstance()))
                  .setSchemaDescriptor(new SecurityServiceMethodDescriptorSupplier("GetSecurityPriceHistory"))
                  .build();
          }
        }
     }
     return getGetSecurityPriceHistoryMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SecurityServiceStub newStub(io.grpc.Channel channel) {
    return new SecurityServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SecurityServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SecurityServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SecurityServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SecurityServiceFutureStub(channel);
  }

  /**
   * <pre>
   **
   * Security service provides access
   * to the 
   * </pre>
   */
  public static abstract class SecurityServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     **
     * Gets security information about security
     * &#64;param SecurityInfoRequest
     *   Request object with interested security 
     * &#64;return SecurityInfoReply
     *   Complete information about security      
     * </pre>
     */
    public void getSecurityInfo(com.consorsbank.module.tapi.grpc.security.SecurityInfoRequest request,
        io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.security.SecurityInfoReply> responseObserver) {
      asyncUnimplementedUnaryCall(getGetSecurityInfoMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     **
     * Subscribes security with stock exchange for market data updates
     * &#64;param SecurityMarketDataRequest 
     *      Market data request with interested security and stock exchange
     * &#64;stream SecurityMarketDataReply
     *      Reply with all market data values 
     * </pre>
     */
    public void streamMarketData(com.consorsbank.module.tapi.grpc.security.SecurityMarketDataRequest request,
        io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.security.SecurityMarketDataReply> responseObserver) {
      asyncUnimplementedUnaryCall(getStreamMarketDataMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     **
     * Subscribes security with stock exchange for orderbook updates
     * &#64;param SecurityOrderBookRequest 
     *      Orderbook data request with interested security and stock exchange
     * &#64;stream SecurityOrderBookReply
     *      Reply with all orderbook values 
     * </pre>
     */
    public void streamOrderBook(com.consorsbank.module.tapi.grpc.security.SecurityOrderBookRequest request,
        io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.security.SecurityOrderBookReply> responseObserver) {
      asyncUnimplementedUnaryCall(getStreamOrderBookMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     **
     * Subscribes for currency rate from one currency to another currency. 
     * &#64;param SecurityOrderBookRequest 
     *      currency rate request with interested currencies from/to
     * &#64;stream CurrencyRateReply
     *      reply with currency rate 
     * </pre>
     */
    public void streamCurrencyRate(com.consorsbank.module.tapi.grpc.security.CurrencyRateRequest request,
        io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.security.CurrencyRateReply> responseObserver) {
      asyncUnimplementedUnaryCall(getStreamCurrencyRateMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     **
     * Requests history data for one security on one stockexchange in intraday or historical format
     * &#64;param SecurityPriceHistoryRequest
     *    Data with security, stockexchange, how many days and resolution
     * &#64;return SecurityPriceHistoryReply
     *    List of the historical quotes or an error
     * </pre>
     */
    public void getSecurityPriceHistory(com.consorsbank.module.tapi.grpc.security.SecurityPriceHistoryRequest request,
        io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.security.SecurityPriceHistoryReply> responseObserver) {
      asyncUnimplementedUnaryCall(getGetSecurityPriceHistoryMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetSecurityInfoMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.consorsbank.module.tapi.grpc.security.SecurityInfoRequest,
                com.consorsbank.module.tapi.grpc.security.SecurityInfoReply>(
                  this, METHODID_GET_SECURITY_INFO)))
          .addMethod(
            getStreamMarketDataMethodHelper(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.consorsbank.module.tapi.grpc.security.SecurityMarketDataRequest,
                com.consorsbank.module.tapi.grpc.security.SecurityMarketDataReply>(
                  this, METHODID_STREAM_MARKET_DATA)))
          .addMethod(
            getStreamOrderBookMethodHelper(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.consorsbank.module.tapi.grpc.security.SecurityOrderBookRequest,
                com.consorsbank.module.tapi.grpc.security.SecurityOrderBookReply>(
                  this, METHODID_STREAM_ORDER_BOOK)))
          .addMethod(
            getStreamCurrencyRateMethodHelper(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.consorsbank.module.tapi.grpc.security.CurrencyRateRequest,
                com.consorsbank.module.tapi.grpc.security.CurrencyRateReply>(
                  this, METHODID_STREAM_CURRENCY_RATE)))
          .addMethod(
            getGetSecurityPriceHistoryMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.consorsbank.module.tapi.grpc.security.SecurityPriceHistoryRequest,
                com.consorsbank.module.tapi.grpc.security.SecurityPriceHistoryReply>(
                  this, METHODID_GET_SECURITY_PRICE_HISTORY)))
          .build();
    }
  }

  /**
   * <pre>
   **
   * Security service provides access
   * to the 
   * </pre>
   */
  public static final class SecurityServiceStub extends io.grpc.stub.AbstractStub<SecurityServiceStub> {
    private SecurityServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SecurityServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecurityServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SecurityServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     **
     * Gets security information about security
     * &#64;param SecurityInfoRequest
     *   Request object with interested security 
     * &#64;return SecurityInfoReply
     *   Complete information about security      
     * </pre>
     */
    public void getSecurityInfo(com.consorsbank.module.tapi.grpc.security.SecurityInfoRequest request,
        io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.security.SecurityInfoReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetSecurityInfoMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     **
     * Subscribes security with stock exchange for market data updates
     * &#64;param SecurityMarketDataRequest 
     *      Market data request with interested security and stock exchange
     * &#64;stream SecurityMarketDataReply
     *      Reply with all market data values 
     * </pre>
     */
    public void streamMarketData(com.consorsbank.module.tapi.grpc.security.SecurityMarketDataRequest request,
        io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.security.SecurityMarketDataReply> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getStreamMarketDataMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     **
     * Subscribes security with stock exchange for orderbook updates
     * &#64;param SecurityOrderBookRequest 
     *      Orderbook data request with interested security and stock exchange
     * &#64;stream SecurityOrderBookReply
     *      Reply with all orderbook values 
     * </pre>
     */
    public void streamOrderBook(com.consorsbank.module.tapi.grpc.security.SecurityOrderBookRequest request,
        io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.security.SecurityOrderBookReply> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getStreamOrderBookMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     **
     * Subscribes for currency rate from one currency to another currency. 
     * &#64;param SecurityOrderBookRequest 
     *      currency rate request with interested currencies from/to
     * &#64;stream CurrencyRateReply
     *      reply with currency rate 
     * </pre>
     */
    public void streamCurrencyRate(com.consorsbank.module.tapi.grpc.security.CurrencyRateRequest request,
        io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.security.CurrencyRateReply> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getStreamCurrencyRateMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     **
     * Requests history data for one security on one stockexchange in intraday or historical format
     * &#64;param SecurityPriceHistoryRequest
     *    Data with security, stockexchange, how many days and resolution
     * &#64;return SecurityPriceHistoryReply
     *    List of the historical quotes or an error
     * </pre>
     */
    public void getSecurityPriceHistory(com.consorsbank.module.tapi.grpc.security.SecurityPriceHistoryRequest request,
        io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.security.SecurityPriceHistoryReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetSecurityPriceHistoryMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   **
   * Security service provides access
   * to the 
   * </pre>
   */
  public static final class SecurityServiceBlockingStub extends io.grpc.stub.AbstractStub<SecurityServiceBlockingStub> {
    private SecurityServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SecurityServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecurityServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SecurityServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     **
     * Gets security information about security
     * &#64;param SecurityInfoRequest
     *   Request object with interested security 
     * &#64;return SecurityInfoReply
     *   Complete information about security      
     * </pre>
     */
    public com.consorsbank.module.tapi.grpc.security.SecurityInfoReply getSecurityInfo(com.consorsbank.module.tapi.grpc.security.SecurityInfoRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetSecurityInfoMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     **
     * Subscribes security with stock exchange for market data updates
     * &#64;param SecurityMarketDataRequest 
     *      Market data request with interested security and stock exchange
     * &#64;stream SecurityMarketDataReply
     *      Reply with all market data values 
     * </pre>
     */
    public java.util.Iterator<com.consorsbank.module.tapi.grpc.security.SecurityMarketDataReply> streamMarketData(
        com.consorsbank.module.tapi.grpc.security.SecurityMarketDataRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getStreamMarketDataMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     **
     * Subscribes security with stock exchange for orderbook updates
     * &#64;param SecurityOrderBookRequest 
     *      Orderbook data request with interested security and stock exchange
     * &#64;stream SecurityOrderBookReply
     *      Reply with all orderbook values 
     * </pre>
     */
    public java.util.Iterator<com.consorsbank.module.tapi.grpc.security.SecurityOrderBookReply> streamOrderBook(
        com.consorsbank.module.tapi.grpc.security.SecurityOrderBookRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getStreamOrderBookMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     **
     * Subscribes for currency rate from one currency to another currency. 
     * &#64;param SecurityOrderBookRequest 
     *      currency rate request with interested currencies from/to
     * &#64;stream CurrencyRateReply
     *      reply with currency rate 
     * </pre>
     */
    public java.util.Iterator<com.consorsbank.module.tapi.grpc.security.CurrencyRateReply> streamCurrencyRate(
        com.consorsbank.module.tapi.grpc.security.CurrencyRateRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getStreamCurrencyRateMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     **
     * Requests history data for one security on one stockexchange in intraday or historical format
     * &#64;param SecurityPriceHistoryRequest
     *    Data with security, stockexchange, how many days and resolution
     * &#64;return SecurityPriceHistoryReply
     *    List of the historical quotes or an error
     * </pre>
     */
    public com.consorsbank.module.tapi.grpc.security.SecurityPriceHistoryReply getSecurityPriceHistory(com.consorsbank.module.tapi.grpc.security.SecurityPriceHistoryRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetSecurityPriceHistoryMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   **
   * Security service provides access
   * to the 
   * </pre>
   */
  public static final class SecurityServiceFutureStub extends io.grpc.stub.AbstractStub<SecurityServiceFutureStub> {
    private SecurityServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SecurityServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecurityServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SecurityServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     **
     * Gets security information about security
     * &#64;param SecurityInfoRequest
     *   Request object with interested security 
     * &#64;return SecurityInfoReply
     *   Complete information about security      
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.consorsbank.module.tapi.grpc.security.SecurityInfoReply> getSecurityInfo(
        com.consorsbank.module.tapi.grpc.security.SecurityInfoRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetSecurityInfoMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     **
     * Requests history data for one security on one stockexchange in intraday or historical format
     * &#64;param SecurityPriceHistoryRequest
     *    Data with security, stockexchange, how many days and resolution
     * &#64;return SecurityPriceHistoryReply
     *    List of the historical quotes or an error
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.consorsbank.module.tapi.grpc.security.SecurityPriceHistoryReply> getSecurityPriceHistory(
        com.consorsbank.module.tapi.grpc.security.SecurityPriceHistoryRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetSecurityPriceHistoryMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_SECURITY_INFO = 0;
  private static final int METHODID_STREAM_MARKET_DATA = 1;
  private static final int METHODID_STREAM_ORDER_BOOK = 2;
  private static final int METHODID_STREAM_CURRENCY_RATE = 3;
  private static final int METHODID_GET_SECURITY_PRICE_HISTORY = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SecurityServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SecurityServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_SECURITY_INFO:
          serviceImpl.getSecurityInfo((com.consorsbank.module.tapi.grpc.security.SecurityInfoRequest) request,
              (io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.security.SecurityInfoReply>) responseObserver);
          break;
        case METHODID_STREAM_MARKET_DATA:
          serviceImpl.streamMarketData((com.consorsbank.module.tapi.grpc.security.SecurityMarketDataRequest) request,
              (io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.security.SecurityMarketDataReply>) responseObserver);
          break;
        case METHODID_STREAM_ORDER_BOOK:
          serviceImpl.streamOrderBook((com.consorsbank.module.tapi.grpc.security.SecurityOrderBookRequest) request,
              (io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.security.SecurityOrderBookReply>) responseObserver);
          break;
        case METHODID_STREAM_CURRENCY_RATE:
          serviceImpl.streamCurrencyRate((com.consorsbank.module.tapi.grpc.security.CurrencyRateRequest) request,
              (io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.security.CurrencyRateReply>) responseObserver);
          break;
        case METHODID_GET_SECURITY_PRICE_HISTORY:
          serviceImpl.getSecurityPriceHistory((com.consorsbank.module.tapi.grpc.security.SecurityPriceHistoryRequest) request,
              (io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.security.SecurityPriceHistoryReply>) responseObserver);
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

  private static abstract class SecurityServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SecurityServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.consorsbank.module.tapi.grpc.TradingAPI.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SecurityService");
    }
  }

  private static final class SecurityServiceFileDescriptorSupplier
      extends SecurityServiceBaseDescriptorSupplier {
    SecurityServiceFileDescriptorSupplier() {}
  }

  private static final class SecurityServiceMethodDescriptorSupplier
      extends SecurityServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SecurityServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (SecurityServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SecurityServiceFileDescriptorSupplier())
              .addMethod(getGetSecurityInfoMethodHelper())
              .addMethod(getStreamMarketDataMethodHelper())
              .addMethod(getStreamOrderBookMethodHelper())
              .addMethod(getStreamCurrencyRateMethodHelper())
              .addMethod(getGetSecurityPriceHistoryMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
