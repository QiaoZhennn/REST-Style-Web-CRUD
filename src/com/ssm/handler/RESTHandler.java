package com.ssm.handler;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.beans.Department;
import com.ssm.beans.Employee;
import com.ssm.service.DepartmentService;
import com.ssm.service.EmployeeService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * Created by qiaoz on 2017/7/19.
 */
@Controller
public class RESTHandler {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/emps")
    public String emps(Map<String,Object> map){
        List<Employee> emps = employeeService.getAllEmps();

        //PageHelper
//        Page<Object> page= PageHelper.startPage(2,2);
//        System.out.println("");
//        System.out.println("Total: "+page.getTotal());
//        System.out.println("Total page: "+page.getPages());
//        System.out.println("Current Page: "+page.getPageNum());
//        System.out.println();
//        PageInfo<Employee> info=new PageInfo<>(emps,3);
//        int[] nums = info.getNavigatepageNums();
//        for(int i:nums){
//            System.out.print("\t"+i);
//        }

        map.put("emps",emps);
        return "list";
    }
    @RequestMapping(value = "/emp",method = RequestMethod.GET)
    public String toAddPage(Map<String,Object> map){
        Collection<Department> allDepts = departmentService.getAllDepts();
        map.put("departments",allDepts);
        map.put("employee",new Employee());
        return "update";
    }
    @RequestMapping(value = "/emp",method = RequestMethod.POST)
    public String addEmp(Employee employee){
        employeeService.saveEmp(employee);
        return "redirect:/emps";
    }
    @RequestMapping(value = "/emp/{id}",method = RequestMethod.DELETE)
    public String deleteEmp(@PathVariable Integer id){
        employeeService.deleteEmp(id);
        return "redirect:/emps";
    }
    @RequestMapping(value = "/emp/{id}",method = RequestMethod.GET)
    public String toUpdatePage(@PathVariable Integer id,Map<String,Object> map){
        Employee employee = employeeService.getEmpById(id);
        map.put("departments",departmentService.getAllDepts());
        map.put("employee",employee);
        return "update";
    }
    @RequestMapping(value = "/emp",method = RequestMethod.PUT)
    public String updateEmp(Employee employee){
        employeeService.updateEmp(employee);
        return "redirect:/emps";
    }
    @ModelAttribute
    public void setEmployee(@RequestParam(value = "id",required = false) Integer id,Map<String,Object> map){
        if(id!=null){
            Employee employee=employeeService.getEmpById(id);
            map.put("employee",employee);
        }
    }
}
