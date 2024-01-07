package com.lite.thinking.store.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Price {
	private int id;
	private String currency;
	private float value;
}
