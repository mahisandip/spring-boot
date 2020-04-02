package com.email.common;

@FunctionalInterface
public interface Process<T> {
   T execute();
}