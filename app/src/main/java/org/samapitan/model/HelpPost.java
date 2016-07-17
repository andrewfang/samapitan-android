package org.samapitan.model;

import com.google.auto.value.AutoValue;

import java.util.List;

@AutoValue
abstract class HelpPost {
  abstract Location getLocation();
  abstract String getTitle();
  abstract Urgency getUrgency();
  abstract long timePosted();
  abstract List<Person> membersHelpingOut();
}
