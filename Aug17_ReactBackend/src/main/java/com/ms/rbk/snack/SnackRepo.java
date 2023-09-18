package com.ms.rbk.snack;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SnackRepo extends CrudRepository<Snack, String> {

	public abstract List<Snack>findAll();
	
	
}
