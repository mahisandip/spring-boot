package com.thales.common;

@FunctionalInterface
public interface Process<T> {
	T execute();
}