package com.example.fullstack;

import com.example.fullstack.models.Product;
import com.example.fullstack.repository.ProductRepository;
import com.mongodb.*;
import com.mongodb.client.*;
import com.mongodb.client.MongoClient;
import org.apache.catalina.User;
import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

@SpringBootApplication
@RestController
public class FullstackApplication {

	public static void main(String[] args) {
		//SpringApplication.run(FullstackApplication.class, args);
		//MongoClientOptions options = new MongoClientOptions.Builder().socketKeepAlive(true).build();

		String uri = "mongodb://localhost:27017/test";
		ConnectionString connectionString = new ConnectionString(uri);
		CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
		CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
		MongoClientSettings clientSettings = MongoClientSettings.builder()
				.applyConnectionString(connectionString)
				.codecRegistry(codecRegistry)
				.build();

		try (MongoClient mongoClient = MongoClients.create(clientSettings)) { // try with resources
			MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
			MongoCollection productCollection = mongoDatabase.getCollection("product", Product.class);

			Query query = new Query();
			BasicDBObject query1 = new BasicDBObject("image", "book.png");
			query.addCriteria(Criteria.where("lastName").is("Paul"));
			//query.addCriteria()
			Product product = new Product();
			product.setTitle("Book");
			product.setPrice("12.14$");
			product.setImage("book.png");
			product.setPrime(true);
			product.setRating(4);
			product.setReviews(1234);

			productCollection.insertOne(product);
			DBCursor cursor = productCollection.find(query1, Product.class);


			while(cursor.hasNext())
			{
				System.out.println(cursor.next());
			}
			cursor.close();

		//ConnectionString connectionString = new ConnectionString(uri);
	//	CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
	//	CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);

	//	MongoClientSettings clientSettings = MongoClientSettings.builder()
		//		.applyConnectionString(connectionString)
		//		.codecRegistry(codecRegistry)
		//		.build();

		/**	try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
			MongoDatabase database = mongoClient.getDatabase("test");
			//DB db = mongoClient.getDB("journaldev");

			MongoCollection<Product> collection = database.getCollection("user", Product.class);
			System.out.println(collection); // [datas, names, system.indexes, users]
			System.out.println(collection.countDocuments());
			Product product = new Product();
			product.setTitle("abcd");
			product.setImage("abcd.png");
			product.setPrice("12.35$");
			collection.insertOne(product);
			try {
				Bson command = new BsonDocument("ping", new BsonInt64(1));
				Document commandResult = database.runCommand(command);
				System.out.println("Connected successfully to server.");
			} catch (MongoException me) {
				System.err.println("An error occurred while attempting to run a command: " + me);
			}*/
		}
	}

}
