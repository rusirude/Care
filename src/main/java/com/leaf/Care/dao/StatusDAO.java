package com.leaf.Care.dao;

import com.leaf.Care.entity.StatusEntity;

public interface StatusDAO {
	
	/**
	 * Find Status Entity By Code
	 * @param code
	 * @return {@link StatusEntity}
	 */
	StatusEntity findStatusEntityByCode(String code);
}
