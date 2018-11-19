package com.lyj.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.lyj.validator.Myconstraint;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Past;
import java.util.Date;

/**
 * @auther lyj
 * @date 2018/11/17 0017 下午 16:06
 */
@Data
public class User {

    public interface UserSimpleview {};
    public interface UserDetailView extends UserSimpleview{};

    private String id;

  @JsonView(UserSimpleview.class)
  @Myconstraint(message = "这是一个测试")
    private String username;

  @JsonView(UserDetailView.class)
  @NotBlank(message = "密码不能为空")
    private String password;

  @JsonView(UserSimpleview.class)
  @Past(message = "生日必须是过去的时间")
    private Date date;

}
