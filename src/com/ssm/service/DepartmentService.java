package com.ssm.service;

import com.ssm.beans.Department;
import com.ssm.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by qiaoz on 2017/7/19.
 */
@Service
public class DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;
    public List<Department> getAllDepts(){
        return departmentMapper.getAllDepts();
    }
}
