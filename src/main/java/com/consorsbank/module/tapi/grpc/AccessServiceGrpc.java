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
 * Access service provides functions for the client validation / invalidation
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: TradingAPI.proto")
public final class AccessServiceGrpc {

  private AccessServiceGrpc() {}

  public static final String SERVICE_NAME = "com.consorsbank.module.tapi.grpc.AccessService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getLoginMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.access.LoginRequest,
      com.consorsbank.module.tapi.grpc.access.LoginReply> METHOD_LOGIN = getLoginMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.access.LoginRequest,
      com.consorsbank.module.tapi.grpc.access.LoginReply> getLoginMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.access.LoginRequest,
      com.consorsbank.module.tapi.grpc.access.LoginReply> getLoginMethod() {
    return getLoginMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.access.LoginRequest,
      com.consorsbank.module.tapi.grpc.access.LoginReply> getLoginMethodHelper() {
    io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.access.LoginRequest, com.consorsbank.module.tapi.grpc.access.LoginReply> getLoginMethod;
    if ((getLoginMethod = AccessServiceGrpc.getLoginMethod) == null) {
      synchronized (AccessServiceGrpc.class) {
        if ((getLoginMethod = AccessServiceGrpc.getLoginMethod) == null) {
          AccessServiceGrpc.getLoginMethod = getLoginMethod = 
              io.grpc.MethodDescriptor.<com.consorsbank.module.tapi.grpc.access.LoginRequest, com.consorsbank.module.tapi.grpc.access.LoginReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.consorsbank.module.tapi.grpc.AccessService", "Login"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.consorsbank.module.tapi.grpc.access.LoginRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.consorsbank.module.tapi.grpc.access.LoginReply.getDefaultInstance()))
                  .setSchemaDescriptor(new AccessServiceMethodDescriptorSupplier("Login"))
                  .build();
          }
        }
     }
     return getLoginMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getLogoutMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.access.LogoutRequest,
      com.consorsbank.module.tapi.grpc.access.LogoutReply> METHOD_LOGOUT = getLogoutMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.access.LogoutRequest,
      com.consorsbank.module.tapi.grpc.access.LogoutReply> getLogoutMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.access.LogoutRequest,
      com.consorsbank.module.tapi.grpc.access.LogoutReply> getLogoutMethod() {
    return getLogoutMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.access.LogoutRequest,
      com.consorsbank.module.tapi.grpc.access.LogoutReply> getLogoutMethodHelper() {
    io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.access.LogoutRequest, com.consorsbank.module.tapi.grpc.access.LogoutReply> getLogoutMethod;
    if ((getLogoutMethod = AccessServiceGrpc.getLogoutMethod) == null) {
      synchronized (AccessServiceGrpc.class) {
        if ((getLogoutMethod = AccessServiceGrpc.getLogoutMethod) == null) {
          AccessServiceGrpc.getLogoutMethod = getLogoutMethod = 
              io.grpc.MethodDescriptor.<com.consorsbank.module.tapi.grpc.access.LogoutRequest, com.consorsbank.module.tapi.grpc.access.LogoutReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.consorsbank.module.tapi.grpc.AccessService", "Logout"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.consorsbank.module.tapi.grpc.access.LogoutRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.consorsbank.module.tapi.grpc.access.LogoutReply.getDefaultInstance()))
                  .setSchemaDescriptor(new AccessServiceMethodDescriptorSupplier("Logout"))
                  .build();
          }
        }
     }
     return getLogoutMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AccessServiceStub newStub(io.grpc.Channel channel) {
    return new AccessServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AccessServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AccessServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AccessServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AccessServiceFutureStub(channel);
  }

  /**
   * <pre>
   **
   * Access service provides functions for the client validation / invalidation
   * </pre>
   */
  public static abstract class AccessServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     **
     * Validates client by the TAPI and gets access data
     * </pre>
     */
    public void login(com.consorsbank.module.tapi.grpc.access.LoginRequest request,
        io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.access.LoginReply> responseObserver) {
      asyncUnimplementedUnaryCall(getLoginMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     **
     * Invalidates client by the TAPI and gets logout result
     * </pre>
     */
    public void logout(com.consorsbank.module.tapi.grpc.access.LogoutRequest request,
        io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.access.LogoutReply> responseObserver) {
      asyncUnimplementedUnaryCall(getLogoutMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getLoginMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.consorsbank.module.tapi.grpc.access.LoginRequest,
                com.consorsbank.module.tapi.grpc.access.LoginReply>(
                  this, METHODID_LOGIN)))
          .addMethod(
            getLogoutMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.consorsbank.module.tapi.grpc.access.LogoutRequest,
                com.consorsbank.module.tapi.grpc.access.LogoutReply>(
                  this, METHODID_LOGOUT)))
          .build();
    }
  }

  /**
   * <pre>
   **
   * Access service provides functions for the client validation / invalidation
   * </pre>
   */
  public static final class AccessServiceStub extends io.grpc.stub.AbstractStub<AccessServiceStub> {
    private AccessServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AccessServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccessServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AccessServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     **
     * Validates client by the TAPI and gets access data
     * </pre>
     */
    public void login(com.consorsbank.module.tapi.grpc.access.LoginRequest request,
        io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.access.LoginReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLoginMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     **
     * Invalidates client by the TAPI and gets logout result
     * </pre>
     */
    public void logout(com.consorsbank.module.tapi.grpc.access.LogoutRequest request,
        io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.access.LogoutReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLogoutMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   **
   * Access service provides functions for the client validation / invalidation
   * </pre>
   */
  public static final class AccessServiceBlockingStub extends io.grpc.stub.AbstractStub<AccessServiceBlockingStub> {
    private AccessServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AccessServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccessServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AccessServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     **
     * Validates client by the TAPI and gets access data
     * </pre>
     */
    public com.consorsbank.module.tapi.grpc.access.LoginReply login(com.consorsbank.module.tapi.grpc.access.LoginRequest request) {
      return blockingUnaryCall(
          getChannel(), getLoginMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     **
     * Invalidates client by the TAPI and gets logout result
     * </pre>
     */
    public com.consorsbank.module.tapi.grpc.access.LogoutReply logout(com.consorsbank.module.tapi.grpc.access.LogoutRequest request) {
      return blockingUnaryCall(
          getChannel(), getLogoutMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   **
   * Access service provides functions for the client validation / invalidation
   * </pre>
   */
  public static final class AccessServiceFutureStub extends io.grpc.stub.AbstractStub<AccessServiceFutureStub> {
    private AccessServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AccessServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccessServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AccessServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     **
     * Validates client by the TAPI and gets access data
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.consorsbank.module.tapi.grpc.access.LoginReply> login(
        com.consorsbank.module.tapi.grpc.access.LoginRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLoginMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     **
     * Invalidates client by the TAPI and gets logout result
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.consorsbank.module.tapi.grpc.access.LogoutReply> logout(
        com.consorsbank.module.tapi.grpc.access.LogoutRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLogoutMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LOGIN = 0;
  private static final int METHODID_LOGOUT = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AccessServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AccessServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LOGIN:
          serviceImpl.login((com.consorsbank.module.tapi.grpc.access.LoginRequest) request,
              (io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.access.LoginReply>) responseObserver);
          break;
        case METHODID_LOGOUT:
          serviceImpl.logout((com.consorsbank.module.tapi.grpc.access.LogoutRequest) request,
              (io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.access.LogoutReply>) responseObserver);
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

  private static abstract class AccessServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AccessServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.consorsbank.module.tapi.grpc.TradingAPI.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AccessService");
    }
  }

  private static final class AccessServiceFileDescriptorSupplier
      extends AccessServiceBaseDescriptorSupplier {
    AccessServiceFileDescriptorSupplier() {}
  }

  private static final class AccessServiceMethodDescriptorSupplier
      extends AccessServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AccessServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (AccessServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AccessServiceFileDescriptorSupplier())
              .addMethod(getLoginMethodHelper())
              .addMethod(getLogoutMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
