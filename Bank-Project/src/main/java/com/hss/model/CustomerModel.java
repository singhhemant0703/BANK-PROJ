package com.hss.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="CIF")
@Setter
@Getter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class CustomerModel implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CIF_NO", updatable = false)
	private long customerId;
	@Column(name="CUSTOMER_NAME")
	private String customerName;
	@Column(name="DATE_OF_BIRTH")
	private LocalDate dob;
	@Column(name="PAN_NO")
	private String panNo;
	@Column(name="AADHAR_NO")
	private long aadharNo;
}
