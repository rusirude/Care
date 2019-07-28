package com.leaf.Care.controller;

import com.leaf.Care.dto.SysRoleDTO;
import com.leaf.Care.dto.common.DataTableRequestDTO;
import com.leaf.Care.dto.common.DataTableResponseDTO;
import com.leaf.Care.dto.common.ResponseDTO;
import com.leaf.Care.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(path = "userRole")
public class SysRoleController {

	private SysRoleService sysRoleService;

	@Autowired
	public SysRoleController(SysRoleService sysRoleService) {
		this.sysRoleService = sysRoleService;
	}

//	@PreAuthorize("hasRole('ROLE_SYSROLE')")
//	@RequestMapping(path = "/", method = RequestMethod.GET)
//	public ModelAndView viewSysRole() {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("sysRole");
//		return mv;
//	}

	@PreAuthorize("hasRole('ROLE_SYSROLE')")
	@RequestMapping(path = "/loadRefDataForSysRole", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDTO<HashMap<String, Object>> loadSysRoleRefereceData() {
		return sysRoleService.getReferenceDataForSysRole();
	}

	@PreAuthorize("hasRole('ROLE_SYSROLE')")
	@RequestMapping(path = "/save", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDTO<?> saveSysRole(@RequestBody SysRoleDTO sysRoleDTO) {
		return sysRoleService.saveSysRole(sysRoleDTO);
	}

	@PreAuthorize("hasRole('ROLE_SYSROLE')")
	@RequestMapping(path = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDTO<?> updateSysRole(@RequestBody SysRoleDTO sysRoleDTO) {
		return sysRoleService.updateSysRole(sysRoleDTO);
	}

	@PreAuthorize("hasRole('ROLE_SYSROLE')")
	@RequestMapping(path = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDTO<?> daleteSysRole(@RequestBody SysRoleDTO sysRoleDTO) {
		return sysRoleService.deleteSysRole(sysRoleDTO);
	}

	@PreAuthorize("hasRole('ROLE_SYSROLE')")
	@RequestMapping(path = "/loadUserRoles", method = RequestMethod.POST)
	@ResponseBody
	public DataTableResponseDTO loadSysRoleDataGrid(@RequestBody DataTableRequestDTO dataTableRequestDTO) {
		return sysRoleService.getSysRolesForDataTable(dataTableRequestDTO);
	}

	@PreAuthorize("hasRole('ROLE_SYSROLE')")
	@RequestMapping(path = "/loadUserRoleByCode", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDTO<SysRoleDTO> loadSysRoleByCode(@RequestBody SysRoleDTO sysRoleDTO) {
		return sysRoleService.findSysRole(sysRoleDTO);
	}
}
