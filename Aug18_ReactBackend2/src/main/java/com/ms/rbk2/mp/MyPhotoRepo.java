package com.ms.rbk2.mp;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyPhotoRepo extends CrudRepository<MyPhoto, String> {

	public abstract List<MyPhoto>findAll();
}


