package com.encore.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDAOImpl implements EmpDAO{

	@Inject
	private SqlSession sqlSession;//sql호출
	
	@Override
	public List<String> selectEnames() {
		return sqlSession.selectList("emp.selectEnames");
	}

}
