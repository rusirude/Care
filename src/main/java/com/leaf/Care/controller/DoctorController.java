package com.leaf.Care.controller;

import com.leaf.Care.dto.DoctorDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Rusiru on 21-Jul-19.
 */

@RestController
@RequestMapping(value = "doctor")
public class DoctorController {

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
    public List<DoctorDTO> getDoctors(){
        List<DoctorDTO> doctorDTOs = new ArrayList<>();
        DoctorDTO doctorDTO = new DoctorDTO();
        doctorDTO.setId((long) 1);
        doctorDTO.setName("Dr. Harshan");
        doctorDTO.setContactNo("0768371019");
        doctorDTO.setEmail("harshan@ymail.com");

        doctorDTOs.add(doctorDTO);

        return doctorDTOs;


    }
}
