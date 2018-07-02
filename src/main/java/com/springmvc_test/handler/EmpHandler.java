package com.springmvc_test.handler;

import com.springmvc_test.beans.Employee;
import com.springmvc_test.services.EmpService;
import com.springmvc_test.validation.groups.First;
import com.springmvc_test.validation.groups.Second;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class EmpHandler {

    @Autowired
    private EmpService empService;

    @RequestMapping("/emps")
    public String list(Map<String, Object> map) {
        map.put("emps", empService.getEmployees());
        return "list";
    }

    @RequestMapping(value = "/emp", method = RequestMethod.GET)
    public String add(Map<String, Object> map) {
        map.put("employee", new Employee());
        map.put("depts", empService.geDepartments());
        List<String> genders = new ArrayList<>();
        genders.add("男");
        genders.add("女");
        map.put("genders", genders);
        return "input";
    }

    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    public String save(
            @ModelAttribute("employee") @Validated({First.class}) Employee employee,
            BindingResult result,
                       /*@RequestParam(value = "lastName1")
                               String lastName1,*/
            Map<String, Object> map) {


        /*if(!lastName1.equals(employee.getLastName())){
            result.rejectValue("lastName","not_equal");
        }*/
        if (result.getErrorCount() > 0) {

            errorResult(map);
            return "input";
        }
        empService.add(employee);
        return "redirect:/emps";
    }

    @RequestMapping(value = "/emp/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id) {
        empService.delete(id);
        return "redirect:/emps";
    }

    @RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") Integer id, Map<String, Object> map) {
        map.put("employee", empService.getEmpById(id));
        map.put("depts", empService.geDepartments());
        List<String> genders = new ArrayList<>();
        genders.add("男");
        genders.add("女");
        map.put("genders", genders);
        return "input";
    }

    @ModelAttribute
    public void getEmp(@RequestParam(value = "id", required = false) Integer id, Map<String, Object> map) {
        if (id != null) {
            map.put("employee", empService.getEmpById(id));
        }
    }

    @RequestMapping(value = "/emp", method = RequestMethod.PUT)
    public String update(@Validated(value = Second.class) Employee employee
            , BindingResult result, Map<String, Object> map) {
        if (result.hasErrors()) {
            errorResult(map);
            return "input";
        }
        empService.update(employee);
        return "redirect:/emps";
    }

    public void errorResult(Map<String, Object> map) {
        map.put("depts", empService.geDepartments());
        List<String> genders = new ArrayList<>();
        genders.add("男");
        genders.add("女");
        map.put("genders", genders);
    }

    /**
     * 对WebDataBinder初始化，对表单数据转换格式化
     * 该方法不能有返回值，参数为 WebDataBinder 对象
     * 可以设置一些选项
     * @param binder
     */
    @InitBinder
    public void bind(WebDataBinder binder){
        // binder.setDisallowedFields("lastName"); 不对 lastName 属性赋值
        // ……
    }

}
