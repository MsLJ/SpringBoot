package com.ms.aug081jpa.company;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepo extends CrudRepository<Company, String> {
public abstract	List<Company>findAll();

}
