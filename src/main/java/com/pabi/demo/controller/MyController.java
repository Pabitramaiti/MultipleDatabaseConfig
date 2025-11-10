package com.pabi.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pabi.demo.dpm.entity.ContactDetailsEntity;
import com.pabi.demo.dpm.entity.OrderEntity;
import com.pabi.demo.services.DPMService;
import com.pabi.demo.services.WFSService;
import com.pabi.demo.wfs.entity.ReconDataAccountNumberListEntity;
import com.pabi.demo.wfs.entity.ReconDataEntity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/multidbconn/api")
public class MyController {

	@Autowired
	private DPMService service;

	@Autowired
	private WFSService wfsService;

	@GetMapping(value = "/getorderdetails")
	public Optional<OrderEntity> getOrderById(@RequestParam(required = true, defaultValue = "10") Long id) {
		log.info("getOrderById.............");
		return service.getOrderById(id);
	}

	@GetMapping("/getcontactdetails")
	public Optional<ContactDetailsEntity> getContactDetailsById(@RequestParam(required = true, defaultValue = "10") Long id) {
		log.info("getContactDetailsById.............");
		return service.getContactDetailsById(id);
	}

	@GetMapping(value = "/getWfsReconData")
	public ResponseEntity<List<ReconDataEntity>> getWfsReconData() {
		log.info("getWfsReconData.............");
		return new ResponseEntity<>(wfsService.getAllReconData(), HttpStatus.OK);
	}

	@GetMapping(value = "/getExtractedData")
	public ResponseEntity<List<ReconDataAccountNumberListEntity>> getReconDataAccountNumberList() {
		log.info("getReconDataAccountNumberList.............");
		return new ResponseEntity<>(wfsService.getAllReconDataAccountNumberList(), HttpStatus.OK);
	}
}
