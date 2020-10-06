package com.hss.command;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CustomerCommand implements Serializable {

	private long customerId;
	private String customerName;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dob;
	private String panNo;
	private long aadharNo;
}
