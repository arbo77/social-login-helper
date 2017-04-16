package com.mukeshsolanki.sociallogin;

public interface FacebookListener {
  void onFbSignInFail(String errorMessage);

  void onFbSignInSuccess(String token, String userId);

  void onFBSignOut();
}
