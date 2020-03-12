package com.dandan.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@JSONField(name = "userId")
	private Integer userId;
	@JSONField(name = "username")
	private String username;
	@JSONField(name = "password")
	private String password;
	@JSONField(name = "tel")
	private String tel;
	@JSONField(name = "email")
	private String email;
	@JSONField(name = "qq")
	private String qq;
}
