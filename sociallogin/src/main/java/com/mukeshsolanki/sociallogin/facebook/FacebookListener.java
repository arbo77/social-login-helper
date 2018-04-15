package com.mukeshsolanki.sociallogin.facebook;

import com.facebook.AccessToken;

public interface FacebookListener {
  void onFbSignInFail(String errorMessage);

  void onFbSignInSuccess(String authToken, String userId);

  void onFbSignInSuccess(String authToken, AccessToken result);

  void onFBSignOut();
}
