package com.mukeshsolanki.socialloginexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.mukeshsolanki.sociallogin.facebook.FacebookHelper;
import com.mukeshsolanki.sociallogin.facebook.FacebookListener;
import com.mukeshsolanki.sociallogin.google.GoogleHelper;
import com.mukeshsolanki.sociallogin.google.GoogleListener;
import com.mukeshsolanki.sociallogin.twitter.TwitterHelper;
import com.mukeshsolanki.sociallogin.twitter.TwitterListener;

public class MainActivity extends AppCompatActivity
    implements FacebookListener, TwitterListener, GoogleListener, View.OnClickListener {

  private Button mFacebookButton, mTwitterButton, mGoogleButton;

  private FacebookHelper mFacebook;
  private TwitterHelper mTwitter;
  private GoogleHelper mGoogle;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    initializeView();
  }

  private void initializeView() {
    mFacebookButton = (Button) findViewById(R.id.facebook_button);
    mGoogleButton = (Button) findViewById(R.id.google_button);
    mTwitterButton = (Button) findViewById(R.id.twitter_button);
  }

  @Override public void onTwitterError(String errorMessage) {
  }

  @Override public void onTwitterSignIn(long userId, String authToken, String secret) {
  }

  @Override public void onFbSignInFail(String errorMessage) {
  }

  @Override public void onFbSignInSuccess(String token, String userId) {
  }

  @Override public void onFBSignOut() {
  }

  @Override public void onGoogleAuthSignIn(String authToken, String userId) {
  }

  @Override public void onGoogleAuthSignInFailed(String errorMessage) {
  }

  @Override public void onGoogleAuthSignOut() {
  }

  @Override public void onClick(View v) {
    switch (v.getId()) {
      case R.id.facebook_button:
        mFacebook.performSignIn(this);
        break;
      case R.id.twitter_button:
        mTwitter.performSignIn(this);
        break;
      case R.id.google_button:
        mGoogle.performSignIn(this);
        break;
    }
  }
}
