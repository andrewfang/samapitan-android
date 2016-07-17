package org.samapitan.model;

import com.google.auto.value.AutoValue;

@AutoValue
abstract class Person {
  abstract String getName();
  abstract String getGroup();
  abstract String imageUrl();
  abstract String bio();
  abstract Location getLocation();
}
