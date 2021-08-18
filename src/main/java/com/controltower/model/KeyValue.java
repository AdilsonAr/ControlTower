package com.controltower.model;

import lombok.Data;
import lombok.*;

@Data
public class KeyValue {
	@Getter @Setter
	private String keyAttribute;
	@Getter @Setter
	private String valAttribute;
}
