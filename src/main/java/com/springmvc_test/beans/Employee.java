package com.springmvc_test.beans;

import com.springmvc_test.validation.groups.First;
import com.springmvc_test.validation.groups.Second;
import lombok.*;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.ScriptAssert;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import javax.validation.GroupSequence;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false, of = {"id"})
@ScriptAssert(
        alias = "_this",//默认值，表示验证时，该对象的表示符号
        lang = "javascript",//固定写法
        script = "com.springmvc_test.validation.Check.checkParam(_this.lastName)",
        reportOn = "lastName")//出错时，错误作用在lastName字段上
public class Employee {
    private int id;
    @NotEmpty(groups = {First.class})
    @Length(min = 3, max = 10,
            message = "{lastName.length}",
            /* 分组验证 */groups = {First.class})
    private String lastName;
    @Email(message = "{Email.employee.email}", groups = Second.class)
    private String email;
    private String gender;
    private Department department;
    @Past(groups = {First.class})
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;
}
