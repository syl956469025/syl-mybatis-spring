package mybatisconfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.syl.dao.ClassesMapper;
import com.syl.dao.UserMapper;
import com.syl.model.Classes;
import com.syl.model.User;
import com.syl.utils.JsonUtil;


/**
 * @description 
 * @author 史彦磊
 * @version 1.0
 *  2015年10月30日
 */
public class MyBatisConfigTest {
	
	
	private SqlSession session =null ;
	
	@Test
	public void selectAllUser(){
//		List<User> user = session.selectList("User.selectAllUser");
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> user = mapper.selectAllUser();
		System.out.println(JsonUtil.toJson(user));
	}
	
	
	@Test
	public void selectAllClasses() throws IOException{
		ClassesMapper mapper = new ClassesMapper();
		List<Classes> classes = mapper.selectAllClasses();
		System.out.println(JsonUtil.toJson(classes));
	}
	
	
	
	
	
	@Before
	public void initConfig() throws IOException{
		String resource = "mybatis/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		session =sqlSessionFactory.openSession();
	}
	
	@After
	public void closeSession(){
		if(session !=null){
			session.close();
		}
	}

}
