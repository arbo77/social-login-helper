package com.mukeshsolanki.sociallogin.facebook;

public interface FacebookListener {
  void onFbSignInFail(String errorMessage);

  void onFbSignInSuccess(String token, String userId);

  void onFBSignOut();
}
