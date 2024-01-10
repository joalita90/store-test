package com.lite.thinking.store.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
	private int id;
	private String username;
	private String password;
	private String typeUser;
}
