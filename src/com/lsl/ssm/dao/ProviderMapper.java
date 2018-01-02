package com.lsl.ssm.dao;

import java.util.List;

import com.lsl.ssm.pojo.Provider;

public interface ProviderMapper {
	/**
	 * 查询提供商表记录数
	 * @return
	 */
	public int count();
	/**
	 * 查询提供商列表
	 * @return
	 */
	public List<Provider> getProviderList();
}
