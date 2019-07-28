package com.leaf.Care.service;

import com.leaf.Care.dto.common.MainMenuDTO;

/**
 * @author : rusiru on 7/6/19.
 */
public interface DashboardService {

    /**
     * Load Menu For Logged User
     *
     * @return MainMenuDTO
     */
    MainMenuDTO loadMainMenu();
}
