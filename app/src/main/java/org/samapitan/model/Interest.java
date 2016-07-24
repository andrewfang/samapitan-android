package org.samapitan.model;

import com.google.firebase.database.PropertyName;

import android.os.Parcel;
import android.os.Parcelable;

public class Interest implements Parcelable {
  @PropertyName("lat") public float latitude;
  @PropertyName("long") public float longitude;
  public String photoUrl;
  public String title;
  public String description;

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeFloat(this.latitude);
    dest.writeFloat(this.longitude);
    dest.writeString(this.photoUrl);
    dest.writeString(this.title);
    dest.writeString(this.description);
  }

  public Interest() {
  }

  private Interest(Parcel in) {
    this.latitude = in.readFloat();
    this.longitude = in.readFloat();
    this.photoUrl = in.readString();
    this.title = in.readString();
    this.description = in.readString();
  }

  public static final Parcelable.Creator<Interest> CREATOR = new Parcelable.Creator<Interest>() {
    @Override
    public Interest createFromParcel(Parcel source) {
      return new Interest(source);
    }

    @Override
    public Interest[] newArray(int size) {
      return new Interest[size];
    }
  };
}
