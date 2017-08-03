package com.ssm.service;

import com.ssm.beans.Employee;
import com.ssm.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by qiaoz on 2017/7/19.
 */
@Service
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    public List<Employee> getAllEmps(){return employeeMapper.getAllEmps();}
    public void saveEmp(Employee employee){
        employeeMapper.saveEmp(employee);
    }
    public void deleteEmp(Integer id){
        employeeMapper.deleteEmp(id);
    }
    public Employee getEmpById(Integer id) {return employeeMapper.getEmpById(id);}
    public void updateEmp(Employee employee) {
        employeeMapper.updateEmp(employee);
    }
}
