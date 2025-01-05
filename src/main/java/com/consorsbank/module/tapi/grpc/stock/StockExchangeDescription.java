// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: StockExchangeService.proto

package com.consorsbank.module.tapi.grpc.stock;

/**
 * Protobuf type {@code com.consorsbank.module.tapi.grpc.StockExchangeDescription}
 */
public  final class StockExchangeDescription extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.consorsbank.module.tapi.grpc.StockExchangeDescription)
    StockExchangeDescriptionOrBuilder {
private static final long serialVersionUID = 0L;
  // Use StockExchangeDescription.newBuilder() to construct.
  private StockExchangeDescription(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private StockExchangeDescription() {
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private StockExchangeDescription(
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
            com.consorsbank.module.tapi.grpc.stock.StockExchangeInfo.Builder subBuilder = null;
            if (stockExchangeInfo_ != null) {
              subBuilder = stockExchangeInfo_.toBuilder();
            }
            stockExchangeInfo_ = input.readMessage(com.consorsbank.module.tapi.grpc.stock.StockExchangeInfo.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(stockExchangeInfo_);
              stockExchangeInfo_ = subBuilder.buildPartial();
            }

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
    return com.consorsbank.module.tapi.grpc.stock.StockExchangeService.internal_static_com_consorsbank_module_tapi_grpc_StockExchangeDescription_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.consorsbank.module.tapi.grpc.stock.StockExchangeService.internal_static_com_consorsbank_module_tapi_grpc_StockExchangeDescription_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.consorsbank.module.tapi.grpc.stock.StockExchangeDescription.class, com.consorsbank.module.tapi.grpc.stock.StockExchangeDescription.Builder.class);
  }

  public static final int STOCK_EXCHANGE_INFO_FIELD_NUMBER = 1;
  private com.consorsbank.module.tapi.grpc.stock.StockExchangeInfo stockExchangeInfo_;
  /**
   * <pre>
   ** Stock exchange information 
   * </pre>
   *
   * <code>.com.consorsbank.module.tapi.grpc.StockExchangeInfo stock_exchange_info = 1;</code>
   */
  public boolean hasStockExchangeInfo() {
    return stockExchangeInfo_ != null;
  }
  /**
   * <pre>
   ** Stock exchange information 
   * </pre>
   *
   * <code>.com.consorsbank.module.tapi.grpc.StockExchangeInfo stock_exchange_info = 1;</code>
   */
  public com.consorsbank.module.tapi.grpc.stock.StockExchangeInfo getStockExchangeInfo() {
    return stockExchangeInfo_ == null ? com.consorsbank.module.tapi.grpc.stock.StockExchangeInfo.getDefaultInstance() : stockExchangeInfo_;
  }
  /**
   * <pre>
   ** Stock exchange information 
   * </pre>
   *
   * <code>.com.consorsbank.module.tapi.grpc.StockExchangeInfo stock_exchange_info = 1;</code>
   */
  public com.consorsbank.module.tapi.grpc.stock.StockExchangeInfoOrBuilder getStockExchangeInfoOrBuilder() {
    return getStockExchangeInfo();
  }

  public static final int ERROR_FIELD_NUMBER = 1000;
  private com.consorsbank.module.tapi.grpc.common.Error error_;
  /**
   * <pre>
   **
   * Error information if occuirs
   * </pre>
   *
   * <code>.com.consorsbank.module.tapi.grpc.Error error = 1000;</code>
   */
  public boolean hasError() {
    return error_ != null;
  }
  /**
   * <pre>
   **
   * Error information if occuirs
   * </pre>
   *
   * <code>.com.consorsbank.module.tapi.grpc.Error error = 1000;</code>
   */
  public com.consorsbank.module.tapi.grpc.common.Error getError() {
    return error_ == null ? com.consorsbank.module.tapi.grpc.common.Error.getDefaultInstance() : error_;
  }
  /**
   * <pre>
   **
   * Error information if occuirs
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
    if (stockExchangeInfo_ != null) {
      output.writeMessage(1, getStockExchangeInfo());
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
    if (stockExchangeInfo_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getStockExchangeInfo());
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
    if (!(obj instanceof com.consorsbank.module.tapi.grpc.stock.StockExchangeDescription)) {
      return super.equals(obj);
    }
    com.consorsbank.module.tapi.grpc.stock.StockExchangeDescription other = (com.consorsbank.module.tapi.grpc.stock.StockExchangeDescription) obj;

    boolean result = true;
    result = result && (hasStockExchangeInfo() == other.hasStockExchangeInfo());
    if (hasStockExchangeInfo()) {
      result = result && getStockExchangeInfo()
          .equals(other.getStockExchangeInfo());
    }
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
    if (hasStockExchangeInfo()) {
      hash = (37 * hash) + STOCK_EXCHANGE_INFO_FIELD_NUMBER;
      hash = (53 * hash) + getStockExchangeInfo().hashCode();
    }
    if (hasError()) {
      hash = (37 * hash) + ERROR_FIELD_NUMBER;
      hash = (53 * hash) + getError().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.consorsbank.module.tapi.grpc.stock.StockExchangeDescription parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.consorsbank.module.tapi.grpc.stock.StockExchangeDescription parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.consorsbank.module.tapi.grpc.stock.StockExchangeDescription parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.consorsbank.module.tapi.grpc.stock.StockExchangeDescription parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.consorsbank.module.tapi.grpc.stock.StockExchangeDescription parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.consorsbank.module.tapi.grpc.stock.StockExchangeDescription parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.consorsbank.module.tapi.grpc.stock.StockExchangeDescription parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.consorsbank.module.tapi.grpc.stock.StockExchangeDescription parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.consorsbank.module.tapi.grpc.stock.StockExchangeDescription parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.consorsbank.module.tapi.grpc.stock.StockExchangeDescription parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.consorsbank.module.tapi.grpc.stock.StockExchangeDescription parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.consorsbank.module.tapi.grpc.stock.StockExchangeDescription parseFrom(
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
  public static Builder newBuilder(com.consorsbank.module.tapi.grpc.stock.StockExchangeDescription prototype) {
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
   * Protobuf type {@code com.consorsbank.module.tapi.grpc.StockExchangeDescription}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.consorsbank.module.tapi.grpc.StockExchangeDescription)
      com.consorsbank.module.tapi.grpc.stock.StockExchangeDescriptionOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.consorsbank.module.tapi.grpc.stock.StockExchangeService.internal_static_com_consorsbank_module_tapi_grpc_StockExchangeDescription_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.consorsbank.module.tapi.grpc.stock.StockExchangeService.internal_static_com_consorsbank_module_tapi_grpc_StockExchangeDescription_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.consorsbank.module.tapi.grpc.stock.StockExchangeDescription.class, com.consorsbank.module.tapi.grpc.stock.StockExchangeDescription.Builder.class);
    }

    // Construct using com.consorsbank.module.tapi.grpc.stock.StockExchangeDescription.newBuilder()
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
      if (stockExchangeInfoBuilder_ == null) {
        stockExchangeInfo_ = null;
      } else {
        stockExchangeInfo_ = null;
        stockExchangeInfoBuilder_ = null;
      }
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
      return com.consorsbank.module.tapi.grpc.stock.StockExchangeService.internal_static_com_consorsbank_module_tapi_grpc_StockExchangeDescription_descriptor;
    }

    @java.lang.Override
    public com.consorsbank.module.tapi.grpc.stock.StockExchangeDescription getDefaultInstanceForType() {
      return com.consorsbank.module.tapi.grpc.stock.StockExchangeDescription.getDefaultInstance();
    }

    @java.lang.Override
    public com.consorsbank.module.tapi.grpc.stock.StockExchangeDescription build() {
      com.consorsbank.module.tapi.grpc.stock.StockExchangeDescription result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.consorsbank.module.tapi.grpc.stock.StockExchangeDescription buildPartial() {
      com.consorsbank.module.tapi.grpc.stock.StockExchangeDescription result = new com.consorsbank.module.tapi.grpc.stock.StockExchangeDescription(this);
      if (stockExchangeInfoBuilder_ == null) {
        result.stockExchangeInfo_ = stockExchangeInfo_;
      } else {
        result.stockExchangeInfo_ = stockExchangeInfoBuilder_.build();
      }
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
      if (other instanceof com.consorsbank.module.tapi.grpc.stock.StockExchangeDescription) {
        return mergeFrom((com.consorsbank.module.tapi.grpc.stock.StockExchangeDescription)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.consorsbank.module.tapi.grpc.stock.StockExchangeDescription other) {
      if (other == com.consorsbank.module.tapi.grpc.stock.StockExchangeDescription.getDefaultInstance()) return this;
      if (other.hasStockExchangeInfo()) {
        mergeStockExchangeInfo(other.getStockExchangeInfo());
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
      com.consorsbank.module.tapi.grpc.stock.StockExchangeDescription parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.consorsbank.module.tapi.grpc.stock.StockExchangeDescription) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private com.consorsbank.module.tapi.grpc.stock.StockExchangeInfo stockExchangeInfo_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.consorsbank.module.tapi.grpc.stock.StockExchangeInfo, com.consorsbank.module.tapi.grpc.stock.StockExchangeInfo.Builder, com.consorsbank.module.tapi.grpc.stock.StockExchangeInfoOrBuilder> stockExchangeInfoBuilder_;
    /**
     * <pre>
     ** Stock exchange information 
     * </pre>
     *
     * <code>.com.consorsbank.module.tapi.grpc.StockExchangeInfo stock_exchange_info = 1;</code>
     */
    public boolean hasStockExchangeInfo() {
      return stockExchangeInfoBuilder_ != null || stockExchangeInfo_ != null;
    }
    /**
     * <pre>
     ** Stock exchange information 
     * </pre>
     *
     * <code>.com.consorsbank.module.tapi.grpc.StockExchangeInfo stock_exchange_info = 1;</code>
     */
    public com.consorsbank.module.tapi.grpc.stock.StockExchangeInfo getStockExchangeInfo() {
      if (stockExchangeInfoBuilder_ == null) {
        return stockExchangeInfo_ == null ? com.consorsbank.module.tapi.grpc.stock.StockExchangeInfo.getDefaultInstance() : stockExchangeInfo_;
      } else {
        return stockExchangeInfoBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     ** Stock exchange information 
     * </pre>
     *
     * <code>.com.consorsbank.module.tapi.grpc.StockExchangeInfo stock_exchange_info = 1;</code>
     */
    public Builder setStockExchangeInfo(com.consorsbank.module.tapi.grpc.stock.StockExchangeInfo value) {
      if (stockExchangeInfoBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        stockExchangeInfo_ = value;
        onChanged();
      } else {
        stockExchangeInfoBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <pre>
     ** Stock exchange information 
     * </pre>
     *
     * <code>.com.consorsbank.module.tapi.grpc.StockExchangeInfo stock_exchange_info = 1;</code>
     */
    public Builder setStockExchangeInfo(
        com.consorsbank.module.tapi.grpc.stock.StockExchangeInfo.Builder builderForValue) {
      if (stockExchangeInfoBuilder_ == null) {
        stockExchangeInfo_ = builderForValue.build();
        onChanged();
      } else {
        stockExchangeInfoBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <pre>
     ** Stock exchange information 
     * </pre>
     *
     * <code>.com.consorsbank.module.tapi.grpc.StockExchangeInfo stock_exchange_info = 1;</code>
     */
    public Builder mergeStockExchangeInfo(com.consorsbank.module.tapi.grpc.stock.StockExchangeInfo value) {
      if (stockExchangeInfoBuilder_ == null) {
        if (stockExchangeInfo_ != null) {
          stockExchangeInfo_ =
            com.consorsbank.module.tapi.grpc.stock.StockExchangeInfo.newBuilder(stockExchangeInfo_).mergeFrom(value).buildPartial();
        } else {
          stockExchangeInfo_ = value;
        }
        onChanged();
      } else {
        stockExchangeInfoBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <pre>
     ** Stock exchange information 
     * </pre>
     *
     * <code>.com.consorsbank.module.tapi.grpc.StockExchangeInfo stock_exchange_info = 1;</code>
     */
    public Builder clearStockExchangeInfo() {
      if (stockExchangeInfoBuilder_ == null) {
        stockExchangeInfo_ = null;
        onChanged();
      } else {
        stockExchangeInfo_ = null;
        stockExchangeInfoBuilder_ = null;
      }

      return this;
    }
    /**
     * <pre>
     ** Stock exchange information 
     * </pre>
     *
     * <code>.com.consorsbank.module.tapi.grpc.StockExchangeInfo stock_exchange_info = 1;</code>
     */
    public com.consorsbank.module.tapi.grpc.stock.StockExchangeInfo.Builder getStockExchangeInfoBuilder() {
      
      onChanged();
      return getStockExchangeInfoFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     ** Stock exchange information 
     * </pre>
     *
     * <code>.com.consorsbank.module.tapi.grpc.StockExchangeInfo stock_exchange_info = 1;</code>
     */
    public com.consorsbank.module.tapi.grpc.stock.StockExchangeInfoOrBuilder getStockExchangeInfoOrBuilder() {
      if (stockExchangeInfoBuilder_ != null) {
        return stockExchangeInfoBuilder_.getMessageOrBuilder();
      } else {
        return stockExchangeInfo_ == null ?
            com.consorsbank.module.tapi.grpc.stock.StockExchangeInfo.getDefaultInstance() : stockExchangeInfo_;
      }
    }
    /**
     * <pre>
     ** Stock exchange information 
     * </pre>
     *
     * <code>.com.consorsbank.module.tapi.grpc.StockExchangeInfo stock_exchange_info = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.consorsbank.module.tapi.grpc.stock.StockExchangeInfo, com.consorsbank.module.tapi.grpc.stock.StockExchangeInfo.Builder, com.consorsbank.module.tapi.grpc.stock.StockExchangeInfoOrBuilder> 
        getStockExchangeInfoFieldBuilder() {
      if (stockExchangeInfoBuilder_ == null) {
        stockExchangeInfoBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.consorsbank.module.tapi.grpc.stock.StockExchangeInfo, com.consorsbank.module.tapi.grpc.stock.StockExchangeInfo.Builder, com.consorsbank.module.tapi.grpc.stock.StockExchangeInfoOrBuilder>(
                getStockExchangeInfo(),
                getParentForChildren(),
                isClean());
        stockExchangeInfo_ = null;
      }
      return stockExchangeInfoBuilder_;
    }

    private com.consorsbank.module.tapi.grpc.common.Error error_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.consorsbank.module.tapi.grpc.common.Error, com.consorsbank.module.tapi.grpc.common.Error.Builder, com.consorsbank.module.tapi.grpc.common.ErrorOrBuilder> errorBuilder_;
    /**
     * <pre>
     **
     * Error information if occuirs
     * </pre>
     *
     * <code>.com.consorsbank.module.tapi.grpc.Error error = 1000;</code>
     */
    public boolean hasError() {
      return errorBuilder_ != null || error_ != null;
    }
    /**
     * <pre>
     **
     * Error information if occuirs
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
     **
     * Error information if occuirs
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
     **
     * Error information if occuirs
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
     **
     * Error information if occuirs
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
     **
     * Error information if occuirs
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
     **
     * Error information if occuirs
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
     **
     * Error information if occuirs
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
     **
     * Error information if occuirs
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


    // @@protoc_insertion_point(builder_scope:com.consorsbank.module.tapi.grpc.StockExchangeDescription)
  }

  // @@protoc_insertion_point(class_scope:com.consorsbank.module.tapi.grpc.StockExchangeDescription)
  private static final com.consorsbank.module.tapi.grpc.stock.StockExchangeDescription DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.consorsbank.module.tapi.grpc.stock.StockExchangeDescription();
  }

  public static com.consorsbank.module.tapi.grpc.stock.StockExchangeDescription getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<StockExchangeDescription>
      PARSER = new com.google.protobuf.AbstractParser<StockExchangeDescription>() {
    @java.lang.Override
    public StockExchangeDescription parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new StockExchangeDescription(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<StockExchangeDescription> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<StockExchangeDescription> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.consorsbank.module.tapi.grpc.stock.StockExchangeDescription getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

