package com.hradmin.service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hradmin.dao.HrAdminDAO;
import com.hradmin.dao.Impl.DepartmentMstRepository;
import com.hradmin.dto.DepartmentDTO;
import com.hradmin.entity.DepartmentMaster;
import com.hradmin.exception.RecordsNotFoundException;
import com.hradmin.service.HrAdminService;
import com.hradmin.utils.ApplicationUtils;

import lombok.extern.log4j.Log4j2;

/**
 * @author Muntaseem Bijapure
 *
 */
@Service
@Log4j2
public class HrAdminServiceImpl implements HrAdminService {

	@Autowired
	public HrAdminDAO hrAdminDAO;

	@Autowired
	DepartmentMstRepository depMstRepo;

	/**
	 * @param departmentDTO
	 *
	 * @return
	 */
	@Override
	public void addUpdateDeparmentMaster(DepartmentDTO departmentDTO) {
		log.info("Started HrAdminServiceImpl :: addUpdateDeparmentMaster");
		DepartmentMaster departmentData = ApplicationUtils.entityToDto(departmentDTO, DepartmentMaster::new);
		if (!ApplicationUtils.isObjectNull(departmentData.getDepartmentId())) {
			Optional<DepartmentMaster> depData = depMstRepo.findById(departmentDTO.getDepartmentId());
			if (depData.get()!=null) {
				departmentData = depData.get();
				departmentData.setDepartmentName(departmentDTO.getDepartmentName());
				departmentData.setDepartmentType(departmentDTO.getDepartmentType());
				departmentData.setHod(departmentDTO.getHod());
				departmentData.setMisCats(departmentDTO.getMisCats());
				hrAdminDAO.saveorUpdateDepartmentMasterDetail(departmentData);
			} else {
				log.error("No record found for id  {} ::", departmentDTO.getDepartmentId());
				throw new RecordsNotFoundException("No record Found for Id :: " + departmentDTO.getDepartmentId());
			}

		} else {
			hrAdminDAO.saveorUpdateDepartmentMasterDetail(departmentData);
		}
	}

}
