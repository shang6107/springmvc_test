package com.springmvc_test.converters;

import com.springmvc_test.beans.Employee;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 自定义类型转换器：
 *
 *      1.需要实现 org.springframework.core.convert.converter.Converter
 *          重写 convert() 方法
 *      2.将该类注册到 MVC-IOC 容器中
 *      3.MVC.xml的配置：
 *          <bean class="org.springframework.context.support.ConversionServiceFactoryBean" id="conversionService">
                 <property name="converters">
                     <set>
                        <ref bean="myConverterService"/>
                    </set>
                </property>
            </bean>
*       需求：
 *          将 字符串 LASTNAME-EMAIL-GENDER-BIRTH 转换为一个 Employee对象
 *            aaaa-aaa@qq.com-男-2001/01/01
 */
@Component
public class MyConverterService implements Converter<String,Employee> {
    @Override
    public Employee convert(String s) {
        String[] fields = null;
        if(s != null)
         fields = s.split("-");
        if(fields != null && fields.length == 4){
           Employee employee = new Employee();
           employee.setLastName(fields[0]);
           employee.setEmail(fields[1]);
           employee.setGender(fields[2]);
            try {
                employee.setBirth(new SimpleDateFormat("yyyy/MM/dd").parse(fields[3]));
            } catch (ParseException e) {
                return null;
            }
            System.out.println("employee = " + employee);
            return employee;
        }

        return null;
    }
}
