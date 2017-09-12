package com.example.micro_phoneFilters.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.micro_phoneFilters.entity.EquipmentFilter;

/**
 * @author Rohit
 *
 */
@Repository
public interface EquipmentFilterRepository extends JpaRepository<EquipmentFilter, Integer> {

}
