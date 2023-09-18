package com.ms.aug071jpa.coffee;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//자바빈/Id준거 자료형
//Spring regacy에서는 Mapper였지만 여기서는 뒤에Repo라는걸 붙여서
//CrudRepository <자바빈,프라이머리키 자료형>
//기존에 Mapper에 sql문을 직접 짜줘야했는데 이건 그냥 자동으로 해주는
@Repository
public interface CoffeeRepo  extends CrudRepository<Coffee,String>{
	//원래 Iterable<Coffee>로 나가니 V쪽에서 불편할것
	//List<Coffee>로 나가도록 리턴타입만 바꿔주는거
	public abstract List<Coffee>findAll();
	
	//우리가 기존에 했던 그런 페이지 나누고 그런걸 하기위한
	//메소드명만 규칙에 맞춰서 지으면
	//https://spring.io/projects/spring-data-jpa#learn
	//3.12 reference DOC
	//5.1.3.Query Methods
	//가서 찾아서 보고 알아서 집어넣는
	public abstract List<Coffee>findByPriceGreaterThanEqual(Integer p);
	public abstract List<Coffee>findByNameContaining(String n);
	public abstract List<Coffee>findByNameContaining(String n,Pageable p);

}
