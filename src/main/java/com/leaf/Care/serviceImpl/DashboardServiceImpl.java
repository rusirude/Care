package com.leaf.Care.serviceImpl;

import com.leaf.Care.dao.SysRoleAuthorityDAO;
import com.leaf.Care.dao.SysUserAuthorityDAO;
import com.leaf.Care.dao.SysUserDAO;
import com.leaf.Care.dto.common.MainMenuDTO;
import com.leaf.Care.dto.common.MenuDTO;
import com.leaf.Care.dto.common.MenuSectionDTO;
import com.leaf.Care.entity.AuthorityEntity;
import com.leaf.Care.entity.SysRoleEntity;
import com.leaf.Care.entity.SysUserEntity;
import com.leaf.Care.enums.DefaultStatusEnum;
import com.leaf.Care.service.DashboardService;
import com.leaf.Care.utility.CommonMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author : rusiru on 7/6/19.
 */

@Service
public class DashboardServiceImpl implements DashboardService {

    private CommonMethod commonMethod;
    private SysRoleAuthorityDAO sysRoleAuthorityDAO;
    private SysUserAuthorityDAO sysUserAuthorityDAO;
    private SysUserDAO sysUserDAO;


    @Autowired
    public DashboardServiceImpl(CommonMethod commonMethod, SysRoleAuthorityDAO sysRoleAuthorityDAO, SysUserAuthorityDAO sysUserAuthorityDAO, SysUserDAO sysUserDAO) {
        this.commonMethod = commonMethod;
        this.sysRoleAuthorityDAO = sysRoleAuthorityDAO;
        this.sysUserAuthorityDAO = sysUserAuthorityDAO;
        this.sysUserDAO = sysUserDAO;
    }

    public MainMenuDTO loadMainMenu(){

        Map<String, Set<AuthorityEntity>> menuMap = new HashMap<>();

        SysUserEntity user = sysUserDAO.getSysUserEntityByUsername(commonMethod.getUsername());

        List<SysRoleEntity> sysRoles = new ArrayList<>();
        user.getSysUserSysRoleEntities()
                .forEach(sysUserSysRole -> {
                    sysRoles.add(sysUserSysRole.getSysRoleEntity());
                });
        if (! sysRoles.isEmpty()) {
            sysRoleAuthorityDAO.getSysRoleAuthorityEntitiesBySysRolesAndAnuthorityStatusAndSysRoleStatus(sysRoles, DefaultStatusEnum.ACTIVE.getCode(),DefaultStatusEnum.ACTIVE.getCode())
                    .stream()
                    .forEach(roleAuthority -> {
                        String key = roleAuthority.getAuthorityEntity().getSectionEntity().getCode()+"-"+roleAuthority.getAuthorityEntity().getSectionEntity().getDescription();
                        if(! menuMap.containsKey(key)){
                            Set<AuthorityEntity> set = new HashSet<>();
                            set.add(roleAuthority.getAuthorityEntity());
                            menuMap.put(key, set);
                        }
                        else{
                            menuMap.get(key).add(roleAuthority.getAuthorityEntity());
                        }
                    });
        }

        sysUserAuthorityDAO.getSysUserAuthorityEntitiesBySysUser(user.getUsername())
                .stream()
                .forEach(userAuthority -> {
                    String key = userAuthority.getAuthorityEntity().getSectionEntity().getCode()+"-"+userAuthority.getAuthorityEntity().getSectionEntity().getDescription();

                    long isEnabled = userAuthority.getIsGrant();
                    if(isEnabled == 1) {
                        if(! menuMap.containsKey(key)){
                            Set<AuthorityEntity> set = new HashSet<>();
                            set.add(userAuthority.getAuthorityEntity());
                            menuMap.put(key, set);
                        }
                        else{
                            menuMap.get(key).add(userAuthority.getAuthorityEntity());
                        }
                    }
                    else {
                        if(menuMap.containsKey(key)){
                            menuMap.get(key).remove(userAuthority.getAuthorityEntity());
                        }
                    }

                });



        List<MenuSectionDTO> sectionDTOs = menuMap.entrySet()
                    .stream()
                    .map(stringSetEntry -> {
                        MenuSectionDTO section = new MenuSectionDTO();
                        section.setDescription(stringSetEntry.getKey().split("-")[1]);
                        List<MenuDTO> menu = stringSetEntry.getValue().stream().map(authorityEntity -> {
                            MenuDTO menuItem = new MenuDTO();
                            menuItem.setDescription(authorityEntity.getDescription());
                            menuItem.setUrl(authorityEntity.getUrl());
                            return menuItem;
                        }).collect(Collectors.toList());
                        section.setMenuDTOs(menu);
                        return section;
                    }).collect(Collectors.toList());

        return new MainMenuDTO(sectionDTOs);
    }
}
