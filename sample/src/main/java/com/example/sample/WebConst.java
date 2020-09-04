package com.example.sample;

public interface WebConst {

    /** ---- MDC ---- **/
    String MDC_LOGIN_USER_ID = "LOGIN_USER_ID";

    String MDC_FUNCTION_NAME = "FUNCTION_NAME";

    String MAV_ERRORS = "errors";

    /** ---- URLs ---- **/
    String HOME_URL = "/";

    String ERROR_URL = "/error";

    String FORBIDDEN_URL = "/forbidden";

    String LOGIN_URL = "/signin";

    String LOGIN_PROCESSING_URL = "/login";

    String LOGIN_SUCCESS_URL = "/loginSuccess";

    String LOGIN_FAILURE_URL = "/loginFailure";

    String LOGIN_TIMEOUT_URL = "/loginTimeout";

    String RESET_PASSWORD_URL = "/resetPassword";

    String CHANGE_PASSWORD_URL = "/changePassword";

    String LOGOUT_URL = "/logout";

    String LOGOUT_SUCCESS_URL = "/logoutSuccess";

    String WEBJARS_URL = "/webjars/**";

    String STATIC_RESOURCES_URL = "/static/**";

    String API_BASE_URL = "/api/**";
}
