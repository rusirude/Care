package com.leaf.Care.controller;

import com.leaf.Care.dto.SectionDTO;
import com.leaf.Care.dto.common.DataTableRequestDTO;
import com.leaf.Care.dto.common.DataTableResponseDTO;
import com.leaf.Care.dto.common.ResponseDTO;
import com.leaf.Care.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(path = "section")
public class SectionController {

	private SectionService sectionService;

	@Autowired
	public SectionController(SectionService sectionService) {
		this.sectionService = sectionService;
	}

//	@PreAuthorize("hasRole('ROLE_SECTION')")
//	@RequestMapping(path = "/", method = RequestMethod.GET)
//	public ModelAndView viewSection() {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("section");
//		return mv;
//	}

	//@PreAuthorize("hasRole('ROLE_SECTION')")
	@RequestMapping(path = "/loadRefDataForSection", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDTO<HashMap<String, Object>> loadSectionRefereceData() {
		return sectionService.getReferenceDataForSection();
	}

	//@PreAuthorize("hasRole('ROLE_SECTION')")
	@RequestMapping(path = "/save", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDTO<?> saveSection(@RequestBody SectionDTO sectionDTO) {
		return sectionService.saveSection(sectionDTO);
	}

	//@PreAuthorize("hasRole('ROLE_SECTION')")
	@RequestMapping(path = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDTO<?> updateSection(@RequestBody SectionDTO sectionDTO) {
		return sectionService.updateSection(sectionDTO);
	}

	//@PreAuthorize("hasRole('ROLE_SECTION')")
	@RequestMapping(path = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDTO<?> daleteSection(@RequestBody SectionDTO sectionDTO) {
		return sectionService.deleteSection(sectionDTO);
	}

	//@PreAuthorize("hasRole('ROLE_SECTION')")
	@RequestMapping(path = "/loadSections", method = RequestMethod.POST)
	@ResponseBody
	public DataTableResponseDTO loadSectionDataGrid(@RequestBody DataTableRequestDTO dataTableRequestDTO) {
		return sectionService.getSectionsForDataTable(dataTableRequestDTO);
	}

	//@PreAuthorize("hasRole('ROLE_SECTION')")
	@RequestMapping(path = "/loadSectionByCode", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDTO<SectionDTO> loadSectionByCode(@RequestBody SectionDTO sectionDTO) {
		return sectionService.findSection(sectionDTO);
	}
}
