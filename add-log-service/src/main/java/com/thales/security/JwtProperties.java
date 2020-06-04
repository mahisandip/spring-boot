package com.thales.security;

public class JwtProperties {
    public static final String SECRET = "SomeSecretForJWTGeneration";
    public static final int EXPIRATION_TIME = 864_00_000; // expires in 1 day
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
}
