package org.samapitan.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.samapitan.R;
import org.samapitan.model.Interest;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InterestActivity extends AppCompatActivity {
  private static final String EXTRA_INTEREST = "EXTRA_INTEREST";

  static Intent generateIntent(Context context, Interest interest) {
    Intent intent = new Intent(context, InterestActivity.class);
    intent.putExtra(EXTRA_INTEREST, interest);
    return intent;
  }

  @BindView(R.id.image) ImageView image;
  @BindView(R.id.title) TextView title;
  @BindView(R.id.description) TextView description;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    Interest interest = getIntent().getParcelableExtra(EXTRA_INTEREST);
    if (interest == null) {
      finish();
    } else {
      setContentView(R.layout.interest_activity);
      ButterKnife.bind(this);
      this.title.setText(interest.title);
      this.description.setText(interest.description);
      Picasso.with(this)
          .load(interest.photoUrl)
          .fit()
          .centerCrop()
          .into(this.image);
    }
  }

  @Override
  protected void onDestroy() {
    Picasso.with(this).cancelRequest(this.image);
    super.onDestroy();
  }
}
