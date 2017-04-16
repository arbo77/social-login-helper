package com.mukeshsolanki.sociallogin.twitter;

public interface TwitterListener {
  void onTwitterError(String errorMessage);

  void onTwitterSignIn(long userId, String authToken, String secret);
}
