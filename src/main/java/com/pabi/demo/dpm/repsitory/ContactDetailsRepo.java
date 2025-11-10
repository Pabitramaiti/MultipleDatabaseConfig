package com.pabi.demo.dpm.repsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pabi.demo.dpm.entity.ContactDetailsEntity;

public interface ContactDetailsRepo extends JpaRepository<ContactDetailsEntity, Long> {

}
