package com.pabi.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pabi.demo.dpm.entity.ContactDetailsEntity;
import com.pabi.demo.dpm.entity.OrderEntity;
import com.pabi.demo.dpm.repsitory.ContactDetailsRepo;
import com.pabi.demo.dpm.repsitory.OrderRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DPMService {

	@Autowired
	private OrderRepo orderRepository;

	@Autowired
	private ContactDetailsRepo contactDetailsRepository;

	public Optional<OrderEntity> getOrderById(long id) {
		return orderRepository.findById(id);
	}

	public Optional<ContactDetailsEntity> getContactDetailsById(long id) {
		return contactDetailsRepository.findById(id);
	}

}
