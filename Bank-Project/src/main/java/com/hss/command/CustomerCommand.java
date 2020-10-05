package com.hss.command;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;

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
	private LocalDate dob;
	private String panNo;
	private long uid;
}
