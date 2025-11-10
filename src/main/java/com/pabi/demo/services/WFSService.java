package com.pabi.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pabi.demo.wfs.entity.ReconDataAccountNumberListEntity;
import com.pabi.demo.wfs.entity.ReconDataEntity;
import com.pabi.demo.wfs.repository.WFSReconDataAccountNumberListRepository;
import com.pabi.demo.wfs.repository.WFSReconRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class WFSService {

	@Autowired
	private WFSReconRepository fileRepository;

	@Autowired
	private WFSReconDataAccountNumberListRepository accountRepository;

	public List<ReconDataEntity> getAllReconData() {
		return fileRepository.findAll();
	}

	public List<ReconDataAccountNumberListEntity> getAllReconDataAccountNumberList() {
		return accountRepository.findAll();
	}

}
