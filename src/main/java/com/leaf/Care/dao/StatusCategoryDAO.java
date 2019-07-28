package com.leaf.Care.dao;

import com.leaf.Care.entity.StatusCategoryEntity;

public interface StatusCategoryDAO {

	/**
	 * Find Status Category By Code
	 * @param code
	 * @return {@link StatusCategoryEntity}
	 */
	StatusCategoryEntity findStatusCategoryByCode(String code);
}
