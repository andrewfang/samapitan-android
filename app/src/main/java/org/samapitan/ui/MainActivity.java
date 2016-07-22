package org.samapitan.ui;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import org.samapitan.R;
import org.samapitan.model.Interest;

import java.util.List;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

  private GoogleMap map;
  private List<Interest> interests;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
        .findFragmentById(R.id.map);
    mapFragment.getMapAsync(this);

    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference reference = db.getReference();
    reference.child("interests")
        .addListenerForSingleValueEvent(new ValueEventListener() {
          @Override
          public void onDataChange(DataSnapshot dataSnapshot) {
            GenericTypeIndicator<List<Interest>> t = new GenericTypeIndicator<List<Interest>>() {};
            interests = dataSnapshot.getValue(t);
            updateMap();
          }

          @Override
          public void onCancelled(DatabaseError databaseError) {
          }
        });
  }

  @Override
  public void onMapReady(GoogleMap googleMap) {
    this.map = googleMap;
    updateMap();
  }

  private void updateMap() {
    if (this.map == null) {
      return;
    }

    if (this.interests != null) {
      for (int i = 0, size = this.interests.size(); i < size; i++) {
        Interest interest = this.interests.get(i);
        this.map.addMarker(new MarkerOptions()
            .position(new LatLng(interest.latitude, interest.longitude))
            .title(interest.title)
            .snippet(interest.description));
      }
    }
  }
}
