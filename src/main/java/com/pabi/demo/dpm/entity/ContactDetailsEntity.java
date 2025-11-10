package com.pabi.demo.dpm.entity;

import java.time.ZonedDateTime;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contact_details")
public class ContactDetailsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JdbcTypeCode(SqlTypes.VARCHAR)
	@Column(name = "orderid", length = 50, nullable = false)
	private String orderId;

	@JdbcTypeCode(SqlTypes.VARCHAR)
	@Column(name = "name", length = 100)
	private String name;

	@JdbcTypeCode(SqlTypes.VARCHAR)
	@Column(name = "first_name", length = 50)
	private String firstName;

	@JdbcTypeCode(SqlTypes.VARCHAR)
	@Column(name = "last_name", length = 50)
	private String lastName;

	@JdbcTypeCode(SqlTypes.VARCHAR)
	@Column(name = "value", length = 50)
	private String value;

	@JdbcTypeCode(SqlTypes.VARCHAR)
	@Column(name = "address_line1", length = 100)
	private String addressLine1;

	@JdbcTypeCode(SqlTypes.VARCHAR)
	@Column(name = "address_line2", length = 100)
	private String addressLine2;

	@JdbcTypeCode(SqlTypes.VARCHAR)
	@Column(name = "city", length = 50)
	private String city;

	@JdbcTypeCode(SqlTypes.VARCHAR)
	@Column(name = "province_country", length = 50)
	private String provinceCountry;

	@JdbcTypeCode(SqlTypes.VARCHAR)
	@Column(name = "zip_code", length = 8)
	private String zipCode;

	@JdbcTypeCode(SqlTypes.VARCHAR)
	@Column(name = "country", length = 50)
	private String country;

	@Column(name = "recieved_time", nullable = false, columnDefinition = "TIMESTAMPTZ NOT NULL DEFAULT NOW()")
	private ZonedDateTime recievedTime;

	@Column(name = "updated_time", nullable = true, columnDefinition = "TIMESTAMPTZ")
	private ZonedDateTime updatedTime;

}
