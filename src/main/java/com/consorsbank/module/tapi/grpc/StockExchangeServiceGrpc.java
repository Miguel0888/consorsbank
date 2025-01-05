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
 * StockExchangeService provide information about stockexchanges and
 * issuers
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: TradingAPI.proto")
public final class StockExchangeServiceGrpc {

  private StockExchangeServiceGrpc() {}

  public static final String SERVICE_NAME = "com.consorsbank.module.tapi.grpc.StockExchangeService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetStockExchangesMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.common.AccessTokenRequest,
      com.consorsbank.module.tapi.grpc.stock.StockExchangeDescriptions> METHOD_GET_STOCK_EXCHANGES = getGetStockExchangesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.common.AccessTokenRequest,
      com.consorsbank.module.tapi.grpc.stock.StockExchangeDescriptions> getGetStockExchangesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.common.AccessTokenRequest,
      com.consorsbank.module.tapi.grpc.stock.StockExchangeDescriptions> getGetStockExchangesMethod() {
    return getGetStockExchangesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.common.AccessTokenRequest,
      com.consorsbank.module.tapi.grpc.stock.StockExchangeDescriptions> getGetStockExchangesMethodHelper() {
    io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.common.AccessTokenRequest, com.consorsbank.module.tapi.grpc.stock.StockExchangeDescriptions> getGetStockExchangesMethod;
    if ((getGetStockExchangesMethod = StockExchangeServiceGrpc.getGetStockExchangesMethod) == null) {
      synchronized (StockExchangeServiceGrpc.class) {
        if ((getGetStockExchangesMethod = StockExchangeServiceGrpc.getGetStockExchangesMethod) == null) {
          StockExchangeServiceGrpc.getGetStockExchangesMethod = getGetStockExchangesMethod = 
              io.grpc.MethodDescriptor.<com.consorsbank.module.tapi.grpc.common.AccessTokenRequest, com.consorsbank.module.tapi.grpc.stock.StockExchangeDescriptions>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.consorsbank.module.tapi.grpc.StockExchangeService", "GetStockExchanges"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.consorsbank.module.tapi.grpc.common.AccessTokenRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.consorsbank.module.tapi.grpc.stock.StockExchangeDescriptions.getDefaultInstance()))
                  .setSchemaDescriptor(new StockExchangeServiceMethodDescriptorSupplier("GetStockExchanges"))
                  .build();
          }
        }
     }
     return getGetStockExchangesMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetStockExchangeMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.stock.StockExchangeRequest,
      com.consorsbank.module.tapi.grpc.stock.StockExchangeDescription> METHOD_GET_STOCK_EXCHANGE = getGetStockExchangeMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.stock.StockExchangeRequest,
      com.consorsbank.module.tapi.grpc.stock.StockExchangeDescription> getGetStockExchangeMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.stock.StockExchangeRequest,
      com.consorsbank.module.tapi.grpc.stock.StockExchangeDescription> getGetStockExchangeMethod() {
    return getGetStockExchangeMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.stock.StockExchangeRequest,
      com.consorsbank.module.tapi.grpc.stock.StockExchangeDescription> getGetStockExchangeMethodHelper() {
    io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.stock.StockExchangeRequest, com.consorsbank.module.tapi.grpc.stock.StockExchangeDescription> getGetStockExchangeMethod;
    if ((getGetStockExchangeMethod = StockExchangeServiceGrpc.getGetStockExchangeMethod) == null) {
      synchronized (StockExchangeServiceGrpc.class) {
        if ((getGetStockExchangeMethod = StockExchangeServiceGrpc.getGetStockExchangeMethod) == null) {
          StockExchangeServiceGrpc.getGetStockExchangeMethod = getGetStockExchangeMethod = 
              io.grpc.MethodDescriptor.<com.consorsbank.module.tapi.grpc.stock.StockExchangeRequest, com.consorsbank.module.tapi.grpc.stock.StockExchangeDescription>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.consorsbank.module.tapi.grpc.StockExchangeService", "GetStockExchange"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.consorsbank.module.tapi.grpc.stock.StockExchangeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.consorsbank.module.tapi.grpc.stock.StockExchangeDescription.getDefaultInstance()))
                  .setSchemaDescriptor(new StockExchangeServiceMethodDescriptorSupplier("GetStockExchange"))
                  .build();
          }
        }
     }
     return getGetStockExchangeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StockExchangeServiceStub newStub(io.grpc.Channel channel) {
    return new StockExchangeServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StockExchangeServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new StockExchangeServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StockExchangeServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new StockExchangeServiceFutureStub(channel);
  }

  /**
   * <pre>
   ** 
   * StockExchangeService provide information about stockexchanges and
   * issuers
   * </pre>
   */
  public static abstract class StockExchangeServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     **
     * Gets predefined stockexchages 
     * &#64;return StockExchangeDescriptions
     *    list of stock exchange informations 
     * </pre>
     */
    public void getStockExchanges(com.consorsbank.module.tapi.grpc.common.AccessTokenRequest request,
        io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.stock.StockExchangeDescriptions> responseObserver) {
      asyncUnimplementedUnaryCall(getGetStockExchangesMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     **
     * Gets specific stock exchange 
     * &#64;param StockExchange
     *    Requested stock exchange
     * &#64;return StockExchangeDescription
     *    Stock exchange information 
     * </pre>
     */
    public void getStockExchange(com.consorsbank.module.tapi.grpc.stock.StockExchangeRequest request,
        io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.stock.StockExchangeDescription> responseObserver) {
      asyncUnimplementedUnaryCall(getGetStockExchangeMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetStockExchangesMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.consorsbank.module.tapi.grpc.common.AccessTokenRequest,
                com.consorsbank.module.tapi.grpc.stock.StockExchangeDescriptions>(
                  this, METHODID_GET_STOCK_EXCHANGES)))
          .addMethod(
            getGetStockExchangeMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.consorsbank.module.tapi.grpc.stock.StockExchangeRequest,
                com.consorsbank.module.tapi.grpc.stock.StockExchangeDescription>(
                  this, METHODID_GET_STOCK_EXCHANGE)))
          .build();
    }
  }

  /**
   * <pre>
   ** 
   * StockExchangeService provide information about stockexchanges and
   * issuers
   * </pre>
   */
  public static final class StockExchangeServiceStub extends io.grpc.stub.AbstractStub<StockExchangeServiceStub> {
    private StockExchangeServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StockExchangeServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StockExchangeServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StockExchangeServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     **
     * Gets predefined stockexchages 
     * &#64;return StockExchangeDescriptions
     *    list of stock exchange informations 
     * </pre>
     */
    public void getStockExchanges(com.consorsbank.module.tapi.grpc.common.AccessTokenRequest request,
        io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.stock.StockExchangeDescriptions> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetStockExchangesMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     **
     * Gets specific stock exchange 
     * &#64;param StockExchange
     *    Requested stock exchange
     * &#64;return StockExchangeDescription
     *    Stock exchange information 
     * </pre>
     */
    public void getStockExchange(com.consorsbank.module.tapi.grpc.stock.StockExchangeRequest request,
        io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.stock.StockExchangeDescription> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetStockExchangeMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   ** 
   * StockExchangeService provide information about stockexchanges and
   * issuers
   * </pre>
   */
  public static final class StockExchangeServiceBlockingStub extends io.grpc.stub.AbstractStub<StockExchangeServiceBlockingStub> {
    private StockExchangeServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StockExchangeServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StockExchangeServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StockExchangeServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     **
     * Gets predefined stockexchages 
     * &#64;return StockExchangeDescriptions
     *    list of stock exchange informations 
     * </pre>
     */
    public com.consorsbank.module.tapi.grpc.stock.StockExchangeDescriptions getStockExchanges(com.consorsbank.module.tapi.grpc.common.AccessTokenRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetStockExchangesMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     **
     * Gets specific stock exchange 
     * &#64;param StockExchange
     *    Requested stock exchange
     * &#64;return StockExchangeDescription
     *    Stock exchange information 
     * </pre>
     */
    public com.consorsbank.module.tapi.grpc.stock.StockExchangeDescription getStockExchange(com.consorsbank.module.tapi.grpc.stock.StockExchangeRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetStockExchangeMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   ** 
   * StockExchangeService provide information about stockexchanges and
   * issuers
   * </pre>
   */
  public static final class StockExchangeServiceFutureStub extends io.grpc.stub.AbstractStub<StockExchangeServiceFutureStub> {
    private StockExchangeServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StockExchangeServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StockExchangeServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StockExchangeServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     **
     * Gets predefined stockexchages 
     * &#64;return StockExchangeDescriptions
     *    list of stock exchange informations 
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.consorsbank.module.tapi.grpc.stock.StockExchangeDescriptions> getStockExchanges(
        com.consorsbank.module.tapi.grpc.common.AccessTokenRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetStockExchangesMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     **
     * Gets specific stock exchange 
     * &#64;param StockExchange
     *    Requested stock exchange
     * &#64;return StockExchangeDescription
     *    Stock exchange information 
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.consorsbank.module.tapi.grpc.stock.StockExchangeDescription> getStockExchange(
        com.consorsbank.module.tapi.grpc.stock.StockExchangeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetStockExchangeMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_STOCK_EXCHANGES = 0;
  private static final int METHODID_GET_STOCK_EXCHANGE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final StockExchangeServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(StockExchangeServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_STOCK_EXCHANGES:
          serviceImpl.getStockExchanges((com.consorsbank.module.tapi.grpc.common.AccessTokenRequest) request,
              (io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.stock.StockExchangeDescriptions>) responseObserver);
          break;
        case METHODID_GET_STOCK_EXCHANGE:
          serviceImpl.getStockExchange((com.consorsbank.module.tapi.grpc.stock.StockExchangeRequest) request,
              (io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.stock.StockExchangeDescription>) responseObserver);
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

  private static abstract class StockExchangeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StockExchangeServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.consorsbank.module.tapi.grpc.TradingAPI.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StockExchangeService");
    }
  }

  private static final class StockExchangeServiceFileDescriptorSupplier
      extends StockExchangeServiceBaseDescriptorSupplier {
    StockExchangeServiceFileDescriptorSupplier() {}
  }

  private static final class StockExchangeServiceMethodDescriptorSupplier
      extends StockExchangeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    StockExchangeServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (StockExchangeServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StockExchangeServiceFileDescriptorSupplier())
              .addMethod(getGetStockExchangesMethodHelper())
              .addMethod(getGetStockExchangeMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
