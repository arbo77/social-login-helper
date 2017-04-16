package com.mukeshsolanki.sociallogin.twitter;

public interface TwitterListener {
  void onTwitterError(String errorMessage);

  void onTwitterSignIn(String authToken, String secret, long userId);
}
