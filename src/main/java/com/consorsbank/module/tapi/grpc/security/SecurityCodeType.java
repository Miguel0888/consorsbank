// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: SecurityService.proto

package com.consorsbank.module.tapi.grpc.security;

/**
 * <pre>
 **
 * Represents information about security code type
 * Some of the types are refer to the market data provider (FactSet)
 * </pre>
 *
 * Protobuf enum {@code com.consorsbank.module.tapi.grpc.SecurityCodeType}
 */
public enum SecurityCodeType
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <pre>
   ** Unknown code type 
   * </pre>
   *
   * <code>NO_CODE_TYPE = 0;</code>
   */
  NO_CODE_TYPE(0),
  /**
   * <pre>
   **  WKN code type 
   * </pre>
   *
   * <code>WKN = 1;</code>
   */
  WKN(1),
  /**
   * <pre>
   **  ISIN code type 
   * </pre>
   *
   * <code>ISIN = 2;</code>
   */
  ISIN(2),
  /**
   * <pre>
   **  Factset id notation 
   * </pre>
   *
   * <code>ID_NOTATION = 3;</code>
   */
  ID_NOTATION(3),
  /**
   * <pre>
   **  Factset id osi 
   * </pre>
   *
   * <code>ID_OSI = 4;</code>
   */
  ID_OSI(4),
  /**
   * <pre>
   **  Factset id instrument 
   * </pre>
   *
   * <code>ID_INSTRUMENT = 5;</code>
   */
  ID_INSTRUMENT(5),
  /**
   * <pre>
   **  Mnemonic or symbol 
   * </pre>
   *
   * <code>MNEMONIC = 6;</code>
   */
  MNEMONIC(6),
  /**
   * <pre>
   **  US Mnemonic or symbol 
   * </pre>
   *
   * <code>MNEMONIC_US = 7;</code>
   */
  MNEMONIC_US(7),
  UNRECOGNIZED(-1),
  ;

  /**
   * <pre>
   ** Unknown code type 
   * </pre>
   *
   * <code>NO_CODE_TYPE = 0;</code>
   */
  public static final int NO_CODE_TYPE_VALUE = 0;
  /**
   * <pre>
   **  WKN code type 
   * </pre>
   *
   * <code>WKN = 1;</code>
   */
  public static final int WKN_VALUE = 1;
  /**
   * <pre>
   **  ISIN code type 
   * </pre>
   *
   * <code>ISIN = 2;</code>
   */
  public static final int ISIN_VALUE = 2;
  /**
   * <pre>
   **  Factset id notation 
   * </pre>
   *
   * <code>ID_NOTATION = 3;</code>
   */
  public static final int ID_NOTATION_VALUE = 3;
  /**
   * <pre>
   **  Factset id osi 
   * </pre>
   *
   * <code>ID_OSI = 4;</code>
   */
  public static final int ID_OSI_VALUE = 4;
  /**
   * <pre>
   **  Factset id instrument 
   * </pre>
   *
   * <code>ID_INSTRUMENT = 5;</code>
   */
  public static final int ID_INSTRUMENT_VALUE = 5;
  /**
   * <pre>
   **  Mnemonic or symbol 
   * </pre>
   *
   * <code>MNEMONIC = 6;</code>
   */
  public static final int MNEMONIC_VALUE = 6;
  /**
   * <pre>
   **  US Mnemonic or symbol 
   * </pre>
   *
   * <code>MNEMONIC_US = 7;</code>
   */
  public static final int MNEMONIC_US_VALUE = 7;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static SecurityCodeType valueOf(int value) {
    return forNumber(value);
  }

  public static SecurityCodeType forNumber(int value) {
    switch (value) {
      case 0: return NO_CODE_TYPE;
      case 1: return WKN;
      case 2: return ISIN;
      case 3: return ID_NOTATION;
      case 4: return ID_OSI;
      case 5: return ID_INSTRUMENT;
      case 6: return MNEMONIC;
      case 7: return MNEMONIC_US;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<SecurityCodeType>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      SecurityCodeType> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<SecurityCodeType>() {
          public SecurityCodeType findValueByNumber(int number) {
            return SecurityCodeType.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return com.consorsbank.module.tapi.grpc.security.SecurityService.getDescriptor().getEnumTypes().get(1);
  }

  private static final SecurityCodeType[] VALUES = values();

  public static SecurityCodeType valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private SecurityCodeType(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:com.consorsbank.module.tapi.grpc.SecurityCodeType)
}

