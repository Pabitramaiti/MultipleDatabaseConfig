package com.pabi.demo.dpm.entity;

import java.time.ZonedDateTime;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "order_table")
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JdbcTypeCode(SqlTypes.VARCHAR)
	@Column(name = "orderid", length = 50, nullable = false)
	private String orderId;

	@JdbcTypeCode(SqlTypes.VARCHAR)
	@Column(name = "client", length = 50)
	private String client;

	@Column(name = "recieved_time", nullable = false, columnDefinition = "TIMESTAMPTZ NOT NULL DEFAULT NOW()")
	private ZonedDateTime recievedTime;

	@Column(name = "updated_time", nullable = true, columnDefinition = "TIMESTAMPTZ")
	private ZonedDateTime updatedTime;

	@JdbcTypeCode(SqlTypes.VARCHAR)
	@Column(name = "channel", length = 50)
	private String channel;

	@JdbcTypeCode(SqlTypes.VARCHAR)
	@Column(name = "distribution_id", length = 50)
	private String distributionId;

	@JdbcTypeCode(SqlTypes.VARCHAR)
	@Column(name = "job_name", length = 50)
	private String jobName;

	@JdbcTypeCode(SqlTypes.VARCHAR)
	@Column(name = "status", length = 50)
	private String status;

	@JdbcTypeCode(SqlTypes.VARCHAR)
	@Column(name = "correlation_id", length = 100)
	private String correlationId;

	@JdbcTypeCode(SqlTypes.VARCHAR)
	@Column(name = "print_flag", length = 50)
	private String printFlag;

	@Basic(fetch = FetchType.LAZY)
	@Column(name = "orderdata", columnDefinition = "TEXT")
	private String orderData;

	@Basic(fetch = FetchType.LAZY)
	@Column(name = "orderdata_s3location", columnDefinition = "TEXT")
	private String orderData_S3location;

	@JdbcTypeCode(SqlTypes.VARCHAR)
	@Column(name = "traceid", length = 100)
	private String traceId;

	@JdbcTypeCode(SqlTypes.INTEGER)
	@Column(name = "narr_sequence", columnDefinition = "INTEGER DEFAULT 0")
	private int commuNarrativeSequence;

	@JdbcTypeCode(SqlTypes.VARCHAR)
	@Column(name = "facility", length = 50)
	private String facility;

	@JdbcTypeCode(SqlTypes.VARCHAR)
	@Column(name = "packages", length = 150)
	private String packages;

	@JdbcTypeCode(SqlTypes.VARCHAR)
	@Column(name = "parent_order", length = 100)
	private String parent_order;

	@JdbcTypeCode(SqlTypes.VARCHAR)
	@Column(name = "shipping_id", length = 100)
	private String shipping_id;

	@JdbcTypeCode(SqlTypes.VARCHAR)
	@Column(name = "inserts", length = 100)
	private String inserts;

}
