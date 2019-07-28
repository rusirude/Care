package com.leaf.Care.service;

import java.util.HashMap;

import com.leaf.Care.dto.AuthorityDTO;
import com.leaf.Care.dto.common.DataTableRequestDTO;
import com.leaf.Care.dto.common.DataTableResponseDTO;
import com.leaf.Care.dto.common.ResponseDTO;

public interface AuthorityService {
	
	/**
	 * Save Authority
	 * @param AuthorityDTO
	 * @return {@link ResponseDTO}
	 */
	ResponseDTO<AuthorityDTO> saveAuthority(AuthorityDTO authorityDTO);
	
	/**
	 * Update Authority
	 * @param AuthorityDTO
	 * @return {@link ResponseDTO}
	 */
	ResponseDTO<AuthorityDTO> updateAuthority(AuthorityDTO authorityDTO);
	
	/**
	 * Delete Authority
	 * @param AuthorityDTO - code 
	 * @return {@link ResponseDTO}
	 */
	ResponseDTO<AuthorityDTO> deleteAuthority(AuthorityDTO authorityDTO);
	
	/**
	 * Load Reference Data For Authority Page
	 * @return {@link ResponseDTO}
	 */
	ResponseDTO<HashMap<String, Object>> getReferenceDataForAuthority();
	
	
	/**
	 * Find Authority By Code
	 * @param AuthorityDTO - code 
	 * @return {@link ResponseDTO}
	 */
	ResponseDTO<AuthorityDTO> findAuthority(AuthorityDTO authorityDTO);
	
	/**
	 * Get Authorities Data For Data Table
	 * @param dataTableRequestDTO
	 * @return {@link DataTableResponseDTO}
	 */
	DataTableResponseDTO getAuthoritiesForDataTable(DataTableRequestDTO dataTableRequestDTO);
}


