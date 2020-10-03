package com.pm.es.daoImpl;

import java.util.Map;
import java.util.UUID;

import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pm.es.dao.StudentDAO;
import com.pm.es.model.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {

	private final String INDEX = "studentdata";
	private final String TYPE = "Student";
	
	private RestHighLevelClient restHighLevelClient;
	private ObjectMapper objectMapper;
	
	public StudentDAOImpl(RestHighLevelClient restHighLevelClient,ObjectMapper objectMapper) {
		this.objectMapper=objectMapper;
		this.restHighLevelClient=restHighLevelClient;
	}

	@Override
	public Student insertStudent(Student student) {
		
		  student.setId(UUID.randomUUID().toString());
		  Map dataMap = objectMapper.convertValue(student, Map.class);
		  IndexRequest indexRequest = new IndexRequest(INDEX, TYPE, student.getId())
		                .source(dataMap);
		  try {
		    IndexResponse response = restHighLevelClient.index(indexRequest);
		  } catch(ElasticsearchException e) {
		    e.getDetailedMessage();
		  } catch (java.io.IOException ex){
		    ex.getLocalizedMessage();
		  }
		  return student;
	}

	@Override
	public Map<String, Object> getStudents(String id) {
		 GetRequest getRequest = new GetRequest(INDEX, TYPE,id);
		  GetResponse getResponse = null;
		  try {
		    getResponse = restHighLevelClient.get(getRequest);
		  } catch (java.io.IOException e){
		    e.getLocalizedMessage();
		  }
		  Map<String, Object> sourceAsMap = getResponse.getSourceAsMap();
		  return sourceAsMap;
	}
	
	public Map<String, Object> getBookById(String id){
		  GetRequest getRequest = new GetRequest(INDEX, TYPE,"");
		  GetResponse getResponse = null;
		  try {
		    getResponse = restHighLevelClient.get(getRequest);
		  } catch (java.io.IOException e){
		    e.getLocalizedMessage();
		  }
		  Map<String, Object> sourceAsMap = getResponse.getSourceAsMap();
		  return sourceAsMap;
		}

}
