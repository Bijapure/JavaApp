package com.hradmin.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class DepartmentDTO {
	private Integer departmentId;

	@NotEmpty(message = "departmentName can't be empty")
	private String departmentName;
	@NotEmpty(message = "departmentType can't be empty")
	private String departmentType;
	@NotEmpty(message = "hod can't be empty")
	private String hod;
	@NotEmpty(message = "misCats can't be empty")
	private String misCats;

}
