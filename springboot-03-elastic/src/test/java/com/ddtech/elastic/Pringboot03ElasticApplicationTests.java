package com.ddtech.elastic;

import com.ddtech.elastic.bean.Book;
import com.ddtech.elastic.bean.BookJest;
import com.ddtech.elastic.repository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.UnknownHostException;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Pringboot03ElasticApplicationTests {
	/**
	 * 测试通过elasticsearch 2.4.6
	 * 其他版本测试不通过
	 *
	 *
	 * spring data elasticsearch 	elasticsearch
						 3.1.x 	             6.2.2
						 3.0.x 	            5.5.0
						 2.1.x            	2.4.0
						 2.0.x           	2.2.0
						 1.3.x 	         1.5.2
	 版本适配关系
	 https://github.com/spring-projects/spring-data-elasticsearch
	 */
	//jest 方式
	@Autowired
	JestClient jestClient;

	//spring data 方式
	@Autowired
	BookRepository bookRepository;
	
	 @Test
	 public void repostioryBookTestIndex()throws NumberFormatException, UnknownHostException {

		 Book book=new Book();
		 book.setId(2);
		 book.setBookName("三国演义");
		 book.setBookAuthor("罗贯中");
		 bookRepository.index(book);
	 }
	 @Test
	 public void repostioryBookTestFind(){

		 List<Book> bookList = bookRepository.findByBookName("三国演义");
		 for (Book book:bookList){
		 	System.out.println(book.toString());
		 }
		 
	 }
	 
	/**
	 * 存入数据
	 */
	@Test
	public void contextLoads() {
		BookJest book=new BookJest();
		book.setId(1);
		book.setBookName("西游记");
		book.setBookAuthor("吴承恩");
		//创建一个索引

		Index index=new Index.Builder(book).index("ddtech").type("book").build();

		//执行
		try {
			jestClient.execute(index);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 获取数据
	 */
	@Test
	public void getElasticData(){
		String json = "{\n    \"query\" : {\n        \"match\" : {\n            \"bookName\" : \"西游记\"\n        }\n    }\n}";
		//创建一个搜索
		Search search = new Search.Builder(json).addIndex("ddtech").addType("book").build();
		//执行
		try {
			SearchResult result = jestClient.execute(search);
			System.out.println(result.getJsonString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
