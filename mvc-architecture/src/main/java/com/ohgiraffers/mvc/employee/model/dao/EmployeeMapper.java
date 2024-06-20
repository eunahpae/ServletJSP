package com.ohgiraffers.mvc.employee.model.dao;

import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeMapper {

    List<EmployeeDTO> selectAllEmp();

    EmployeeDTO selectOneEmpById(String empId);

    Integer selectNewEmpId();

    int insertEmp(EmployeeDTO emp);

    int updateEmp(EmployeeDTO emp);

    int deleteEmp(String empId);

}
