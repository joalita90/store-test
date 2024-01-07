package com.lite.thinking.store.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {
	
	private int id;
	private String username;
	private String password;
	private int typeUser;

}
