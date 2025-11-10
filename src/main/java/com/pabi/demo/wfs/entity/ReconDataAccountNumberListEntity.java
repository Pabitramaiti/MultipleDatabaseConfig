package com.pabi.demo.wfs.entity;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Immutable
@Table(name = "bios_wfs_out_recon_data_account_list", schema="AUX")
public class ReconDataAccountNumberListEntity {

	@Id
	//@GeneratedValue(strategy = GenerationType.TABLE)
	@JdbcTypeCode(SqlTypes.VARCHAR)
	@Column(name = "accountnumber", length = 50)
	private String accountNumber;

	@JdbcTypeCode(SqlTypes.VARCHAR)
	@Column(name = "clientid", length = 50)
	private String clientId;

	@JdbcTypeCode(SqlTypes.VARCHAR)
	@Column(name = "status", length = 50)
	private String status;
}
