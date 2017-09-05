package com.example.micro_phoneFilters.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.micro_phoneFilters.model.FilterCategory;

/**
 * @author Rohit
 *
 */
@Repository
public interface FilterCategoryRepository extends JpaRepository<FilterCategory, Integer> {

	/**
	 * @param catId
	 * @return
	 */
	public FilterCategory findByCatID(Integer id);

}
