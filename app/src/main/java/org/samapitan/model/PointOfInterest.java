package org.samapitan.model;

import com.google.auto.value.AutoValue;

@AutoValue
abstract class PointOfInterest {
  abstract Location getLocation();
  abstract String getTitle();
  abstract String getDescription();
  abstract String getPhotoUrl();
}
