package org.samapitan.model;

import com.google.firebase.database.PropertyName;

public class Interest {
  @PropertyName("lat") public float latitude;
  @PropertyName("long") public float longitude;
  public String photoUrl;
  public String title;
  public String description;
}
