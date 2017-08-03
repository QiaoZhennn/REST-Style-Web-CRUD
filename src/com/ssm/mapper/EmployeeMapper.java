package com.ssm.mapper;

import com.ssm.beans.Employee;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by qiaoz on 2017/7/19.
 */
public interface EmployeeMapper {
    List<Employee> getAllEmps();
    void saveEmp(Employee employee);
    void deleteEmp(Integer id);
    Employee getEmpById(Integer id);
    void updateEmp(Employee employee);
}
