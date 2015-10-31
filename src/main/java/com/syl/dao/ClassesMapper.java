package com.syl.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.syl.model.Classes;

/**
 * @description 
 * @author 史彦磊
 * @version 1.0
 *  2015年10月30日
 */
public class ClassesMapper {
	
	
	
	
	public List<Classes> selectAllClasses() throws IOException{
		String resource = "mybatis/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session =sqlSessionFactory.openSession();
		return session.selectList("Classes.selectAllClasses");
	}

}
