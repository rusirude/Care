package com.leaf.Care.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leaf.Care.dao.SysRoleDAO;
import com.leaf.Care.dao.SysUserDAO;
import com.leaf.Care.dao.SysUserSysRoleDAO;
import com.leaf.Care.dto.SysUserDTO;
import com.leaf.Care.dto.SysUserSysRoleDTO;
import com.leaf.Care.dto.common.DataTableResponseDTO;
import com.leaf.Care.dto.common.DropDownDTO;
import com.leaf.Care.dto.common.ResponseDTO;
import com.leaf.Care.entity.SysRoleEntity;
import com.leaf.Care.entity.SysUserEntity;
import com.leaf.Care.entity.SysUserSysRoleEntity;
import com.leaf.Care.entity.SysUserSysRoleEntityId;
import com.leaf.Care.enums.DefaultStatusEnum;
import com.leaf.Care.enums.ResponseCodeEnum;
import com.leaf.Care.service.SysUserSysRoleService;

@Service
public class SysUserSysRoleServiceImpl implements SysUserSysRoleService {
	
	private SysUserDAO sysUserDAO;
	private SysRoleDAO sysRoleDAO;
	private SysUserSysRoleDAO sysUserSysRoleDAO;
	
	@Autowired
	public SysUserSysRoleServiceImpl(SysUserDAO sysUserDAO, SysRoleDAO sysRoleDAO,
			SysUserSysRoleDAO sysUserSysRoleDAO) {		
		this.sysUserDAO = sysUserDAO;
		this.sysRoleDAO = sysRoleDAO;
		this.sysUserSysRoleDAO = sysUserSysRoleDAO;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public DataTableResponseDTO getSysUserSysRoleForSysUser(SysUserDTO sysUserDTO) {
		Map<String, SysUserSysRoleDTO> sysUserSysRoleMap = new HashMap<>();
		List<SysUserSysRoleDTO> sysUserSysRoles = new ArrayList<>();
		DataTableResponseDTO responseDTO = new DataTableResponseDTO();
		try {
			SysUserEntity sysUserEntity = sysUserDAO.getSysUserEntityByUsername(sysUserDTO.getUsername());

			sysRoleDAO.findAllSysRoleEntities(DefaultStatusEnum.ACTIVE.getCode()).stream()
					.forEach(sysRoleEntity -> {
						SysUserSysRoleDTO sysUserSysRoleDTO = new SysUserSysRoleDTO();
						sysUserSysRoleDTO.setUsername(sysUserEntity.getUsername());
						sysUserSysRoleDTO.setName(sysUserEntity.getName());
						sysUserSysRoleDTO.setSysRoleCode(sysRoleEntity.getCode());
						sysUserSysRoleDTO.setSysRoleDescription(sysRoleEntity.getDescription());
						sysUserSysRoleDTO.setEnable(false);

						sysUserSysRoleMap.put(sysUserSysRoleDTO.getSysRoleCode(), sysUserSysRoleDTO);

					});

			sysUserSysRoleDAO.getSysUserSysRoleEntitiesBySysUser(sysUserEntity.getUsername()).stream()
					.forEach(sysUserSysRole -> {
						SysUserSysRoleDTO sysUserSysRoleDTO = sysUserSysRoleMap.get(sysUserSysRole.getSysRoleEntity().getCode());
						sysUserSysRoleDTO.setEnable(true);
						sysUserSysRoleMap.put(sysUserSysRoleDTO.getSysRoleCode(), sysUserSysRoleDTO);
					});

			sysUserSysRoles = sysUserSysRoleMap.values().stream().collect(Collectors.toList());
			responseDTO.setData(sysUserSysRoles);

		} catch (Exception e) {
			System.err.println("Getting SysUSer SysRole for Sys User Issue");
			responseDTO.setData(sysUserSysRoles);
		}
		return responseDTO;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public ResponseDTO<HashMap<String, Object>> getReferenceDataForSysUserSysRole() {
		HashMap<String, Object> map = new HashMap<>();
		String code = ResponseCodeEnum.FAILED.getCode();
		try {
			
			List<DropDownDTO> sysUser = sysUserDAO.findAllSysUsereEntities(DefaultStatusEnum.ACTIVE.getCode())
					.stream()
					.map(su-> new DropDownDTO(su.getUsername(),su.getUsername())).collect(Collectors.toList());

			map.put("sysUser", sysUser);

			code = ResponseCodeEnum.SUCCESS.getCode();
		} catch (Exception e) {
			System.err.println("Sys User Sys Role Ref Data Issue");
		}
		return new ResponseDTO<HashMap<String, Object>>(code, map);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public ResponseDTO<SysUserSysRoleDTO> saveSysUserSysRole(SysUserSysRoleDTO sysUserSysRoleDTO) {
		String code = ResponseCodeEnum.FAILED.getCode();
		String description = "Sys User Sys Role Save Faield";
		try {		
			SysUserSysRoleEntity sysUserSysRoleEntity = new SysUserSysRoleEntity();
			SysUserSysRoleEntityId id = new SysUserSysRoleEntityId();
			
			
			SysUserEntity sysUserEntity = sysUserDAO.getSysUserEntityByUsername(sysUserSysRoleDTO.getUsername());
			SysRoleEntity sysRoleEntity = sysRoleDAO.findSysRoleEntityByCode(sysUserSysRoleDTO.getSysRoleCode());
			
			
			id.setSysUser(sysUserEntity.getUsername());
			id.setSysRole(sysRoleEntity.getId());
			
			sysUserSysRoleEntity.setSysUserSysRoleEntityId(id);
			sysUserSysRoleEntity.setSysUserEntity(sysUserEntity);
			sysUserSysRoleEntity.setSysRoleEntity(sysRoleEntity);
			
			
			sysUserSysRoleDAO.saveSysUserSysRoleEntity(sysUserSysRoleEntity);
			
			description = "Sys User Sys Role Save Successfully";
			code = ResponseCodeEnum.SUCCESS.getCode();
		} catch (Exception e) {
			System.err.println("SysUSerSysRole Save Issue");
		}
		return new ResponseDTO<SysUserSysRoleDTO>(code, description);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public ResponseDTO<SysUserSysRoleDTO> deleteSysUserSysRole(SysUserSysRoleDTO sysUserSysRoleDTO) {
		String code = ResponseCodeEnum.FAILED.getCode();
		String description = "Sys User Sys Role Delete Faield";
		try {			
			
			SysUserEntity sysUserEntity = sysUserDAO.getSysUserEntityByUsername(sysUserSysRoleDTO.getUsername());
			SysRoleEntity sysRoleEntity = sysRoleDAO.findSysRoleEntityByCode(sysUserSysRoleDTO.getSysRoleCode());			
			
			sysUserSysRoleDAO.deleteSysUserSysRoleEntityBySysUserAndSysRole(sysUserEntity.getUsername(), sysRoleEntity.getId());
			
			description = "Sys User Sys Role Delete Successfully";
			code = ResponseCodeEnum.SUCCESS.getCode();
		} catch (Exception e) {
			System.err.println("SysUserSysRole Delete Issue");
		}
		return new ResponseDTO<SysUserSysRoleDTO>(code, description);
	}

}
