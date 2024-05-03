package com.example.demo.dao;

import com.example.demo.entity.LaboratoryWorker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaboratoryWorkerRepository extends JpaRepository<LaboratoryWorker,Long> {
}
