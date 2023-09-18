package com.ms.aug081jpa.snack;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
//N+1
//Hibernate:우리가 쓰던 join이 아닌 값 같은걸 여러번 찾는
//		->여러번 select를 하니까 효율성,속도에 문제가
//Hibernate를 사용하면
//그게 아닌 select를 하나씩해서 Ram에 부담이 안가는 데이터 폭증x
//값같은거 하나씩 찾아내는 :CPU에
//->select자체를 여러번 해내는


//우리가 하던 select *조인 형태가
//원래 10*10 데이터 폭증시키는 형태였는데
//fetch join
//우리가 쓰던 그 join을
//		->select는 한번->데이터가 늘어나는데.. ???

@Repository
public interface SnackRepo extends CrudRepository<Snack, Integer> {
	//SQL-x
	//JPQL:select distinct 닉 from 테이블명 닉 join fetch 닉.변수명
	@Query("select distinct asnack from aug08_snack asnack join fetch asnack.company")
	public abstract List<Snack> findAll();

}
