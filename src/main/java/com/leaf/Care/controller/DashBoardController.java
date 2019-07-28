package com.leaf.Care.controller;

import com.leaf.Care.dto.common.MainMenuDTO;
import com.leaf.Care.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(path = "dashBoard")
public class DashBoardController {

	private DashboardService dashboardService;

	@Autowired
	public DashBoardController(DashboardService dashboardService) {
		this.dashboardService = dashboardService;
	}

//	@RequestMapping(path = "/", method = RequestMethod.GET)
//	public ModelAndView viewUserRole() {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("dashBoard");
//		return mv;
//	}

	@RequestMapping(path = "/loadMainMenu", method = RequestMethod.POST)
	@ResponseBody
	public MainMenuDTO loadMainMenu() {
		return dashboardService.loadMainMenu();
	}

}
