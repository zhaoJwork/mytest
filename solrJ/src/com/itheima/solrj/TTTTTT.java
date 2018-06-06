package com.itheima.solrj;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class TTTTTT {
	@Test
	public void egtew() throws Exception{//添加 文档对象
		//首先创建solrjServert对象
		SolrServer solrServer=new HttpSolrServer("http://localhost:8080/solr/collection1");
		//创建solr的文档对象
		SolrInputDocument solrInputDocument=new SolrInputDocument();
		//向文档内容中添加域
		solrInputDocument.addField("id", "3");
		solrInputDocument.addField("name", "哈再见来不及挥手");
		//添加文档
		solrServer.add(solrInputDocument);
		//提交文档对象
		solrServer.commit();
	}
	
	@Test
	public void dele() throws Exception{
		//根据id删除文档
		SolrServer solrServer=new HttpSolrServer("http://localhost:8080/solr/collection1");
		//solrServer.deleteById("id:1");
		//solrj完全支持lucene语法
		solrServer.deleteByQuery("name:再见");
		solrServer.commit();
	}
}
