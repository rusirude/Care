package com.leaf.Care.service;

import java.util.List;

import com.leaf.Care.dto.MasterDataDTO;
import com.leaf.Care.dto.common.ResponseDTO;

public interface MasterDataService {

	/**
	 * Get All Master Data
	 * @return {@link ResponseDTO}
	 */
	ResponseDTO<List<MasterDataDTO>> loadAllMasterData();
	
	/**
	 * Save or Update Master Data
	 * @param masterDataDTOS
	 * @return {@link ResponseDTO}
	 */
	ResponseDTO<MasterDataDTO> saveOrUpdateMasterData(List<MasterDataDTO> masterDataDTOS);
}
