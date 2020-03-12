package com.dandan.controller;

import com.dandan.dto.WelcomeDTO;
import com.dandan.model.RespResult;
import com.dandan.utils.RespUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class WelcomeController {

	@GetMapping("/")
	public RespResult welcome(){
		String message = "dandan";
		return RespUtil.successResp(new WelcomeDTO(message));
	}
}
