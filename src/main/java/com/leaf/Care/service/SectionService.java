package com.leaf.Care.service;

import java.util.HashMap;

import com.leaf.Care.dto.SectionDTO;
import com.leaf.Care.dto.common.DataTableRequestDTO;
import com.leaf.Care.dto.common.DataTableResponseDTO;
import com.leaf.Care.dto.common.ResponseDTO;

public interface SectionService {
	/**
	 * Save Section
	 * @param SectionDTO
	 * @return {@link ResponseDTO}
	 */
	ResponseDTO<SectionDTO> saveSection(SectionDTO sectionDTO);
	
	/**
	 * Update Section
	 * @param SectionDTO
	 * @return {@link ResponseDTO}
	 */
	ResponseDTO<SectionDTO> updateSection(SectionDTO sectionDTO);
	
	/**
	 * Delete Section
	 * @param SectionDTO - code 
	 * @return {@link ResponseDTO}
	 */
	ResponseDTO<SectionDTO> deleteSection(SectionDTO sectionDTO);
	
	/**
	 * Find Section By Code
	 * @param SectionDTO - code 
	 * @return {@link ResponseDTO}
	 */
	ResponseDTO<SectionDTO> findSection(SectionDTO sectionDTO);
	
	/**
	 * Load Reference Data For Section Page
	 * @return {@link ResponseDTO}
	 */
	ResponseDTO<HashMap<String, Object>> getReferenceDataForSection();
	
	/**
	 * Get Sections Data For Data Table
	 * @param dataTableRequestDTO
	 * @return {@link DataTableResponseDTO}
	 */
	DataTableResponseDTO getSectionsForDataTable(DataTableRequestDTO dataTableRequestDTO);
}
