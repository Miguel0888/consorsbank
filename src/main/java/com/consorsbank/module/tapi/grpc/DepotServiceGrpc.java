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
 * Depot service provides access to the depot linked to the account
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: TradingAPI.proto")
public final class DepotServiceGrpc {

  private DepotServiceGrpc() {}

  public static final String SERVICE_NAME = "com.consorsbank.module.tapi.grpc.DepotService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getStreamDepotMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.account.TradingAccountRequest,
      com.consorsbank.module.tapi.grpc.depot.DepotEntries> METHOD_STREAM_DEPOT = getStreamDepotMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.account.TradingAccountRequest,
      com.consorsbank.module.tapi.grpc.depot.DepotEntries> getStreamDepotMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.account.TradingAccountRequest,
      com.consorsbank.module.tapi.grpc.depot.DepotEntries> getStreamDepotMethod() {
    return getStreamDepotMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.account.TradingAccountRequest,
      com.consorsbank.module.tapi.grpc.depot.DepotEntries> getStreamDepotMethodHelper() {
    io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.account.TradingAccountRequest, com.consorsbank.module.tapi.grpc.depot.DepotEntries> getStreamDepotMethod;
    if ((getStreamDepotMethod = DepotServiceGrpc.getStreamDepotMethod) == null) {
      synchronized (DepotServiceGrpc.class) {
        if ((getStreamDepotMethod = DepotServiceGrpc.getStreamDepotMethod) == null) {
          DepotServiceGrpc.getStreamDepotMethod = getStreamDepotMethod = 
              io.grpc.MethodDescriptor.<com.consorsbank.module.tapi.grpc.account.TradingAccountRequest, com.consorsbank.module.tapi.grpc.depot.DepotEntries>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "com.consorsbank.module.tapi.grpc.DepotService", "StreamDepot"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.consorsbank.module.tapi.grpc.account.TradingAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.consorsbank.module.tapi.grpc.depot.DepotEntries.getDefaultInstance()))
                  .setSchemaDescriptor(new DepotServiceMethodDescriptorSupplier("StreamDepot"))
                  .build();
          }
        }
     }
     return getStreamDepotMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateDepotMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.account.TradingAccountRequest,
      com.consorsbank.module.tapi.grpc.common.Empty> METHOD_UPDATE_DEPOT = getUpdateDepotMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.account.TradingAccountRequest,
      com.consorsbank.module.tapi.grpc.common.Empty> getUpdateDepotMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.account.TradingAccountRequest,
      com.consorsbank.module.tapi.grpc.common.Empty> getUpdateDepotMethod() {
    return getUpdateDepotMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.account.TradingAccountRequest,
      com.consorsbank.module.tapi.grpc.common.Empty> getUpdateDepotMethodHelper() {
    io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.account.TradingAccountRequest, com.consorsbank.module.tapi.grpc.common.Empty> getUpdateDepotMethod;
    if ((getUpdateDepotMethod = DepotServiceGrpc.getUpdateDepotMethod) == null) {
      synchronized (DepotServiceGrpc.class) {
        if ((getUpdateDepotMethod = DepotServiceGrpc.getUpdateDepotMethod) == null) {
          DepotServiceGrpc.getUpdateDepotMethod = getUpdateDepotMethod = 
              io.grpc.MethodDescriptor.<com.consorsbank.module.tapi.grpc.account.TradingAccountRequest, com.consorsbank.module.tapi.grpc.common.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.consorsbank.module.tapi.grpc.DepotService", "UpdateDepot"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.consorsbank.module.tapi.grpc.account.TradingAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.consorsbank.module.tapi.grpc.common.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new DepotServiceMethodDescriptorSupplier("UpdateDepot"))
                  .build();
          }
        }
     }
     return getUpdateDepotMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DepotServiceStub newStub(io.grpc.Channel channel) {
    return new DepotServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DepotServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new DepotServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DepotServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new DepotServiceFutureStub(channel);
  }

  /**
   * <pre>
   **
   * Depot service provides access to the depot linked to the account
   * </pre>
   */
  public static abstract class DepotServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     **
     * Subscribes one trading account for the depot data updates
     * &#64;param TradingAccount
     *      Trading account for push
     * &#64;stream DepotEntries depot entries linked to the account
     * </pre>
     */
    public void streamDepot(com.consorsbank.module.tapi.grpc.account.TradingAccountRequest request,
        io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.depot.DepotEntries> responseObserver) {
      asyncUnimplementedUnaryCall(getStreamDepotMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     **
     * Initiates depot update action. All changes come by the 
     * StreamDepot subscription. This function doesn't wait for the action result.
     * &#64;param TradingAccount 
     *      Trading account for update
     * </pre>
     */
    public void updateDepot(com.consorsbank.module.tapi.grpc.account.TradingAccountRequest request,
        io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.common.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateDepotMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getStreamDepotMethodHelper(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.consorsbank.module.tapi.grpc.account.TradingAccountRequest,
                com.consorsbank.module.tapi.grpc.depot.DepotEntries>(
                  this, METHODID_STREAM_DEPOT)))
          .addMethod(
            getUpdateDepotMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.consorsbank.module.tapi.grpc.account.TradingAccountRequest,
                com.consorsbank.module.tapi.grpc.common.Empty>(
                  this, METHODID_UPDATE_DEPOT)))
          .build();
    }
  }

  /**
   * <pre>
   **
   * Depot service provides access to the depot linked to the account
   * </pre>
   */
  public static final class DepotServiceStub extends io.grpc.stub.AbstractStub<DepotServiceStub> {
    private DepotServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DepotServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DepotServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DepotServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     **
     * Subscribes one trading account for the depot data updates
     * &#64;param TradingAccount
     *      Trading account for push
     * &#64;stream DepotEntries depot entries linked to the account
     * </pre>
     */
    public void streamDepot(com.consorsbank.module.tapi.grpc.account.TradingAccountRequest request,
        io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.depot.DepotEntries> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getStreamDepotMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     **
     * Initiates depot update action. All changes come by the 
     * StreamDepot subscription. This function doesn't wait for the action result.
     * &#64;param TradingAccount 
     *      Trading account for update
     * </pre>
     */
    public void updateDepot(com.consorsbank.module.tapi.grpc.account.TradingAccountRequest request,
        io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.common.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateDepotMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   **
   * Depot service provides access to the depot linked to the account
   * </pre>
   */
  public static final class DepotServiceBlockingStub extends io.grpc.stub.AbstractStub<DepotServiceBlockingStub> {
    private DepotServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DepotServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DepotServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DepotServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     **
     * Subscribes one trading account for the depot data updates
     * &#64;param TradingAccount
     *      Trading account for push
     * &#64;stream DepotEntries depot entries linked to the account
     * </pre>
     */
    public java.util.Iterator<com.consorsbank.module.tapi.grpc.depot.DepotEntries> streamDepot(
        com.consorsbank.module.tapi.grpc.account.TradingAccountRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getStreamDepotMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     **
     * Initiates depot update action. All changes come by the 
     * StreamDepot subscription. This function doesn't wait for the action result.
     * &#64;param TradingAccount 
     *      Trading account for update
     * </pre>
     */
    public com.consorsbank.module.tapi.grpc.common.Empty updateDepot(com.consorsbank.module.tapi.grpc.account.TradingAccountRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateDepotMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   **
   * Depot service provides access to the depot linked to the account
   * </pre>
   */
  public static final class DepotServiceFutureStub extends io.grpc.stub.AbstractStub<DepotServiceFutureStub> {
    private DepotServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DepotServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DepotServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DepotServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     **
     * Initiates depot update action. All changes come by the 
     * StreamDepot subscription. This function doesn't wait for the action result.
     * &#64;param TradingAccount 
     *      Trading account for update
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.consorsbank.module.tapi.grpc.common.Empty> updateDepot(
        com.consorsbank.module.tapi.grpc.account.TradingAccountRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateDepotMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_STREAM_DEPOT = 0;
  private static final int METHODID_UPDATE_DEPOT = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DepotServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DepotServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_STREAM_DEPOT:
          serviceImpl.streamDepot((com.consorsbank.module.tapi.grpc.account.TradingAccountRequest) request,
              (io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.depot.DepotEntries>) responseObserver);
          break;
        case METHODID_UPDATE_DEPOT:
          serviceImpl.updateDepot((com.consorsbank.module.tapi.grpc.account.TradingAccountRequest) request,
              (io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.common.Empty>) responseObserver);
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

  private static abstract class DepotServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DepotServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.consorsbank.module.tapi.grpc.TradingAPI.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DepotService");
    }
  }

  private static final class DepotServiceFileDescriptorSupplier
      extends DepotServiceBaseDescriptorSupplier {
    DepotServiceFileDescriptorSupplier() {}
  }

  private static final class DepotServiceMethodDescriptorSupplier
      extends DepotServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DepotServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (DepotServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DepotServiceFileDescriptorSupplier())
              .addMethod(getStreamDepotMethodHelper())
              .addMethod(getUpdateDepotMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
