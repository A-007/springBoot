package com.infotect.mytodoapp;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

@SpringBootApplication
public class MytodoappApplication {

	public static void main(String[] args) throws UnsupportedEncodingException {
		
		String url = "mongodb+srv://Akshay123:Mongodb%402020@cluster0.hmpo1.mongodb.net/ToDoAppDB?retryWrites=true&w=majority";

//		byte [] bytes = url.getBytes(StandardCharsets.UTF_8);
//		
//		String endUrl = new String(bytes, url);
		
		MongoClientURI uri = new MongoClientURI(url);
		
		
		
		MongoClient mongoClient = new MongoClient(uri);
		MongoDatabase database = mongoClient.getDatabase("ToDoAppDB");

		SpringApplication.run(MytodoappApplication.class, args);
	}

}
