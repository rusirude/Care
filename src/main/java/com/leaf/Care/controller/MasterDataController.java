package com.leaf.Care.controller;

import com.leaf.Care.dto.MasterDataDTO;
import com.leaf.Care.dto.common.ResponseDTO;
import com.leaf.Care.service.MasterDataService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "masterData")
public class MasterDataController {
	
	private MasterDataService masterDataService;	
	
	@Autowired
	public MasterDataController(MasterDataService masterDataService) {		
		this.masterDataService = masterDataService;
	}

//	@PreAuthorize("hasRole('ROLE_MASTERDATA')")
//	@RequestMapping(path = "/", method = RequestMethod.GET)
//	public ModelAndView viewMasterData() {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("masterData");
//		return mv;
//	}
	
	//@PreAuthorize("hasRole('ROLE_MASTERDATA')")
	@RequestMapping(path = "/loadMasterData", method = RequestMethod.POST)
	@ResponseBody
	ResponseDTO<List<MasterDataDTO>> loadMasterData() {
		return masterDataService.loadAllMasterData();
	}
	
	//@PreAuthorize("hasRole('ROLE_MASTERDATA')")
	@RequestMapping(path = "/save", method = RequestMethod.POST)
	@ResponseBody
	ResponseDTO<MasterDataDTO> saveMasterData(@RequestBody List<MasterDataDTO> masterDataDTOs) {
		return masterDataService.saveOrUpdateMasterData(masterDataDTOs);
	}

}
