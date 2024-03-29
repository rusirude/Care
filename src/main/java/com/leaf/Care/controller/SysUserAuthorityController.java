package com.leaf.Care.controller;

import com.leaf.Care.dto.SysUserAuthorityDTO;
import com.leaf.Care.dto.SysUserDTO;
import com.leaf.Care.dto.common.DataTableResponseDTO;
import com.leaf.Care.dto.common.ResponseDTO;
import com.leaf.Care.service.SysUserAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(path = "sysUserAuthority")
public class SysUserAuthorityController {
	
	private SysUserAuthorityService sysUserAuthorityService;	
	
	@Autowired
	public SysUserAuthorityController(SysUserAuthorityService sysUserAuthorityService) {		
		this.sysUserAuthorityService = sysUserAuthorityService;
	}

//	@PreAuthorize("hasRole('ROLE_USERAUTHORITY')")
//	@RequestMapping(path = "/", method = RequestMethod.GET)
//	public ModelAndView viewSysRoleAuthority() {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("sysUserAuthority");
//		return mv;
//	}
	
	//@PreAuthorize("hasRole('ROLE_USERAUTHORITY')")
	@RequestMapping(path = "/loadRefDataForSysUserAuthority", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDTO<HashMap<String, Object>> loadysRoleAuthorityRefereceData() {
		return sysUserAuthorityService.getReferenceDataForSysUserAuthority();
	}
	
	//@PreAuthorize("hasRole('ROLE_USERAUTHORITY')")
	@RequestMapping(path = "/loadAuthoritiesForSysUser", method = RequestMethod.POST)
	@ResponseBody
	public DataTableResponseDTO loadAuthoritiesForSysUser(@RequestBody SysUserDTO sysUserDTO) {
		return sysUserAuthorityService.getSysUserAuthorityForSysUser(sysUserDTO);
	}
	

	//@PreAuthorize("hasRole('ROLE_USERAUTHORITY')")
	@RequestMapping(path = "/save", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDTO<SysUserAuthorityDTO> saveSysUserAuthority(@RequestBody SysUserAuthorityDTO sysUserAuthorityDTO) {
		return sysUserAuthorityService.saveSysUserAuthority(sysUserAuthorityDTO);
	}

	//@PreAuthorize("hasRole('ROLE_USERAUTHORITY')")
	@RequestMapping(path = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDTO<SysUserAuthorityDTO> deleteSysUserAuthority(@RequestBody SysUserAuthorityDTO sysUserAuthorityDTO) {
		return sysUserAuthorityService.deleteSysUserAuthority(sysUserAuthorityDTO);
	}

}
