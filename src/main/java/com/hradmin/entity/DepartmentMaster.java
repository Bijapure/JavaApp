package com.hradmin.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
* @author Muntaseem Bijapure
*
*/
@Entity
@Data
public class DepartmentMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer departmentId;
	private String departmentName;
	private String departmentType;
	private String hod;
	private String misCats;
	
}
