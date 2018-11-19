package com.lyj.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.lyj.dto.User;
import com.lyj.dto.UserQueryCondition;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @auther lyj
 * @date 2018/11/17 0017 下午 16:02
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @PostMapping
    public User create(@Valid @RequestBody User user, BindingResult errors){

        if(errors.hasErrors()){
            errors.getAllErrors().stream().forEach(error-> System.out.println(error.getDefaultMessage()));
        }
        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getDate());
        user.setId("1");
        return user;
    }

    @PutMapping(value = "/{id:\\d+}")
    public User update(@Valid @RequestBody User user, BindingResult errors){

        if(errors.hasErrors()){
            errors.getAllErrors().stream().forEach(error->{
//                FieldError fieldError=(FieldError) error;
//                String message=fieldError.getField()+"  "+error.getDefaultMessage();
//                System.out.println(message);
                        System.out.println(error.getDefaultMessage());
             }
            );
        }
        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getDate());
        user.setId("1");
        return user;
    }


    @GetMapping
    @JsonView(User.UserSimpleview.class)
//    @RequestParam(name="username",required = false,defaultValue = "tom")
    public List<User> query(UserQueryCondition Condition, @PageableDefault(page = 2,size = 17,sort = "username,asc") Pageable pageable) {
        System.out.println(ReflectionToStringBuilder.toString(Condition, ToStringStyle.MULTI_LINE_STYLE));
        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getSort());
        List<User> users=new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;

    }


    @GetMapping (value = "/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getInfo(@PathVariable(name = "id") String id){
        User user=new User();
        user.setUsername("tom");

        return user;
    }


    @DeleteMapping(value = "/{id:\\d+}")
    public void delete(@PathVariable String id){
        System.out.println(id);
    }

}
