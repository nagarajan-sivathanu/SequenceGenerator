package com.learn.springboot.SequenceGenerator.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.learn.springboot.SequenceGenerator.pojo.Counter;

@Service
public class CounterService {
	@Autowired 
	private MongoOperations mongo;
	
	public int getNextSequence(String collectionName) {
		System.out.println("Inside getNextSequence()");
		System.out.println(collectionName);
		Query query = new Query(Criteria.where("_id").is(collectionName));
		System.out.println("Query : "+query.toString());
		FindAndModifyOptions options = new FindAndModifyOptions();
		options.returnNew(true);
		options.upsert(false);
		options.remove(false);
		System.out.println("Options : "+options.toString());
	    System.out.println((mongo.find(query, Counter.class)).toArray());
		Counter counter = mongo.findAndModify(
	      query, 
	      new Update().inc("seq", 1),
	      options,
	      Counter.class
	     );
	     System.out.println("Counter : "+counter);  
	     System.out.println("ID : "+counter.getId()+" && Seq : " + counter.getSeq());
	     return counter.getSeq();
	  }
}
