package com.springmvc_test.dao;

import com.springmvc_test.beans.Department;
import com.springmvc_test.beans.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class EmployeeDao {
    private static List<Employee> emps;
    private static List<Department> departments;
    static {
        departments = new ArrayList<>();
        Department department = new Department(10,"dept-1");
        Department department1 = new Department(20,"dept-2");
        Department department2 = new Department(30,"dept-3");
        departments.add(department);
        departments.add(department1);
        departments.add(department2);
        emps = new ArrayList<>();
        emps.add(new Employee(101,"张三","tom@qq.com","男",department,new Date()));
        emps.add(new Employee(102,"Marry","marry@qq.com","女",department2,new Date()));
        emps.add(new Employee(103,"Jack","jack@qq.com","男",department1,new Date()));
        emps.add(new Employee(104,"Alan","alan@qq.com","男",department,new Date()));
    }

    public List<Department> getDepartments(){
        return departments;
    }

    public List<Employee> getEmps(){
        return emps;
    }

    public Employee getEmpById(Integer id){
        for (Employee emp : emps) {
            if(id.equals(emp.getId())){
                return emp;
            }
        }
        return null;
    }

    public void add(Employee employee){
        employee.setId((int)(System.currentTimeMillis()%1000));
        emps.add(employee);
    }

    public void deleteEmpById(Integer id){
        emps.remove(getEmpById(id));
    }

    public void update(Employee employee){
        if(employee == null) return;
        if (this.getEmpById(employee.getId()) == null) {
            this.add(employee);
        } else {
            this.deleteEmpById(employee.getId());
            emps.add(employee);
        }
    }

}
