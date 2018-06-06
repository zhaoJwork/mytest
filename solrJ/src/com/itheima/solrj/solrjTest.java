package com.itheima.solrj;

import java.awt.TextField;
import java.io.IOException;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class solrjTest {

	@Test
	public void egeas() throws Exception{
		//首先创建对象,solrServlet,和服务器建立一个连接
		SolrServer server=new  HttpSolrServer("http://localhost:8080/solr/collection1");
		//创建一个solrinpuntDocument对象//这是solr的文档对象
		SolrInputDocument document=new SolrInputDocument();
		//向文档对象中添加域
		document.addField("id", "2", 1.0f);
		document.addField("title", "测试哈哈哈");
		document.addField("content", "新添加的内容");
		//把文档对象写入到索引库
		server.add(document);
		//提交
		server.commit();
	}
	//删除
	@Test
	public void delete() throws Exception{
		//首先创建对象,solrServlet,和服务器建立一个连接
		SolrServer server=new  HttpSolrServer("http://localhost:8080/solr/collection1");
		//根据条件删除
//		server.deleteById("2");
		server.deleteByQuery("title:哈哈");
		//提交
		server.commit();
	}
	
}
