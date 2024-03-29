package com.leaf.Care.service;

import java.util.HashMap;

import com.leaf.Care.dto.TitleDTO;
import com.leaf.Care.dto.common.DataTableRequestDTO;
import com.leaf.Care.dto.common.DataTableResponseDTO;
import com.leaf.Care.dto.common.ResponseDTO;

public interface TitleService {
	/**
	 * Save Title
	 * @param TitleDTO
	 * @return {@link ResponseDTO}
	 */
	ResponseDTO<TitleDTO> saveTitle(TitleDTO titleDTO);
	
	/**
	 * Update Title
	 * @param TitleDTO
	 * @return {@link ResponseDTO}
	 */
	ResponseDTO<TitleDTO> updateTitle(TitleDTO titleDTO);
	
	/**
	 * Delete Title
	 * @param TitleDTO - code 
	 * @return {@link ResponseDTO}
	 */
	ResponseDTO<TitleDTO> deleteTitle(TitleDTO titleDTO);
	
	/**
	 * Find Title By Code
	 * @param TitleDTO - code 
	 * @return {@link ResponseDTO}
	 */
	ResponseDTO<TitleDTO> findTitle(TitleDTO titleDTO);
	
	/**
	 * Load Reference Data For Title Page
	 * @return {@link ResponseDTO}
	 */
	ResponseDTO<HashMap<String, Object>> getReferenceDataForTitle();
	
	/**
	 * Get Titles Data For Data Table
	 * @param dataTableRequestDTO
	 * @return {@link DataTableResponseDTO}
	 */
	DataTableResponseDTO getTitlesForDataTable(DataTableRequestDTO dataTableRequestDTO);
}
