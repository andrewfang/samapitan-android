package org.samapitan.model;

import com.google.auto.value.AutoValue;

@AutoValue
abstract class Location {
  abstract double getLatitude();
  abstract double getLongitude();
}
