// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: SecurityService.proto

package com.consorsbank.module.tapi.grpc.security;

/**
 * <pre>
 **
 * Returns currency rate
 * </pre>
 *
 * Protobuf type {@code com.consorsbank.module.tapi.grpc.CurrencyRateReply}
 */
public  final class CurrencyRateReply extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.consorsbank.module.tapi.grpc.CurrencyRateReply)
    CurrencyRateReplyOrBuilder {
private static final long serialVersionUID = 0L;
  // Use CurrencyRateReply.newBuilder() to construct.
  private CurrencyRateReply(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private CurrencyRateReply() {
    currencyFrom_ = "";
    currencyTo_ = "";
    currencyRate_ = 0D;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private CurrencyRateReply(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            currencyFrom_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            currencyTo_ = s;
            break;
          }
          case 25: {

            currencyRate_ = input.readDouble();
            break;
          }
          case 8002: {
            com.consorsbank.module.tapi.grpc.common.Error.Builder subBuilder = null;
            if (error_ != null) {
              subBuilder = error_.toBuilder();
            }
            error_ = input.readMessage(com.consorsbank.module.tapi.grpc.common.Error.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(error_);
              error_ = subBuilder.buildPartial();
            }

            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.consorsbank.module.tapi.grpc.security.SecurityService.internal_static_com_consorsbank_module_tapi_grpc_CurrencyRateReply_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.consorsbank.module.tapi.grpc.security.SecurityService.internal_static_com_consorsbank_module_tapi_grpc_CurrencyRateReply_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.consorsbank.module.tapi.grpc.security.CurrencyRateReply.class, com.consorsbank.module.tapi.grpc.security.CurrencyRateReply.Builder.class);
  }

  public static final int CURRENCY_FROM_FIELD_NUMBER = 1;
  private volatile java.lang.Object currencyFrom_;
  /**
   * <pre>
   ** Source currency 
   * </pre>
   *
   * <code>string currency_from = 1;</code>
   */
  public java.lang.String getCurrencyFrom() {
    java.lang.Object ref = currencyFrom_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      currencyFrom_ = s;
      return s;
    }
  }
  /**
   * <pre>
   ** Source currency 
   * </pre>
   *
   * <code>string currency_from = 1;</code>
   */
  public com.google.protobuf.ByteString
      getCurrencyFromBytes() {
    java.lang.Object ref = currencyFrom_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      currencyFrom_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int CURRENCY_TO_FIELD_NUMBER = 2;
  private volatile java.lang.Object currencyTo_;
  /**
   * <pre>
   ** Target currency
   * </pre>
   *
   * <code>string currency_to = 2;</code>
   */
  public java.lang.String getCurrencyTo() {
    java.lang.Object ref = currencyTo_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      currencyTo_ = s;
      return s;
    }
  }
  /**
   * <pre>
   ** Target currency
   * </pre>
   *
   * <code>string currency_to = 2;</code>
   */
  public com.google.protobuf.ByteString
      getCurrencyToBytes() {
    java.lang.Object ref = currencyTo_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      currencyTo_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int CURRENCY_RATE_FIELD_NUMBER = 3;
  private double currencyRate_;
  /**
   * <pre>
   ** Currency rate
   * </pre>
   *
   * <code>double currency_rate = 3;</code>
   */
  public double getCurrencyRate() {
    return currencyRate_;
  }

  public static final int ERROR_FIELD_NUMBER = 1000;
  private com.consorsbank.module.tapi.grpc.common.Error error_;
  /**
   * <pre>
   ** Error information if occuirs 
   * </pre>
   *
   * <code>.com.consorsbank.module.tapi.grpc.Error error = 1000;</code>
   */
  public boolean hasError() {
    return error_ != null;
  }
  /**
   * <pre>
   ** Error information if occuirs 
   * </pre>
   *
   * <code>.com.consorsbank.module.tapi.grpc.Error error = 1000;</code>
   */
  public com.consorsbank.module.tapi.grpc.common.Error getError() {
    return error_ == null ? com.consorsbank.module.tapi.grpc.common.Error.getDefaultInstance() : error_;
  }
  /**
   * <pre>
   ** Error information if occuirs 
   * </pre>
   *
   * <code>.com.consorsbank.module.tapi.grpc.Error error = 1000;</code>
   */
  public com.consorsbank.module.tapi.grpc.common.ErrorOrBuilder getErrorOrBuilder() {
    return getError();
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getCurrencyFromBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, currencyFrom_);
    }
    if (!getCurrencyToBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, currencyTo_);
    }
    if (currencyRate_ != 0D) {
      output.writeDouble(3, currencyRate_);
    }
    if (error_ != null) {
      output.writeMessage(1000, getError());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getCurrencyFromBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, currencyFrom_);
    }
    if (!getCurrencyToBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, currencyTo_);
    }
    if (currencyRate_ != 0D) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(3, currencyRate_);
    }
    if (error_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1000, getError());
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.consorsbank.module.tapi.grpc.security.CurrencyRateReply)) {
      return super.equals(obj);
    }
    com.consorsbank.module.tapi.grpc.security.CurrencyRateReply other = (com.consorsbank.module.tapi.grpc.security.CurrencyRateReply) obj;

    boolean result = true;
    result = result && getCurrencyFrom()
        .equals(other.getCurrencyFrom());
    result = result && getCurrencyTo()
        .equals(other.getCurrencyTo());
    result = result && (
        java.lang.Double.doubleToLongBits(getCurrencyRate())
        == java.lang.Double.doubleToLongBits(
            other.getCurrencyRate()));
    result = result && (hasError() == other.hasError());
    if (hasError()) {
      result = result && getError()
          .equals(other.getError());
    }
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + CURRENCY_FROM_FIELD_NUMBER;
    hash = (53 * hash) + getCurrencyFrom().hashCode();
    hash = (37 * hash) + CURRENCY_TO_FIELD_NUMBER;
    hash = (53 * hash) + getCurrencyTo().hashCode();
    hash = (37 * hash) + CURRENCY_RATE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getCurrencyRate()));
    if (hasError()) {
      hash = (37 * hash) + ERROR_FIELD_NUMBER;
      hash = (53 * hash) + getError().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.consorsbank.module.tapi.grpc.security.CurrencyRateReply parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.consorsbank.module.tapi.grpc.security.CurrencyRateReply parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.consorsbank.module.tapi.grpc.security.CurrencyRateReply parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.consorsbank.module.tapi.grpc.security.CurrencyRateReply parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.consorsbank.module.tapi.grpc.security.CurrencyRateReply parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.consorsbank.module.tapi.grpc.security.CurrencyRateReply parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.consorsbank.module.tapi.grpc.security.CurrencyRateReply parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.consorsbank.module.tapi.grpc.security.CurrencyRateReply parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.consorsbank.module.tapi.grpc.security.CurrencyRateReply parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.consorsbank.module.tapi.grpc.security.CurrencyRateReply parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.consorsbank.module.tapi.grpc.security.CurrencyRateReply parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.consorsbank.module.tapi.grpc.security.CurrencyRateReply parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.consorsbank.module.tapi.grpc.security.CurrencyRateReply prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   **
   * Returns currency rate
   * </pre>
   *
   * Protobuf type {@code com.consorsbank.module.tapi.grpc.CurrencyRateReply}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.consorsbank.module.tapi.grpc.CurrencyRateReply)
      com.consorsbank.module.tapi.grpc.security.CurrencyRateReplyOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.consorsbank.module.tapi.grpc.security.SecurityService.internal_static_com_consorsbank_module_tapi_grpc_CurrencyRateReply_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.consorsbank.module.tapi.grpc.security.SecurityService.internal_static_com_consorsbank_module_tapi_grpc_CurrencyRateReply_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.consorsbank.module.tapi.grpc.security.CurrencyRateReply.class, com.consorsbank.module.tapi.grpc.security.CurrencyRateReply.Builder.class);
    }

    // Construct using com.consorsbank.module.tapi.grpc.security.CurrencyRateReply.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      currencyFrom_ = "";

      currencyTo_ = "";

      currencyRate_ = 0D;

      if (errorBuilder_ == null) {
        error_ = null;
      } else {
        error_ = null;
        errorBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.consorsbank.module.tapi.grpc.security.SecurityService.internal_static_com_consorsbank_module_tapi_grpc_CurrencyRateReply_descriptor;
    }

    @java.lang.Override
    public com.consorsbank.module.tapi.grpc.security.CurrencyRateReply getDefaultInstanceForType() {
      return com.consorsbank.module.tapi.grpc.security.CurrencyRateReply.getDefaultInstance();
    }

    @java.lang.Override
    public com.consorsbank.module.tapi.grpc.security.CurrencyRateReply build() {
      com.consorsbank.module.tapi.grpc.security.CurrencyRateReply result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.consorsbank.module.tapi.grpc.security.CurrencyRateReply buildPartial() {
      com.consorsbank.module.tapi.grpc.security.CurrencyRateReply result = new com.consorsbank.module.tapi.grpc.security.CurrencyRateReply(this);
      result.currencyFrom_ = currencyFrom_;
      result.currencyTo_ = currencyTo_;
      result.currencyRate_ = currencyRate_;
      if (errorBuilder_ == null) {
        result.error_ = error_;
      } else {
        result.error_ = errorBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.consorsbank.module.tapi.grpc.security.CurrencyRateReply) {
        return mergeFrom((com.consorsbank.module.tapi.grpc.security.CurrencyRateReply)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.consorsbank.module.tapi.grpc.security.CurrencyRateReply other) {
      if (other == com.consorsbank.module.tapi.grpc.security.CurrencyRateReply.getDefaultInstance()) return this;
      if (!other.getCurrencyFrom().isEmpty()) {
        currencyFrom_ = other.currencyFrom_;
        onChanged();
      }
      if (!other.getCurrencyTo().isEmpty()) {
        currencyTo_ = other.currencyTo_;
        onChanged();
      }
      if (other.getCurrencyRate() != 0D) {
        setCurrencyRate(other.getCurrencyRate());
      }
      if (other.hasError()) {
        mergeError(other.getError());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.consorsbank.module.tapi.grpc.security.CurrencyRateReply parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.consorsbank.module.tapi.grpc.security.CurrencyRateReply) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object currencyFrom_ = "";
    /**
     * <pre>
     ** Source currency 
     * </pre>
     *
     * <code>string currency_from = 1;</code>
     */
    public java.lang.String getCurrencyFrom() {
      java.lang.Object ref = currencyFrom_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        currencyFrom_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     ** Source currency 
     * </pre>
     *
     * <code>string currency_from = 1;</code>
     */
    public com.google.protobuf.ByteString
        getCurrencyFromBytes() {
      java.lang.Object ref = currencyFrom_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        currencyFrom_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     ** Source currency 
     * </pre>
     *
     * <code>string currency_from = 1;</code>
     */
    public Builder setCurrencyFrom(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      currencyFrom_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     ** Source currency 
     * </pre>
     *
     * <code>string currency_from = 1;</code>
     */
    public Builder clearCurrencyFrom() {
      
      currencyFrom_ = getDefaultInstance().getCurrencyFrom();
      onChanged();
      return this;
    }
    /**
     * <pre>
     ** Source currency 
     * </pre>
     *
     * <code>string currency_from = 1;</code>
     */
    public Builder setCurrencyFromBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      currencyFrom_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object currencyTo_ = "";
    /**
     * <pre>
     ** Target currency
     * </pre>
     *
     * <code>string currency_to = 2;</code>
     */
    public java.lang.String getCurrencyTo() {
      java.lang.Object ref = currencyTo_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        currencyTo_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     ** Target currency
     * </pre>
     *
     * <code>string currency_to = 2;</code>
     */
    public com.google.protobuf.ByteString
        getCurrencyToBytes() {
      java.lang.Object ref = currencyTo_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        currencyTo_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     ** Target currency
     * </pre>
     *
     * <code>string currency_to = 2;</code>
     */
    public Builder setCurrencyTo(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      currencyTo_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     ** Target currency
     * </pre>
     *
     * <code>string currency_to = 2;</code>
     */
    public Builder clearCurrencyTo() {
      
      currencyTo_ = getDefaultInstance().getCurrencyTo();
      onChanged();
      return this;
    }
    /**
     * <pre>
     ** Target currency
     * </pre>
     *
     * <code>string currency_to = 2;</code>
     */
    public Builder setCurrencyToBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      currencyTo_ = value;
      onChanged();
      return this;
    }

    private double currencyRate_ ;
    /**
     * <pre>
     ** Currency rate
     * </pre>
     *
     * <code>double currency_rate = 3;</code>
     */
    public double getCurrencyRate() {
      return currencyRate_;
    }
    /**
     * <pre>
     ** Currency rate
     * </pre>
     *
     * <code>double currency_rate = 3;</code>
     */
    public Builder setCurrencyRate(double value) {
      
      currencyRate_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     ** Currency rate
     * </pre>
     *
     * <code>double currency_rate = 3;</code>
     */
    public Builder clearCurrencyRate() {
      
      currencyRate_ = 0D;
      onChanged();
      return this;
    }

    private com.consorsbank.module.tapi.grpc.common.Error error_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.consorsbank.module.tapi.grpc.common.Error, com.consorsbank.module.tapi.grpc.common.Error.Builder, com.consorsbank.module.tapi.grpc.common.ErrorOrBuilder> errorBuilder_;
    /**
     * <pre>
     ** Error information if occuirs 
     * </pre>
     *
     * <code>.com.consorsbank.module.tapi.grpc.Error error = 1000;</code>
     */
    public boolean hasError() {
      return errorBuilder_ != null || error_ != null;
    }
    /**
     * <pre>
     ** Error information if occuirs 
     * </pre>
     *
     * <code>.com.consorsbank.module.tapi.grpc.Error error = 1000;</code>
     */
    public com.consorsbank.module.tapi.grpc.common.Error getError() {
      if (errorBuilder_ == null) {
        return error_ == null ? com.consorsbank.module.tapi.grpc.common.Error.getDefaultInstance() : error_;
      } else {
        return errorBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     ** Error information if occuirs 
     * </pre>
     *
     * <code>.com.consorsbank.module.tapi.grpc.Error error = 1000;</code>
     */
    public Builder setError(com.consorsbank.module.tapi.grpc.common.Error value) {
      if (errorBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        error_ = value;
        onChanged();
      } else {
        errorBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <pre>
     ** Error information if occuirs 
     * </pre>
     *
     * <code>.com.consorsbank.module.tapi.grpc.Error error = 1000;</code>
     */
    public Builder setError(
        com.consorsbank.module.tapi.grpc.common.Error.Builder builderForValue) {
      if (errorBuilder_ == null) {
        error_ = builderForValue.build();
        onChanged();
      } else {
        errorBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <pre>
     ** Error information if occuirs 
     * </pre>
     *
     * <code>.com.consorsbank.module.tapi.grpc.Error error = 1000;</code>
     */
    public Builder mergeError(com.consorsbank.module.tapi.grpc.common.Error value) {
      if (errorBuilder_ == null) {
        if (error_ != null) {
          error_ =
            com.consorsbank.module.tapi.grpc.common.Error.newBuilder(error_).mergeFrom(value).buildPartial();
        } else {
          error_ = value;
        }
        onChanged();
      } else {
        errorBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <pre>
     ** Error information if occuirs 
     * </pre>
     *
     * <code>.com.consorsbank.module.tapi.grpc.Error error = 1000;</code>
     */
    public Builder clearError() {
      if (errorBuilder_ == null) {
        error_ = null;
        onChanged();
      } else {
        error_ = null;
        errorBuilder_ = null;
      }

      return this;
    }
    /**
     * <pre>
     ** Error information if occuirs 
     * </pre>
     *
     * <code>.com.consorsbank.module.tapi.grpc.Error error = 1000;</code>
     */
    public com.consorsbank.module.tapi.grpc.common.Error.Builder getErrorBuilder() {
      
      onChanged();
      return getErrorFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     ** Error information if occuirs 
     * </pre>
     *
     * <code>.com.consorsbank.module.tapi.grpc.Error error = 1000;</code>
     */
    public com.consorsbank.module.tapi.grpc.common.ErrorOrBuilder getErrorOrBuilder() {
      if (errorBuilder_ != null) {
        return errorBuilder_.getMessageOrBuilder();
      } else {
        return error_ == null ?
            com.consorsbank.module.tapi.grpc.common.Error.getDefaultInstance() : error_;
      }
    }
    /**
     * <pre>
     ** Error information if occuirs 
     * </pre>
     *
     * <code>.com.consorsbank.module.tapi.grpc.Error error = 1000;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.consorsbank.module.tapi.grpc.common.Error, com.consorsbank.module.tapi.grpc.common.Error.Builder, com.consorsbank.module.tapi.grpc.common.ErrorOrBuilder> 
        getErrorFieldBuilder() {
      if (errorBuilder_ == null) {
        errorBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.consorsbank.module.tapi.grpc.common.Error, com.consorsbank.module.tapi.grpc.common.Error.Builder, com.consorsbank.module.tapi.grpc.common.ErrorOrBuilder>(
                getError(),
                getParentForChildren(),
                isClean());
        error_ = null;
      }
      return errorBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:com.consorsbank.module.tapi.grpc.CurrencyRateReply)
  }

  // @@protoc_insertion_point(class_scope:com.consorsbank.module.tapi.grpc.CurrencyRateReply)
  private static final com.consorsbank.module.tapi.grpc.security.CurrencyRateReply DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.consorsbank.module.tapi.grpc.security.CurrencyRateReply();
  }

  public static com.consorsbank.module.tapi.grpc.security.CurrencyRateReply getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<CurrencyRateReply>
      PARSER = new com.google.protobuf.AbstractParser<CurrencyRateReply>() {
    @java.lang.Override
    public CurrencyRateReply parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new CurrencyRateReply(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<CurrencyRateReply> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<CurrencyRateReply> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.consorsbank.module.tapi.grpc.security.CurrencyRateReply getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

