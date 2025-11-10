package com.pabi.demo.wfs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pabi.demo.wfs.entity.ReconDataEntity;

public interface WFSReconRepository extends JpaRepository<ReconDataEntity, String> {

}
