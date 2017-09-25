package io.invertase.firebase.appindexing;


import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import com.google.firebase.appindexing.Action;
import com.google.firebase.appindexing.FirebaseUserActions;
import com.google.firebase.appindexing.Indexable;
import com.google.firebase.appindexing.builders.Actions;


public class RNFirebaseAppIndexing extends ReactContextBaseJavaModule {

  private static final String TAG = "RNFirebaseAppIndexing";

  public RNFirebaseAppIndexing(ReactApplicationContext reactContext) {
    super(reactContext);
    Log.d(TAG, "New instance");
  }

  /**
   * @return
   */
  @Override
  public String getName() {
    return TAG;
  }

  @ReactMethod
  public void startViewAction(String title, String url) {
    FirebaseUserActions.getInstance().start(getAction(title, url));
  }

  @ReactMethod
  public void endViewAction(String title, String url) {
    FirebaseUserActions.getInstance().end(getAction(title, url));
  }

  private Action getAction(String title, String url) {
    return new Action.Builder(Action.Builder.VIEW_ACTION)
      .setObject(title, url)
      .build();
    }
}
