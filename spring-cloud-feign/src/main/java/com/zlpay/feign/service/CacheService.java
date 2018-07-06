package com.zlpay.feign.service;

public interface CacheService {

	String delete(String id);

	String save(String id, String value);

	String update(String id, String value);

	String get(String id);

}
