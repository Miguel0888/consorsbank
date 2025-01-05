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
 * AccountService provide functionality with access
 * to the trading accounts  
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: TradingAPI.proto")
public final class AccountServiceGrpc {

  private AccountServiceGrpc() {}

  public static final String SERVICE_NAME = "com.consorsbank.module.tapi.grpc.AccountService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetTradingAccountsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.common.AccessTokenRequest,
      com.consorsbank.module.tapi.grpc.account.TradingAccounts> METHOD_GET_TRADING_ACCOUNTS = getGetTradingAccountsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.common.AccessTokenRequest,
      com.consorsbank.module.tapi.grpc.account.TradingAccounts> getGetTradingAccountsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.common.AccessTokenRequest,
      com.consorsbank.module.tapi.grpc.account.TradingAccounts> getGetTradingAccountsMethod() {
    return getGetTradingAccountsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.common.AccessTokenRequest,
      com.consorsbank.module.tapi.grpc.account.TradingAccounts> getGetTradingAccountsMethodHelper() {
    io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.common.AccessTokenRequest, com.consorsbank.module.tapi.grpc.account.TradingAccounts> getGetTradingAccountsMethod;
    if ((getGetTradingAccountsMethod = AccountServiceGrpc.getGetTradingAccountsMethod) == null) {
      synchronized (AccountServiceGrpc.class) {
        if ((getGetTradingAccountsMethod = AccountServiceGrpc.getGetTradingAccountsMethod) == null) {
          AccountServiceGrpc.getGetTradingAccountsMethod = getGetTradingAccountsMethod = 
              io.grpc.MethodDescriptor.<com.consorsbank.module.tapi.grpc.common.AccessTokenRequest, com.consorsbank.module.tapi.grpc.account.TradingAccounts>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.consorsbank.module.tapi.grpc.AccountService", "GetTradingAccounts"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.consorsbank.module.tapi.grpc.common.AccessTokenRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.consorsbank.module.tapi.grpc.account.TradingAccounts.getDefaultInstance()))
                  .setSchemaDescriptor(new AccountServiceMethodDescriptorSupplier("GetTradingAccounts"))
                  .build();
          }
        }
     }
     return getGetTradingAccountsMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getStreamTradingAccountMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.account.TradingAccountRequest,
      com.consorsbank.module.tapi.grpc.account.TradingAccountInformation> METHOD_STREAM_TRADING_ACCOUNT = getStreamTradingAccountMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.account.TradingAccountRequest,
      com.consorsbank.module.tapi.grpc.account.TradingAccountInformation> getStreamTradingAccountMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.account.TradingAccountRequest,
      com.consorsbank.module.tapi.grpc.account.TradingAccountInformation> getStreamTradingAccountMethod() {
    return getStreamTradingAccountMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.account.TradingAccountRequest,
      com.consorsbank.module.tapi.grpc.account.TradingAccountInformation> getStreamTradingAccountMethodHelper() {
    io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.account.TradingAccountRequest, com.consorsbank.module.tapi.grpc.account.TradingAccountInformation> getStreamTradingAccountMethod;
    if ((getStreamTradingAccountMethod = AccountServiceGrpc.getStreamTradingAccountMethod) == null) {
      synchronized (AccountServiceGrpc.class) {
        if ((getStreamTradingAccountMethod = AccountServiceGrpc.getStreamTradingAccountMethod) == null) {
          AccountServiceGrpc.getStreamTradingAccountMethod = getStreamTradingAccountMethod = 
              io.grpc.MethodDescriptor.<com.consorsbank.module.tapi.grpc.account.TradingAccountRequest, com.consorsbank.module.tapi.grpc.account.TradingAccountInformation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "com.consorsbank.module.tapi.grpc.AccountService", "StreamTradingAccount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.consorsbank.module.tapi.grpc.account.TradingAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.consorsbank.module.tapi.grpc.account.TradingAccountInformation.getDefaultInstance()))
                  .setSchemaDescriptor(new AccountServiceMethodDescriptorSupplier("StreamTradingAccount"))
                  .build();
          }
        }
     }
     return getStreamTradingAccountMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getStreamTradingAccountTransactionsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.account.TradingAccountRequest,
      com.consorsbank.module.tapi.grpc.account.TradingAccountTransactions> METHOD_STREAM_TRADING_ACCOUNT_TRANSACTIONS = getStreamTradingAccountTransactionsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.account.TradingAccountRequest,
      com.consorsbank.module.tapi.grpc.account.TradingAccountTransactions> getStreamTradingAccountTransactionsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.account.TradingAccountRequest,
      com.consorsbank.module.tapi.grpc.account.TradingAccountTransactions> getStreamTradingAccountTransactionsMethod() {
    return getStreamTradingAccountTransactionsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.account.TradingAccountRequest,
      com.consorsbank.module.tapi.grpc.account.TradingAccountTransactions> getStreamTradingAccountTransactionsMethodHelper() {
    io.grpc.MethodDescriptor<com.consorsbank.module.tapi.grpc.account.TradingAccountRequest, com.consorsbank.module.tapi.grpc.account.TradingAccountTransactions> getStreamTradingAccountTransactionsMethod;
    if ((getStreamTradingAccountTransactionsMethod = AccountServiceGrpc.getStreamTradingAccountTransactionsMethod) == null) {
      synchronized (AccountServiceGrpc.class) {
        if ((getStreamTradingAccountTransactionsMethod = AccountServiceGrpc.getStreamTradingAccountTransactionsMethod) == null) {
          AccountServiceGrpc.getStreamTradingAccountTransactionsMethod = getStreamTradingAccountTransactionsMethod = 
              io.grpc.MethodDescriptor.<com.consorsbank.module.tapi.grpc.account.TradingAccountRequest, com.consorsbank.module.tapi.grpc.account.TradingAccountTransactions>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "com.consorsbank.module.tapi.grpc.AccountService", "StreamTradingAccountTransactions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.consorsbank.module.tapi.grpc.account.TradingAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.consorsbank.module.tapi.grpc.account.TradingAccountTransactions.getDefaultInstance()))
                  .setSchemaDescriptor(new AccountServiceMethodDescriptorSupplier("StreamTradingAccountTransactions"))
                  .build();
          }
        }
     }
     return getStreamTradingAccountTransactionsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AccountServiceStub newStub(io.grpc.Channel channel) {
    return new AccountServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AccountServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AccountServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AccountServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AccountServiceFutureStub(channel);
  }

  /**
   * <pre>
   **
   * AccountService provide functionality with access
   * to the trading accounts  
   * </pre>
   */
  public static abstract class AccountServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     **
     * Gets trading accounts
     * &#64;return TradingAccounts
     *       List of trading accounts
     * </pre>
     */
    public void getTradingAccounts(com.consorsbank.module.tapi.grpc.common.AccessTokenRequest request,
        io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.account.TradingAccounts> responseObserver) {
      asyncUnimplementedUnaryCall(getGetTradingAccountsMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     **
     * Subscribes one trading account for updates
     * &#64;param TradingAccount 
     *      Trading account for push
     * &#64;stream TradingAccountInformation
     *      Specific information for subscribed account (balance, kredit line, etc.)
     * </pre>
     */
    public void streamTradingAccount(com.consorsbank.module.tapi.grpc.account.TradingAccountRequest request,
        io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.account.TradingAccountInformation> responseObserver) {
      asyncUnimplementedUnaryCall(getStreamTradingAccountMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     **
     * Subscribes one trading account for the transactions updates
     * &#64;param TradingAccount 
     *      Trading account for push
     * &#64;stream TradingAccountInformation
     *      Transactions list for subscribed account 
     * </pre>
     */
    public void streamTradingAccountTransactions(com.consorsbank.module.tapi.grpc.account.TradingAccountRequest request,
        io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.account.TradingAccountTransactions> responseObserver) {
      asyncUnimplementedUnaryCall(getStreamTradingAccountTransactionsMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetTradingAccountsMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.consorsbank.module.tapi.grpc.common.AccessTokenRequest,
                com.consorsbank.module.tapi.grpc.account.TradingAccounts>(
                  this, METHODID_GET_TRADING_ACCOUNTS)))
          .addMethod(
            getStreamTradingAccountMethodHelper(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.consorsbank.module.tapi.grpc.account.TradingAccountRequest,
                com.consorsbank.module.tapi.grpc.account.TradingAccountInformation>(
                  this, METHODID_STREAM_TRADING_ACCOUNT)))
          .addMethod(
            getStreamTradingAccountTransactionsMethodHelper(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.consorsbank.module.tapi.grpc.account.TradingAccountRequest,
                com.consorsbank.module.tapi.grpc.account.TradingAccountTransactions>(
                  this, METHODID_STREAM_TRADING_ACCOUNT_TRANSACTIONS)))
          .build();
    }
  }

  /**
   * <pre>
   **
   * AccountService provide functionality with access
   * to the trading accounts  
   * </pre>
   */
  public static final class AccountServiceStub extends io.grpc.stub.AbstractStub<AccountServiceStub> {
    private AccountServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AccountServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AccountServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     **
     * Gets trading accounts
     * &#64;return TradingAccounts
     *       List of trading accounts
     * </pre>
     */
    public void getTradingAccounts(com.consorsbank.module.tapi.grpc.common.AccessTokenRequest request,
        io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.account.TradingAccounts> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetTradingAccountsMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     **
     * Subscribes one trading account for updates
     * &#64;param TradingAccount 
     *      Trading account for push
     * &#64;stream TradingAccountInformation
     *      Specific information for subscribed account (balance, kredit line, etc.)
     * </pre>
     */
    public void streamTradingAccount(com.consorsbank.module.tapi.grpc.account.TradingAccountRequest request,
        io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.account.TradingAccountInformation> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getStreamTradingAccountMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     **
     * Subscribes one trading account for the transactions updates
     * &#64;param TradingAccount 
     *      Trading account for push
     * &#64;stream TradingAccountInformation
     *      Transactions list for subscribed account 
     * </pre>
     */
    public void streamTradingAccountTransactions(com.consorsbank.module.tapi.grpc.account.TradingAccountRequest request,
        io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.account.TradingAccountTransactions> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getStreamTradingAccountTransactionsMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   **
   * AccountService provide functionality with access
   * to the trading accounts  
   * </pre>
   */
  public static final class AccountServiceBlockingStub extends io.grpc.stub.AbstractStub<AccountServiceBlockingStub> {
    private AccountServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AccountServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AccountServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     **
     * Gets trading accounts
     * &#64;return TradingAccounts
     *       List of trading accounts
     * </pre>
     */
    public com.consorsbank.module.tapi.grpc.account.TradingAccounts getTradingAccounts(com.consorsbank.module.tapi.grpc.common.AccessTokenRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetTradingAccountsMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     **
     * Subscribes one trading account for updates
     * &#64;param TradingAccount 
     *      Trading account for push
     * &#64;stream TradingAccountInformation
     *      Specific information for subscribed account (balance, kredit line, etc.)
     * </pre>
     */
    public java.util.Iterator<com.consorsbank.module.tapi.grpc.account.TradingAccountInformation> streamTradingAccount(
        com.consorsbank.module.tapi.grpc.account.TradingAccountRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getStreamTradingAccountMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     **
     * Subscribes one trading account for the transactions updates
     * &#64;param TradingAccount 
     *      Trading account for push
     * &#64;stream TradingAccountInformation
     *      Transactions list for subscribed account 
     * </pre>
     */
    public java.util.Iterator<com.consorsbank.module.tapi.grpc.account.TradingAccountTransactions> streamTradingAccountTransactions(
        com.consorsbank.module.tapi.grpc.account.TradingAccountRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getStreamTradingAccountTransactionsMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   **
   * AccountService provide functionality with access
   * to the trading accounts  
   * </pre>
   */
  public static final class AccountServiceFutureStub extends io.grpc.stub.AbstractStub<AccountServiceFutureStub> {
    private AccountServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AccountServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AccountServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     **
     * Gets trading accounts
     * &#64;return TradingAccounts
     *       List of trading accounts
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.consorsbank.module.tapi.grpc.account.TradingAccounts> getTradingAccounts(
        com.consorsbank.module.tapi.grpc.common.AccessTokenRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetTradingAccountsMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_TRADING_ACCOUNTS = 0;
  private static final int METHODID_STREAM_TRADING_ACCOUNT = 1;
  private static final int METHODID_STREAM_TRADING_ACCOUNT_TRANSACTIONS = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AccountServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AccountServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_TRADING_ACCOUNTS:
          serviceImpl.getTradingAccounts((com.consorsbank.module.tapi.grpc.common.AccessTokenRequest) request,
              (io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.account.TradingAccounts>) responseObserver);
          break;
        case METHODID_STREAM_TRADING_ACCOUNT:
          serviceImpl.streamTradingAccount((com.consorsbank.module.tapi.grpc.account.TradingAccountRequest) request,
              (io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.account.TradingAccountInformation>) responseObserver);
          break;
        case METHODID_STREAM_TRADING_ACCOUNT_TRANSACTIONS:
          serviceImpl.streamTradingAccountTransactions((com.consorsbank.module.tapi.grpc.account.TradingAccountRequest) request,
              (io.grpc.stub.StreamObserver<com.consorsbank.module.tapi.grpc.account.TradingAccountTransactions>) responseObserver);
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

  private static abstract class AccountServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AccountServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.consorsbank.module.tapi.grpc.TradingAPI.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AccountService");
    }
  }

  private static final class AccountServiceFileDescriptorSupplier
      extends AccountServiceBaseDescriptorSupplier {
    AccountServiceFileDescriptorSupplier() {}
  }

  private static final class AccountServiceMethodDescriptorSupplier
      extends AccountServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AccountServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (AccountServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AccountServiceFileDescriptorSupplier())
              .addMethod(getGetTradingAccountsMethodHelper())
              .addMethod(getStreamTradingAccountMethodHelper())
              .addMethod(getStreamTradingAccountTransactionsMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
