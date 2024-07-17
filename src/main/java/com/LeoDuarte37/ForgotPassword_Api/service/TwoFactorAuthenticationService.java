package com.LeoDuarte37.ForgotPassword_Api.service;

import com.LeoDuarte37.ForgotPassword_Api.dto.SessionLoginDto;
import com.LeoDuarte37.ForgotPassword_Api.dto.VerifiyCodeDto;

public interface TwoFactorAuthenticationService {

    SessionLoginDto verifyCode(VerifiyCodeDto verifiyCodeDto);
}
