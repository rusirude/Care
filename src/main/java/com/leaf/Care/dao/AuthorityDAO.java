package com.leaf.Care.dao;

import java.util.List;

import com.leaf.Care.dto.common.DataTableRequestDTO;
import com.leaf.Care.entity.AuthorityEntity;
import com.leaf.Care.entity.SectionEntity;

public interface AuthorityDAO {
	
	
    /**
     * Save Authority Entity
     * @param authorityEntity
     */
    void saveAuthorityEntity(AuthorityEntity authorityEntity);
    
    /**
     * Update Authority Entity
     * @param authorityEntity
     */
    void updateAuthorityEntity(AuthorityEntity authorityEntity);
	
	/**
	 * select *
	 * From - Authority
	 * Where - CODE = code
	 * 
	 * Find Entity from DB By Code
	 *  
	 * @param code
	 * @return {@link SectionEntity}
	 */
	AuthorityEntity findAuthorityEntityByCode(String code);

	/**
	 * select - *
	 * From - Authority
	 * Where - STATUS = statusCode
	 * 
	 * Find Authorities By Status Code
	 * 
	 * @param statusCode
	 * @return {@link List<AuthorityEntity>}
	 */
	List<AuthorityEntity> findAuthorityEntitiesByStatus(String statusCode);
	
	
    /**
     * Getting Data For  Grid 
     * @param dataTableRequestDTO
     * @return 
     */
    <T> T getDataForGrid(DataTableRequestDTO dataTableRequestDTO, String type);
}
