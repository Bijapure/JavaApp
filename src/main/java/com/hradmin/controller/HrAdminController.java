package com.hradmin.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hradmin.dto.DepartmentDTO;
import com.hradmin.service.HrAdminService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.log4j.Log4j2;

/**
 * @author Muntaseem Bijapure
 *
 */
@RestController
@CrossOrigin
@Log4j2
@Validated
@RequestMapping("/v1/")
public class HrAdminController {

	@Autowired
	public HrAdminService hrAdminService;

	/**
	 * API to save/update department master detail to database.
	 * 
	 * @param departmentDTO
	 * @return
	 */
	@PostMapping("department/master")
	@ApiOperation(value = "service to add department details", notes = "Returns success when record is added")
	@ApiResponses({ @ApiResponse(code = 200, message = "When Department master details saved successfully"),
			@ApiResponse(code = 500, message = "While any error occured") })
	public String addUpdateDeparmentMaster(@Valid @RequestBody DepartmentDTO departmentDTO) {
		log.info("started HrAdminController :: addUpdateDeparmentMaster");
		hrAdminService.addUpdateDeparmentMaster(departmentDTO);
		return "success";
	}

}
