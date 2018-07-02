package com.springmvc_test.services;

import com.springmvc_test.beans.Department;
import com.springmvc_test.beans.Employee;
import com.springmvc_test.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {

    @Autowired
    private EmployeeDao employeeDao;

    public List<Employee> getEmployees(){
        return employeeDao.getEmps();
    }

    public List<Department> geDepartments(){
        return employeeDao.getDepartments();
    }

    public Employee getEmpById(Integer id){
        return employeeDao.getEmpById(id);
    }

    public void delete(Integer id){
        employeeDao.deleteEmpById(id);
    }

    public void add(Employee employee){
        employeeDao.add(employee);
    }

    public void update(Employee employee){
        employeeDao.update(employee);
    }

}
