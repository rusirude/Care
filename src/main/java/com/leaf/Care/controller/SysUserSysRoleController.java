package com.leaf.Care.controller;

import com.leaf.Care.dto.SysUserDTO;
import com.leaf.Care.dto.SysUserSysRoleDTO;
import com.leaf.Care.dto.common.DataTableResponseDTO;
import com.leaf.Care.dto.common.ResponseDTO;
import com.leaf.Care.service.SysUserSysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(path = "/sysUserSysRole")
public class SysUserSysRoleController {
	
	private SysUserSysRoleService sysUserSysRoleService;

	@Autowired
	public SysUserSysRoleController(SysUserSysRoleService sysUserSysRoleService) {
		this.sysUserSysRoleService = sysUserSysRoleService;
	}
	
//	@PreAuthorize("hasRole('ROLE_ASGNROLE')")
//	@RequestMapping(path = "/", method = RequestMethod.GET)
//	public ModelAndView viewSysUserSysRole() {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("sysUserSysRole");
//		return mv;
//	}
	
	//@PreAuthorize("hasRole('ROLE_ASGNROLE')")
	@RequestMapping(path = "/loadRefDataForSysUserSysRole", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDTO<HashMap<String, Object>> loadSysUserSysRoleRefereceData() {
		return sysUserSysRoleService.getReferenceDataForSysUserSysRole();
	}

		
	//@PreAuthorize("hasRole('ROLE_ASGNROLE')")
	@RequestMapping(path = "/loadSysRolesForSysUser", method = RequestMethod.POST)
	@ResponseBody
	public DataTableResponseDTO loadSysRolesForSysUser(@RequestBody SysUserDTO sysUserDTO) {
		return sysUserSysRoleService.getSysUserSysRoleForSysUser(sysUserDTO);
	}		

	//@PreAuthorize("hasRole('ROLE_ASGNROLE')")
	@RequestMapping(path = "/save", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDTO<SysUserSysRoleDTO> saveSysUserSysRole(@RequestBody SysUserSysRoleDTO sysUserSysRoleDTO) {
		return sysUserSysRoleService.saveSysUserSysRole(sysUserSysRoleDTO);
	}

	//@PreAuthorize("hasRole('ROLE_ASGNROLE')")
	@RequestMapping(path = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDTO<SysUserSysRoleDTO> deleteSysUserSysRole(@RequestBody SysUserSysRoleDTO sysUserSysRoleDTO) {
		return sysUserSysRoleService.deleteSysUserSysRole(sysUserSysRoleDTO);
	}
	
}
