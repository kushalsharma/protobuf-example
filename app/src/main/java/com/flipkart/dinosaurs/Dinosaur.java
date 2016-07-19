// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: flipkart/dinosaurs/dinosaur.proto at 9:1
package com.flipkart.dinosaurs;

import com.flipkart.geology.Period;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.lang.Double;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import okio.ByteString;

public final class Dinosaur extends Message<Dinosaur, Dinosaur.Builder> {
  public static final ProtoAdapter<Dinosaur> ADAPTER = new ProtoAdapter_Dinosaur();

  private static final long serialVersionUID = 0L;

  public static final String DEFAULT_NAME = "";

  public static final String DEFAULT_PICTURE_URLS = "";

  public static final Double DEFAULT_LENGTH_METERS = 0.0d;

  public static final Double DEFAULT_MASS_KILOGRAMS = 0.0d;

  public static final Period DEFAULT_PERIOD = Period.CRETACEOUS;

  /**
   * Common name of this dinosaur, like "Stegosaurus".
   */
  @WireField(
      tag = 1,
      adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  public final String name;

  /**
   * URLs with images of this dinosaur.
   */
  @WireField(
      tag = 2,
      adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  public final String picture_urls;

  @WireField(
      tag = 3,
      adapter = "com.squareup.wire.ProtoAdapter#DOUBLE"
  )
  public final Double length_meters;

  @WireField(
      tag = 4,
      adapter = "com.squareup.wire.ProtoAdapter#DOUBLE"
  )
  public final Double mass_kilograms;

  @WireField(
      tag = 5,
      adapter = "com.flipkart.geology.Period#ADAPTER"
  )
  public final Period period;

  public Dinosaur(String name, String picture_urls, Double length_meters, Double mass_kilograms, Period period) {
    this(name, picture_urls, length_meters, mass_kilograms, period, ByteString.EMPTY);
  }

  public Dinosaur(String name, String picture_urls, Double length_meters, Double mass_kilograms, Period period, ByteString unknownFields) {
    super(ADAPTER, unknownFields);
    this.name = name;
    this.picture_urls = picture_urls;
    this.length_meters = length_meters;
    this.mass_kilograms = mass_kilograms;
    this.period = period;
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.name = name;
    builder.picture_urls = picture_urls;
    builder.length_meters = length_meters;
    builder.mass_kilograms = mass_kilograms;
    builder.period = period;
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof Dinosaur)) return false;
    Dinosaur o = (Dinosaur) other;
    return unknownFields().equals(o.unknownFields())
        && Internal.equals(name, o.name)
        && Internal.equals(picture_urls, o.picture_urls)
        && Internal.equals(length_meters, o.length_meters)
        && Internal.equals(mass_kilograms, o.mass_kilograms)
        && Internal.equals(period, o.period);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode;
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + (name != null ? name.hashCode() : 0);
      result = result * 37 + (picture_urls != null ? picture_urls.hashCode() : 0);
      result = result * 37 + (length_meters != null ? length_meters.hashCode() : 0);
      result = result * 37 + (mass_kilograms != null ? mass_kilograms.hashCode() : 0);
      result = result * 37 + (period != null ? period.hashCode() : 0);
      super.hashCode = result;
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    if (name != null) builder.append(", name=").append(name);
    if (picture_urls != null) builder.append(", picture_urls=").append(picture_urls);
    if (length_meters != null) builder.append(", length_meters=").append(length_meters);
    if (mass_kilograms != null) builder.append(", mass_kilograms=").append(mass_kilograms);
    if (period != null) builder.append(", period=").append(period);
    return builder.replace(0, 2, "Dinosaur{").append('}').toString();
  }

  public static final class Builder extends Message.Builder<Dinosaur, Builder> {
    public String name;

    public String picture_urls;

    public Double length_meters;

    public Double mass_kilograms;

    public Period period;

    public Builder() {
    }

    /**
     * Common name of this dinosaur, like "Stegosaurus".
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * URLs with images of this dinosaur.
     */
    public Builder picture_urls(String picture_urls) {
      this.picture_urls = picture_urls;
      return this;
    }

    public Builder length_meters(Double length_meters) {
      this.length_meters = length_meters;
      return this;
    }

    public Builder mass_kilograms(Double mass_kilograms) {
      this.mass_kilograms = mass_kilograms;
      return this;
    }

    public Builder period(Period period) {
      this.period = period;
      return this;
    }

    @Override
    public Dinosaur build() {
      return new Dinosaur(name, picture_urls, length_meters, mass_kilograms, period, super.buildUnknownFields());
    }
  }

  private static final class ProtoAdapter_Dinosaur extends ProtoAdapter<Dinosaur> {
    ProtoAdapter_Dinosaur() {
      super(FieldEncoding.LENGTH_DELIMITED, Dinosaur.class);
    }

    @Override
    public int encodedSize(Dinosaur value) {
      return (value.name != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, value.name) : 0)
          + (value.picture_urls != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, value.picture_urls) : 0)
          + (value.length_meters != null ? ProtoAdapter.DOUBLE.encodedSizeWithTag(3, value.length_meters) : 0)
          + (value.mass_kilograms != null ? ProtoAdapter.DOUBLE.encodedSizeWithTag(4, value.mass_kilograms) : 0)
          + (value.period != null ? Period.ADAPTER.encodedSizeWithTag(5, value.period) : 0)
          + value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, Dinosaur value) throws IOException {
      if (value.name != null) ProtoAdapter.STRING.encodeWithTag(writer, 1, value.name);
      if (value.picture_urls != null) ProtoAdapter.STRING.encodeWithTag(writer, 2, value.picture_urls);
      if (value.length_meters != null) ProtoAdapter.DOUBLE.encodeWithTag(writer, 3, value.length_meters);
      if (value.mass_kilograms != null) ProtoAdapter.DOUBLE.encodeWithTag(writer, 4, value.mass_kilograms);
      if (value.period != null) Period.ADAPTER.encodeWithTag(writer, 5, value.period);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public Dinosaur decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1;) {
        switch (tag) {
          case 1: builder.name(ProtoAdapter.STRING.decode(reader)); break;
          case 2: builder.picture_urls(ProtoAdapter.STRING.decode(reader)); break;
          case 3: builder.length_meters(ProtoAdapter.DOUBLE.decode(reader)); break;
          case 4: builder.mass_kilograms(ProtoAdapter.DOUBLE.decode(reader)); break;
          case 5: {
            try {
              builder.period(Period.ADAPTER.decode(reader));
            } catch (ProtoAdapter.EnumConstantNotFoundException e) {
              builder.addUnknownField(tag, FieldEncoding.VARINT, (long) e.value);
            }
            break;
          }
          default: {
            FieldEncoding fieldEncoding = reader.peekFieldEncoding();
            Object value = fieldEncoding.rawProtoAdapter().decode(reader);
            builder.addUnknownField(tag, fieldEncoding, value);
          }
        }
      }
      reader.endMessage(token);
      return builder.build();
    }

    @Override
    public Dinosaur redact(Dinosaur value) {
      Builder builder = value.newBuilder();
      builder.clearUnknownFields();
      return builder.build();
    }
  }
}