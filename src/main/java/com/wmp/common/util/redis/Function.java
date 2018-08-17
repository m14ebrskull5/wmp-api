package com.wmp.common.util.redis;

public interface Function<E, T> {
	
	public T callback(E e);

}
