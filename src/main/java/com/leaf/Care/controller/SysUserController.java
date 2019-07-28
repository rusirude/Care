package com.leaf.Care.controller;

import com.leaf.Care.dto.SysUserDTO;
import com.leaf.Care.dto.common.DataTableRequestDTO;
import com.leaf.Care.dto.common.DataTableResponseDTO;
import com.leaf.Care.dto.common.ResponseDTO;
import com.leaf.Care.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(path = "sysUser")
public class SysUserController {
	
	private SysUserService sysUserService;
	
	@Autowired
	public SysUserController(SysUserService sysUserService) {		
		this.sysUserService = sysUserService;
	}

//	@PreAuthorize("hasRole('ROLE_USER')")
//	@RequestMapping(path = "/", method = RequestMethod.GET)
//	public ModelAndView viewSysRole() {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("sysUser");
//		return mv;
//	}
	
	//@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping(path = "/loadRefDataForSysUser", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDTO<HashMap<String, Object>> loadSysUserRefereceData() {
		return sysUserService.getReferenceDataForSysUser();
	}
	
	//@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping(path = "/save", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDTO<?> saveSysUser(@RequestBody SysUserDTO sysUserDTO) {
		return sysUserService.saveSysUser(sysUserDTO);
	}
	
	//@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping(path = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDTO<?> updateSysUser(@RequestBody SysUserDTO sysUserDTO) {
		return sysUserService.updateSysUser(sysUserDTO);
	}

	//@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping(path = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDTO<?> daleteSysUser(@RequestBody SysUserDTO sysUserDTO) {
		return sysUserService.deleteSysUser(sysUserDTO);
	}
	
	//@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping(path = "/loadSysUsers", method = RequestMethod.POST)
	@ResponseBody
	public DataTableResponseDTO loadSysUsersDataGrid(@RequestBody DataTableRequestDTO dataTableRequestDTO) {
		return sysUserService.getSysUsersForDataTable(dataTableRequestDTO);
	}

	//@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping(path = "/loadSysUserByUsername", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDTO<SysUserDTO> loadSysUseerByUsername(@RequestBody SysUserDTO sysUserDTO) {
		return sysUserService.findSysUser(sysUserDTO);
	}
}
