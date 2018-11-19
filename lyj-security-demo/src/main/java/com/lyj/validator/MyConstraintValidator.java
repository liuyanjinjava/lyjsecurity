package com.lyj.validator;


import com.lyj.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @auther lyj
 * @date 2018/11/19 0019 下午 15:20
 */
public class MyConstraintValidator implements ConstraintValidator<Myconstraint,Object> {
    @Autowired
    private HelloService helloService;

    @Override
    public void initialize(Myconstraint myconstraint) {
        System.out.println("my validator init");
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        helloService.greeting("tom");
        System.out.println(o);
        return true;
    }
}
