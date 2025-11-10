package com.pabi.demo.exception;

import java.time.ZonedDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {
	private String message;
	private int status;
	private String details;
	private ZonedDateTime timestamp;
}
