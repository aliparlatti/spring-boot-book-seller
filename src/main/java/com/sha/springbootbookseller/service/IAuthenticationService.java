package com.sha.springbootbookseller.service;

import com.sha.springbootbookseller.model.User;

public interface IAuthenticationService {
    User signInReturnJWT(User signInRequest);
}
