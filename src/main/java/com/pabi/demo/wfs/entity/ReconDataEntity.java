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
@Table(name = "bios_wfs_out_recon", schema = "AUX")
public class ReconDataEntity {

	@Id
	// @GeneratedValue(strategy = GenerationType.TABLE)
	@JdbcTypeCode(SqlTypes.VARCHAR)
	@Column(name = "filename", length = 200)
	private String fileName;

	@JdbcTypeCode(SqlTypes.VARCHAR)
	@Column(name = "accountnumber", length = 50)
	private String accountNumber;

	@JdbcTypeCode(SqlTypes.VARCHAR)
	@Column(name = "clientid", length = 50)
	private String clientID;

	@JdbcTypeCode(SqlTypes.VARCHAR)
	@Column(name = "status", length = 50)
	private String status;

	@JdbcTypeCode(SqlTypes.VARCHAR)
	@Column(name = "partytype", length = 50)
	private String partyType;

	// @JdbcTypeCode(SqlTypes.VARCHAR)
	@Column(name = "errorjson", columnDefinition = "TEXT")
	private String errorJson;

	/*
	 * @Column(name = "updatedtime", nullable = true, columnDefinition =
	 * "TIMESTAMPTZ") private ZonedDateTime updatedTime;
	 */

	public ReconDataEntity(String fileName, String status) {
		this.fileName = fileName;
		this.status = status;
	}
}
