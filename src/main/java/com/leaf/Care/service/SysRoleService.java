package com.leaf.Care.service;

import java.util.HashMap;

import com.leaf.Care.dto.SysRoleDTO;
import com.leaf.Care.dto.common.DataTableRequestDTO;
import com.leaf.Care.dto.common.DataTableResponseDTO;
import com.leaf.Care.dto.common.ResponseDTO;

public interface SysRoleService {
	
	/**
	 * Save System Role
	 * @param SysRoleDTO
	 * @return {@link ResponseDTO}
	 */
	ResponseDTO<SysRoleDTO> saveSysRole(SysRoleDTO sysRoleDTO);
	
	/**
	 * Update System Role
	 * @param SysRoleDTO
	 * @return {@link ResponseDTO}
	 */
	ResponseDTO<SysRoleDTO> updateSysRole(SysRoleDTO sysRoleDTO);
	
	/**
	 * Delete System Role
	 * @param SysRoleDTO - code 
	 * @return {@link ResponseDTO}
	 */
	ResponseDTO<SysRoleDTO> deleteSysRole(SysRoleDTO sysRoleDTO);
	
	/**
	 * Find System Role By Code
	 * @param SysRoleDTO - code 
	 * @return {@link ResponseDTO}
	 */
	ResponseDTO<SysRoleDTO> findSysRole(SysRoleDTO sysRoleDTO);
	
	/**
	 * Load Reference Data For SysRole Page
	 * @return {@link ResponseDTO}
	 */
	ResponseDTO<HashMap<String, Object>> getReferenceDataForSysRole();
	
	/**
	 * Get System Roles Data For Data Table
	 * @param dataTableRequestDTO
	 * @return {@link DataTableResponseDTO}
	 */
	DataTableResponseDTO getSysRolesForDataTable(DataTableRequestDTO dataTableRequestDTO);
}
