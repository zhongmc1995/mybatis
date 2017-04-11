package com.zmc.homework;



import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.sound.midi.Soundbank;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.zmc.pojo.StudentMapper;

/**
 * 在BookMapper.java接口中定义方法
 * 在BookService中调用BookMapper.java接口中方法
 * 完成以下功能(注意参照笔记中的实例)
 */
//处理书籍相关信息的服务类
public class BookService {
	private static BookMapper mapper=null;
	static SqlSession session = null;
	static{
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		Configuration configuration = sqlSessionFactory.getConfiguration();
		session = sqlSessionFactory.openSession();
		//第一种执行sql语句的方式  通过XxxxMapper接口的实现类对象来调用
		//动态获得XxxxMapper接口的实现类
		 mapper = session.getMapper(BookMapper.class);
	}
	//添加书籍
	//书籍的名称不能重复
	public void addBook(Book book){
		mapper.addABook(book);
		session.commit();
	}
	
	//删除书籍
	//id值不存在则不能删除
	public void removeBook(Integer id){
		mapper.removeBook(id);
		session.commit();
	}
	
	//查找书籍
	//通过名字
	public Book findBookByName(String bookName){
		Book book = mapper.findBookByName(bookName);
		return book;
	}
	
	//查找书籍
	//通过id
	public Book findBookById(Integer id){
		Book book = mapper.findBookById(id);
		return book;
	}
	
	//查找所有书籍
	public List<Book> findAllBooks(){
		List<Book> books = mapper.findAllBooks();
		return books;
	}
	
	//查找所有书籍的名字
	public List<String> findAllBooksName(){
		
		return mapper.findAllBooksName();
	}
	
	//查找一共有多少本书籍
	public int findCountOfBook(){
		
		return mapper.findCountOfBook();
	}
	
	//修改书籍
	//通过id确定修改的是那本书
	public void updateBook(Book book){
		mapper.updateBook(book);
		session.commit();
	}
	
	//查询所有书籍的名字和对应的作者
	public List<Map<String,Object>> findBookNameAndAuthor(){
		
		return mapper.findBookNameAndAuthor();
	}
	
	public static void main(String[] args) {
		BookService service = new BookService();
		//service.addBook(new Book(3, "test", "zmc", new Date(), 12.2));
		//Book b = service.findBookByName("test");
		//Book b = service.findBookById(2);
		List<Book> books = service.findAllBooks();
		for (Book book : books) {
			System.out.println(book);
		}
		/*List<String> names = service.findAllBooksName();
		for (String string : names) {
			System.out.println(string);
		}*/
		/*int count = service.findCountOfBook();
		System.out.println(count);*/
		
		//service.updateBook(new Book(2,"test2","xxx",new Date(),29.0));
		service.removeBook(3);
		List<Map<String, Object>> bookNameAndAuthor = service.findBookNameAndAuthor();
		for (Map<String, Object> map : bookNameAndAuthor) {
			Set<Entry<String, Object>> entrySet = map.entrySet();
			for (Entry<String, Object> entry : entrySet) {
				System.out.println(entry.getKey()+":"+entry.getValue());
			}
		}
	}
	
}
