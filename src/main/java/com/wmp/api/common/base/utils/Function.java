package com.wmp.api.common.base.utils;

public interface Function<E, T> {
	public T callback(E e);

}