package com.dandan.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WelcomeDTO {
	private Date time;
	private String message;

	public WelcomeDTO(String message){
		this.message = message;
		this.time =new Date();
	}
}
