package com.hradmin.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hradmin.dao.Impl.DepartmentMstRepository;
import com.hradmin.entity.DepartmentMaster;
import com.hradmin.exception.DAOException;

import lombok.extern.log4j.Log4j2;

/**
* @author Muntaseem Bijapure
*
*/
@Component
@Log4j2

public class HrAdminDAO {

	@Autowired
	DepartmentMstRepository depMstRepo;

	public void saveorUpdateDepartmentMasterDetail(DepartmentMaster departmentData) {
		log.info("Started HrAdminDAO :: saveorUpdateDepartmentMasterDetail");
		try {
			depMstRepo.save(departmentData);
		} catch (DAOException ex) {
			log.error("Error while saving/updating the record ::" , ex.getMessage());
			throw new DAOException("Error while saving/updating the record ::" + ex.getMessage());
		}
	}
}
