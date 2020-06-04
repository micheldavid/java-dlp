/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/privacy/dlp/v2/dlp.proto

package com.google.privacy.dlp.v2;

/**
 *
 *
 * <pre>
 * Summary statistics of a custom dictionary.
 * </pre>
 *
 * Protobuf type {@code google.privacy.dlp.v2.LargeCustomDictionaryStats}
 */
public final class LargeCustomDictionaryStats extends com.google.protobuf.GeneratedMessageV3
    implements
    // @@protoc_insertion_point(message_implements:google.privacy.dlp.v2.LargeCustomDictionaryStats)
    LargeCustomDictionaryStatsOrBuilder {
  private static final long serialVersionUID = 0L;
  // Use LargeCustomDictionaryStats.newBuilder() to construct.
  private LargeCustomDictionaryStats(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private LargeCustomDictionaryStats() {}

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
    return new LargeCustomDictionaryStats();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }

  private LargeCustomDictionaryStats(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
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
          case 8:
            {
              approxNumPhrases_ = input.readInt64();
              break;
            }
          default:
            {
              if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }

  public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
    return com.google.privacy.dlp.v2.DlpProto
        .internal_static_google_privacy_dlp_v2_LargeCustomDictionaryStats_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.privacy.dlp.v2.DlpProto
        .internal_static_google_privacy_dlp_v2_LargeCustomDictionaryStats_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.privacy.dlp.v2.LargeCustomDictionaryStats.class,
            com.google.privacy.dlp.v2.LargeCustomDictionaryStats.Builder.class);
  }

  public static final int APPROX_NUM_PHRASES_FIELD_NUMBER = 1;
  private long approxNumPhrases_;
  /**
   *
   *
   * <pre>
   * Approximate number of distinct phrases in the dictionary.
   * </pre>
   *
   * <code>int64 approx_num_phrases = 1;</code>
   *
   * @return The approxNumPhrases.
   */
  @java.lang.Override
  public long getApproxNumPhrases() {
    return approxNumPhrases_;
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
  public void writeTo(com.google.protobuf.CodedOutputStream output) throws java.io.IOException {
    if (approxNumPhrases_ != 0L) {
      output.writeInt64(1, approxNumPhrases_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (approxNumPhrases_ != 0L) {
      size += com.google.protobuf.CodedOutputStream.computeInt64Size(1, approxNumPhrases_);
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
    if (!(obj instanceof com.google.privacy.dlp.v2.LargeCustomDictionaryStats)) {
      return super.equals(obj);
    }
    com.google.privacy.dlp.v2.LargeCustomDictionaryStats other =
        (com.google.privacy.dlp.v2.LargeCustomDictionaryStats) obj;

    if (getApproxNumPhrases() != other.getApproxNumPhrases()) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + APPROX_NUM_PHRASES_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getApproxNumPhrases());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.google.privacy.dlp.v2.LargeCustomDictionaryStats parseFrom(
      java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.privacy.dlp.v2.LargeCustomDictionaryStats parseFrom(
      java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.privacy.dlp.v2.LargeCustomDictionaryStats parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.privacy.dlp.v2.LargeCustomDictionaryStats parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.privacy.dlp.v2.LargeCustomDictionaryStats parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.privacy.dlp.v2.LargeCustomDictionaryStats parseFrom(
      byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.privacy.dlp.v2.LargeCustomDictionaryStats parseFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.privacy.dlp.v2.LargeCustomDictionaryStats parseFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.privacy.dlp.v2.LargeCustomDictionaryStats parseDelimitedFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
  }

  public static com.google.privacy.dlp.v2.LargeCustomDictionaryStats parseDelimitedFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.privacy.dlp.v2.LargeCustomDictionaryStats parseFrom(
      com.google.protobuf.CodedInputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.privacy.dlp.v2.LargeCustomDictionaryStats parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() {
    return newBuilder();
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(com.google.privacy.dlp.v2.LargeCustomDictionaryStats prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   *
   *
   * <pre>
   * Summary statistics of a custom dictionary.
   * </pre>
   *
   * Protobuf type {@code google.privacy.dlp.v2.LargeCustomDictionaryStats}
   */
  public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
      implements
      // @@protoc_insertion_point(builder_implements:google.privacy.dlp.v2.LargeCustomDictionaryStats)
      com.google.privacy.dlp.v2.LargeCustomDictionaryStatsOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.google.privacy.dlp.v2.DlpProto
          .internal_static_google_privacy_dlp_v2_LargeCustomDictionaryStats_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.privacy.dlp.v2.DlpProto
          .internal_static_google_privacy_dlp_v2_LargeCustomDictionaryStats_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.privacy.dlp.v2.LargeCustomDictionaryStats.class,
              com.google.privacy.dlp.v2.LargeCustomDictionaryStats.Builder.class);
    }

    // Construct using com.google.privacy.dlp.v2.LargeCustomDictionaryStats.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {}
    }

    @java.lang.Override
    public Builder clear() {
      super.clear();
      approxNumPhrases_ = 0L;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
      return com.google.privacy.dlp.v2.DlpProto
          .internal_static_google_privacy_dlp_v2_LargeCustomDictionaryStats_descriptor;
    }

    @java.lang.Override
    public com.google.privacy.dlp.v2.LargeCustomDictionaryStats getDefaultInstanceForType() {
      return com.google.privacy.dlp.v2.LargeCustomDictionaryStats.getDefaultInstance();
    }

    @java.lang.Override
    public com.google.privacy.dlp.v2.LargeCustomDictionaryStats build() {
      com.google.privacy.dlp.v2.LargeCustomDictionaryStats result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.google.privacy.dlp.v2.LargeCustomDictionaryStats buildPartial() {
      com.google.privacy.dlp.v2.LargeCustomDictionaryStats result =
          new com.google.privacy.dlp.v2.LargeCustomDictionaryStats(this);
      result.approxNumPhrases_ = approxNumPhrases_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }

    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field, java.lang.Object value) {
      return super.setField(field, value);
    }

    @java.lang.Override
    public Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }

    @java.lang.Override
    public Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }

    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field, int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }

    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field, java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.google.privacy.dlp.v2.LargeCustomDictionaryStats) {
        return mergeFrom((com.google.privacy.dlp.v2.LargeCustomDictionaryStats) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.google.privacy.dlp.v2.LargeCustomDictionaryStats other) {
      if (other == com.google.privacy.dlp.v2.LargeCustomDictionaryStats.getDefaultInstance())
        return this;
      if (other.getApproxNumPhrases() != 0L) {
        setApproxNumPhrases(other.getApproxNumPhrases());
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
      com.google.privacy.dlp.v2.LargeCustomDictionaryStats parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage =
            (com.google.privacy.dlp.v2.LargeCustomDictionaryStats) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private long approxNumPhrases_;
    /**
     *
     *
     * <pre>
     * Approximate number of distinct phrases in the dictionary.
     * </pre>
     *
     * <code>int64 approx_num_phrases = 1;</code>
     *
     * @return The approxNumPhrases.
     */
    @java.lang.Override
    public long getApproxNumPhrases() {
      return approxNumPhrases_;
    }
    /**
     *
     *
     * <pre>
     * Approximate number of distinct phrases in the dictionary.
     * </pre>
     *
     * <code>int64 approx_num_phrases = 1;</code>
     *
     * @param value The approxNumPhrases to set.
     * @return This builder for chaining.
     */
    public Builder setApproxNumPhrases(long value) {

      approxNumPhrases_ = value;
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * Approximate number of distinct phrases in the dictionary.
     * </pre>
     *
     * <code>int64 approx_num_phrases = 1;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearApproxNumPhrases() {

      approxNumPhrases_ = 0L;
      onChanged();
      return this;
    }

    @java.lang.Override
    public final Builder setUnknownFields(final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }

    // @@protoc_insertion_point(builder_scope:google.privacy.dlp.v2.LargeCustomDictionaryStats)
  }

  // @@protoc_insertion_point(class_scope:google.privacy.dlp.v2.LargeCustomDictionaryStats)
  private static final com.google.privacy.dlp.v2.LargeCustomDictionaryStats DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new com.google.privacy.dlp.v2.LargeCustomDictionaryStats();
  }

  public static com.google.privacy.dlp.v2.LargeCustomDictionaryStats getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<LargeCustomDictionaryStats> PARSER =
      new com.google.protobuf.AbstractParser<LargeCustomDictionaryStats>() {
        @java.lang.Override
        public LargeCustomDictionaryStats parsePartialFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
          return new LargeCustomDictionaryStats(input, extensionRegistry);
        }
      };

  public static com.google.protobuf.Parser<LargeCustomDictionaryStats> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<LargeCustomDictionaryStats> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.privacy.dlp.v2.LargeCustomDictionaryStats getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
}
