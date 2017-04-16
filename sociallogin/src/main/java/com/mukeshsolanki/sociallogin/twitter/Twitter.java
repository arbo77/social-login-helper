package com.mukeshsolanki.sociallogin.twitter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterAuthClient;

public class Twitter {
  private TwitterAuthClient mAuthClient;

  @NonNull private final Activity mActivity;

  @NonNull private final TwitterListener mListener;

  public Twitter(@NonNull TwitterListener response, @NonNull Activity context) {
    mActivity = context;
    mListener = response;
    mAuthClient = new TwitterAuthClient();
  }

  private Callback<TwitterSession> mCallback = new Callback<TwitterSession>() {
    @Override public void success(Result<TwitterSession> result) {
      TwitterSession session = result.data;
      mListener.onTwitterSignIn(session.getUserId(), session.getAuthToken().token,
          session.getAuthToken().secret);
    }

    @Override public void failure(TwitterException exception) {
      mListener.onTwitterError(exception.getMessage());
    }
  };

  public void performSignIn() {
    mAuthClient.authorize(mActivity, mCallback);
  }

  public void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (mAuthClient != null) mAuthClient.onActivityResult(requestCode, resultCode, data);
  }
}